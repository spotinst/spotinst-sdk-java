package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKEMetadata;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKEMetadata {

    private Set<String> isSet;
    private String      key;
    private String      value;

    public ApiOceanGKEMetadata() {
        isSet = new HashSet<>();
    }

    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        private ApiOceanGKEMetadata apiGkeMetadata;

        private Builder() {
            this.apiGkeMetadata = new ApiOceanGKEMetadata();
        }

        public static ApiOceanGKEMetadata.Builder get() {
            ApiOceanGKEMetadata.Builder builder = new ApiOceanGKEMetadata.Builder();
            return builder;
        }

        public ApiOceanGKEMetadata.Builder setKey(final String key) {
            apiGkeMetadata.setKey(key);
            return this;
        }

        public ApiOceanGKEMetadata.Builder setValue(final String value) {
            apiGkeMetadata.setValue(value);
            return this;
        }
        public ApiOceanGKEMetadata build() {
            return apiGkeMetadata;
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
