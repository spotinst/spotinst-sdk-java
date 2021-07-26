package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class OceanGKELabels {

    private Set<String> isSet;
    private String      key;
    private String      value;

    public OceanGKELabels(){isSet = new HashSet<>();
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

    public static class Builder {
        private OceanGKELabels gkeLabels;

        private Builder() {
            this.gkeLabels = new OceanGKELabels();
        }

        public static OceanGKELabels.Builder get() {
            OceanGKELabels.Builder builder = new OceanGKELabels.Builder();
            return builder;
        }

        public OceanGKELabels.Builder setKey(final String key) {
            gkeLabels.setKey(key);
            return this;
        }

        public OceanGKELabels.Builder setValue(final String value) {
            gkeLabels.setValue(value);
            return this;
        }
        public OceanGKELabels build() {
            return gkeLabels;
        }
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
