package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterStrategyConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private Boolean                    fallbackToOd;
    private Boolean                    utilizeReservedInstances;
    private Integer                    drainingTimeout;
    private Integer                    gracePeriod;
    private Integer                    spotPercentage;

    public ApiClusterStrategyConfiguration() {
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

    public Integer getSpotPercentage() {
        return spotPercentage;
    }

    public void setSpotPercentage(Integer spotPercentage) {
        isSet.add("spotPercentage");
        this.spotPercentage = spotPercentage;
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

    @JsonIgnore
    public boolean isSpotPercentageSet() {
        return isSet.contains("spotPercentage");
    }
}
