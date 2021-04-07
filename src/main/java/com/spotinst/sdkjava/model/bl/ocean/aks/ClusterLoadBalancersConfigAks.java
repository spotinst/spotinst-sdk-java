package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiLoadBalancer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterLoadBalancersConfigAks {
    @JsonIgnore
    private Set<String>                        isSet;
    private List<ClusterLoadBalancerAks>       loadBalancers;


    private ClusterLoadBalancersConfigAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterLoadBalancerAks> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<ClusterLoadBalancerAks> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }

    @JsonIgnore
    public boolean isLoadBalancersSet() {
        return isSet.contains("loadBalancers");
    }

    public static class Builder {

        private ClusterLoadBalancersConfigAks clusterLoadBalancersConfigAks;

        private Builder() {
            this.clusterLoadBalancersConfigAks = new ClusterLoadBalancersConfigAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder  setLoadBalancers(final List<ClusterLoadBalancerAks> loadBalancers) {
            clusterLoadBalancersConfigAks.setLoadBalancers(loadBalancers);
            return this;
        }

        public ClusterLoadBalancersConfigAks build() {
            return clusterLoadBalancersConfigAks;
        }
    }
}
