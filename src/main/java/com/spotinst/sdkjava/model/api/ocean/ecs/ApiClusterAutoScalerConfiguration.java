package com.spotinst.sdkjava.model.api.ocean.ecs;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiClusterAutoScalerConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                             isSet;
    private Boolean                                 isEnabled;
    private Integer                                 autoHeadroomPercentage;
    private Integer                                 cooldown;
    private ApiClusterAttributes                    attribute;
    private ApiClusterDownSpecification             down;
    private ApiClusterHeadroomsSpecification        headroom;
    private ApiClusterResourceLimitsSpecification   resourceLimits;
    private Boolean                                 isAutoConfig;
    private Boolean                                 shouldScaleDownNonServiceTasks;
    private Boolean                                 enableAutomaticAndManualHeadroom;

    public ApiClusterAutoScalerConfiguration() {
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

    public ApiClusterAttributes getAttribute() { return attribute; }

    public void setAttribute(ApiClusterAttributes attribute)
    {
        isSet.add("attribute");
        this.attribute = attribute;
    }

    public ApiClusterResourceLimitsSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiClusterResourceLimitsSpecification resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public ApiClusterDownSpecification getDown() {
        return down;
    }

    public void setDown(ApiClusterDownSpecification down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiClusterHeadroomsSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiClusterHeadroomsSpecification headroom) {
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

    public void setenableAutomaticAndManualHeadroom(Boolean enableAutomaticAndManualHeadroom) {
        isSet.add("enableAutomaticAndManualHeadroom");
        this.enableAutomaticAndManualHeadroom = enableAutomaticAndManualHeadroom;
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
    public boolean isResourceLimitsSet() { return isSet.contains("resourceLimits"); }

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
    public boolean isEnableAutomaticAndManualHeadroomSet() {return isSet.contains("enableAutomaticAndManualHeadroom");}
}