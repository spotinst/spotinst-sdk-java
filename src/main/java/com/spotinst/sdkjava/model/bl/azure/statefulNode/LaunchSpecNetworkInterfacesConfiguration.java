package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecNetworkInterfacesConfiguration {
    @JsonIgnore
    private Set<String>                                 isSet;
    private Boolean                                     assignPublicIp;
    private Boolean                                     isPrimary;
    private String                                      subnetName;
    private String                                      publicIpSku;
    private LaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup;

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

    public static class Builder {

        private LaunchSpecNetworkInterfacesConfiguration networkInterfacesConfiguration;

        private Builder() {
            this.networkInterfacesConfiguration = new LaunchSpecNetworkInterfacesConfiguration();
        }

        public static Builder get() {
            return new Builder();
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
}

