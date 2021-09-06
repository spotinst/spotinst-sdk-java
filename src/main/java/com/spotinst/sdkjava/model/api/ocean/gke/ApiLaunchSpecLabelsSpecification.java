package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

public class ApiLaunchSpecLabelsSpecification {

    private Set<String> isSet;
    private String      key;
    private String      value;

    public ApiLaunchSpecLabelsSpecification(){ isSet = new HashSet<>();
    }
    public String getKey(){
        return key;
    }

    public void setKey(String key){
        isSet.add("key");
        this.key = key;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    @JsonIgnore
    public boolean isKeySet() {
        return isSet.contains("key");
    }
    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }

}
