package com.spotinst.sdkjava.model.bl.aws.elastigroup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsElastigroupActionTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDeploymentStrategyOnFailure {
    @JsonIgnore
    private Set<String>                  isSet;
    private AwsElastigroupActionTypeEnum actionType;
    private Integer                      drainingTimeout;
    private Boolean                      shouldDecrementTargetCapacity;
    private Boolean                      shouldHandleAllBatches;

    public ElastigroupDeploymentStrategyOnFailure() {
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

    public AwsElastigroupActionTypeEnum getActionType() {
        return actionType;
    }

    public void setActionType(AwsElastigroupActionTypeEnum actionType) {
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
        private ElastigroupDeploymentStrategyOnFailure elastigroupOnFailure;

        private Builder() {
            this.elastigroupOnFailure = new ElastigroupDeploymentStrategyOnFailure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDrainingTimeout(final Integer drainingTimeout) {
            elastigroupOnFailure.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public Builder setActionType(final AwsElastigroupActionTypeEnum actionType) {
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

        public ElastigroupDeploymentStrategyOnFailure build() {
            return elastigroupOnFailure;
        }
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