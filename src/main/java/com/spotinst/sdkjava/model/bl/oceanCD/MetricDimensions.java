package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricDimensions {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private String                                    value;

    private MetricDimensions() {
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
        private MetricDimensions metricDimensions;

        private Builder() {
            this.metricDimensions = new MetricDimensions();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            metricDimensions.setName(name);
            return this;
        }

        public Builder setValue(final String value) {
            metricDimensions.setValue(value);
            return this;
        }

        public MetricDimensions build() {
            return metricDimensions;
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