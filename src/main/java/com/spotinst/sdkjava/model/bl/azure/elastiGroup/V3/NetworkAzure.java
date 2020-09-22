package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.NetworkInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NetworkAzure {

    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String                      resourceGroupName;
    private String                      virtualNetworkName;
    private List<NetworkInterfaceAzure> networkInterfaces;

    //region Constructor

    private NetworkAzure() {
        isSet = new HashSet<>();
    }
    //endregion

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

    public List<NetworkInterfaceAzure> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<NetworkInterfaceAzure> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public String getVirtualNetworkName() {
        return virtualNetworkName;
    }

    public void setVirtualNetworkName(String virtualNetworkName) {
        isSet.add("virtualNetworkName");
        this.virtualNetworkName = virtualNetworkName;
    }

    //region Builder class
    public static class Builder {
        private NetworkAzure networkInterface;

        private Builder() {
            this.networkInterface = new NetworkAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }


        public Builder setResourceGroupName(final String resourceGroupName) {
            networkInterface.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setVirtualNetworkName(final String virtualNetworkName) {
            networkInterface.setVirtualNetworkName(virtualNetworkName);
            return this;
        }

        public Builder setNetworkInterfaces(final List<NetworkInterfaceAzure> networkInterfaces) {
            networkInterface.setNetworkInterfaces(networkInterfaces);
            return this;
        }

        public NetworkAzure build() {
            // TODO : Validations
            return networkInterface;
        }
    }

    //endregion
    //region isSet methods
    // Is resourceGroupName Set boolean method
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    // Is networkInterface Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfaceSet() {
        return isSet.contains("networkInterfaces");
    }

    // Is virtualNetworkName Set boolean method
    @JsonIgnore
    public boolean isVirtualNetworkNameSet() {
        return isSet.contains("virtualNetworkName");
    }

    //endregion
}
