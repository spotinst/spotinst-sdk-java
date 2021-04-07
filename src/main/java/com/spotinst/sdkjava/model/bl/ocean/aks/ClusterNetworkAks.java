package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterNetworkAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<ClusterNetworkInterfaceAks>    networkInterfaces;
    private String                              resourceGroupName;
    private String                              virtualNetworkName;


    private ClusterNetworkAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterNetworkInterfaceAks> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ClusterNetworkInterfaceAks> networkInterfaces) {

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

    public static class Builder {

        private ClusterNetworkAks clusterNetworkAks;
        private Builder() {
            this.clusterNetworkAks = new ClusterNetworkAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setNetworkInterfaces(final List<ClusterNetworkInterfaceAks> networkInterfaces) {
            clusterNetworkAks.setNetworkInterfaces(networkInterfaces);
            return this;
        }
        public Builder setResourceGroupName(final String resourceGroupName) {
            clusterNetworkAks.setResourceGroupName(resourceGroupName);
            return this;
        }
        public Builder setVirtualNetworkName(final String virtualNetworkName) {
            clusterNetworkAks.setVirtualNetworkName(virtualNetworkName);
            return this;
        }

        public ClusterNetworkAks build() {
            return clusterNetworkAks;
        }
    }
}
