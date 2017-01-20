package org.bonitasoft.connectors.chain;

import java.io.Serializable;

public class Balance implements Serializable {
    
    private Long amount;
    
    public Balance(Long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
