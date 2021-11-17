package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiElastigroupStartDeploymentOnFailure implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      actionType;
    private Integer     drainingTimeout;
    private Boolean     shouldDecrementTargetCapacity;
    private Boolean     shouldHandleAllBatches;

    public ApiElastigroupStartDeploymentOnFailure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        isSet.add("actionType");
        this.actionType = actionType;
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

    public Boolean getShouldHandleAllBatches() {
        return shouldHandleAllBatches;
    }

    public void setShouldHandleAllBatches(Boolean shouldHandleAllBatches) {
        isSet.add("shouldHandleAllBatches");
        this.shouldHandleAllBatches = shouldHandleAllBatches;
    }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isActionTypeSet() { return isSet.contains("actionType"); }

    @JsonIgnore
    public boolean isShouldDecrementTargetCapacitySet() {
        return isSet.contains("shouldDecrementTargetCapacity");
    }

    @JsonIgnore
    public boolean isShouldHandleAllBatchesSet() {
        return isSet.contains("shouldHandleAllBatches");
    }

}
