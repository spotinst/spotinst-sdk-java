package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiClusterStrategyConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     fallbackToOd;
    private Boolean     utilizeReservedInstances;
    private Integer     drainingTimeout;
    private Integer     spotPercentage;
    private Boolean     utilizeCommitments;

    public ApiClusterStrategyConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public Boolean getUtilizeReservedInstances() {
        return utilizeReservedInstances;
    }

    public void setUtilizeReservedInstances(Boolean utilizeReservedInstances) {
        isSet.add("utilizeReservedInstances");
        this.utilizeReservedInstances = utilizeReservedInstances;
    }

    public Boolean getUtilizeCommitments(){
        return utilizeCommitments;
    }

    public void setUtilizeCommitments(Boolean utilizeCommitments){
        isSet.add("utilizeCommitments");
        this.utilizeCommitments = utilizeCommitments;
    }

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }

    public Integer getspotPercentage() {
        return spotPercentage;
    }

    public void setspotPercentage(Integer spotPercentage) {
        isSet.add("spotPercentage");
        this.spotPercentage = spotPercentage;
    }

    @JsonIgnore
    public boolean isFallbackToOdSet() {
        return isSet.contains("fallbackToOd");
    }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isUtilizeReservedInstancesSet() {
        return isSet.contains("utilizeReservedInstances");
    }

    @JsonIgnore
    public boolean isUtilizeCommitments() {
        return isSet.contains("utilizeCommitments");
    }

    @JsonIgnore
    public boolean isspotPercentageSet() {
        return isSet.contains("spotPercentage");
    }
}
