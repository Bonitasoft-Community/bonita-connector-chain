/**
 * 
 */

package org.bonitasoft.connectors.chain;

import com.chain.api.MockHsm;
import com.chain.api.Transaction;
import com.chain.exception.BadURLException;
import com.chain.exception.BuildException;
import com.chain.exception.ChainException;
import com.chain.http.Client;
import com.chain.signing.HsmSigner;
import com.chain.api.Transaction.Action.ControlWithAccount;

import org.apache.commons.lang3.StringUtils;
import org.bonitasoft.engine.connector.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * The connector execution will follow the steps 1 - setInputParameters() --> the connector receives
 * input parameters values 2 - validateInputParameters() --> the connector can validate input
 * parameters values 3 - connect() --> the connector can establish a connection to a remote server
 * (if necessary) 4 - executeBusinessLogic() --> execute the connector 5 - getOutputParameters() -->
 * output are retrieved from connector 6 - disconnect() --> the connector can close connection to
 * remote server (if any)
 */
public class ChainExchangeAssetConnector extends AbstractChainExchangeAssetImpl {

    @Override
    protected void executeBusinessLogic() throws ConnectorException {
        // Get access to the connector input parameters
        // getUrl();
        // getAccountToken();
        // getAlias();

        final Logger logger = LoggerFactory.getLogger(ChainExchangeAssetConnector.class);

        Client client;

        if (StringUtils.isNotEmpty(getUrl())) {
            try {
                if (StringUtils.isNotEmpty(getAccountToken())) {
                    client = new Client(getUrl(), getAccountToken());
                } else {
                    client = new Client(getUrl());
                }
            } catch (BadURLException e) {
                throw new ConnectorException("Error while creating Chain client", e.getCause());
            }
        } else {
            client = new Client();
        }

        try {
            MockHsm.Key assetOneKey = new MockHsm.Key.QueryBuilder()
                    .setAliases(Arrays.asList(getKeyAssetOneAlias())).execute(client).next();

            MockHsm.Key assetTwoKey = new MockHsm.Key.QueryBuilder()
                    .setAliases(Arrays.asList(getKeyAssetTwoAlias())).execute(client).next();

            MockHsm.Key accountOneKey = new MockHsm.Key.QueryBuilder()
                    .setAliases(Arrays.asList(getKeyAccountOneAlias())).execute(client).next();

            MockHsm.Key accountTwoKey = new MockHsm.Key.QueryBuilder()
                    .setAliases(Arrays.asList(getKeyAccountTwoAlias())).execute(client).next();

            HsmSigner.addKey(assetOneKey, MockHsm.getSignerClient(client));
            HsmSigner.addKey(assetTwoKey, MockHsm.getSignerClient(client));

            HsmSigner.addKey(accountOneKey, MockHsm.getSignerClient(client));
            HsmSigner.addKey(accountTwoKey, MockHsm.getSignerClient(client));

            List<List<String>> listReferenceDataOne = getReferenceDataOne();

            ControlWithAccount outputTransactionOne = new Transaction.Action.ControlWithAccount()
                    .setAccountAlias(getAccountTwoAlias()).setAssetAlias(getAssetOneAlias())
                    .setAmount(Long.parseLong(getAmountOne()));

            for (List<String> row : listReferenceDataOne) {
                if (row.size() == 2) {
                    outputTransactionOne.addReferenceDataField(row.get(0), row.get(1));
                }
            }

            List<List<String>> listReferenceDataTwo = getReferenceDataTwo();

            ControlWithAccount outputTransactionTwo = new Transaction.Action.ControlWithAccount()
                    .setAccountAlias(getAccountOneAlias()).setAssetAlias(getAssetTwoAlias())
                    .setAmount(Long.parseLong(getAmountTwo()));

            for (List<String> row : listReferenceDataTwo) {
                if (row.size() == 2) {
                    outputTransactionTwo.addReferenceDataField(row.get(0), row.get(1));
                }
            }

            Transaction.Template issueTransaction = new Transaction.Builder()
                    .addAction(new Transaction.Action.SpendFromAccount()
                            .setAssetAlias(getAssetOneAlias()).setAccountAlias(getAccountOneAlias())
                            .setAmount(Long.parseLong(getAmountOne())))
                    .addAction(new Transaction.Action.SpendFromAccount()
                            .setAssetAlias(getAssetTwoAlias()).setAccountAlias(getAccountTwoAlias())
                            .setAmount(Long.parseLong(getAmountTwo())))
                    .addAction(outputTransactionOne).addAction(outputTransactionTwo).build(client);

            Transaction.Template signedIssuance = HsmSigner.sign(issueTransaction);
            Transaction.SubmitResponse submitResponse = Transaction.submit(client, signedIssuance);

            org.bonitasoft.connectors.chain.TransactionResponse formattedResult =
                    new org.bonitasoft.connectors.chain.TransactionResponse(submitResponse.id);
            setTransactionResponse(formattedResult);
        } catch (ChainException e) {
            if (e instanceof BuildException) {
                BuildException buildEx = (BuildException) e;
                setTransactionResponse(
                        new TransactionResponse(buildEx.code, dataErrorsToString(buildEx)));
            } else {
                throw new ConnectorException("Error while exchange multi trade, cause: ", e.getCause());
            }
        }
    }

    private String dataErrorsToString(BuildException buildEx) {

        if (buildEx.data == null || buildEx.data.actionErrors.size() == 0) {
            return buildEx.detail;
        }

        StringBuilder builder = new StringBuilder();
        for (BuildException.ActionError error : buildEx.data.actionErrors) {
            builder.append(error.chainMessage);
        }
        return builder.toString();

    }

    @Override
    public void connect() throws ConnectorException {
        // [Optional] Open a connection to remote server

    }

    @Override
    public void disconnect() throws ConnectorException {
        // [Optional] Close connection to remote server

    }

}
