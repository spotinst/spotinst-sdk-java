package com.spotinst.sdkjava.model.api.ocean.kubernetes;


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
    private Set<String>                           isSet;
    private Boolean                               isEnabled;
    private Integer                               cooldown;
    private ApiClusterResourceLimitsSpecification resourceLimits;
    private ApiClusterDownSpecification           down;
    private ApiClusterHeadroomSpecification       headroom;
    private Boolean                               isAutoConfig;
    private Integer                               autoHeadroomPrecentage;

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

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
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

    public ApiClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiClusterHeadroomSpecification headroom) {
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

    public void setAutoHeadroomPercentage(Integer autoHeadroomPrecentage) {
        isSet.add("autoHeadroomPrecentage");
        this.autoHeadroomPrecentage = autoHeadroomPrecentage;
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
