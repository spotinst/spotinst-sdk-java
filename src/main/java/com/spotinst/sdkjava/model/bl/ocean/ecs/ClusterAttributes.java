package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterAttributes {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      key;
    private String      value;
    //endregion

    //region Constructors
    private ClusterAttributes() {
        isSet = new HashSet<>();
    }
    //endregion


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public static class Builder {
        private ClusterAttributes clusterAttributes;

        private Builder() {
            this.clusterAttributes = new ClusterAttributes();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setKey(final String key) {
            clusterAttributes.setKey(key);
            return this;
        }

        public Builder setValue(final String value) {
            clusterAttributes.setValue(value);
            return this;
        }

        public ClusterAttributes build() {
            return clusterAttributes;
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


