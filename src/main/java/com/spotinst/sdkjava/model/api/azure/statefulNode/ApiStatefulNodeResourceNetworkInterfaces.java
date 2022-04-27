package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.LaunchSpecNetworkSecurityGroupConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeResourceNetworkInterfaces implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                             isSet;
    private String                                                  name;
    private String                                                  resourceGroupName;
    private Boolean                                                 isPrimary;
    private ApiLaunchSpecNetworkSecurityGroupConfiguration          networkSecurityGroup;
    private List<ApiStatefulNodeResourceNetworkIpConfigurations>    ipConfigurations;
    private String                                                  macAddress;
    private Boolean                                                 enableAcceleratedNetworking;
    private Boolean                                                 enableIpForwarding;

    public ApiStatefulNodeResourceNetworkInterfaces() {
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

    public ApiLaunchSpecNetworkSecurityGroupConfiguration getNetworkSecurityGroup() {
        return networkSecurityGroup;
    }

    public void setNetworkSecurityGroup(ApiLaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup) {
        isSet.add("networkSecurityGroup");
        this.networkSecurityGroup = networkSecurityGroup;
    }

    public List<ApiStatefulNodeResourceNetworkIpConfigurations> getIpConfigurations() {
        return ipConfigurations;
    }

    public void setIpConfigurations(List<ApiStatefulNodeResourceNetworkIpConfigurations> ipConfigurations) {
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
    public boolean isMacAddressSet() {
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
