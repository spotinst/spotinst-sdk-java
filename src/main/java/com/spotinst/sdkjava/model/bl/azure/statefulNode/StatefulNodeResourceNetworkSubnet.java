package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceNetworkSubnet {

    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;
    private String      addressPrefix;

    private StatefulNodeResourceNetworkSubnet() {
        isSet = new HashSet<>();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getAddressPrefix() {
        return addressPrefix;
    }

    public void setAddressPrefix(String addressPrefix) {
        isSet.add("addressPrefix");
        this.addressPrefix = addressPrefix;
    }

    public static class Builder {

        private StatefulNodeResourceNetworkSubnet networkSubnet;

        private Builder() {
            this.networkSubnet = new StatefulNodeResourceNetworkSubnet();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            networkSubnet.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            networkSubnet.setName(name);
            return this;
        }

        public Builder setAddressPrefix(final String addressPrefix) {
            networkSubnet.setAddressPrefix(addressPrefix);
            return this;
        }

        public StatefulNodeResourceNetworkSubnet build() {
            return networkSubnet;
        }
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isAddressPrefixSet() {
        return isSet.contains("addressPrefix");
    }
}
