package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiStrategy implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     risk;
    private Integer     onDemandCount;
    private String      availabilityVsCost;
    private Integer     drainingTimeout;
    private Boolean     utilizeReservedInstances;
    private Boolean     fallbackToOd;

    //region Constructor

    public ApiStrategy() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        isSet.add("risk");
        this.risk = risk;
    }

    public Integer getOnDemandCount() {
        return onDemandCount;
    }

    public void setOnDemandCount(Integer onDemandCount) {
        isSet.add("onDemandCount");
        this.onDemandCount = onDemandCount;
    }

    public String getAvailabilityVsCost() {
        return availabilityVsCost;
    }

    public void setAvailabilityVsCost(String availabilityVsCost) {
        isSet.add("availabilityVsCost");
        this.availabilityVsCost = availabilityVsCost;
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

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }
    //endregion

    //region isSet methods

    // Is risk Set boolean method
    @JsonIgnore
    public boolean isRiskSet() {
        return isSet.contains("risk");
    }


    // Is onDemandCount Set boolean method
    @JsonIgnore
    public boolean isOnDemandCountSet() {
        return isSet.contains("onDemandCount");
    }


    // Is availabilityVsCost Set boolean method
    @JsonIgnore
    public boolean isAvailabilityVsCostSet() {
        return isSet.contains("availabilityVsCost");
    }


    // Is drainingTimeout Set boolean method
    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }


    // Is utilizeReservedInstances Set boolean method
    @JsonIgnore
    public boolean isUtilizeReservedInstancesSet() {
        return isSet.contains("utilizeReservedInstances");
    }

    // Is fallbackToOd Set boolean method
    @JsonIgnore
    public boolean isFallbackToOdSet() {
        return isSet.contains("fallbackToOd");
    }


    //endregion
}
