package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupStartDeploymentOnFailure {
    @JsonIgnore
    private Set<String> isSet;
    private String      actionType;
    private Integer     drainingTimeout;
    private Boolean     shouldDecrementTargetCapacity;
    private Boolean     shouldHandleAllBatches;

    public ElastigroupStartDeploymentOnFailure() {
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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        isSet.add("actionType");
        this.actionType = actionType;
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

    public static class Builder {
        private ElastigroupStartDeploymentOnFailure elastigroupOnFailure;

        private Builder() {
            this.elastigroupOnFailure = new ElastigroupStartDeploymentOnFailure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            elastigroupOnFailure.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setActionType(final String actionType) {
            elastigroupOnFailure.setActionType(actionType);
            return this;
        }

        public Builder setShouldDecrementTargetCapacity(final Boolean shouldDecrementTargetCapacity) {
            elastigroupOnFailure.setShouldDecrementTargetCapacity(shouldDecrementTargetCapacity);
            return this;
        }

        public Builder setShouldHandleAllBatches(final Boolean shouldHandleAllBatches) {
            elastigroupOnFailure.setShouldHandleAllBatches(shouldHandleAllBatches);
            return this;
        }

        public ElastigroupStartDeploymentOnFailure build() {
            return elastigroupOnFailure;
        }
    }

    @JsonIgnore
    public boolean isDrainingTimeoutSet() {
        return isSet.contains("drainingTimeout");
    }

    @JsonIgnore
    public boolean isActionType() { return isSet.contains("actionType"); }

    @JsonIgnore
    public boolean isShouldDecrementTargetCapacitySet() {
        return isSet.contains("shouldDecrementTargetCapacity");
    }

    @JsonIgnore
    public boolean isShouldHandleAllBatchesSet() {
        return isSet.contains("shouldHandleAllBatches");
    }

}