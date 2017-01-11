package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainGetAssetImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String ALIAS_INPUT_PARAMETER = "alias";
	protected final String ASSET_OUTPUT_PARAMETER = "asset";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	protected final java.lang.String getAlias() {
		return (java.lang.String) getInputParameter(ALIAS_INPUT_PARAMETER);
	}

	protected final void setAsset(org.bonitasoft.connectors.chain.Asset asset) {
		setOutputParameter(ASSET_OUTPUT_PARAMETER, asset);
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
