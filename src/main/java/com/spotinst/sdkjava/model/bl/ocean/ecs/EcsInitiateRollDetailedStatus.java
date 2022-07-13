package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.InitiateRollResponseOldInstances;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EcsInitiateRollDetailedStatus {
    @JsonIgnore
    private Set<String>                               isSet;
    private List<EcsInitiateRollResponseOldInstances> oldInstances;

    private EcsInitiateRollDetailedStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<EcsInitiateRollResponseOldInstances> getOldInstances() {
        return oldInstances;
    }

    public void setOldInstances(List<EcsInitiateRollResponseOldInstances> oldInstances) {
        isSet.add("oldInstances");
        this.oldInstances = oldInstances;
    }

    public static class Builder {
        private EcsInitiateRollDetailedStatus initiateRollDetailedStatus;

        private Builder() {
            this.initiateRollDetailedStatus = new EcsInitiateRollDetailedStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOldInstances(final List<EcsInitiateRollResponseOldInstances> oldInstances) {
            initiateRollDetailedStatus.setOldInstances(oldInstances);
            return this;
        }

        public EcsInitiateRollDetailedStatus build() {
            return initiateRollDetailedStatus;
        }
    }

    @JsonIgnore
    public boolean isOldInstancesSet() {
        return isSet.contains("oldInstances");
    }
}