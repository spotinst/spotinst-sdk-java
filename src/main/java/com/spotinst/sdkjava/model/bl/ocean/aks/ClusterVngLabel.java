package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterVngLabel {
    @JsonIgnore
    private Set<String> isSet;
    private String      key;
    private String      value;

    private ClusterVngLabel() {
        isSet = new HashSet<>();
    }

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
        private ClusterVngLabel labels;

        private Builder() {
            this.labels = new ClusterVngLabel();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setKey(final String key) {
            labels.setKey(key);
            return this;
        }

        public Builder setValue(final String value) {
            labels.setValue(value);
            return this;
        }

        public ClusterVngLabel build() {
            return labels;
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
