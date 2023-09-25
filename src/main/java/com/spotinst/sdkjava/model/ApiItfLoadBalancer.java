package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiDefaultStaticTargetGroups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiItfLoadBalancer implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>           isSet;
    private String                loadBalancerArn;
    private List<ApiListenerRule> listenerRules;
    private List<ApiDefaultStaticTargetGroups>     defaultStaticTargetGroups;
    //endregion

    //region Constructor

    public ApiItfLoadBalancer() {
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

    public List<ApiListenerRule> getListenerRules() {
        return listenerRules;
    }

    public void setListenerRules(List<ApiListenerRule> listenerRules) {
        isSet.add("listenerRules");
        this.listenerRules = listenerRules;
    }

    public List<ApiDefaultStaticTargetGroups> getDefaultStaticTargetGroups() {
        return defaultStaticTargetGroups;
    }

    public void setDefaultStaticTargetGroups(List<ApiDefaultStaticTargetGroups> defaultStaticTargetGroups) {
        isSet.add("defaultStaticTargetGroups");
        this.defaultStaticTargetGroups = defaultStaticTargetGroups;
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

    // Is defaultStaticTargetGroups Set boolean method
    @JsonIgnore
    public boolean isDefaultStaticTargetGroupsSet() {
        return isSet.contains("defaultStaticTargetGroups");
    }

    //endregion
}
