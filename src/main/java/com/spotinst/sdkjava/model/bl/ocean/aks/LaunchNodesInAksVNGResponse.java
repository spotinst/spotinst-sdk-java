package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaunchNodesInAksVNGResponse {
    @JsonIgnore
    private Set<String>              isSet;
    private List<VmsDetails>         vms;

    public LaunchNodesInAksVNGResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<VmsDetails> getVms() {
        return vms;
    }

    public void setVms(List<VmsDetails> vms) {
        isSet.add("vms");
        this.vms = vms;
    }

    public static class Builder {
        private LaunchNodesInAksVNGResponse nodes;

        private Builder() {
            this.nodes = new LaunchNodesInAksVNGResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVms(final List<VmsDetails> launchNodes) {
            nodes.setVms(launchNodes);
            return this;
        }

        public LaunchNodesInAksVNGResponse build() {
            return nodes;
        }
    }

    @JsonIgnore
    public boolean isVmsSet() {
        return isSet.contains("vms");
    }


}