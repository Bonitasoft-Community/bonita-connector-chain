package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainGetAccountImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String ALIAS_INPUT_PARAMETER = "alias";
	protected final String ACCOUNT_OUTPUT_PARAMETER = "account";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	protected final java.lang.String getAlias() {
		return (java.lang.String) getInputParameter(ALIAS_INPUT_PARAMETER);
	}

	protected final void setAccount(org.bonitasoft.connectors.chain.Account account) {
		setOutputParameter(ACCOUNT_OUTPUT_PARAMETER, account);
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
			getAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("alias type is invalid");
		}

	}

}
