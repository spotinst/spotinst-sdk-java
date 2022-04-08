package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AksDetachInstances {
    @JsonIgnore
    private Set<String>      isSet;
    private List<String>     vmsToDetach;

    private AksDetachInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getVmsToDetach() {
        return vmsToDetach;
    }

    public void setVmsToDetach(List<String> vmsToDetach) {
        isSet.add("vmsToDetach");
        this.vmsToDetach = vmsToDetach;
    }

    public static class Builder {
        private AksDetachInstances detachInstances;

        private Builder() {
            this.detachInstances = new AksDetachInstances();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVmsToDetach(final List<String> vmsToDetach) {
            detachInstances.setVmsToDetach(vmsToDetach);
            return this;
        }
        public AksDetachInstances build() {
            return detachInstances;
        }
    }

    @JsonIgnore
    public boolean isVmsToDetachSet() {
        return isSet.contains("vmsToDetach");
    }

}