package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiNetworkInterfaceAks  implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>               isSet;
    private boolean                   isPrimary;
    private String                    subnetName;
    private boolean                   assignPublicIp;
    private ApiSecurityGroupAks       securityGroup;
    private boolean                   enableIPForwarding;


    public ApiNetworkInterfaceAks() {
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
        isSet.add("primary");
        isPrimary = primary;
    }

    public ApiSecurityGroupAks getSecurityGroup() {
        return securityGroup;
    }

    public void setSecurityGroup(ApiSecurityGroupAks securityGroup) {
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
        return isSet.contains("primary");
    }

    @JsonIgnore
    public boolean isSecurityGroupSet() {
        return isSet.contains("securityGroup");
    }

    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }
}
