package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeStrategyConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                              isSet;
    private Boolean                                  fallbackToOd;
    private Integer                                  drainingTimeout;
    private String                                   preferredLifecycle;
    private ApiStatefulNodeRevertToSpotConfiguration revertToSpot;
    private List<ApiStatefulNodeSignalConfiguration> signals;
    private List<String>                             optimizationWindows;

    public ApiStatefulNodeStrategyConfiguration() {
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

    public String getPreferredLifecycle() {
        return preferredLifecycle;
    }

    public void setPreferredLifecycle(String preferredLifecycle) {
        isSet.add("preferredLifecycle");
        this.preferredLifecycle = preferredLifecycle;
    }

    public ApiStatefulNodeRevertToSpotConfiguration getRevertToSpot() {
        return revertToSpot;
    }

    public void setRevertToSpot(ApiStatefulNodeRevertToSpotConfiguration revertToSpot) {
        isSet.add("revertToSpot");
        this.revertToSpot = revertToSpot;
    }

    public List<ApiStatefulNodeSignalConfiguration> getSignals() {
        return signals;
    }

    public void setSignals(List<ApiStatefulNodeSignalConfiguration> signals) {
        isSet.add("signals");
        this.signals = signals;
    }

    public List<String> getOptimizationWindows() {
        return optimizationWindows;
    }

    public void setOptimizationWindows(List<String> optimizationWindows) {
        isSet.add("optimizationWindows");
        this.optimizationWindows = optimizationWindows;
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

    @JsonIgnore
    public boolean isOptimizationWindowsSet() {
        return isSet.contains("optimizationWindows");
    }

}