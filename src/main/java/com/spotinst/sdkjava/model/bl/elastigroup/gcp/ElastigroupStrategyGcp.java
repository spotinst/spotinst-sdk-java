package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupStrategyGcp {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private Integer                           preemptiblePercentage;
    private Integer                           onDemandCount;
    private Integer                           drainingTimeout;
    private Boolean                           fallbackToOd;
    private ElastigroupRevertToPreemptibleGcp revertToPreemptible;
    private List<String>                      optimizationWindows;
    //endregion

    //region Constructor
    private ElastigroupStrategyGcp() {
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

    public Integer getPreemptiblePercentage() {
        return preemptiblePercentage;
    }

    public void setPreemptiblePercentage(Integer preemptiblePercentage) {
        isSet.add("preemptiblePercentage");
        this.preemptiblePercentage = preemptiblePercentage;
    }

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }

    public ElastigroupRevertToPreemptibleGcp getRevertToPreemptible() {
        return revertToPreemptible;
    }

    public void setRevertToPreemptible(ElastigroupRevertToPreemptibleGcp revertToPreemptible) {
        isSet.add("revertToPreemptible");
        this.revertToPreemptible = revertToPreemptible;
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
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupStrategyGcp strategy;

        private Builder() {
            this.strategy = new ElastigroupStrategyGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            strategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setOnDemandCount(final Integer onDemandCount) {
            strategy.setOnDemandCount(onDemandCount);
            return this;
        }

        public Builder setPreemptiblePercentage(final Integer preemptiblePercentage) {
            strategy.setPreemptiblePercentage(preemptiblePercentage);
            return this;
        }

        public Builder setFallbackToOd(final Boolean fallbackToOd) {
            strategy.setFallbackToOd(fallbackToOd);
            return this;
        }

        public Builder setRevertToPreemptible(final ElastigroupRevertToPreemptibleGcp revertToPreemptible) {
            strategy.setRevertToPreemptible(revertToPreemptible);
            return this;
        }

        public Builder setOptimizationWindows(final List<String> optimizationWindows) {
            strategy.setOptimizationWindows(optimizationWindows);
            return this;
        }

        public ElastigroupStrategyGcp build() {
            return strategy;
        }
    }
    //endregion

    //region isSet methods
    // Is preemptiblePercentage Set boolean method
    @JsonIgnore
    public boolean isPreemptiblePercentageSet() { return isSet.contains("preemptiblePercentage"); }

    // Is onDemandCount Set boolean method
    @JsonIgnore
    public boolean isOnDemandCountSet() { return isSet.contains("onDemandCount"); }

    // Is fallbackToOd Set boolean method
    @JsonIgnore
    public boolean isFallbackToOdSet() { return isSet.contains("fallbackToOd"); }

    // Is drainingTimeout Set boolean method
    @JsonIgnore
    public boolean isDrainingTimeoutSet() { return isSet.contains("drainingTimeout"); }

    // Is revertToPreemptible Set boolean method
    @JsonIgnore
    public boolean isRevertToPreemptibleSet() { return isSet.contains("revertToPreemptible"); }

    // Is optimizationWindows Set boolean method
    @JsonIgnore
    public boolean isOptimizationWindowsSet() { return isSet.contains("optimizationWindows"); }
    //endregion
}
