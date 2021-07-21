package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiItfLoadBalancers implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>            isSet;
    private String                 loadBalancerArn;
    private List<ApiListenerRules> listenerRules;
    //endregion

    //region Constructor

    public ApiItfLoadBalancers() {
        isSet = new HashSet<>();
    }
    //endregion
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getLoadBalancerArn() {
        return loadBalancerArn;
    }

    public void setLoadBalancerArn(String loadBalancerArn) {
        isSet.add("loadBalancerArn");
        this.loadBalancerArn = loadBalancerArn;
    }

    public List<ApiListenerRules> getListenerRules() {
        return listenerRules;
    }

    public void setListenerRules(List<ApiListenerRules> listenerRules) {
        isSet.add("listenerRules");
        this.listenerRules = listenerRules;
    }

    //endregion

    //region isSet methods

    // Is loadBalancerArn Set boolean method
    @JsonIgnore
    public boolean isLoadBalancerArnSet() { return isSet.contains("loadBalancerArn"); }

    // Is listenerRules Set boolean method
    @JsonIgnore
    public boolean isListenerRulesSet() {
        return isSet.contains("listenerRules");
    }

    //endregion
}
