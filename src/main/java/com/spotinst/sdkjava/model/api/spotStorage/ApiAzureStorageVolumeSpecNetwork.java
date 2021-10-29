package com.spotinst.sdkjava.model.api.spotStorage;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAzureStorageVolumeSpecNetwork implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      virtualNetworkName;
    private String      subnetName;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeSpecNetwork() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        isSet.add("subnetName");
        this.subnetName = subnetName;
    }
    //end region

    //region isSet methods
    // Is resourceGroupName Set boolean method
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    // Is virtualNetworkName Set boolean method
    @JsonIgnore
    public boolean isVirtualNetworkNameSet() {
        return isSet.contains("virtualNetworkName");
    }

    // Is subnetName Set boolean method
    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }
    //endregion
}
