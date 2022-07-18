package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ImportClusterAutoScalerConfiguration {
    @JsonIgnore
    private Set<String>                              isSet;
    private Boolean                                  isEnabled;
    private ImportClusterResourceLimitsSpecification resourceLimits;
    private ImportClusterDownSpecification           down;
    private ImportClusterHeadroomSpecification       headroom;

    public ImportClusterAutoScalerConfiguration() {
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

    public ImportClusterResourceLimitsSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ImportClusterResourceLimitsSpecification resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public ImportClusterDownSpecification getDown() {
        return down;
    }

    public void setDown(ImportClusterDownSpecification down) {
        isSet.add("down");
        this.down = down;
    }

    public ImportClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ImportClusterHeadroomSpecification headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public static class Builder {
        private ImportClusterAutoScalerConfiguration autoScale;

        private Builder() {
            this.autoScale = new ImportClusterAutoScalerConfiguration();
        }

        public static ImportClusterAutoScalerConfiguration.Builder get() {
            return new Builder();
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            autoScale.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setResourceLimits(final ImportClusterResourceLimitsSpecification resourceLimits) {
            autoScale.setResourceLimits(resourceLimits);
            return this;
        }

        public Builder setDown(final ImportClusterDownSpecification Down) {
            autoScale.setDown(Down);
            return this;
        }

        public Builder setHeadroom(final ImportClusterHeadroomSpecification headroom) {
            autoScale.setHeadroom(headroom);
            return this;
        }

        public ImportClusterAutoScalerConfiguration build() {
            return autoScale;
        }
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isResourceLimits() {
        return isSet.contains("resourceLimits");
    }

    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headroom");
    }

}
