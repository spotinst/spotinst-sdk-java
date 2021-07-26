package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKELabels;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKELabels {

    private Set<String> isSet;
    private String      key;
    private String      value;

    public ApiOceanGKELabels(){isSet = new HashSet<>();
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
        private ApiOceanGKELabels apiGkeLabels;

        private Builder() {
            this.apiGkeLabels = new ApiOceanGKELabels();
        }

        public static ApiOceanGKELabels.Builder get() {
            ApiOceanGKELabels.Builder builder = new ApiOceanGKELabels.Builder();
            return builder;
        }

        public ApiOceanGKELabels.Builder setKey(final String key) {
            apiGkeLabels.setKey(key);
            return this;
        }

        public ApiOceanGKELabels.Builder setValue(final String value) {
            apiGkeLabels.setValue(value);
            return this;
        }
        public ApiOceanGKELabels build() {
            return apiGkeLabels;
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
