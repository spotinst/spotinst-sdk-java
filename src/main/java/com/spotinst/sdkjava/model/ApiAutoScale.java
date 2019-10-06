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
    private ElastigroupDownSpecification     Down;
    private ElastigroupHeadroomSpecification headroom;
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

    public ElastigroupDownSpecification getDown() {
        return Down;
    }

    public void setDown(ElastigroupDownSpecification down) {
        isSet.add("Down");
        this.Down = Down;
    }

    public ElastigroupHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ElastigroupHeadroomSpecification headroom) {
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
    public boolean isDownSet() {return isSet.contains("Down");}

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
