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
public class ApiStatefulNodeResourceNetworkPublicIp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;
    private String      ipAddress;
    private String      skuName;

    public ApiStatefulNodeResourceNetworkPublicIp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        isSet.add("ipAddress");
        this.ipAddress = ipAddress;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        isSet.add("skuName");
        this.skuName = skuName;
    }


    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isIpAddressSet() {
        return isSet.contains("ipAddress");
    }

    @JsonIgnore
    public boolean isSkuNameSet() {
        return isSet.contains("skuName");
    }
}
