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
public class ApiImportClusterNetworkAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private String                              resourceGroupName;
    private String                              virtualNetworkName;
    private List<ApiImportClusterNetworkInterfaceAks>    networkInterfaces;

    private ApiImportClusterNetworkAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiImportClusterNetworkInterfaceAks> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiImportClusterNetworkInterfaceAks> networkInterfaces) {

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

        private ApiImportClusterNetworkAks clusterNetworkAks;
        private Builder() {
            this.clusterNetworkAks = new ApiImportClusterNetworkAks();
        }

        public static Builder get() {
            return new Builder();
        }
        public Builder setNetworkInterfaces(final List<ApiImportClusterNetworkInterfaceAks> networkInterfaces) {
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

        public ApiImportClusterNetworkAks build() {
            return clusterNetworkAks;
        }
    }
}
