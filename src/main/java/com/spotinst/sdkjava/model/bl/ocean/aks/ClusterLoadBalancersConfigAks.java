package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
            return new Builder();
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
