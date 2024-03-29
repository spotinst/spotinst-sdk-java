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
public class ApiLaunchSpecNetworkInterfacesConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                    isSet;
    private Boolean                                        assignPublicIp;
    private Boolean                                        isPrimary;
    private String                                         subnetName;
    private String                                         publicIpSku;
    private ApiLaunchSpecNetworkSecurityGroupConfiguration networkSecurityGroup;

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


}

