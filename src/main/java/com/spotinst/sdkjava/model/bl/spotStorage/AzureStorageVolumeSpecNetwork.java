package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AzureStorageVolumeSpecNetwork {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      virtualNetworkName;
    private String      subnetName;
    //endregion

    //region Constructor
    private AzureStorageVolumeSpecNetwork() {
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

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeSpecNetwork volumeSpecNetwork;
        //endregion


        private Builder() {
            this.volumeSpecNetwork = new AzureStorageVolumeSpecNetwork();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setResourceGroupName(final String resourceGroupName) {
            volumeSpecNetwork.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setVirtualNetworkName(final String virtualNetworkName) {
            volumeSpecNetwork.setVirtualNetworkName(virtualNetworkName);
            return this;
        }

        public Builder setSubnetName(final String subnetName) {
            volumeSpecNetwork.setSubnetName(subnetName);
            return this;
        }

        public AzureStorageVolumeSpecNetwork build() {
            // Validations
            return volumeSpecNetwork;
        }
        //endregion
    }
    //endregion

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
