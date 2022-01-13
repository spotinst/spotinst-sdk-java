package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiLaunchSpecNetworkInterfacesConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                               isSet;
    private Boolean                                                   assignPublicIp;
    private Boolean                                                   isPrimary;
    private String                                                    subnetName;
    private String                                                    publicIpSku;
    private ApiLaunchSpecNetworkSecurityGroupConfiguration            networkSecurityGroup;
    private ApiLaunchSpecApplicationSecurityGroupConfiguration        applicationSecurityGroup;
    private Boolean                                                   enableIpForwarding;
    private List<String>                                              privateIps;
    private List<ApiLaunchSpecNetworkInterfaceAdditionalIpConfiguration> additionalIpConfigurations;
    private List<ApiLaunchSpecNetworkInterfacePublicIpsConfiguration> publicIps;

    //region Constructors
    public ApiLaunchSpecNetworkInterfacesConfiguration() {
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
        isPrimary = primary;
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

    public ApiLaunchSpecNetworkSecurityGroupConfiguration getNetworkSecurityGroup() {
        return networkSecurityGroup;
    }

    public void setNetworkSecurityGroup(ApiLaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup) {
        isSet.add("networkSecurityGroup");
        this.networkSecurityGroup = networkSecurityGroup;
    }


    public ApiLaunchSpecApplicationSecurityGroupConfiguration getApplicationSecurityGroup() {
        return applicationSecurityGroup;
    }

    public void setApplicationSecurityGroup(ApiLaunchSpecApplicationSecurityGroupConfiguration applicationSecurityGroup) {
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

    public List<ApiLaunchSpecNetworkInterfaceAdditionalIpConfiguration> getAdditionalIpConfigurations() {
        return additionalIpConfigurations;
    }

    public void setAdditionalIpConfigurations(List<ApiLaunchSpecNetworkInterfaceAdditionalIpConfiguration> additionalIpConfigurations) {
        isSet.add("additionalIpConfigurations");
        this.additionalIpConfigurations = additionalIpConfigurations;
    }

    public List<ApiLaunchSpecNetworkInterfacePublicIpsConfiguration> getPublicIps() {
        return publicIps;
    }

    public void setPublicIps(List<ApiLaunchSpecNetworkInterfacePublicIpsConfiguration> publicIps) {
        isSet.add("publicIps");
        this.publicIps = publicIps;
    }

    @JsonIgnore
    public boolean isAssignPublicIpSet() {
        return isSet.contains("assignPublicIp");
    }

    @JsonIgnore
    public boolean isIsPrimarySet() {
        return isSet.contains("isPrimary");
    }

    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }

    @JsonIgnore
    public boolean isPublicIpSkuSet() {
        return isSet.contains("publicIpSku");
    }

    @JsonIgnore
    public boolean isNetworkSecurityGroupSet() {
        return isSet.contains("networkSecurityGroup");
    }

    @JsonIgnore
    public boolean isApplicationSecurityGroupGroupSet() {
        return isSet.contains("applicationSecurityGroup");
    }

    @JsonIgnore
    public boolean isEnableIpForwardingSet() {
        return isSet.contains("enableIpForwarding");
    }

    @JsonIgnore
    public boolean isPrivateIpsSet() {
        return isSet.contains("privateIps");
    }

    @JsonIgnore
    public boolean isAdditionalIpConfigurationsSet() {
        return isSet.contains("additionalIpConfigurations");
    }

    @JsonIgnore
    public boolean isPublicIpsSet() {
        return isSet.contains("publicIps");
    }
}

