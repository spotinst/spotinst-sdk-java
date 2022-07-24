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
public class ApiImportClusterLaunchSpecificationAksResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<ApiClusterExtensionAks>           extensions;
    private ApiClusterImageAks                  image;
    private ApiClusterLoadBalancersConfigAks    loadBalancersConfig;
    private ApiImportClusterLoginAks            login;
    private ApiImportClusterNetworkAks          network;
    private ApiImportClusterOsDiskAks           osDisk;
    private String                              resourceGroupName;
    private String                              customData;
    private List<ApiClusterTagAks>                 tags;
    private Integer                             maxPods;

    private ApiImportClusterLaunchSpecificationAksResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiClusterExtensionAks> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<ApiClusterExtensionAks> extensions) {
        isSet.add("extensions");
        this.extensions = extensions;
    }

    public ApiClusterImageAks getImage() {
        return image;
    }

    public void setImage(ApiClusterImageAks image) {

        isSet.add("image");
        this.image = image;
    }

    public ApiClusterLoadBalancersConfigAks getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ApiClusterLoadBalancersConfigAks loadBalancersConfig) {

        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ApiImportClusterLoginAks getLogin() {
        return login;
    }

    public void setLogin(ApiImportClusterLoginAks login) {

        isSet.add("login");
        this.login = login;
    }

    public ApiImportClusterNetworkAks getNetwork() {
        return network;
    }

    public void setNetwork(ApiImportClusterNetworkAks network) {

        isSet.add("network");
        this.network = network;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {

        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public List<ApiClusterTagAks> getTags() {
        return tags;
    }

    public void setTags(List<ApiClusterTagAks> tags) {

        isSet.add("tags");
        this.tags = tags;
    }

    public ApiImportClusterOsDiskAks getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ApiImportClusterOsDiskAks osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {

        isSet.add("customData");
        this.customData = customData;
    }

    public Integer getMaxPods() {
        return maxPods;
    }

    public void setMaxPods(Integer maxPods) {

        isSet.add("maxPods");
        this.maxPods = maxPods;
    }

    @JsonIgnore
    public boolean isExtensionsSet() {
        return isSet.contains("extensions");
    }

    @JsonIgnore
    public boolean isImageSet() {
        return isSet.contains("image");
    }

    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }

    @JsonIgnore
    public boolean isLoginSet() {
        return isSet.contains("login");
    }

    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    @JsonIgnore
    public boolean isOsDiskSet() {
        return isSet.contains("osDisk");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isCustomDataSet() {
        return isSet.contains("customData");
    }

    @JsonIgnore
    public boolean isMaxPodsSet() {
        return isSet.contains("maxPods");
    }

}

