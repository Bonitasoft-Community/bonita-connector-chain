package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainGenerateReceiverImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String ACCOUNT_ALIAS_INPUT_PARAMETER = "accountAlias";
	protected final static String KEY_ACCOUNT_ALIAS_INPUT_PARAMETER = "keyAccountAlias";

	protected final String RECEIVER_JSON_OUTPUT_PARAMETER = "receiverJson";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	
	protected final java.lang.String getAccountAlias() {
		return (java.lang.String) getInputParameter(ACCOUNT_ALIAS_INPUT_PARAMETER);
	}
	
	
	protected final java.lang.String getKeyAccountAlias() {
		return (java.lang.String) getInputParameter(KEY_ACCOUNT_ALIAS_INPUT_PARAMETER);
	}
	
	
	protected final void setReceiverJson(java.lang.String receiverJson) {
		setOutputParameter(RECEIVER_JSON_OUTPUT_PARAMETER, receiverJson);
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
			getAccountAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("account alias type is invalid");
		}
		try {
			getKeyAccountAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key account alias type is invalid");
		}
	}

}
