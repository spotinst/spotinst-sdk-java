package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Integrations {

    @JsonIgnore
    private Set<String>             isSet;
    private LoadBalancersConfig     loadBalancersConfig;
    private Route53                 route53;

    private Integrations() {
        isSet = new HashSet<>();
    }

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

    public static class Builder {
        private Integrations integrations;

        private Builder() {
            this.integrations = new Integrations();
        }

        public static Builder get() {
            return new Builder();
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
            return integrations;
        }
    }

    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }

    @JsonIgnore
    public boolean isRoute53Set() {
        return isSet.contains("route53");
    }
}
