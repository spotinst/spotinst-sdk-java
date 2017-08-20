package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by talzur on 16/01/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiDetachInstancesRequest {
    //region Members
    private List<String> instancesToDetach;
    private Boolean      shouldTerminateInstances;
    private Boolean      shouldDecrementTargetCapacity;
    private Integer      drainingTimeout;
    //endregion

    //region Getters & Setters

    public List<String> getInstancesToDetach() {
        return instancesToDetach;
    }

    public void setInstancesToDetach(List<String> instancesToDetach) {
        this.instancesToDetach = instancesToDetach;
    }

    public Boolean getShouldTerminateInstances() {
        return shouldTerminateInstances;
    }

    public void setShouldTerminateInstances(Boolean shouldTerminateInstances) {
        this.shouldTerminateInstances = shouldTerminateInstances;
    }

    public Boolean getShouldDecrementTargetCapacity() {
        return shouldDecrementTargetCapacity;
    }

    public void setShouldDecrementTargetCapacity(Boolean shouldDecrementTargetCapacity) {
        this.shouldDecrementTargetCapacity = shouldDecrementTargetCapacity;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        this.drainingTimeout = drainingTimeout;
    }

    //endregion
}
