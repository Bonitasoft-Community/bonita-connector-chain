package org.bonitasoft.connectors.chain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Asset implements Serializable {
    
    private String alias;
    private String id;
    private Map<String,Serializable> definition;
    private Map<String,Serializable> tags;

    
    public Asset(String id, String alias, Map<String, Object> definition, Map<String,Object> tags) {
        this.id = id;
        this.alias = alias;
        this.definition= new HashMap<String, Serializable>();
        for (Entry<String, Object> e: definition.entrySet()) {
            this.definition.put(e.getKey(), (Serializable)e.getValue());
        }
        this.tags= new HashMap<String, Serializable>();
        for (Entry<String, Object> e: tags.entrySet()) {
            this.tags.put(e.getKey(), (Serializable)e.getValue());
        }
        
    }
    
    public String getId() {
      return id;
    }
    
    public void setId(String id) {
      this.id = id;
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

    public Map<String, Serializable> getTags() {
        return tags;
    }

    public void setTags(Map<String, Serializable> tags) {
        this.tags = tags;
    }
    
    

}
