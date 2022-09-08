package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDetachVmsAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>     isSet;
    private Integer         drainingTimeout;
    private Boolean         shouldDecrementTargetCapacity;
    private Boolean         shouldTerminateVms;
    private List<String>    vmsToDetach;

    public ApiDetachVmsAzure() {
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

    public Boolean getShouldDecrementTargetCapacity() {
        return shouldDecrementTargetCapacity;
    }

    public void setShouldDecrementTargetCapacity(Boolean shouldDecrementTargetCapacity) {
        isSet.add("shouldDecrementTargetCapacity");
        this.shouldDecrementTargetCapacity = shouldDecrementTargetCapacity;
    }

    public Boolean getShouldTerminateVms() {
        return shouldTerminateVms;
    }

    public void setShouldTerminateVms(Boolean shouldTerminateVms) {
        isSet.add("shouldTerminateVms");
        this.shouldTerminateVms = shouldTerminateVms;
    }

    public List<String> getVmsToDetach() {
        return vmsToDetach;
    }

    public void setVmsToDetach(List<String> vmsToDetach) {
        isSet.add("vmsToDetach");
        this.vmsToDetach = vmsToDetach;
    }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isShouldDecrementTargetCapacitySet() {
        return isSet.contains("shouldDecrementTargetCapacity");
    }

    @JsonIgnore
    public boolean isShouldTerminateVmsSet() {
        return isSet.contains("shouldTerminateVms");
    }

    @JsonIgnore
    public boolean isVmsToDetachSet() {
        return isSet.contains("vmsToDetach");
    }
}
