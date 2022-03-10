package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoadBalancersConfig {

    @JsonIgnore
    private Set<String>         isSet;
    private List<LoadBalancers> loadBalancers;

    private LoadBalancersConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<LoadBalancers> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<LoadBalancers> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }

    public static class Builder {
        private LoadBalancersConfig loadBalancersConfig;

        private Builder() {
            this.loadBalancersConfig = new LoadBalancersConfig();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLoadBalancers(final List<LoadBalancers> loadBalancers) {
            loadBalancersConfig.setLoadBalancers(loadBalancers);
            return this;
        }

        public LoadBalancersConfig build() {
            return loadBalancersConfig;
        }
    }

    @JsonIgnore
    public boolean isLoadBalancersSet() {
        return isSet.contains("loadBalancers");
    }
}
