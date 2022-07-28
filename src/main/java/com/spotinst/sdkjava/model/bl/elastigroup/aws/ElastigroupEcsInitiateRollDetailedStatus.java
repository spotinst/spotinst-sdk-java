package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupEcsInitiateRollDetailedStatus {
    @JsonIgnore
    private Set<String>                                          isSet;
    private List<ElastigroupEcsInitiateRollResponseOldInstances> oldInstances;

    private ElastigroupEcsInitiateRollDetailedStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupEcsInitiateRollResponseOldInstances> getOldInstances() {
        return oldInstances;
    }

    public void setOldInstances(List<ElastigroupEcsInitiateRollResponseOldInstances> oldInstances) {
        isSet.add("oldInstances");
        this.oldInstances = oldInstances;
    }

    public static class Builder {
        private ElastigroupEcsInitiateRollDetailedStatus initiateRollDetailedStatus;

        private Builder() {
            this.initiateRollDetailedStatus = new ElastigroupEcsInitiateRollDetailedStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOldInstances(final List<ElastigroupEcsInitiateRollResponseOldInstances> oldInstances) {
            initiateRollDetailedStatus.setOldInstances(oldInstances);
            return this;
        }

        public ElastigroupEcsInitiateRollDetailedStatus build() {
            return initiateRollDetailedStatus;
        }
    }

    @JsonIgnore
    public boolean isOldInstancesSet() {
        return isSet.contains("oldInstances");
    }
}