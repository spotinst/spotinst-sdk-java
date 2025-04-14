package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScalingDimensionGcp {

    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      value;

    private ElastigroupScalingDimensionGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public static class Builder {
        private ElastigroupScalingDimensionGcp dimension;

        private Builder() {
            this.dimension = new ElastigroupScalingDimensionGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            dimension.setName(name);
            return this;
        }

        public Builder setValue(final String value) {
            dimension.setValue(value);
            return this;
        }

        public ElastigroupScalingDimensionGcp build() {
            return dimension;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }
}
