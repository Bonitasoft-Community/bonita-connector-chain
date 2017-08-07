package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainIssueAssetExternalImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String ASSET_ID_INPUT_PARAMETER = "assetId";
	protected final static String RECEIVER_INPUT_PARAMETER = "receiver";
	protected final static String AMOUNT_INPUT_PARAMETER = "amount";
	protected final static String KEY_ASSET_ALIAS_INPUT_PARAMETER = "keyAssetAlias";
    protected final static String REFERENCE_DATA_INPUT_PARAMETER = "referenceData";

	protected final String TRANSACTION_RESPONSE_OUTPUT_PARAMETER = "transactionResponse";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	protected final java.lang.String getAssetId() {
		return (java.lang.String) getInputParameter(ASSET_ID_INPUT_PARAMETER);
	}
	
	protected final java.lang.String getReceiver() {
		return (java.lang.String) getInputParameter(RECEIVER_INPUT_PARAMETER);
	}
	
	protected final java.lang.String getAmount() {
		return (java.lang.String) getInputParameter(AMOUNT_INPUT_PARAMETER);
	}
	
	protected final java.lang.String getKeyAssetAlias() {
		return (java.lang.String) getInputParameter(KEY_ASSET_ALIAS_INPUT_PARAMETER);
	}
	
	protected final java.util.List getReferenceData() {
        return (java.util.List) getInputParameter(REFERENCE_DATA_INPUT_PARAMETER);
    }
	
	protected final void setTransactionResponse(org.bonitasoft.connectors.chain.TransactionResponse transactionResponse) {
		setOutputParameter(TRANSACTION_RESPONSE_OUTPUT_PARAMETER, transactionResponse);
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
			getAssetId();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("asset id type is invalid");
		}
		try {
			getReceiver();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("account alias type is invalid");
		}
		try {
			getAmount();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("amount type is invalid");
		}
		try {
			getKeyAssetAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key asset alias type is invalid");
		}
		try {
            getReferenceData();
        } catch (ClassCastException cce) {
            throw new ConnectorValidationException("reference data type is invalid");
        }
	}

}
