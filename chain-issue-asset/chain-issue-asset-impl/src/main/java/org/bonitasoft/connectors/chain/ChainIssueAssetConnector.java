/**
 * 
 */
package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.lang.Long;

import com.chain.api.Transaction;
import com.chain.api.MockHsm;
import com.chain.signing.HsmSigner;
import com.chain.exception.BadURLException;
import com.chain.exception.ChainException;
import com.chain.http.Client;

/**
 *The connector execution will follow the steps
 * 1 - setInputParameters() --> the connector receives input parameters values
 * 2 - validateInputParameters() --> the connector can validate input parameters values
 * 3 - connect() --> the connector can establish a connection to a remote server (if necessary)
 * 4 - executeBusinessLogic() --> execute the connector
 * 5 - getOutputParameters() --> output are retrieved from connector
 * 6 - disconnect() --> the connector can close connection to remote server (if any)
 */
public class ChainIssueAssetConnector extends AbstractChainIssueAssetImpl {

	@Override
	protected void executeBusinessLogic() throws ConnectorException{
		//Get access to the connector input parameters
		//getUrl();
		//getAccountToken();
		//getAlias();
	
	    final Logger logger = LoggerFactory.getLogger(ChainIssueAssetConnector.class);
	    
	    Client client;
	    
	        
	    if (getUrl() != null) {
	        try {
	        if (getAccountToken() != null) {
	            client = new Client(getUrl(), getAccountToken());
	        } else {
	            client = new Client(getUrl());
	        }
	        } catch (BadURLException e) {
	            throw new ConnectorException("Error while creating Chain client" , e.getCause());
	        }
	    } else {
	        client = new Client();
	    }
	    
	    try {
					MockHsm.Key assetKey = 
                new MockHsm.Key.QueryBuilder().setAliases(Arrays.asList(getKeyAssetAlias())).execute(client).next();
				
					MockHsm.Key accountKey = 
											new MockHsm.Key.QueryBuilder().setAliases(Arrays.asList(getKeyAccountAlias())).execute(client).next();
    	    
					HsmSigner.addKey(assetKey, MockHsm.getSignerClient(client));
					HsmSigner.addKey(accountKey, MockHsm.getSignerClient(client));

					Transaction.Template issueTransaction = new Transaction.Builder()
				                 .addAction(
				                         new Transaction.Action.Issue().setAssetAlias(getAssetAlias()).setAmount(Long.parseLong(getAmount())))
				                 .addAction(new Transaction.Action.ControlWithAccount().setAccountAlias(getAccountAlias())
				                         .setAssetAlias(getAssetAlias()).setAmount(Long.parseLong(getAmount())))
				                 .build(client);
				         
				  Transaction.Template signedIssuance = HsmSigner.sign(issueTransaction);
				  Transaction.SubmitResponse submitResponse = Transaction.submit(client, signedIssuance);

    	    org.bonitasoft.connectors.chain.TransactionResponse formattedResult = new org.bonitasoft.connectors.chain.TransactionResponse(submitResponse.id);
    	    setTransactionResponse(formattedResult);
	    } catch (ChainException e) {
	        throw new ConnectorException("Error while getting the Chain account", e.getCause());
	    }
	 }

	@Override
	public void connect() throws ConnectorException{
		//[Optional] Open a connection to remote server 
	
	}

	@Override
	public void disconnect() throws ConnectorException{
		//[Optional] Close connection to remote server
	
	}

}
