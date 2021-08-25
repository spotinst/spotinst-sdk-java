package com.spotinst.sdkjava.model.bl.ocean.ecs;

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
    private ClusterAttributes                  attributes;
    private Integer                            autoHeadroomPercentage;
    private Integer                            cooldown;
    private ClusterDownSpecification           down;
    private ClusterHeadroomsSpecification      headroom;
    private ClusterResourceLimitsSpecification resourceLimits;
    private Boolean                            isAutoConfig;
    private Boolean                            shouldScaleDownNonServiceTasks;
    private Boolean                            enableAutomaticAndManualHeadroom;

    public ClusterAutoScalerConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getIsEnabled() { return isEnabled; }

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

    public ClusterAttributes getAttribute() { return attributes; }

    public void setAttribute(ClusterAttributes attributes)
    {
        isSet.add("attribute");
        this.attributes = attributes;
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

    public ClusterHeadroomsSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ClusterHeadroomsSpecification headroom) {
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

    public Boolean getshouldScaleDownNonServiceTasks() {
        return shouldScaleDownNonServiceTasks;
    }

    public void setshouldScaleDownNonServiceTasks(Boolean shouldScaleDownNonServiceTasks) {
        isSet.add("shouldScaleDownNonServiceTasks");
        this.shouldScaleDownNonServiceTasks = shouldScaleDownNonServiceTasks;
    }

    public Boolean getenableAutomaticAndManualHeadroom() {
        return enableAutomaticAndManualHeadroom;
    }

    public void setEnableAutomaticAndManualHeadroom(Boolean enableAutomaticAndManualHeadroom) {
        isSet.add("enableAutomaticAndManualHeadroom");
        this.enableAutomaticAndManualHeadroom = enableAutomaticAndManualHeadroom;
    }

    public static class Builder {
        private ClusterAutoScalerConfiguration autoScale;

        private Builder() {
            this.autoScale = new ClusterAutoScalerConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
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

        public Builder setAttributes(final ClusterAttributes attributes){
            autoScale.setAttribute(attributes);
            return this;
        }

        public Builder setShouldScaleDownNonServiceTasks(final Boolean shouldScaleDownNonServiceTasks){
            autoScale.setshouldScaleDownNonServiceTasks(shouldScaleDownNonServiceTasks);
            return this;
        }
        public Builder setEnableAutomaticAndManualHeadroom(final Boolean enableAutomaticAndManualHeadroom){
            autoScale.setEnableAutomaticAndManualHeadroom(enableAutomaticAndManualHeadroom);
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

        public Builder setHeadroom(final ClusterHeadroomsSpecification headroom) {
            autoScale.setHeadroom(headroom);
            return this;
        }

        public Builder setIsAutoConfig(final Boolean isAutoConfig) {
            autoScale.setIsAutoConfig(isAutoConfig);
            return this;
        }

        public Builder setAutoHeadroomPercentage(final Integer autoHeadroomPercentage) {
            autoScale.setAutoHeadroomPercentage(autoHeadroomPercentage);
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
    public boolean isAttributesSet() {
        return isSet.contains("attributes");
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
    public boolean isShouldScaleDownNonServiceTasksSet() {return isSet.contains("shouldScaleDownNonServiceTasks");}

    @JsonIgnore
    public boolean isEnableAutomaticAndManualHeadroomSet () {return isSet.contains("enableAutomaticAndManualHeadroom");}

}
