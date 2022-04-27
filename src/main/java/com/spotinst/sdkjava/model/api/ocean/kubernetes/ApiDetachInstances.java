package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiDetachInstances implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>      isSet;
    private List<String>     instancesToDetach;
    private Boolean		     shouldTerminateInstances;
    private Boolean          shouldDecrementTargetCapacity;

    public ApiDetachInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getInstancesToDetach() {
        return instancesToDetach;
    }

    public void setInstancesToDetach(List<String> instancesToDetach) {
        isSet.add("instancesToDetach");
        this.instancesToDetach = instancesToDetach;
    }

    public Boolean getShouldTerminateInstances() {
        return shouldTerminateInstances;
    }

    public void setShouldTerminateInstances(Boolean shouldTerminateInstances) {
        isSet.add("shouldTerminateInstances");
        this.shouldTerminateInstances = shouldTerminateInstances;
    }

    public Boolean getShouldDecrementTargetCapacity() {
        return shouldDecrementTargetCapacity;
    }

    public void setShouldDecrementTargetCapacity(Boolean shouldDecrementTargetCapacity) {
        isSet.add("shouldDecrementTargetCapacity");
        this.shouldDecrementTargetCapacity = shouldDecrementTargetCapacity;
    }

    @JsonIgnore
    public boolean isInstancesToDetachSet() {
        return isSet.contains("instancesToDetach");
    }

    @JsonIgnore
    public boolean isShouldTerminateInstancesSet() {
        return isSet.contains("shouldTerminateInstances");
    }

    @JsonIgnore
    public boolean isShouldDecrementTargetCapacitySet() {
        return isSet.contains("shouldDecrementTargetCapacity");
    }


}