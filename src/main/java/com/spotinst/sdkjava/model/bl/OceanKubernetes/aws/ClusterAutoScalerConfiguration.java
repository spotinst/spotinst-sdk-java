package com.spotinst.sdkjava.model.bl.OceanKubernetes.aws;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ApiAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ClusterAutoScalerConfiguration {
    @JsonIgnore
    private Set<String>                        isSet;
    private Boolean                            isEnabled;
    private Integer                            cooldown;
    private ClusterResourceLimitsSpecification resourceLimits;
    private ClusterDownSpecification           down;
    private ClusterHeadroomSpecification       headroom;
    private Boolean                            isAutoConfig;
    private Integer                            autoHeadroomPrecentage;

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

    public ClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ClusterHeadroomSpecification headroom) {
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

    public Integer getAutoHeadroomPrecentage() {
        return autoHeadroomPrecentage;
    }

    public void setAutoHeadroomPrecentage(Integer autoHeadroomPrecentage) {
        isSet.add("autoHeadroomPrecentage");
        this.autoHeadroomPrecentage = autoHeadroomPrecentage;
    }


    public static class Builder {
        private ClusterAutoScalerConfiguration autoScale;

        private Builder() {
            this.autoScale = new ClusterAutoScalerConfiguration();
        }

        public static ClusterAutoScalerConfiguration.Builder get() {
            ClusterAutoScalerConfiguration.Builder builder = new ClusterAutoScalerConfiguration.Builder();
            return builder;
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            autoScale.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setCooldown(final Integer cooldown) {
            autoScale.setCooldown(cooldown);
            return this;
        }

        public Builder setResourceLimits(final ClusterResourceLimitsSpecification resourceLimits) {
            autoScale.setResourceLimits(resourceLimits);
            return this;
        }

        public Builder setDown(final ClusterDownSpecification Down) {
            autoScale.setDown(Down);
            return this;
        }

        public Builder setHeadroom(final ClusterHeadroomSpecification headroom) {
            autoScale.setHeadroom(headroom);
            return this;
        }

        public Builder setIsAutoConfig(final Boolean isAutoConfig) {
            autoScale.setIsAutoConfig(isAutoConfig);
            return this;
        }

        public Builder setAutoHeadroomPercentage(final Integer autoHeadroomPercentage) {
            autoScale.setAutoHeadroomPrecentage(autoHeadroomPercentage);
            return this;
        }

        public ClusterAutoScalerConfiguration build() {
            return autoScale;
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

    @JsonIgnore
    public boolean isIsAutoConfigSet() {
        return isSet.contains("isAutoConfig");
    }

    @JsonIgnore
    public boolean isAutoHeadroomPercentageSet() {
        return isSet.contains("autoHeadroomPercentage");
    }





}
