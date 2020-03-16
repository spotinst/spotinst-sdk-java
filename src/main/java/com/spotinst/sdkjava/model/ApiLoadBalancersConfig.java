package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLoadBalancersConfig implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>           isSet;
    private List<ApiLoadBalancer> loadBalancers;
    //endregion

    public ApiLoadBalancersConfig() {
        isSet = new HashSet<>();
    }
    //region Setters & Getters

    public List<ApiLoadBalancer> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<ApiLoadBalancer> loadBalancers) {
        isSet.add("loadBalancers");
        this.loadBalancers = loadBalancers;
    }

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
