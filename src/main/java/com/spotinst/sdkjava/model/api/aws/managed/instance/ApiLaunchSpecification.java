package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiLaunchSpecification {

    @JsonIgnore
    private Set<String>                     isSet;
    private List<ApiBlockDeviceMappings>    blockDeviceMappings;
    private ApiCreditSpecification          creditSpecification;
    private Boolean                         ebsOptimized;
    private ApiIamRole                      iamRole;
    private String                          imageId;
    private ApiInstanceTypes                instanceTypes;
    private String                          keyPair;
    private Boolean                         monitoring;
    private List<ApiNetworkInterfaces>         networkInterfaces;
    private ApiResourceTagSpecification        resourceTagSpecification;
    private List<String>                    securityGroupIds;
    private String                          shutdownScript;
    private List<ApiTags>                      tags;
    private String                          tenancy;
    private String                          userData;

    private ApiLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiBlockDeviceMappings> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ApiBlockDeviceMappings> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public ApiCreditSpecification getCreditSpecification() {
        return creditSpecification;
    }

    public void setCreditSpecification(ApiCreditSpecification creditSpecification) {
        isSet.add("creditSpecification");
        this.creditSpecification = creditSpecification;
    }

    public Boolean getEbsOptimized() {
        return ebsOptimized;
    }

    public void setEbsOptimized(Boolean ebsOptimized) {
        isSet.add("ebsOptimized");
        this.ebsOptimized = ebsOptimized;
    }

    public ApiIamRole getIamRole() {
        return iamRole;
    }

    public void setIamRole(ApiIamRole iamRole) {
        isSet.add("iamRole");
        this.iamRole = iamRole;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public ApiInstanceTypes getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ApiInstanceTypes instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        isSet.add("keyPair");
        this.keyPair = keyPair;
    }

    public Boolean getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(Boolean monitoring) {
        isSet.add("monitoring");
        this.monitoring = monitoring;
    }

    public List<ApiNetworkInterfaces> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiNetworkInterfaces> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public ApiResourceTagSpecification getResourceTagSpecification() {
        return resourceTagSpecification;
    }

    public void setResourceTagSpecification(ApiResourceTagSpecification resourceTagSpecification) {
        isSet.add("resourceTagSpecification");
        this.resourceTagSpecification = resourceTagSpecification;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public String getShutdownScript() {
        return shutdownScript;
    }

    public void setShutdownScript(String shutdownScript) {
        isSet.add("shutdownScript");
        this.shutdownScript = shutdownScript;
    }

    public List<ApiTags> getTags() {
        return tags;
    }

    public void setTags(List<ApiTags> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public String getTenancy() {
        return tenancy;
    }

    public void setTenancy(String tenancy) {
        isSet.add("tenancy");
        this.tenancy = tenancy;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        isSet.add("userData");
        this.userData = userData;
    }

    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
    }

    @JsonIgnore
    public boolean isCreditSpecificationSet() {
        return isSet.contains("creditSpecification");
    }

    @JsonIgnore
    public boolean isEbsOptimizedSet() {
        return isSet.contains("ebsOptimized");
    }

    @JsonIgnore
    public boolean isIamRoleSet() {
        return isSet.contains("iamRole");
    }

    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }

    @JsonIgnore
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }

    @JsonIgnore
    public boolean isKeyPairSet() {
        return isSet.contains("keyPair");
    }

    @JsonIgnore
    public boolean isMonitoringSet() {
        return isSet.contains("monitoring");
    }

    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }

    @JsonIgnore
    public boolean isResourceTagSpecificationSet() {
        return isSet.contains("resourceTagSpecification");
    }

    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }

    @JsonIgnore
    public boolean isShutdownScriptSet() {
        return isSet.contains("shutdownScript");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isTenancySet() {
        return isSet.contains("tenancy");
    }

    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }

}
