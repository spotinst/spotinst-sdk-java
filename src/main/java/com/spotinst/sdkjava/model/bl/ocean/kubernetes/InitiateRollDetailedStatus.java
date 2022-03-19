package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitiateRollDetailedStatus {
    @JsonIgnore
    private Set<String>                     isSet;
    private List<InitiateRollResponseOldInstances> oldInstances;

    private InitiateRollDetailedStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<InitiateRollResponseOldInstances> getOldInstances() {
        return oldInstances;
    }

    public void setOldInstances(List<InitiateRollResponseOldInstances> oldInstances) {
        isSet.add("oldInstances");
        this.oldInstances = oldInstances;
    }

    public static class Builder {
        private InitiateRollDetailedStatus initiateRollDetailedStatus;

        private Builder() {
            this.initiateRollDetailedStatus = new InitiateRollDetailedStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOldInstances(final List<InitiateRollResponseOldInstances> oldInstances) {
            initiateRollDetailedStatus.setOldInstances(oldInstances);
            return this;
        }

        public InitiateRollDetailedStatus build() {
            return initiateRollDetailedStatus;
        }
    }

    @JsonIgnore
    public boolean isOldInstancesSet() {
        return isSet.contains("oldInstances");
    }
}