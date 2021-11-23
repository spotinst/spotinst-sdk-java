package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeLoadBalancersConfig {

    @JsonIgnore
    private Set<String>  isSet;
    private List<String> loadBalancers;

    private StatefulNodeLoadBalancersConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<String> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }

    public static class Builder {
        private StatefulNodeLoadBalancersConfig statefulNodeVmSizes;

        private Builder() {
            this.statefulNodeVmSizes = new StatefulNodeLoadBalancersConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setLoadBalancers(final List<String> loadBalancers) {
            statefulNodeVmSizes.setLoadBalancers(loadBalancers);
            return this;
        }

        public StatefulNodeLoadBalancersConfig build() {
            return statefulNodeVmSizes;
        }
    }

    @JsonIgnore
    public boolean isLoadBalancersSet() {
        return isSet.contains("loadBalancers");
    }

}