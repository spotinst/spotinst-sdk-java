package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadBalancersConfig {
    //region Members
    private Set<String>        isSet = new HashSet<>();
    private List<LoadBalancer> loadBalancers;
    //endregion


    //region Setters&Getters
    public List<LoadBalancer> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<LoadBalancer> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }

    //region Builder class
    public static class Builder {
        private LoadBalancersConfig loadBalancersConfig;

        private Builder() {
            this.loadBalancersConfig = new LoadBalancersConfig();
        }

        public static LoadBalancersConfig.Builder get() {
            return new Builder();
        }

        public LoadBalancersConfig.Builder setLoadBalancers(final List<LoadBalancer> loadBalancers) {
            loadBalancersConfig.setLoadBalancers(loadBalancers);
            return this;
        }

        public LoadBalancersConfig build() {
            // TODO : Validations
            return loadBalancersConfig;
        }
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    //endregion

    //region Methods
    @JsonIgnore
    public boolean isLoadBalancersSet() {
        return isSet.contains("loadBalancers");
    }
    //endregion
}
