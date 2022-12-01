package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceNetworkPublicIp {

    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;
    private String      ipAddress;
    private String      skuName;

    private StatefulNodeResourceNetworkPublicIp() {
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        isSet.add("ipAddress");
        this.ipAddress = ipAddress;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        isSet.add("skuName");
        this.skuName = skuName;
    }

    public static class Builder {

        private StatefulNodeResourceNetworkPublicIp networkPublicIp;

        private Builder() {
            this.networkPublicIp = new StatefulNodeResourceNetworkPublicIp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            networkPublicIp.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            networkPublicIp.setName(name);
            return this;
        }

        public Builder setIpAddress(final String ipAddress) {
            networkPublicIp.setIpAddress(ipAddress);
            return this;
        }

        public Builder setSkuName(final String skuName) {
            networkPublicIp.setSkuName(skuName);
            return this;
        }

        public StatefulNodeResourceNetworkPublicIp build() {
            return networkPublicIp;
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
    public boolean isIpAddressSet() {
        return isSet.contains("ipAddress");
    }

    @JsonIgnore
    public boolean isSkuNameSet() {
        return isSet.contains("skuName");
    }
}
