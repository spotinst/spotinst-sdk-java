package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterAutoScalerConfiguration {
    @JsonIgnore
    private Set<String>                        isSet;
    private Boolean                            isEnabled;
    private Integer                            autoHeadroomPercentage;
    private Integer                            cooldown;
    private ClusterDownSpecification           down;
    private Boolean                            enableAutomaticAndManualHeadroom;
    private LaunchSpecHeadroomsSpecification   headroom;
    private Boolean                            isAutoConfig;
    private ClusterResourceLimitsSpecification resourceLimits;

    public ClusterAutoScalerConfiguration() {
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

    public Integer getAutoHeadroomPercentage() {
        return autoHeadroomPercentage;
    }

    public void setAutoHeadroomPercentage(Integer autoHeadroomPercentage) {
        isSet.add("autoHeadroomPercentage");
        this.autoHeadroomPercentage = autoHeadroomPercentage;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }


    public ClusterResourceLimitsSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ClusterResourceLimitsSpecification resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public ClusterDownSpecification getDown() {
        return down;
    }

    public void setDown(ClusterDownSpecification down) {
        isSet.add("down");
        this.down = down;
    }

    public LaunchSpecHeadroomsSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(LaunchSpecHeadroomsSpecification headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public Boolean getIsAutoConfig() {
        return isAutoConfig;
    }

    public void setIsAutoConfig(Boolean isAutoConfig) {
        isSet.add("isAutoConfig");
        this.isAutoConfig = isAutoConfig;
    }

    public Boolean getEnableAutomaticAndManualHeadroom() {
        return enableAutomaticAndManualHeadroom;
    }

    public void setEnableAutomaticAndManualHeadroom(Boolean enableAutomaticAndManualHeadroom) {
        isSet.add("enableAutomaticAndManualHeadroom");
        this.enableAutomaticAndManualHeadroom = enableAutomaticAndManualHeadroom;
    }

    public static class Builder {
        private ClusterAutoScalerConfiguration autoScaler;

        private Builder() {
            this.autoScaler = new ClusterAutoScalerConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            autoScaler.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setCooldown(final Integer cooldown) {
            autoScaler.setCooldown(cooldown);
            return this;
        }

        public Builder setEnableAutomaticAndManualHeadroom(final Boolean enableAutomaticAndManualHeadroom) {
            autoScaler.setEnableAutomaticAndManualHeadroom(enableAutomaticAndManualHeadroom);
            return this;
        }

        public Builder setResourceLimits(final ClusterResourceLimitsSpecification resourceLimits) {
            autoScaler.setResourceLimits(resourceLimits);
            return this;
        }

        public Builder setDown(final ClusterDownSpecification Down) {
            autoScaler.setDown(Down);
            return this;
        }

        public Builder setHeadroom(final LaunchSpecHeadroomsSpecification headroom) {
            autoScaler.setHeadroom(headroom);
            return this;
        }

        public Builder setIsAutoConfig(final Boolean isAutoConfig) {
            autoScaler.setIsAutoConfig(isAutoConfig);
            return this;
        }

        public Builder setAutoHeadroomPercentage(final Integer autoHeadroomPercentage) {
            autoScaler.setAutoHeadroomPercentage(autoHeadroomPercentage);
            return this;
        }

        public ClusterAutoScalerConfiguration build() {
            return autoScaler;
        }
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isCooldownSet() {
        return isSet.contains("cooldown");
    }

    @JsonIgnore
    public boolean isResourceLimitsSet() {
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

    @JsonIgnore
    public boolean isIsAutoConfigSet() {
        return isSet.contains("isAutoConfig");
    }

    @JsonIgnore
    public boolean isAutoHeadroomPercentageSet() {
        return isSet.contains("autoHeadroomPercentage");
    }

    @JsonIgnore
    public boolean isEnableAutomaticAndManualHeadroomSet() {
        return isSet.contains("enableAutomaticAndManualHeadroom");
    }

}
