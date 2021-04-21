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
public class ApiClusterLaunchSpecificationAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<ApiClusterExtensionAks>        extensions;
    private ApiClusterImageAks                  image;
    private ApiClusterLoadBalancersConfigAks    loadBalancersConfig;
    private ApiClusterLoginAks                  login;
    private ApiClusterNetworkAks                network;
    private ApiClusterOsDiskAks                 osDisk;
    private String                              resourceGroupName;
    private List<ApiClusterTagAks>              tags;

    public ApiClusterLaunchSpecificationAks() {
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

    public ApiClusterLoginAks getLogin() {
        return login;
    }

    public void setLogin(ApiClusterLoginAks login) {

        isSet.add("login");
        this.login = login;
    }

    public ApiClusterNetworkAks getNetwork() {
        return network;
    }

    public void setNetwork(ApiClusterNetworkAks network) {

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

    public ApiClusterOsDiskAks getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ApiClusterOsDiskAks osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public List<ApiClusterTagAks> getTags() {
        return tags;
    }

    public void setTags(List<ApiClusterTagAks> tags) {

        isSet.add("tags");
        this.tags = tags;
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
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isOsDiskSet() {
        return isSet.contains("osDisk");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }
}


