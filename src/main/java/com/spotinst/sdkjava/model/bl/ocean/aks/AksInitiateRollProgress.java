package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AksInitiateRollProgress {
    @JsonIgnore
    private Set<String>                                 isSet;
    private String                                        unit;
    private Integer                                      value;
    private AksInitiateRollDetailedStatus       detailedStatus;

    private AksInitiateRollProgress() {
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

    public AksInitiateRollDetailedStatus getDetailedStatus() {
        return detailedStatus;
    }

    public void setDetailedStatus(AksInitiateRollDetailedStatus detailedStatus) {
        isSet.add("detailedStatus");
        this.detailedStatus = detailedStatus;
    }

    public static class Builder {
        private AksInitiateRollProgress initiateRollProgress;

        private Builder() {
            this.initiateRollProgress = new AksInitiateRollProgress();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setUnit(final String unit) {
            initiateRollProgress.setUnit(unit);
            return this;
        }

        public Builder setValue(final Integer value) {
            initiateRollProgress.setValue(value);
            return this;
        }

        public Builder setDetailedStatus(final AksInitiateRollDetailedStatus detailedStatus) {
            initiateRollProgress.setDetailedStatus(detailedStatus);
            return this;
        }

        public AksInitiateRollProgress build() {
            return initiateRollProgress;
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

    @JsonIgnore
    public boolean isDetailedStatusSet() {
        return isSet.contains("detailedStatus");
    }
}