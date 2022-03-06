package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadBalancersConfigAzure {
    //region Members
    private Set<String>        isSet = new HashSet<>();
    private List<LoadBalancerAzure> loadBalancers;
    //endregion


    //region Setters&Getters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<LoadBalancerAzure> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<LoadBalancerAzure> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private LoadBalancersConfigAzure loadBalancersConfig;

        private Builder() {
            this.loadBalancersConfig = new LoadBalancersConfigAzure();
        }

        public static LoadBalancersConfigAzure.Builder get() {
            return new Builder();
        }

        public LoadBalancersConfigAzure.Builder setLoadBalancers(final List<LoadBalancerAzure> loadBalancers) {
            loadBalancersConfig.setLoadBalancers(loadBalancers);
            return this;
        }

        public LoadBalancersConfigAzure build() {
            // TODO : Validations
            return loadBalancersConfig;
        }
    }
    //endregion

    //region isSet Methods
    @JsonIgnore
    public boolean isLoadBalancersSet() {
        return isSet.contains("loadBalancers");
    }
    //endregion
}
