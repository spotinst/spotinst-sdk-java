package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceNetworkIpConfigurations {

    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  name;
    private String                                  privateIpAddress;
    private String                                  privateIPAddressVersion;
    private String                                  privateIpAllocationMethod;
    private String                                  applicationSecurityGroups;
    private Boolean                                 primary;
    private StatefulNodeResourceNetworkSubnet       subnet;
    private StatefulNodeResourceNetworkPublicIp     publicIp;

    private StatefulNodeResourceNetworkIpConfigurations() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        isSet.add("privateIpAddress");
        this.privateIpAddress = privateIpAddress;
    }

    public String getPrivateIPAddressVersion() {
        return privateIPAddressVersion;
    }

    public void setPrivateIPAddressVersion(String privateIPAddressVersion) {
        isSet.add("privateIPAddressVersion");
        this.privateIPAddressVersion = privateIPAddressVersion;
    }

    public String getPrivateIpAllocationMethod() {
        return privateIpAllocationMethod;
    }

    public void setPrivateIpAllocationMethod(String privateIpAllocationMethod) {
        isSet.add("privateIpAllocationMethod");
        this.privateIpAllocationMethod = privateIpAllocationMethod;
    }

    public String getApplicationSecurityGroups() {
        return applicationSecurityGroups;
    }

    public void setApplicationSecurityGroups(String applicationSecurityGroups) {
        isSet.add("applicationSecurityGroups");
        this.applicationSecurityGroups = applicationSecurityGroups;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        isSet.add("primary");
        this.primary = primary;
    }

    public StatefulNodeResourceNetworkSubnet getSubnet() {
        return subnet;
    }

    public void setSubnet(StatefulNodeResourceNetworkSubnet subnet) {
        isSet.add("subnet");
        this.subnet = subnet;
    }

    public StatefulNodeResourceNetworkPublicIp getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(StatefulNodeResourceNetworkPublicIp publicIp) {
        isSet.add("publicIp");
        this.publicIp = publicIp;
    }

    public static class Builder {

        private StatefulNodeResourceNetworkIpConfigurations networkIpConfigurations;

        private Builder() {
            this.networkIpConfigurations = new StatefulNodeResourceNetworkIpConfigurations();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            networkIpConfigurations.setName(name);
            return this;
        }

        public Builder setPrivateIpAddress(final String privateIpAddress) {
            networkIpConfigurations.setPrivateIpAddress(privateIpAddress);
            return this;
        }

        public Builder setPrivateIPAddressVersion(final String privateIPAddressVersion) {
            networkIpConfigurations.setPrivateIPAddressVersion(privateIPAddressVersion);
            return this;
        }

        public Builder setPrivateIpAllocationMethod(final String privateIpAllocationMethod) {
            networkIpConfigurations.setPrivateIpAllocationMethod(privateIpAllocationMethod);
            return this;
        }

        public Builder setApplicationSecurityGroups(final String applicationSecurityGroups) {
            networkIpConfigurations.setApplicationSecurityGroups(applicationSecurityGroups);
            return this;
        }

        public Builder setPrimary(final Boolean primary) {
            networkIpConfigurations.setPrimary(primary);
            return this;
        }

        public Builder setSubnet(final StatefulNodeResourceNetworkSubnet subnet) {
            networkIpConfigurations.setSubnet(subnet);
            return this;
        }

        public Builder setPublicip(final StatefulNodeResourceNetworkPublicIp publicIp) {
            networkIpConfigurations.setPublicIp(publicIp);
            return this;
        }

        public StatefulNodeResourceNetworkIpConfigurations build() {
            return networkIpConfigurations;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPrivateIpAddressSet() {
        return isSet.contains("privateIpAddress");
    }

    @JsonIgnore
    public boolean isPrivateIPAddressVersionSet() {
        return isSet.contains("privateIPAddressVersion");
    }

    @JsonIgnore
    public boolean isPrivateIpAllocationMethodSet() {
        return isSet.contains("privateIpAllocationMethod");
    }

    @JsonIgnore
    public boolean isApplicationSecurityGroupsSet() {
        return isSet.contains("applicationSecurityGroups");
    }

    @JsonIgnore
    public boolean isPrimarySet() {
        return isSet.contains("primary");
    }

    @JsonIgnore
    public boolean isSubnetSet() {
        return isSet.contains("subnet");
    }

    @JsonIgnore
    public boolean isPublicIpSet() {
        return isSet.contains("publicIp");
    }
}
