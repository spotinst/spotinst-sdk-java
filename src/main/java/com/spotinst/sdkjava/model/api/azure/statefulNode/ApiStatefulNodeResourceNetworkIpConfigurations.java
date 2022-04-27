package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeResourceNetworkIpConfigurations implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  name;
    private String                                  privateIpAddress;
    private String                                  privateIPAddressVersion;
    private String                                  privateIpAllocationMethod;
    private String                                  applicationSecurityGroups;
    private Boolean                                 primary;
    private ApiStatefulNodeResourceNetworkSubnet    subnet;
    private ApiStatefulNodeResourceNetworkPublicIp  publicIp;

    public ApiStatefulNodeResourceNetworkIpConfigurations() {
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

    public ApiStatefulNodeResourceNetworkSubnet getSubnet() {
        return subnet;
    }

    public void setSubnet(ApiStatefulNodeResourceNetworkSubnet subnet) {
        isSet.add("subnet");
        this.subnet = subnet;
    }

    public ApiStatefulNodeResourceNetworkPublicIp getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(ApiStatefulNodeResourceNetworkPublicIp publicIp) {
        isSet.add("publicIp");
        this.publicIp = publicIp;
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
