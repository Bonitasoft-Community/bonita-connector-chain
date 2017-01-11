package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainGetBalanceImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String ASSET_ALIAS_INPUT_PARAMETER = "assetAlias";
	protected final static String ACCOUNT_ALIAS_INPUT_PARAMETER = "accountAlias";

	protected final String BALANCE_OUTPUT_PARAMETER = "balance";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	protected final java.lang.String getAssetAlias() {
		return (java.lang.String) getInputParameter(ASSET_ALIAS_INPUT_PARAMETER);
	}
	
	protected final java.lang.String getAccountAlias() {
		return (java.lang.String) getInputParameter(ACCOUNT_ALIAS_INPUT_PARAMETER);
	}
	
	
	
	protected final void setBalance(org.bonitasoft.connectors.chain.Balance balance) {
		setOutputParameter(BALANCE_OUTPUT_PARAMETER, balance);
	}

	@Override
	public void validateInputParameters() throws ConnectorValidationException {
		try {
			getUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("url type is invalid");
		}
		try {
			getAccountToken();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException(
					"accountToken type is invalid");
		}
		try {
			getAssetAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("asset alias type is invalid");
		}
		try {
			getAccountAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("account alias type is invalid");
		}
	}

}
