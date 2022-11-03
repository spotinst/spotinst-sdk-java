package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AzureOrientationEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupStrategyConfigurationAzure {
    //region Members
    @JsonIgnore
    private Set<String>           isSet;
    private Integer               spotPercentage;
    private Integer               onDemandCount;
    private Integer               drainingTimeout;
    private Boolean               fallbackToOd;
    private RevertToSpotSpecAzure revertToSpot;
    private List<String>          optimizationWindows;
    private AzureOrientationEnum  orientation;
    //todo add  signals in future
    //endregion

    //region Constructor
    private ElastigroupStrategyConfigurationAzure() {
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

    public RevertToSpotSpecAzure getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(RevertToSpotSpecAzure revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public List<String> getOptimizationWindows() {
        return optimizationWindows;
    }

    public void setOptimizationWindows(List<String> optimizationWindows) {
        isSet.add("optimizationWindows");
        this.optimizationWindows = optimizationWindows;
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
        isSet.add("orientation");
        this.orientation = orientation;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupStrategyConfigurationAzure strategy;

        private Builder() {
            this.strategy = new ElastigroupStrategyConfigurationAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            strategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setOnDemandCount(final Integer onDemandCount) {
            strategy.setOnDemandCount(onDemandCount);
            return this;
        }

        public Builder setSpotPercentage(final Integer spotPercentage) {
            strategy.setSpotPercentage(spotPercentage);
            return this;
        }

        public Builder setFallbackToOd(final Boolean fallbackToOd) {
            strategy.setFallbackToOd(fallbackToOd);
            return this;
        }

        public Builder setRevertToSpot(final RevertToSpotSpecAzure revertToSpot) {
            strategy.setRevertToSpot(revertToSpot);
            return this;
        }

        public Builder setOptimizationWindows(final List<String> optimizationWindows) {
            strategy.setOptimizationWindows(optimizationWindows);
            return this;
        }

        public Builder setOrientation(final AzureOrientationEnum orientation){
            strategy.setOrientation(orientation);
            return  this;
        }

        public ElastigroupStrategyConfigurationAzure build() {
            // TODO : Validations
            return strategy;
        }
    }
    //endregion

    //region isSet methods
    // Is spotPercentage Set boolean method
    @JsonIgnore
    public boolean isSpotPercentageSet() {
        return isSet.contains("spotPercentage");
    }


    // Is onDemandCount Set boolean method
    @JsonIgnore
    public boolean isOnDemandCountSet() {
        return isSet.contains("onDemandCount");
    }

    // Is fallbackToOd Set boolean method
    @JsonIgnore
    public boolean isFallbackToOdSet() {
        return isSet.contains("fallbackToOd");
    }

    // Is drainingTimeout Set boolean method
    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    // Is revertToSpot Set boolean method
    @JsonIgnore
    public boolean isRevertToSpotSet() {
        return isSet.contains("revertToSpot");
    }

    // Is optimizationWindows Set boolean method
    @JsonIgnore
    public boolean isOptimizationWindowsSet() {
        return isSet.contains("optimizationWindows");
    }

    // Is azureOrientation Set boolean method
    @JsonIgnore
    public boolean isOrientationSet() {
        return isSet.contains("orientation");
    }
    //endregion
}
