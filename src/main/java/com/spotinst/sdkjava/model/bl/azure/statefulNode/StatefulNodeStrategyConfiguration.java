package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AzureLifeCycleTypeEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeStrategyConfiguration {

    @JsonIgnore
    private Set<String>                           isSet;
    private Boolean                               fallbackToOd;
    private Integer                               drainingTimeout;
    private String                                orientation;
    private AzureLifeCycleTypeEnum                preferredLifecycle;
    private StatefulNodeRevertToSpotConfiguration revertToSpot;
    private List<StatefulNodeSignalConfiguration> signals;

    private StatefulNodeStrategyConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getFallbackToOd() {
        return fallbackToOd;
    }

    public void setFallbackToOd(Boolean fallbackToOd) {
        isSet.add("fallbackToOd");
        this.fallbackToOd = fallbackToOd;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        isSet.add("orientation");
        this.orientation = orientation;
    }

    public AzureLifeCycleTypeEnum getPreferredLifecycle() {
        return preferredLifecycle;
    }

    public void setPreferredLifecycle(AzureLifeCycleTypeEnum preferredLifecycle) {
        isSet.add("preferredLifecycle");
        this.preferredLifecycle = preferredLifecycle;
    }

    public StatefulNodeRevertToSpotConfiguration getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(StatefulNodeRevertToSpotConfiguration revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public List<StatefulNodeSignalConfiguration> getSignals() {
        return signals;
    }

    public void setSignals(List<StatefulNodeSignalConfiguration> signals) {
        isSet.add("signals");
        this.signals = signals;
    }


    public static class Builder {
        private StatefulNodeStrategyConfiguration statefulNodeStrategy;

        private Builder() {
            this.statefulNodeStrategy = new StatefulNodeStrategyConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setFallbackToOd(final Boolean fallbackToOd) {
            statefulNodeStrategy.setFallbackToOd(fallbackToOd);
            return this;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            statefulNodeStrategy.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setOrientation(final String orientation) {
            statefulNodeStrategy.setOrientation(orientation);
            return this;
        }

        public Builder setPreferredLifecycle(final AzureLifeCycleTypeEnum preferredLifecycle) {
            statefulNodeStrategy.setPreferredLifecycle(preferredLifecycle);
            return this;
        }

        public Builder setRevertToSpot(final StatefulNodeRevertToSpotConfiguration revertToSpot) {
            statefulNodeStrategy.setRevertToSpot(revertToSpot);
            return this;
        }

        public Builder setSignals(final List<StatefulNodeSignalConfiguration> signals) {
            statefulNodeStrategy.setSignals(signals);
            return this;
        }

        public StatefulNodeStrategyConfiguration build() {
            return statefulNodeStrategy;
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
    public boolean isOrientationSet() {
        return isSet.contains("orientation");
    }

    @JsonIgnore
    public boolean isPreferredLifecycleSet() {
        return isSet.contains("preferredLifecycle");
    }

    @JsonIgnore
    public boolean isRevertToSpotSet() {
        return isSet.contains("revertToSpot");
    }

    @JsonIgnore
    public boolean isSignalsSet() {
        return isSet.contains("signals");
    }
}