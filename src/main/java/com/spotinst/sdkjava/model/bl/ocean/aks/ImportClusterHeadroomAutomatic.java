package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportClusterHeadroomAutomatic {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     isEnabled;
    private Integer     percentage;

    private ImportClusterHeadroomAutomatic() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        isSet.add("percentage");
        this.percentage = percentage;
    }

    public static class Builder {
        private ImportClusterHeadroomAutomatic headroom;

        private Builder() {
            this.headroom = new ImportClusterHeadroomAutomatic();
        }

        public static ImportClusterHeadroomAutomatic.Builder get() {
            return new Builder();
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            headroom.setIsEnabled(isEnabled);
            return this;
        }

        public ImportClusterHeadroomAutomatic.Builder setPercentage(final Integer percentage) {
            headroom.setPercentage(percentage);
            return this;
        }

        public ImportClusterHeadroomAutomatic build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {return isSet.contains("isEnabled");}

    @JsonIgnore
    public boolean isPercentageSet() {return isSet.contains("percentage");}

}
