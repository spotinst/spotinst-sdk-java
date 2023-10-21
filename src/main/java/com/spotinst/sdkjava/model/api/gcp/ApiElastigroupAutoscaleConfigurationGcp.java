package com.spotinst.sdkjava.model.api.gcp;


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
public class ApiElastigroupAutoscaleConfigurationGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private Integer                                     cooldown;
    private ApiElastigroupDownSpecificationGcp          down;
    private ApiElastigroupHeadroomSpecificationGcp      headroom;
    private Boolean                                     isAutoConfig;
    private Boolean                                     isEnabled;

    public ApiElastigroupAutoscaleConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public ApiElastigroupDownSpecificationGcp getDown() {
        return down;
    }

    public void setDown(ApiElastigroupDownSpecificationGcp down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiElastigroupHeadroomSpecificationGcp getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiElastigroupHeadroomSpecificationGcp headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    public Boolean getIsAutoConfig() {
        return isAutoConfig;
    }

    public void setIsAutoConfig(Boolean isAutoConfig) {
        isSet.add("isAutoConfig");
        this.isAutoConfig = isAutoConfig;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
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
}
