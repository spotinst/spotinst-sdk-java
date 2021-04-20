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

public class ApiNetworkInterfaceAks  implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                             isSet;
    private boolean                                 isPrimary;
    private String                                  subnetName;
    private boolean                                 assignPublicIp;
    private ApiSecurityGroupAks                     securityGroup;
    private boolean                                 enableIPForwarding;
    private String                                  publicIpSku;
    private List<ApiAdditionalIpConfigurationsAks>  additionalIpConfigurations;


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
        isSet.add("isPrimary");
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

    public String getPublicIpSku() {
        return publicIpSku;
    }

    public void setPublicIpSku(String publicIpSku) {
        isSet.add("publicIpSku");
        this.publicIpSku = publicIpSku;
    }

    public List<ApiAdditionalIpConfigurationsAks> getAdditionalIpConfigurations() {
        return additionalIpConfigurations;
    }

    public void setAdditionalIpConfigurations(List<ApiAdditionalIpConfigurationsAks> additionalIpConfigurations) {
        isSet.add("additionalIpConfigurations");
        this.additionalIpConfigurations = additionalIpConfigurations;
    }

    @JsonIgnore
    public boolean isAdditionalIpConfigurationsSet() {
        return isSet.contains("additionalIpConfigurations");
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
        return isSet.contains("isPrimary");
    }

    @JsonIgnore
    public boolean isSecurityGroupSet() {
        return isSet.contains("securityGroup");
    }

    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }

    @JsonIgnore
    public boolean isPublicIpSkuSet() {
        return isSet.contains("publicIpSku");
    }
}
