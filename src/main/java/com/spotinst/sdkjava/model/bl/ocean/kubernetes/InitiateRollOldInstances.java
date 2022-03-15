package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class InitiateRollOldInstances {
    @JsonIgnore
    private Set<String>                     isSet;
    private String                     instanceId;
    private String                         status;

    private InitiateRollOldInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public static class Builder {
        private InitiateRollOldInstances initiateRollOldInstances;

        private Builder() {
            this.initiateRollOldInstances = new InitiateRollOldInstances();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setInstanceId(final String instanceId) {
            initiateRollOldInstances.setInstanceId(instanceId);
            return this;
        }

        public Builder setStatus(final String status) {
            initiateRollOldInstances.setStatus(status);
            return this;
        }

        public InitiateRollOldInstances build() {
            return initiateRollOldInstances;
        }
    }

    @JsonIgnore
    public boolean isBatchSizePercentageSet() {
        return isSet.contains("batchSizePercentage");
    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }
}