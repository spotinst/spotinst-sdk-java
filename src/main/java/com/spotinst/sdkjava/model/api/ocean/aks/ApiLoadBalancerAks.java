package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiLoadBalancerAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<String>                        backendPoolNames;
    private String                              loadBalancerSku;
    private String                              name;
    private String                              resourceGroupName;
    private String                              type;


    public ApiLoadBalancerAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getBackendPoolNames() {
        return backendPoolNames;
    }

    public void setBackendPoolNames(List<String> backendPoolNames) {
        isSet.add("backendPoolNames");
        this.backendPoolNames = backendPoolNames;
    }

    public String getLoadBalancerSku() {
        return loadBalancerSku;
    }

    public void setLoadBalancerSku(String loadBalancerSku) {
        isSet.add("loadBalancerSku");
        this.loadBalancerSku = loadBalancerSku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isBackendPoolNamesSet() {
        return isSet.contains("backendPoolNames");
    }

    @JsonIgnore
    public boolean isLoadBalancerSkuSet() {
        return isSet.contains("loadBalancerSku");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }


}

