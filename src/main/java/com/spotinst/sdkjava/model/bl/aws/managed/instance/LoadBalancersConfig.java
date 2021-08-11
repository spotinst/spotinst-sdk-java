package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class LoadBalancersConfig {

    //region Members
    @JsonIgnore
    private Set<String>         isSet;
    private List<LoadBalancers> loadBalancers;

    //endregion

    //region constructor
    private LoadBalancersConfig() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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

    //endregion

    //region Builder class
    public static class Builder {
        private LoadBalancersConfig loadBalancersConfig;

        private Builder() {
            this.loadBalancersConfig = new LoadBalancersConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setLoadBalancers(final List<LoadBalancers> loadBalancers) {
            loadBalancersConfig.setLoadBalancers(loadBalancers);
            return this;
        }

        public LoadBalancersConfig build() {
            // TODO : Validations
            return loadBalancersConfig;
        }
    }
    //endregion

    //region isSet methods
    // Is loadBalancers Set boolean method
    @JsonIgnore
    public boolean isLoadBalancersSet() {
        return isSet.contains("loadBalancers");
    }

    //endregion
}
