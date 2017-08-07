/**
 * 
 */

package org.bonitasoft.connectors.chain;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.bonitasoft.engine.connector.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chain.api.Account;
import com.chain.api.MockHsm;
import com.chain.api.Receiver;
import com.chain.exception.BadURLException;
import com.chain.exception.ChainException;
import com.chain.http.Client;
import com.chain.signing.HsmSigner;

/**
 * The connector execution will follow the steps 1 - setInputParameters() --> the connector receives
 * input parameters values 2 - validateInputParameters() --> the connector can validate input
 * parameters values 3 - connect() --> the connector can establish a connection to a remote server
 * (if necessary) 4 - executeBusinessLogic() --> execute the connector 5 - getOutputParameters() -->
 * output are retrieved from connector 6 - disconnect() --> the connector can close connection to
 * remote server (if any)
 */
public class ChainGenerateReceiverConnector extends AbstractChainGenerateReceiverImpl {

    @Override
    protected void executeBusinessLogic() throws ConnectorException {
        // Get access to the connector input parameters
        // getUrl();
        // getAccountToken();
        // getAlias();

        final Logger logger = LoggerFactory.getLogger(ChainGenerateReceiverConnector.class);

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

            MockHsm.Key accountKey = new MockHsm.Key.QueryBuilder()
                    .setAliases(Arrays.asList(getKeyAccountAlias())).execute(client).next();

            HsmSigner.addKey(accountKey, MockHsm.getSignerClient(client));
            
            Receiver receiver = new Account.ReceiverBuilder()
                    .setAccountAlias(getAccountAlias())
                    .create(client);
                        
            setReceiverJson(receiver.toJson());
        } catch (ChainException e) {
            throw new ConnectorException("Error while generating the Chain receiver", e.getCause());

        }
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
