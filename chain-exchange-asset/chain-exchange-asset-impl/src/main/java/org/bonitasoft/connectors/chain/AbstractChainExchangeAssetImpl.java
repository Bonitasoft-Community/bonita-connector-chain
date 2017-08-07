package org.bonitasoft.connectors.chain;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractChainExchangeAssetImpl extends AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String ACCOUNTTOKEN_INPUT_PARAMETER = "accountToken";
	protected final static String ASSET_TWO_ALIAS_INPUT_PARAMETER = "assetTwoAlias";
	protected final static String ASSET_ONE_ALIAS_INPUT_PARAMETER = "assetOneAlias";

	protected final static String ACCOUNT_ONE_ALIAS_INPUT_PARAMETER = "accountOneAlias";
	protected final static String ACCOUNT_TWO_ALIAS_INPUT_PARAMETER = "accountTwoAlias";

	protected final static String AMOUNT_ONE_INPUT_PARAMETER = "amountOne";
	protected final static String AMOUNT_TWO_INPUT_PARAMETER = "amountTwo";

	protected final static String KEY_ASSET_ONE_ALIAS_INPUT_PARAMETER = "keyAssetOneAlias";
	protected final static String KEY_ASSET_TWO_ALIAS_INPUT_PARAMETER = "keyAssetTwoAlias";

	protected final static String KEY_ACCOUNT_ONE_ALIAS_INPUT_PARAMETER = "keyAccountOneAlias";
	protected final static String KEY_ACCOUNT_TWO_ALIAS_INPUT_PARAMETER = "keyAccountTwoAlias";

	protected final static String REFERENCE_DATA_ONE_INPUT_PARAMETER = "referenceDataOne";
	protected final static String REFERENCE_DATA_TWO_INPUT_PARAMETER = "referenceDataTwo";


	protected final String TRANSACTION_RESPONSE_OUTPUT_PARAMETER = "transactionResponse";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	} 

	protected final java.lang.String getAccountToken() {
		return (java.lang.String) getInputParameter(ACCOUNTTOKEN_INPUT_PARAMETER);
	}

	protected final java.lang.String getAssetOneAlias() {
		return (java.lang.String) getInputParameter(ASSET_ONE_ALIAS_INPUT_PARAMETER);
	}

	protected final java.lang.String getAssetTwoAlias() {
		return (java.lang.String) getInputParameter(ASSET_TWO_ALIAS_INPUT_PARAMETER);
	}

	protected final java.lang.String getAccountOneAlias() {
		return (java.lang.String) getInputParameter(ACCOUNT_ONE_ALIAS_INPUT_PARAMETER);
	}
	
	protected final java.lang.String getAccountTwoAlias() {
		return (java.lang.String) getInputParameter(ACCOUNT_TWO_ALIAS_INPUT_PARAMETER);
	}
	


	protected final java.lang.String getAmountOne() {
		return (java.lang.String) getInputParameter(AMOUNT_ONE_INPUT_PARAMETER);
	}

	protected final java.lang.String getAmountTwo() {
		return (java.lang.String) getInputParameter(AMOUNT_TWO_INPUT_PARAMETER);
	}


	protected final java.lang.String getKeyAssetOneAlias() {
		return (java.lang.String) getInputParameter(KEY_ASSET_ONE_ALIAS_INPUT_PARAMETER);
	}

	protected final java.lang.String getKeyAssetTwoAlias() {
		return (java.lang.String) getInputParameter(KEY_ASSET_TWO_ALIAS_INPUT_PARAMETER);
	}

	
	protected final java.lang.String getKeyAccountOneAlias() {
		return (java.lang.String) getInputParameter(KEY_ACCOUNT_ONE_ALIAS_INPUT_PARAMETER);
	}
	
	protected final java.lang.String getKeyAccountTwoAlias() {
		return (java.lang.String) getInputParameter(KEY_ACCOUNT_TWO_ALIAS_INPUT_PARAMETER);
	}
	
	protected final java.util.List getReferenceDataOne() {
		return (java.util.List) getInputParameter(REFERENCE_DATA_ONE_INPUT_PARAMETER);
	}

	protected final java.util.List getReferenceDataTwo() {
		return (java.util.List) getInputParameter(REFERENCE_DATA_TWO_INPUT_PARAMETER);
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
			getAssetOneAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("asset one alias type is invalid");
		}
		try {
			getAssetTwoAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("asset two alias type is invalid");
		}
		try {
			getAccountTwoAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("Account Two alias type is invalid");
		}
		try {
			getAccountOneAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("Account One alias type is invalid");
		}
		try {
			getAmountOne();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("amount One type is invalid");
		}
		try {
			getAmountTwo();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("amount Two type is invalid");
		}
		try {
			getKeyAssetOneAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key asset one alias type is invalid");
		}
		try {
			getKeyAssetTwoAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key asset two alias type is invalid");
		}
		try {
			getKeyAccountTwoAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key account Two alias type is invalid");
		}
		try {
			getKeyAccountOneAlias();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("key account One alias type is invalid");
		}
		try {
			getReferenceDataOne();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("reference data one type is invalid");
		}
		try {
			getReferenceDataTwo();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("reference data two type is invalid");
		}
	}

}
