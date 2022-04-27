package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetachInstances {
    @JsonIgnore
    private Set<String>                            isSet;
    private List<String>               instancesToDetach;
    private Boolean		          shouldTerminateInstances;
    private Boolean          shouldDecrementTargetCapacity;

    private DetachInstances() {
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

    public static class Builder {
        private DetachInstances detachInstances;

        private Builder() {
            this.detachInstances = new DetachInstances();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setInstancesToDetach(final List<String> instancesToDetach) {
            detachInstances.setInstancesToDetach(instancesToDetach);
            return this;
        }

        public Builder setShouldTerminateInstances(final Boolean shouldTerminateInstances) {
            detachInstances.setShouldTerminateInstances(shouldTerminateInstances);
            return this;
        }

        public Builder setShouldDecrementTargetCapacity(final Boolean shouldDecrementTargetCapacity) {
            detachInstances.setShouldDecrementTargetCapacity(shouldDecrementTargetCapacity);
            return this;
        }

        public DetachInstances build() {
            // Validations
            return detachInstances;
        }
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