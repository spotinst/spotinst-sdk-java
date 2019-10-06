package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAutoScale {
    //region Members
    @JsonIgnore
    private Set<String>                      isSet;
    private Boolean                          isEnabled;
    private Integer                          cooldown;
    private ApiDown                          down;
    private ApiHeadroom                      headroom;
    private Boolean                          isAutoConfig;
    private Boolean                          shouldScaleDownNonServiceTasks;
    //endregion

    //region Constructor
    public ApiAutoScale() {isSet = new HashSet<>();}
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public ApiDown getDown() {
        return down;
    }

    public void setDown(ApiDown down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiHeadroom getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiHeadroom headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    public Boolean getAutoConfig() {
        return isAutoConfig;
    }

    public void setIsAutoConfig(Boolean autoConfig) {
        isSet.add("isAutoConfig");
        this.isAutoConfig = isAutoConfig;
    }

    public Boolean getShouldScaleDownNonServiceTasks() {
        return shouldScaleDownNonServiceTasks;
    }

    public void setShouldScaleDownNonServiceTasks(Boolean shouldScaleDownNonServiceTasks) {
        isSet.add("shouldScaleDownNonServiceTasks");
        this.shouldScaleDownNonServiceTasks = shouldScaleDownNonServiceTasks;
    }

    //endregion
    //region isSet methods
    // Is isEnabled Set boolean method
    @JsonIgnore
    public boolean isIsEnabledSet() {return isSet.contains("isEnabled");}

    // Is cooldown Set boolean method
    @JsonIgnore
    public boolean isCooldownSet() {return isSet.contains("cooldown");}

    // Is Down Set boolean method
    @JsonIgnore
    public boolean isDownSet() {return isSet.contains("down");}

    // Is Down Set boolean method
    @JsonIgnore
    public boolean isHeadroomSet() {return isSet.contains("headroom");}

    // Is isAutoConfig Set boolean method
    @JsonIgnore
    public boolean isIsAutoConfigSet() {return isSet.contains("isAutoConfig");}

    // Is shouldScaleDownNonServiceTasks Set boolean method
    @JsonIgnore
    public boolean isShouldScaleDownNonServiceTasksSet() {return isSet.contains("shouldScaleDownNonServiceTasks");}

    //endregion
}
