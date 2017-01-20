/**
 * 
 */
package org.bonitasoft.connectors.chain;

import com.chain.exception.BadURLException;
import com.chain.exception.ChainException;
import com.chain.http.Client;
import org.bonitasoft.engine.connector.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.chain.api.Balance;

/**
 *The connector execution will follow the steps
 * 1 - setInputParameters() --> the connector receives input parameters values
 * 2 - validateInputParameters() --> the connector can validate input parameters values
 * 3 - connect() --> the connector can establish a connection to a remote server (if necessary)
 * 4 - executeBusinessLogic() --> execute the connector
 * 5 - getOutputParameters() --> output are retrieved from connector
 * 6 - disconnect() --> the connector can close connection to remote server (if any)
 */
public class ChainGetBalanceConnector extends AbstractChainGetBalanceImpl {

	@Override
	protected void executeBusinessLogic() throws ConnectorException{
	
	    final Logger logger = LoggerFactory.getLogger(ChainGetBalanceConnector.class);
	    
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
			Balance.Items items = new Balance.QueryBuilder()
					.setFilter("account_alias=$1 AND asset_alias=$2").addFilterParameter(getAccountAlias())
					.addFilterParameter(getAssetAlias()).execute(client);
			Balance resultOne = null;
			if (items.hasNext()) {
				resultOne = items.next();
			}
			org.bonitasoft.connectors.chain.Balance balance = null;
			if (resultOne != null) {
				balance = new org.bonitasoft.connectors.chain.Balance(resultOne.amount);
			} else {
				balance = new org.bonitasoft.connectors.chain.Balance(0L);
			}
			setBalance(balance);
	    } catch (ChainException e) {
	        throw new ConnectorException("Error while getting the balance", e.getCause());
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
