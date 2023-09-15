package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiStrategySignal;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiScalingStrategy;

import java.util.List;
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
    private Set<String>              isSet;
    private Integer                  risk;
    private Integer                  onDemandCount;
    private String                   availabilityVsCost;
    private Integer                  drainingTimeout;
    private Boolean                  utilizeReservedInstances;
    private Boolean                  utilizeCommitments;
    private Boolean                  fallbackToOd;
    private Boolean                  restrictSingleAz;
    private ApiGroupPersistence      persistence;
    private ApiRevertToSpot          revertToSpot;
    private Boolean                  considerODPricing;
    private List<ApiStrategySignal>  signals;
    private ApiScalingStrategy       scalingStrategy;


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

    public Boolean getUtilizeCommitments() {
        return utilizeCommitments;
    }

    public void setUtilizeCommitments(Boolean utilizeCommitments) {
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

    public Boolean getRestrictSingleAz() {
        return restrictSingleAz;
    }

    public void setRestrictSingleAz(Boolean restrictSingleAz) {
        isSet.add("restrictSingleAz");
        this.restrictSingleAz = restrictSingleAz;
    }

    public ApiGroupPersistence getPersistence() {
        return persistence;
    }

    public void setPersistence(ApiGroupPersistence persistence) {
        isSet.add("persistence");
        this.persistence = persistence;
    }

    public ApiRevertToSpot getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(ApiRevertToSpot revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public Boolean getConsiderODPricing() {
        return considerODPricing;
    }

    public void setConsiderODPricing(Boolean considerODPricing) {
        isSet.add("considerODPricing");
        this.considerODPricing = considerODPricing;
    }

    public List<ApiStrategySignal> getSignals() {
        return signals;
    }

    public void setSignals(List<ApiStrategySignal> signals) {
        isSet.add("signals");
        this.signals = signals;
    }

    public ApiScalingStrategy getScalingStrategy() {
        return scalingStrategy;
    }

    public void setScalingStrategy(ApiScalingStrategy scalingStrategy) {
        isSet.add("scalingStrategy");
        this.scalingStrategy = scalingStrategy;
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

    // Is utilizeCommitments Set boolean method
    @JsonIgnore
    public boolean isUtilizeCommitmentsSet() {
        return isSet.contains("utilizeCommitments");
    }

    // Is fallbackToOd Set boolean method
    @JsonIgnore
    public boolean isFallbackToOdSet() {
        return isSet.contains("fallbackToOd");
    }

    // Is persistence Set boolean method
    @JsonIgnore
    public boolean isPersistenceSet() {
        return isSet.contains("persistence");
    }

    // Is revertToSpot Set boolean method
    @JsonIgnore
    public boolean isRevertToSpotSet() {
        return isSet.contains("revertToSpot");
    }

    // Is restrictSingleAz Set boolean method
    @JsonIgnore
    public boolean isRestrictSingleAzSet() {
        return isSet.contains("restrictSingleAz");
    }

    // Is considerODPricing Set boolean method
    @JsonIgnore
    public boolean isConsiderODPricingSet() {
        return isSet.contains("considerODPricing");
    }

    // Is signals Set boolean method
    @JsonIgnore
    public boolean isSignalsSet() {
        return isSet.contains("signals");
    }

    // Is scalingStrategy Set boolean method
    @JsonIgnore
    public boolean isScalingStrategySet() {
        return isSet.contains("scalingStrategy");
    }

    //endregion

}
