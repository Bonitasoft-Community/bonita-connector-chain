package org.bonitasoft.connectors.chain;

import java.io.Serializable;

public class Balance implements Serializable {
    
    private long amount;
    
    public Balance(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
