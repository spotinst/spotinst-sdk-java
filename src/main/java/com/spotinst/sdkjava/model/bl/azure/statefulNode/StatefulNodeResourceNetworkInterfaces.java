package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceNetworkInterfaces {

    @JsonIgnore
    private Set<String>                                         isSet;
    private String                                              name;
    private String                                              resourceGroupName;
    private Boolean                                             isPrimary;
    private LaunchSpecNetworkSecurityGroupConfiguration         networkSecurityGroup;
    private List<StatefulNodeResourceNetworkIpConfigurations>   ipConfigurations;
    private String                                              macAddress;
    private Boolean                                             enableAcceleratedNetworking;
    private Boolean                                             enableIpForwarding;

    private StatefulNodeResourceNetworkInterfaces() {
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean primary) {
        isSet.add("isPrimary");
        this.isPrimary = primary;
    }

    public LaunchSpecNetworkSecurityGroupConfiguration getNetworkSecurityGroup() {
        return networkSecurityGroup;
    }

    public void setNetworkSecurityGroup(LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup) {
        isSet.add("networkSecurityGroup");
        this.networkSecurityGroup = networkSecurityGroup;
    }

    public List<StatefulNodeResourceNetworkIpConfigurations> getIpConfigurations() {
        return ipConfigurations;
    }

    public void setIpConfigurations(List<StatefulNodeResourceNetworkIpConfigurations> ipConfigurations) {
        isSet.add("ipConfigurations");
        this.ipConfigurations = ipConfigurations;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        isSet.add("macAddress");
        this.macAddress = macAddress;
    }

    public Boolean getEnableAcceleratedNetworking() {
        return enableAcceleratedNetworking;
    }

    public void setEnableAcceleratedNetworking(Boolean enableAcceleratedNetworking) {
        isSet.add("enableAcceleratedNetworking");
        this.enableAcceleratedNetworking = enableAcceleratedNetworking;
    }

    public Boolean getEnableIpForwarding() {
        return enableIpForwarding;
    }

    public void setEnableIpForwarding(Boolean enableIpForwarding) {
        isSet.add("enableIpForwarding");
        this.enableIpForwarding = enableIpForwarding;
    }



    public static class Builder {

        private StatefulNodeResourceNetworkInterfaces networkInterfacesConfiguration;

        private Builder() {
            this.networkInterfacesConfiguration = new StatefulNodeResourceNetworkInterfaces();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setIsPrimary(final Boolean isPrimary) {
            networkInterfacesConfiguration.setIsPrimary(isPrimary);
            return this;
        }

        public Builder setName(final String name) {
            networkInterfacesConfiguration.setName(name);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            networkInterfacesConfiguration.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setNetworkSecurityGroup(final LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup) {
            networkInterfacesConfiguration.setNetworkSecurityGroup(networkSecurityGroup);
            return this;
        }

        public Builder setIpConfigurations(final List<StatefulNodeResourceNetworkIpConfigurations> ipConfigurations) {
            networkInterfacesConfiguration.setIpConfigurations(ipConfigurations);
            return this;
        }

        public Builder setMacAddress(final String macAddress) {
            networkInterfacesConfiguration.setMacAddress(macAddress);
            return this;
        }

        public Builder setEnableAcceleratedNetworking(final Boolean enableAcceleratedNetworking) {
            networkInterfacesConfiguration.setEnableAcceleratedNetworking(enableAcceleratedNetworking);
            return this;
        }

        public Builder setEnableIpForwarding(final Boolean enableIpForwarding) {
            networkInterfacesConfiguration.setEnableIpForwarding(enableIpForwarding);
            return this;
        }

        public StatefulNodeResourceNetworkInterfaces build() {
            return networkInterfacesConfiguration;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isIsPrimarySet() { return isSet.contains("isPrimary"); }

    @JsonIgnore
    public boolean isResourceGroupNameSet() { return isSet.contains("resourceGroupName"); }

    @JsonIgnore
    public boolean isNetworkSecurityGroupSet() {
        return isSet.contains("networkSecurityGroup");
    }

    @JsonIgnore
    public boolean isIpConfigurationsSet() {
        return isSet.contains("ipConfigurations");
    }

    @JsonIgnore
    public boolean ismacAddressSet() {
        return isSet.contains("macAddress");
    }

    @JsonIgnore
    public boolean isEnableAcceleratedNetworkingSet() {
        return isSet.contains("enableAcceleratedNetworking");
    }

    @JsonIgnore
    public boolean isEnableIpForwardingSet() {
        return isSet.contains("enableIpForwarding");
    }
}
