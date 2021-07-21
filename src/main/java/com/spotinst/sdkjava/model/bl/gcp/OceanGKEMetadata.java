package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OceanGKEMetadata {

    private Set<String> isSet;
    private String      key;
    private String      value;

    private OceanGKEMetadata() {
        isSet = new HashSet<>();
    }
    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getValue(){
        return key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        private OceanGKEMetadata gkeMetadata;

        private Builder() {
            this.gkeMetadata = new OceanGKEMetadata();
        }

        public static OceanGKEMetadata.Builder get() {
            OceanGKEMetadata.Builder builder = new OceanGKEMetadata.Builder();
            return builder;
        }

        public OceanGKEMetadata.Builder setKey(final String key) {
            gkeMetadata.setKey(key);
            return this;
        }

        public OceanGKEMetadata.Builder setValue(final String value) {
            gkeMetadata.setValue(value);
            return this;
        }
        public OceanGKEMetadata build() {
            return gkeMetadata;
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
    //endregion

}
