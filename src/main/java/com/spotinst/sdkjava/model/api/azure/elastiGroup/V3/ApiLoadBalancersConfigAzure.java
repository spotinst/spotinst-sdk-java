package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiLoadBalancer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLoadBalancersConfigAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private List<ApiLoadBalancerAzure> loadBalancers;
    //endregion

    public ApiLoadBalancersConfigAzure() {
        isSet = new HashSet<>();
    }

    //region Setters & Getters
    public List<ApiLoadBalancerAzure> getLoadBalancers() {
        return loadBalancers;
    }

    public void setLoadBalancers(List<ApiLoadBalancerAzure> loadBalancers) {
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
