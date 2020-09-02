package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.ElastigroupOrientationEnumAzure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupStrategyConfigurationAzure {
    //region Members
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer                         spotPercentage;
    private Integer                         onDemandCount;
    private Integer                         drainingTimeout;
    private Boolean                         utilizeReservedInstances;
    private Boolean                         fallbackToOd;
    private ElastigroupOrientationEnumAzure elastigroupOrientation;
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

    public Integer getOnDemandCount() {
        return onDemandCount;
    }

    public void setOnDemandCount(Integer onDemandCount) {
        isSet.add("onDemandCount");
        this.onDemandCount = onDemandCount;
    }

    public ElastigroupOrientationEnumAzure getElastigroupOrientation() {
        return elastigroupOrientation;
    }

    public void setElastigroupOrientation(ElastigroupOrientationEnumAzure elastigroupOrientation) {
        isSet.add("elastigroupOrientation");
        this.elastigroupOrientation = elastigroupOrientation;
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

    //region Builder class
    public static class Builder {
        private ElastigroupStrategyConfigurationAzure strategy;

        private Builder() {
            this.strategy = new ElastigroupStrategyConfigurationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUtilizeReservedInstances(final Boolean utilizeReservedInstances) {
            strategy.setUtilizeReservedInstances(utilizeReservedInstances);
            return this;
        }

        public Builder setElastigroupOrientation(final ElastigroupOrientationEnumAzure availabilityVsCostEnum) {
            strategy.setElastigroupOrientation(availabilityVsCostEnum);
            return this;
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

        public Builder setSpotPercentage(final Integer spotPercentage) {
            strategy.setSpotPercentage(spotPercentage);
            return this;
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

    // Is elastigroupOrientation Set boolean method
    @JsonIgnore
    public boolean isElastigroupOrientationSet() {
        return isSet.contains("elastigroupOrientation");
    }

    //endregion
}
