package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AksInitiateRollDetailedStatus {
    @JsonIgnore
    private Set<String>                            isSet;
    private List<AksInitiateRollResponseOldVms>   oldVms;

    private AksInitiateRollDetailedStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<AksInitiateRollResponseOldVms> getOldVms() {
        return oldVms;
    }

    public void setOldVms(List<AksInitiateRollResponseOldVms> oldVms) {
        isSet.add("oldVms");
        this.oldVms = oldVms;
    }

    public static class Builder {
        private AksInitiateRollDetailedStatus initiateRollDetailedStatus;

        private Builder() {
            this.initiateRollDetailedStatus = new AksInitiateRollDetailedStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOldVms(final List<AksInitiateRollResponseOldVms> oldVms) {
            initiateRollDetailedStatus.setOldVms(oldVms);
            return this;
        }

        public AksInitiateRollDetailedStatus build() {
            return initiateRollDetailedStatus;
        }
    }

    @JsonIgnore
    public boolean isOldVmsSet() {
        return isSet.contains("oldVms");
    }
}