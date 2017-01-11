package org.bonitasoft.connectors.chain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Account implements Serializable {
    
    private String alias;
    private Map<String,Serializable> tags;
    
    public Account(String alias, Map<String, Object> tags) {
        this.alias = alias;
        this.tags= new HashMap<String, Serializable>();
        for (Entry<String, Object> e: tags.entrySet()) {
            this.tags.put(e.getKey(), (Serializable)e.getValue());
        }
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Map<String, Serializable> getTags() {
        return tags;
    }

    public void setTags(Map<String, Serializable> tags) {
        this.tags = tags;
    }
    
    

}
