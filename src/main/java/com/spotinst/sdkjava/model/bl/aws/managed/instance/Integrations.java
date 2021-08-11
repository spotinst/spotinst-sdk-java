package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class Integrations {

    //region Members
    @JsonIgnore
    private Set<String>             isSet;
    private LoadBalancersConfig     loadBalancersConfig;
    private Route53 route53;

    //endregion

    //region constructor
    private Integrations() {
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

    public LoadBalancersConfig getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(LoadBalancersConfig loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public Route53 getRoute53() {
        return route53;
    }

    public void setRoute53(Route53 route53) {
        isSet.add("route53");
        this.route53 = route53;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private Integrations integrations;

        private Builder() {
            this.integrations = new Integrations();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setLoadBalancersConfig(final LoadBalancersConfig loadBalancersConfig) {
            integrations.setLoadBalancersConfig(loadBalancersConfig);
            return this;
        }

        public Builder setRoute53(final Route53 route53) {
            integrations.setRoute53(route53);
            return this;
        }

        public Integrations build() {
            // TODO : Validations
            return integrations;
        }
    }
    //endregion

    //region isSet methods
    // Is loadBalancersConfig Set boolean method
    @JsonIgnore
    public boolean isLoadBalancersConfig() {
        return isSet.contains("loadBalancersConfig");
    }

    // Is route53 Set boolean method
    @JsonIgnore
    public boolean isRoute53Set() {
        return isSet.contains("route53");
    }
    //endregion
}
