package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class Strategy {

    //region Members
    @JsonIgnore
    private Set<String>     isSet;
    private Integer         drainingTimeout;
    private Boolean         fallbackToOd;
    private String          lifeCycle;
    private List<String>    optimizationWindows;
    private String          orientation;
    private RevertToSpot    revertToSpot;
    private Boolean         utilizeReservedInstances;

    //endregion

    //region constructor
    private Strategy() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public List<String> getOptimizationWindows() {
        return optimizationWindows;
    }

    public void setOptimizationWindows(List<String> optimizationWindows) {
        isSet.add("optimizationWindows");
        this.optimizationWindows = optimizationWindows;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        isSet.add("orientation");
        this.orientation = orientation;
    }

    public RevertToSpot getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(RevertToSpot revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public Boolean getUtilizeReservedInstances() {
        return utilizeReservedInstances;
    }

    public void setUtilizeReservedInstances(Boolean utilizeReservedInstances) {
        isSet.add("utilizeReservedInstances");
        this.utilizeReservedInstances = utilizeReservedInstances;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private Strategy strategy;

        private Builder() {
            this.strategy = new Strategy();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            strategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setFallbackToOd(final Boolean fallbackToOd) {
            strategy.setFallbackToOd(fallbackToOd);
            return this;
        }

        public Builder setLifeCycle(final String lifeCycle) {
            strategy.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setOptimizationWindows(final List<String> optimizationWindows) {
            strategy.setOptimizationWindows(optimizationWindows);
            return this;
        }

        public Builder setOrientation(final String orientation) {
            strategy.setOrientation(orientation);
            return this;
        }

        public Builder setRevertToSpot(final RevertToSpot revertToSpot) {
            strategy.setRevertToSpot(revertToSpot);
            return this;
        }

        public Builder setUtilizeReservedInstances(final Boolean utilizeReservedInstances) {
            strategy.setUtilizeReservedInstances(utilizeReservedInstances);
            return this;
        }

        public Strategy build() {
            // TODO : Validations
            return strategy;
        }
    }
    //endregion

    //region isSet methods
    // Is drainingTimeout Set boolean method
    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    // Is fallbackToOd Set boolean method
    @JsonIgnore
    public boolean isFallbackToOdSet() {
        return isSet.contains("fallbackToOd");
    }

    // Is lifeCycle Set boolean method
    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    // Is optimizationWindows Set boolean method
    @JsonIgnore
    public boolean isOptimizationWindowsSet() {
        return isSet.contains("optimizationWindows");
    }

    // Is orientation Set boolean method
    @JsonIgnore
    public boolean isOrientationSet() {
        return isSet.contains("orientation");
    }

    // Is revertToSpot Set boolean method
    @JsonIgnore
    public boolean isRevertToSpotSet() {
        return isSet.contains("revertToSpot");
    }

    // Is utilizeReservedInstances Set boolean method
    @JsonIgnore
    public boolean isUtilizeReservedInstancesSet() {
        return isSet.contains("utilizeReservedInstances");
    }

    //endregion
}
