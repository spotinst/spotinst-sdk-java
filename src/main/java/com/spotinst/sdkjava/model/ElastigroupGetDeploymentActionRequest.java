package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsElastigroupActionTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupGetDeploymentActionRequest {

    @JsonIgnore
    private Set<String>                  isSet;
    private AwsElastigroupActionTypeEnum actionType;
    private Integer                      drainingTimeout;
    private Boolean                      shouldDecrementTargetCapacity;
    private Boolean                      shouldHandleAllBatches;

    public ElastigroupGetDeploymentActionRequest() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public AwsElastigroupActionTypeEnum getActionType() {
        return actionType;
    }

    public void setActionType(AwsElastigroupActionTypeEnum actionType) {
        this.actionType = actionType;
    }

    public Boolean getShouldDecrementTargetCapacity() {
        return shouldDecrementTargetCapacity;
    }

    public void setShouldDecrementTargetCapacity(Boolean shouldDecrementTargetCapacity) {
        this.shouldDecrementTargetCapacity = shouldDecrementTargetCapacity;
    }

    public Boolean getShouldHandleAllBatches() {
        return shouldHandleAllBatches;
    }

    public void setShouldHandleAllBatches(Boolean shouldHandleAllBatches) {
        this.shouldHandleAllBatches = shouldHandleAllBatches;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        isSet.add("drainingTimeout");
        this.drainingTimeout = drainingTimeout;
    }

    public static class Builder {
        private ElastigroupGetDeploymentActionRequest elastigroupDeploymentRequest;

        private Builder() {
            this.elastigroupDeploymentRequest = new ElastigroupGetDeploymentActionRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setActionType(final AwsElastigroupActionTypeEnum actionType){
            elastigroupDeploymentRequest.setActionType(actionType);
            return this;
        }

        public Builder setDrainingTimeout (final Integer drainingTimeout){
            elastigroupDeploymentRequest.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setShouldDecrementTargetCapacity (final Boolean shouldDecrementTargetCapacity){
            elastigroupDeploymentRequest.setShouldDecrementTargetCapacity(shouldDecrementTargetCapacity);
            return this;
        }

        public Builder setShouldHandleAllBatches (final Boolean shouldHandleAllBatches){
            elastigroupDeploymentRequest.setShouldHandleAllBatches(shouldHandleAllBatches);
            return this;
        }

        public ElastigroupGetDeploymentActionRequest build() {
            return elastigroupDeploymentRequest;
        }
    }

    @JsonIgnore
    public boolean isShouldDecrementTargetCapacitySet() {
        return isSet.contains("shouldDecrementTargetCapacity");
    }

    @JsonIgnore
    public boolean isShouldHandleAllBatchesSet() {
        return isSet.contains("shouldHandleAllBatches");
    }

    @JsonIgnore
    public boolean isActionTypeSet() {
        return isSet.contains("actionType");
    }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

}
