package org.bonitasoft.connectors.chain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Asset implements Serializable {
    
    private String alias;
    private Map<String,Serializable> definition;
    
    public Asset(String alias, Map<String, Object> definition) {
        this.alias = alias;
        this.definition= new HashMap<String, Serializable>();
        for (Entry<String, Object> e: definition.entrySet()) {
            this.definition.put(e.getKey(), (Serializable)e.getValue());
        }
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Map<String, Serializable> getDefinition() {
        return definition;
    }

    public void setDefinition(Map<String, Serializable> definition) {
        this.definition = definition;
    }
    
    

}
