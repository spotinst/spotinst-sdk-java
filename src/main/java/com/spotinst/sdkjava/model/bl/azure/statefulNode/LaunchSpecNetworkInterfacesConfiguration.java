package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecNetworkInterfacesConfiguration {
    @JsonIgnore
    private Set<String>                                               isSet;
    private Boolean                                                   assignPublicIp;
    private Boolean                                                   isPrimary;
    private String                                                    subnetName;
    private String                                                    publicIpSku;
    private LaunchSpecNetworkSecurityGroupConfiguration               networkSecurityGroup;
    private LaunchSpecApplicationSecurityGroupConfiguration           applicationSecurityGroup;
    private Boolean                                                   enableIpForwarding;
    private List<String>                                              privateIps;
    private List<LaunchSpecNetworkInterfaceAdditionalIpConfiguration> additionalIpConfigurations;
    private List<LaunchSpecNetworkInterfacePublicIpsConfiguration>    publicIps;

    //region Constructors
    private LaunchSpecNetworkInterfacesConfiguration() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getAssignPublicIp() {
        return assignPublicIp;
    }

    public void setAssignPublicIp(Boolean assignPublicIp) {
        isSet.add("assignPublicIp");
        this.assignPublicIp = assignPublicIp;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean primary) {
        isSet.add("isPrimary");
        this.isPrimary = primary;
    }

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        isSet.add("subnetName");
        this.subnetName = subnetName;
    }

    public String getPublicIpSku() {
        return publicIpSku;
    }

    public void setPublicIpSku(String publicIpSku) {
        isSet.add("publicIpSku");
        this.publicIpSku = publicIpSku;
    }

    public LaunchSpecNetworkSecurityGroupConfiguration getNetworkSecurityGroup() {
        return networkSecurityGroup;
    }

    public void setNetworkSecurityGroup(LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup) {
        isSet.add("networkSecurityGroup");
        this.networkSecurityGroup = networkSecurityGroup;
    }

    public LaunchSpecApplicationSecurityGroupConfiguration getApplicationSecurityGroup() {
        return applicationSecurityGroup;
    }

    public void setApplicationSecurityGroup(LaunchSpecApplicationSecurityGroupConfiguration applicationSecurityGroup) {
        isSet.add("applicationSecurityGroup");
        this.applicationSecurityGroup = applicationSecurityGroup;
    }

    public Boolean getEnableIpForwarding() {
        return enableIpForwarding;
    }

    public void setEnableIpForwarding(Boolean enableIpForwarding) {
        isSet.add("enableIpForwarding");
        this.enableIpForwarding = enableIpForwarding;
    }

    public List<String> getPrivateIps() {
        return privateIps;
    }

    public void setPrivateIps(List<String> privateIps) {
        isSet.add("privateIps");
        this.privateIps = privateIps;
    }

    public List<LaunchSpecNetworkInterfaceAdditionalIpConfiguration> getAdditionalIpConfigurations() {
        return additionalIpConfigurations;
    }

    public void setAdditionalIpConfigurations(List<LaunchSpecNetworkInterfaceAdditionalIpConfiguration> additionalIpConfigurations) {
        isSet.add("additionalIpConfigurations");
        this.additionalIpConfigurations = additionalIpConfigurations;
    }

    public List<LaunchSpecNetworkInterfacePublicIpsConfiguration> getPublicIps() {
        return publicIps;
    }

    public void setPublicIps(List<LaunchSpecNetworkInterfacePublicIpsConfiguration> publicIps) {
        isSet.add("publicIps");
        this.publicIps = publicIps;
    }

    public static class Builder {

        private LaunchSpecNetworkInterfacesConfiguration networkInterfacesConfiguration;

        private Builder() {
            this.networkInterfacesConfiguration = new LaunchSpecNetworkInterfacesConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setIsPrimary(final Boolean isPrimary) {
            networkInterfacesConfiguration.setIsPrimary(isPrimary);
            return this;
        }

        public Builder setAssignPublicIp(final Boolean assignPublicIp) {
            networkInterfacesConfiguration.setAssignPublicIp(assignPublicIp);
            return this;
        }

        public Builder setSubnetName(final String subnetName) {
            networkInterfacesConfiguration.setSubnetName(subnetName);
            return this;
        }

        public Builder setPublicIpSku(final String publicIpSku) {
            networkInterfacesConfiguration.setPublicIpSku(publicIpSku);
            return this;
        }

        public Builder setNetworkSecurityGroup(final LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup) {
            networkInterfacesConfiguration.setNetworkSecurityGroup(networkSecurityGroup);
            return this;
        }

        public Builder setApplicationSecurityGroup(final LaunchSpecApplicationSecurityGroupConfiguration applicationSecurityGroup) {
            networkInterfacesConfiguration.setApplicationSecurityGroup(applicationSecurityGroup);
            return this;
        }

        public Builder setEnableIpForwarding(final Boolean enableIpForwarding) {
            networkInterfacesConfiguration.setEnableIpForwarding(enableIpForwarding);
            return this;
        }

        public Builder setPrivateIps(final List<String> privateIps) {
            networkInterfacesConfiguration.setPrivateIps(privateIps);
            return this;
        }

        public Builder setAdditionalIpConfigurations(final List<LaunchSpecNetworkInterfaceAdditionalIpConfiguration> additionalIpConfigurations) {
            networkInterfacesConfiguration.setAdditionalIpConfigurations(additionalIpConfigurations);
            return this;
        }

        public Builder setPublicIps(final List<LaunchSpecNetworkInterfacePublicIpsConfiguration> publicIps) {
            networkInterfacesConfiguration.setPublicIps(publicIps);
            return this;
        }

        public LaunchSpecNetworkInterfacesConfiguration build() {
            return networkInterfacesConfiguration;
        }
    }

    @JsonIgnore
    public boolean isAssignPublicIpSet() {
        return isSet.contains("assignPublicIp");
    }

    @JsonIgnore
    public boolean isIsPrimarySet() { return isSet.contains("isPrimary"); }

    @JsonIgnore
    public boolean isSubnetNameSet() { return isSet.contains("subnetName"); }

    @JsonIgnore
    public boolean isPublicIpSkuSet() {
        return isSet.contains("publicIpSku");
    }

    @JsonIgnore
    public boolean isNetworkSecurityGroupSet() {
        return isSet.contains("networkSecurityGroup");
    }

    @JsonIgnore
    public boolean isApplicationSecurityGroupSet() { return isSet.contains("applicationSecurityGroup"); }

    @JsonIgnore
    public boolean isEnableIpForwardingSet() {
        return isSet.contains("enableIpForwarding");
    }

    @JsonIgnore
    public boolean isPrivateIpsSet() { return isSet.contains("privateIps"); }

    @JsonIgnore
    public boolean isAdditionalIpConfigurationsSet() { return isSet.contains("additionalIpConfigurations"); }

    @JsonIgnore
    public boolean isPublicIpsSet() {
        return isSet.contains("publicIps");
    }

}

