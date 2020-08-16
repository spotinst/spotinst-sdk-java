package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

public class ClusterStrategyConfiguration {
    @JsonIgnore
    private Set<String>                isSet;
    private Boolean                    fallbackToOd;
    private Boolean                    utilizeReservedInstances;
    private Integer                    drainingTimeout;
    private Integer                    gracePeriod;


    private ClusterStrategyConfiguration() {
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

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public static class Builder {
        private ClusterStrategyConfiguration strategy;

        private Builder() {
            this.strategy = new ClusterStrategyConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setFallbackToOnDemand(final Boolean fallbackToOnDemand) {
            strategy.setFallbackToOd(fallbackToOnDemand);
            return this;
        }

        public Builder setUtilizeReservedInstances(final Boolean utilizeReservedInstances) {
            strategy.setUtilizeReservedInstances(utilizeReservedInstances);
            return this;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            strategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setGracePeriod(final Integer gracePeriod) {
            strategy.setGracePeriod(gracePeriod);
            return this;
        }

        public ClusterStrategyConfiguration build() {
            return strategy;
        }
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
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }
}
