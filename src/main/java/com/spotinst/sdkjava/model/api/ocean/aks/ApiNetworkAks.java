package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiNetworkAks  implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                  isSet;

    private List<ApiNetworkInterfaceAks> networkInterfaces;
    private String                       resourceGroupName;
    private String                       virtualNetworkName;


    public ApiNetworkAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiNetworkInterfaceAks> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiNetworkInterfaceAks> networkInterfaces) {

        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getVirtualNetworkName() {
        return virtualNetworkName;
    }

    public void setVirtualNetworkName(String virtualNetworkName) {
        isSet.add("virtualNetworkName");
        this.virtualNetworkName = virtualNetworkName;
    }

    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isVirtualNetworkNameSet() {
        return isSet.contains("virtualNetworkName");
    }
}
