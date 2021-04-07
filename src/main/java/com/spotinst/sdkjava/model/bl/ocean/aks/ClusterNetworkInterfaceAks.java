package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterNetworkInterfaceAks {
    @JsonIgnore
    private Set<String>                     isSet;
    private boolean                         assignPublicIp;
    private boolean                         enableIPForwarding;
    private boolean                         isPrimary;
    private List<ClusterSecurityGroupAks>   securityGroup;
    private String                          subnetName;


    private ClusterNetworkInterfaceAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public boolean getAssignPublicIp() {
        return assignPublicIp;
    }

    public void setAssignPublicIp(boolean assignPublicIp) {
        isSet.add("assignPublicIp");
        this.assignPublicIp = assignPublicIp;
    }

    public boolean getEnableIPForwarding() {
        return enableIPForwarding;
    }

    public void setEnableIPForwarding(boolean enableIPForwarding) {
        isSet.add("enableIPForwarding");
        this.enableIPForwarding = enableIPForwarding;
    }

    public boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(boolean primary) {
        isSet.add("isPrimary");
        isPrimary = primary;
    }

    public List<ClusterSecurityGroupAks> getSecurityGroup() {
        return securityGroup;
    }

    public void setSecurityGroup(List<ClusterSecurityGroupAks> securityGroup) {
        isSet.add("securityGroup");
        this.securityGroup = securityGroup;
    }

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        isSet.add("subnetName");
        this.subnetName = subnetName;
    }

    @JsonIgnore
    public boolean isAssignPublicIpSet() {
        return isSet.contains("assignPublicIp");
    }

    @JsonIgnore
    public boolean isEnableIPForwardingSet() {
        return isSet.contains("enableIPForwarding");
    }

    @JsonIgnore
    public boolean isIsPrimarySet() {
        return isSet.contains("IsPrimary");
    }

    @JsonIgnore
    public boolean isSecurityGroupSet() {
        return isSet.contains("securityGroup");
    }

    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }

    public static class Builder {

        private ClusterNetworkInterfaceAks clusterNetworkInterfaceAks;

        private Builder() {
            this.clusterNetworkInterfaceAks = new ClusterNetworkInterfaceAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setAssignPublicIp(final boolean assignPublicIp) {
            clusterNetworkInterfaceAks.setAssignPublicIp(assignPublicIp);
            return this;
        }
        public Builder setEnableIPForwarding(final boolean enableIPForwarding) {
            clusterNetworkInterfaceAks.setEnableIPForwarding(enableIPForwarding);
            return this;
        }
        public Builder setSecurityGroup(final List<ClusterSecurityGroupAks> securityGroup) {
            clusterNetworkInterfaceAks.setSecurityGroup(securityGroup);
            return this;
        }
        public Builder setSubnetName(final String subnetName) {
            clusterNetworkInterfaceAks.setSubnetName(subnetName);
            return this;
        }
        public Builder setIsPrimary(final boolean isPrimary) {
            clusterNetworkInterfaceAks.setIsPrimary(isPrimary);
            return this;
        }

        public ClusterNetworkInterfaceAks build() {
            return clusterNetworkInterfaceAks;
        }
    }
}
