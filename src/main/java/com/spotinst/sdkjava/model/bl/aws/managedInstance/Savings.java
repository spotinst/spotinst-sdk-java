package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Savings {

    @JsonIgnore
    private Set<String> isSet;
    private String      unit;
    private Integer     value;

    private Savings() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        isSet.add("value");
        this.value = value;
    }

    public static class Builder {
        private Savings savings;

        private Builder() {
            this.savings = new Savings();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setUnit(final String unit) {
            savings.setUnit(unit);
            return this;
        }

        public Builder setValue(final Integer value) {
            savings.setValue(value);
            return this;
        }

        public Savings build() {
            return savings;
        }
    }

    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }

    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }
}
