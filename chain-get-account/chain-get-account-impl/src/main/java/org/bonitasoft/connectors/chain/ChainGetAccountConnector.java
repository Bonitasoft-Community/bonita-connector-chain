/**
 * 
 */
package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chain.api.Account;
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
public class ChainGetAccountConnector extends AbstractChainGetAccountImpl {

	@Override
	protected void executeBusinessLogic() throws ConnectorException{
		//Get access to the connector input parameters
		//getUrl();
		//getAccountToken();
		//getAlias();
	
	    final Logger logger = LoggerFactory.getLogger(ChainGetAccountConnector.class);
	    
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
    	    Account.Items accounts = new Account.QueryBuilder().setFilter("alias=$1")
                    .addFilterParameter(getAlias()).execute(client);
    	    Account result = accounts.next();
    	    logger.warn("Account found: " + result.alias);
    	    org.bonitasoft.connectors.chain.Account formattedResult = new org.bonitasoft.connectors.chain.Account(result.alias, result.tags);
    	    setAccount(formattedResult);
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
