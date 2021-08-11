package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class ApiIntegrations {

    //region Members
    @JsonIgnore
    private Set<String>             isSet;
    private ApiLoadBalancersConfig  loadBalancersConfig;
    private ApiRoute53                 route53;

    //endregion

    //region constructor
    private ApiIntegrations() {
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

    public ApiLoadBalancersConfig getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ApiLoadBalancersConfig loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ApiRoute53 getRoute53() {
        return route53;
    }

    public void setRoute53(ApiRoute53 route53) {
        isSet.add("route53");
        this.route53 = route53;
    }

    @JsonIgnore
    public boolean isLoadBalancersConfig() {
        return isSet.contains("loadBalancersConfig");
    }

    @JsonIgnore
    public boolean isRoute53Set() {
        return isSet.contains("route53");
    }
}
