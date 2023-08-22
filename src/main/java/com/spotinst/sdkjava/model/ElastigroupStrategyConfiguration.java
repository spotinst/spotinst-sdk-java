package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.ElastigroupOrientationEnum;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ScalingStrategy;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.StrategySignal;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupStrategyConfiguration {
    //region Members
    @JsonIgnore
    private Set<String>                         isSet;
    private Integer                             drainingTimeout;
    private Boolean                             fallbackToOd;
    private Integer                             onDemandCount;
    private ElastigroupPersistenceConfiguration persistence;
    private Boolean                             restrictSingleAz;
    private ElastigroupRevertToSpot             revertToSpot;
    private Integer                             spotPercentage;
    private Boolean                             utilizeReservedInstances;
    private Boolean                             utilizeCommitments;
    private ElastigroupOrientationEnum          elastigroupOrientation;
    private Boolean                             considerODPricing;
    private List<StrategySignal>                signals;
    private ScalingStrategy                     scalingStrategy;

    //endregion

    //region Constructor
    private ElastigroupStrategyConfiguration() {
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

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }

    public Integer getOnDemandCount() {
        return onDemandCount;
    }

    public void setOnDemandCount(Integer onDemandCount) {
        isSet.add("onDemandCount");
        this.onDemandCount = onDemandCount;
    }

    public ElastigroupPersistenceConfiguration getPersistence() {
        return persistence;
    }

    public void setPersistence(ElastigroupPersistenceConfiguration persistence) {
        isSet.add("persistence");
        this.persistence = persistence;
    }

    public Boolean getRestrictSingleAz() {
        return restrictSingleAz;
    }

    public void setRestrictSingleAz(Boolean restrictSingleAz) {
        isSet.add("restrictSingleAz");
        this.restrictSingleAz = restrictSingleAz;
    }

    public ElastigroupRevertToSpot getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(ElastigroupRevertToSpot revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public Integer getSpotPercentage() {
        return spotPercentage;
    }

    public void setSpotPercentage(Integer spotPercentage) {
        isSet.add("spotPercentage");
        this.spotPercentage = spotPercentage;
    }

    public ElastigroupOrientationEnum getElastigroupOrientation() {
        return elastigroupOrientation;
    }

    public void setElastigroupOrientation(ElastigroupOrientationEnum elastigroupOrientation) {
        isSet.add("elastigroupOrientation");
        this.elastigroupOrientation = elastigroupOrientation;
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

    public Boolean getConsiderODPricing() {
        return considerODPricing;
    }

    public void setConsiderODPricing(Boolean considerODPricing) {
        isSet.add("considerODPricing");
        this.considerODPricing = considerODPricing;
    }

    public List<StrategySignal> getSignals() {
        return signals;
    }

    public void setSignals(List<StrategySignal> signals) {
        isSet.add("signals");
        this.signals = signals;
    }

    public ScalingStrategy getScalingStrategy() {
        return scalingStrategy;
    }

    public void setScalingStrategy(ScalingStrategy scalingStrategy) {
        isSet.add("scalingStrategy");
        this.scalingStrategy = scalingStrategy;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupStrategyConfiguration strategy;

        private Builder() {
            this.strategy = new ElastigroupStrategyConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            strategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setFallbackToOnDemand(final Boolean fallbackToOnDemand) {
            strategy.setFallbackToOd(fallbackToOnDemand);
            return this;
        }

        public Builder setOnDemandCount(final Integer onDemandCount) {
            strategy.setOnDemandCount(onDemandCount);
            return this;
        }

        public Builder setPersistence(final ElastigroupPersistenceConfiguration persistence) {
            strategy.setPersistence(persistence);
            return this;
        }

        public Builder setRestrictSingleAz(final Boolean restrictSingleAz) {
            strategy.setRestrictSingleAz(restrictSingleAz);
            return this;
        }

        public Builder setRevertToSpot(final ElastigroupRevertToSpot revertToSpot) {
            strategy.setRevertToSpot(revertToSpot);
            return this;
        }

        public Builder setSpotPercentage(final Integer spotPercentage) {
            strategy.setSpotPercentage(spotPercentage);
            return this;
        }

        public Builder setUtilizeReservedInstances(final Boolean utilizeReservedInstances) {
            strategy.setUtilizeReservedInstances(utilizeReservedInstances);
            return this;
        }

        public Builder setUtilizeCommitments(final Boolean utilizeCommitments) {
            strategy.setUtilizeCommitments(utilizeCommitments);
            return this;
        }

        public Builder setElastigroupOrientation(final ElastigroupOrientationEnum availabilityVsCostEnum) {
            strategy.setElastigroupOrientation(availabilityVsCostEnum);
            return this;
        }

        public Builder setConsiderODPricing(final Boolean considerODPricing) {
            strategy.setConsiderODPricing(considerODPricing);
            return this;
        }

        public Builder setSignals(final List<StrategySignal> signals) {
            strategy.setSignals(signals);
            return this;
        }

        public Builder setScalingStrategy(final ScalingStrategy scalingStrategy) {
            strategy.setScalingStrategy(scalingStrategy);
            return this;
        }

        public ElastigroupStrategyConfiguration build() {
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

    // Is elastigroupOrientation Set boolean method
    @JsonIgnore
    public boolean isElastigroupOrientationSet() {
        return isSet.contains("elastigroupOrientation");
    }

    // Is persistence Set boolean method
    @JsonIgnore
    public boolean isPersistenceSet() {
        return isSet.contains("persistence");
    }

    // Is restrictSingleAz Set boolean method
    @JsonIgnore
    public boolean isRestrictSingleAzSet() {
        return isSet.contains("restrictSingleAz");
    }

    // Is revertToSpot Set boolean method
    @JsonIgnore
    public boolean isRevertToSpotSet() {
        return isSet.contains("revertToSpot");
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
