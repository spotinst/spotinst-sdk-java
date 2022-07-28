package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupEcsInitiateRollResponseOldInstances {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     instanceId;
    private String                     status;

    private ElastigroupEcsInitiateRollResponseOldInstances() {
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
        private ElastigroupEcsInitiateRollResponseOldInstances initiateRollOldInstances;

        private Builder() {
            this.initiateRollOldInstances = new ElastigroupEcsInitiateRollResponseOldInstances();
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

        public ElastigroupEcsInitiateRollResponseOldInstances build() {
            return initiateRollOldInstances;
        }
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