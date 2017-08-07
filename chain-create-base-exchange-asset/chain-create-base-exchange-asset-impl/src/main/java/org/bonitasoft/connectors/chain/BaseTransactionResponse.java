package org.bonitasoft.connectors.chain;

import java.io.Serializable;

public class BaseTransactionResponse implements Serializable {

    private String rawTransaction;
    private Boolean error;
    private String errorCode;
    private String errorMessage;

    public BaseTransactionResponse(String rawTransaction) {
        this.rawTransaction = rawTransaction;
        this.error = false;
    }

    public BaseTransactionResponse(String errorCode, String errorMessage) {
        this.error = true;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public Boolean getError() {
        return error;
    }

    protected void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
