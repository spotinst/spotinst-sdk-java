package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiCpuOptions;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiCreditSpecification;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiMetadataOptions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiLaunchSpec implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           healthCheckType;
    private Boolean                          autoHealing;
    private Integer                          healthCheckGracePeriod;
    private List<String>                     securityGroupIds;
    private Boolean                          monitoring;
    private Boolean                          ebsOptimized;
    private String                           imageId;
    private List<ApiImages>                  images;
    private ApiIamRole                       iamRole;
    private String                           keyPair;
    private Integer                          healthCheckUnhealthyDurationBeforeReplacement;
    private String                           userData;
    private String                           shutdownScript;
    private List<ApiBlockDevice>             blockDeviceMappings;
    private List<ApiNetworkInterface>        networkInterfaces;
    private List<ApiTag>                     tags;
    private ApiGroupResourceTagSpecification resourceTagSpecification;
    private ApiLoadBalancersConfig           loadBalancersConfig;
    private ApiItf                           itf;
    private ApiCpuOptions                    cpuOptions;
    private ApiMetadataOptions               metadataOptions;
    private ApiCreditSpecification           creditSpec;
    //endregion

    //region Constructor

    public ApiLaunchSpec() {
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

    public ApiGroupResourceTagSpecification getResourceTagSpecification() {
        return resourceTagSpecification;
    }

    public void setResourceTagSpecification(ApiGroupResourceTagSpecification resourceTagSpecification) {
        isSet.add("resourceTagSpecification");
        this.resourceTagSpecification = resourceTagSpecification;
    }

    public String getHealthCheckType() {
        return healthCheckType;
    }

    public void setHealthCheckType(String healthCheckType) {
        isSet.add("healthCheckType");
        this.healthCheckType = healthCheckType;
    }

    public Boolean getAutoHealing() {
        return autoHealing;
    }

    public void setAutoHealing(Boolean autoHealing) {
        isSet.add("autoHealing");
        this.autoHealing = autoHealing;
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

    public List<ApiImages> getImages() {
        return images;
    }

    public void setImages(List<ApiImages> images) {
        isSet.add("images");
        this.images = images;
    }

    public ApiIamRole getIamRole() {
        return iamRole;
    }

    public void setIamRole(ApiIamRole iamRole) {
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

    public String getShutdownScript() {
        return shutdownScript;
    }

    public void setShutdownScript(String script) {
        isSet.add("shutdownScript");
        this.shutdownScript = script;
    }

    public Integer getHealthCheckUnhealthyDurationBeforeReplacement() {
        return healthCheckUnhealthyDurationBeforeReplacement;
    }

    public void setHealthCheckUnhealthyDurationBeforeReplacement(Integer healthCheckUnhealthyDurationBeforeReplacement) {
        isSet.add("healthCheckUnhealthyDurationBeforeReplacement");
        this.healthCheckUnhealthyDurationBeforeReplacement = healthCheckUnhealthyDurationBeforeReplacement;
    }

    public List<ApiBlockDevice> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ApiBlockDevice> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public List<ApiNetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiNetworkInterface> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public List<ApiTag> getTags() {
        return tags;
    }

    public void setTags(List<ApiTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ApiLoadBalancersConfig getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ApiLoadBalancersConfig loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ApiItf getItf() {
        return itf;
    }

    public void setItf(ApiItf itf) {
        isSet.add("itf");
        this.itf = itf;
    }

    public ApiCpuOptions getCpuOptions() {
        return cpuOptions;
    }

    public void setCpuOptions(ApiCpuOptions options) {
        isSet.add("cpuOptions");
        this.cpuOptions = options;
    }

    public ApiMetadataOptions getMetadataOptions() {
        return metadataOptions;
    }

    public void setMetadataOptions(ApiMetadataOptions options) {
        isSet.add("metadataOptions");
        this.metadataOptions = options;
    }

    public ApiCreditSpecification getCreditSpecification() {
        return creditSpec;
    }

    public void setCreditSpecification(ApiCreditSpecification spec) {
        isSet.add("creditSpecification");
        this.creditSpec = spec;
    }

    //endregion

    //region isSet methods

    // Is healthCheckType Set boolean method
    @JsonIgnore
    public boolean isHealthCheckTypeSet() {
        return isSet.contains("healthCheckType");
    }

    @JsonIgnore
    public boolean isAutoHealingSet() {
        return isSet.contains("autoHealing");
    }

    // Is resourceTagSpecification Set boolean method
    @JsonIgnore
    public boolean isResourceTagSpecificationSet() {
        return isSet.contains("resourceTagSpecification");
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

    // Is images Set boolean method
    @JsonIgnore
    public boolean isImagesSet() {
        return isSet.contains("images");
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

    @JsonIgnore
    public boolean isShutdownScriptSet() {
        return isSet.contains("shutdownScript");
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

    // Is loadBalancersConfig Set boolean method
    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }

    // Is healthCheckUnhealthyDurationBeforeReplacement Set boolean method
    @JsonIgnore
    public boolean isHealthCheckUnhealthyDurationBeforeReplacementSet() {
        return isSet.contains("healthCheckUnhealthyDurationBeforeReplacement");
    }

    // Is itf Set boolean method
    @JsonIgnore
    public boolean isItfSet() { return isSet.contains("itf"); }

    @JsonIgnore
    public boolean isCpuOptionsSet() { return isSet.contains("cpuOptions"); }

    @JsonIgnore
    public boolean isMetadataOptionsSet() { return isSet.contains("metadataOptions"); }

    @JsonIgnore
    public boolean isCreditSpecificationSet() { return isSet.contains("creditSpecification"); }

    //endregion
}
