package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class LaunchSpecMetadataSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      key;
    private String      value;

    public LaunchSpecMetadataSpecification() {
        isSet = new HashSet<>();
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
        private LaunchSpecMetadataSpecification metadata;

        private Builder() {
            this.metadata = new LaunchSpecMetadataSpecification();
        }

        public static LaunchSpecMetadataSpecification.Builder get() {
            LaunchSpecMetadataSpecification.Builder builder = new LaunchSpecMetadataSpecification.Builder();
            return builder;
        }

        public LaunchSpecMetadataSpecification.Builder setKey(final String key) {
            metadata.setKey(key);
            return this;
        }

        public LaunchSpecMetadataSpecification.Builder setValue(final String value) {
            metadata.setValue(value);
            return this;
        }
        public LaunchSpecMetadataSpecification build() {
            return metadata;
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
