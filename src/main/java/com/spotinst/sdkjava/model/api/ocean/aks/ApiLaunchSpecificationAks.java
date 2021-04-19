package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ApiLaunchSpecificationAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                  isSet;
    private List<ApiExtensionAks>        extensions;
    private ApiImageAks                  image;
    private ApiLoadBalancersConfigAks    loadBalancersConfig;
    private ApiLoginAks                  login;
    private ApiNetworkAks                network;
    private ApiOsDiskAks                 osDisk;
    private String                       resourceGroupName;


    public ApiLaunchSpecificationAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiExtensionAks> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<ApiExtensionAks> extensions) {
        isSet.add("extensions");
        this.extensions = extensions;
    }

    public ApiImageAks getImage() {
        return image;
    }

    public void setImage(ApiImageAks image) {

        isSet.add("image");
        this.image = image;
    }

    public ApiLoadBalancersConfigAks getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ApiLoadBalancersConfigAks loadBalancersConfig) {

        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public ApiLoginAks getLogin() {
        return login;
    }

    public void setLogin(ApiLoginAks login) {

        isSet.add("login");
        this.login = login;
    }

    public ApiNetworkAks getNetwork() {
        return network;
    }

    public void setNetwork(ApiNetworkAks network) {

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

    public ApiOsDiskAks getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ApiOsDiskAks osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
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


}