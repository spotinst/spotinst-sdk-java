package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.AzureOrientationEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStrategyAzure implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>              isSet;
    private Integer                  spotPercentage;
    private Integer                  onDemandCount;
    private Integer                  drainingTimeout;
    private Boolean                  fallbackToOd;
    private ApiRevertToSpotSpecAzure revertToSpot;
    private List<String>             optimizationWindows;
    private AzureOrientationEnum     orientation;


    //todo add  signals in future

    //region Constructor

    public ApiStrategyAzure() {
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

    public Integer getSpotPercentage() {
        return spotPercentage;
    }

    public void setSpotPercentage(Integer spotPercentage) {
        isSet.add("spotPercentage");
        this.spotPercentage = spotPercentage;
    }

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }

    public List<String> getOptimizationWindows() {
        return optimizationWindows;
    }

    public void setOptimizationWindows(List<String> optimizationWindows) {
        isSet.add("optimizationWindows");
        this.optimizationWindows = optimizationWindows;
    }

    public ApiRevertToSpotSpecAzure getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(ApiRevertToSpotSpecAzure revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public Integer getOnDemandCount() {
        return onDemandCount;
    }

    public void setOnDemandCount(Integer onDemandCount) {
        isSet.add("onDemandCount");
        this.onDemandCount = onDemandCount;
    }


    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public AzureOrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(AzureOrientationEnum orientation) {
        isSet.add("azureOrientation");
        this.orientation = orientation;
    }

    //endregion

    //region isSet methods

    // Is spotPercentage Set boolean method
    @JsonIgnore
    public boolean isSpotPercentageSet() {
        return isSet.contains("spotPercentage");
    }

    // Is fallbackToOd Set boolean method
    @JsonIgnore
    public boolean isFallbackToOdSet() {
        return isSet.contains("fallbackToOd");
    }

    // Is onDemandCount Set boolean method
    @JsonIgnore
    public boolean isOnDemandCountSet() {
        return isSet.contains("onDemandCount");
    }

    // Is optimizationWindows Set boolean method
    @JsonIgnore
    public boolean isOptimizationWindowsSet() {
        return isSet.contains("optimizationWindows");
    }

    // Is revertToSpot Set boolean method
    @JsonIgnore
    public boolean isRevertToSpotSet() {
        return isSet.contains("revertToSpot");
    }

    // Is drainingTimeout Set boolean method
    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    //Is azureOrientation Set boolean method
    @JsonIgnore
    public boolean isOrientationSet() {
        return isSet.contains("orientation");
    }
    //endregion
}
