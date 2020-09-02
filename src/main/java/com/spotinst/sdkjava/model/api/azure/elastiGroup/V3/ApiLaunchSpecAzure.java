package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiLaunchSpecAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         healthCheckType;
    private Integer                        healthCheckGracePeriod;
    private List<String>                   securityGroupIds;
    private Boolean                        monitoring;
    private Boolean                        ebsOptimized;
    private String                         imageId;
    private ApiIamRoleAzure                iamRole;
    private String                         keyPair;
    private String                         userData;
    private List<ApiBlockDeviceAzure>      blockDeviceMappings;
    private List<ApiNetworkInterfaceAzure> networkInterfaces;
    private List<ApiTagAzure>                   tags;
    private ApiLoadBalancersConfigAzure         loadBalancersConfig;
    //endregion

    //region Constructor

    public ApiLaunchSpecAzure() {
        isSet = new HashSet<>();
    }
    //endregion
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getHealthCheckType() {
        return healthCheckType;
    }

    public void setHealthCheckType(String healthCheckType) {
        isSet.add("healthCheckType");
        this.healthCheckType = healthCheckType;
    }

    public Integer getHealthCheckGracePeriod() {
        return healthCheckGracePeriod;
    }

    public void setHealthCheckGracePeriod(Integer healthCheckGracePeriod) {
        isSet.add("healthCheckGracePeriod");
        this.healthCheckGracePeriod = healthCheckGracePeriod;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public Boolean getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(Boolean monitoring) {
        isSet.add("monitoring");
        this.monitoring = monitoring;
    }

    public Boolean getEbsOptimized() {
        return ebsOptimized;
    }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public ApiIamRoleAzure getIamRole() {
        return iamRole;
    }

    public void setIamRole(ApiIamRoleAzure iamRole) {
        isSet.add("iamRole");
        this.iamRole = iamRole;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        isSet.add("keyPair");
        this.keyPair = keyPair;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        isSet.add("userData");
        this.userData = userData;
    }

    public List<ApiBlockDeviceAzure> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ApiBlockDeviceAzure> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public List<ApiNetworkInterfaceAzure> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiNetworkInterfaceAzure> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public List<ApiTagAzure> getTags() {
        return tags;
    }

    public void setTags(List<ApiTagAzure> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ApiLoadBalancersConfigAzure getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ApiLoadBalancersConfigAzure loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }
    //endregion

    //region isSet methods
    // Is healthCheckType Set boolean method
    @JsonIgnore
    public boolean isHealthCheckTypeSet() {
        return isSet.contains("healthCheckType");
    }


    // Is healthCheckGracePeriod Set boolean method
    @JsonIgnore
    public boolean isHealthCheckGracePeriodSet() {
        return isSet.contains("healthCheckGracePeriod");
    }


    // Is securityGroupIds Set boolean method
    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }


    // Is monitoring Set boolean method
    @JsonIgnore
    public boolean isMonitoringSet() {
        return isSet.contains("monitoring");
    }


    // Is ebsOptimized Set boolean method
    @JsonIgnore
    public boolean isEbsOptimizedSet() {
        return isSet.contains("ebsOptimized");
    }


    // Is imageId Set boolean method
    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }


    // Is iamRole Set boolean method
    @JsonIgnore
    public boolean isIamRoleSet() {
        return isSet.contains("iamRole");
    }


    // Is keyPair Set boolean method
    @JsonIgnore
    public boolean isKeyPairSet() {
        return isSet.contains("keyPair");
    }


    // Is userData Set boolean method
    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }


    // Is blockDeviceMappings Set boolean method
    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
    }


    // Is networkInterfaces Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }

    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }
    //endregion
}
