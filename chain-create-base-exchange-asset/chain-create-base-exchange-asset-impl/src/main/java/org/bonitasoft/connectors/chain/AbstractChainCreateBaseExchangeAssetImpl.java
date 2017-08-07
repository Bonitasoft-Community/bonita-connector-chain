package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainCreateBaseExchangeAssetImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String SPEND_ASSET_ID_INPUT_PARAMETER = "spendAssetId";
	protected final static String RECEIVE_ASSET_ID_INPUT_PARAMETER = "receiveAssetId";

	protected final static String ACCOUNT_ALIAS_INPUT_PARAMETER = "accountAlias";

	protected final static String SPEND_AMOUNT_INPUT_PARAMETER = "spendAmount";
	protected final static String RECEIVE_AMOUNT_INPUT_PARAMETER = "receiveAmount";

	protected final static String KEY_ACCOUNT_ALIAS_INPUT_PARAMETER = "keyAccountAlias";

	protected final static String REFERENCE_DATA_INPUT_PARAMETER = "referenceData";

	protected final String BASE_TRANSACTION_OUTPUT_PARAMETER = "baseTransaction";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	protected final java.lang.String getSpendAssetId() {
		return (java.lang.String) getInputParameter(SPEND_ASSET_ID_INPUT_PARAMETER);
	}

	protected final java.lang.String getReceiveAssetId() {
		return (java.lang.String) getInputParameter(RECEIVE_ASSET_ID_INPUT_PARAMETER);
	}

	protected final java.lang.String getAccountAlias() {
		return (java.lang.String) getInputParameter(ACCOUNT_ALIAS_INPUT_PARAMETER);
	}
	

	protected final java.lang.String getSpendAmount() {
		return (java.lang.String) getInputParameter(SPEND_AMOUNT_INPUT_PARAMETER);
	}

	protected final java.lang.String getReceiveAmount() {
		return (java.lang.String) getInputParameter(RECEIVE_AMOUNT_INPUT_PARAMETER);
	}


	protected final java.lang.String getKeyAccountAlias() {
		return (java.lang.String) getInputParameter(KEY_ACCOUNT_ALIAS_INPUT_PARAMETER);
	}

	
	protected final java.util.List getReferenceData() {
		return (java.util.List) getInputParameter(REFERENCE_DATA_INPUT_PARAMETER);
	}

	protected final void setBaseTransaction(org.bonitasoft.connectors.chain.BaseTransactionResponse baseTransaction) {
		setOutputParameter(BASE_TRANSACTION_OUTPUT_PARAMETER, baseTransaction);
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
			getSpendAssetId();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("spend asset id type is invalid");
		}
		try {
			getReceiveAssetId();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("receive asset id type is invalid");
		}
		try {
		    getAccountAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("Account alias type is invalid");
		}
		try {
		    getSpendAmount();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("Spend amount type is invalid");
		}
		try {
			getReceiveAmount();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("Receive amount type is invalid");
		}
		try {
		    getKeyAccountAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key account alias type is invalid");
		}
		try {
			getReferenceData();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("reference data type is invalid");
		}
	}

}
