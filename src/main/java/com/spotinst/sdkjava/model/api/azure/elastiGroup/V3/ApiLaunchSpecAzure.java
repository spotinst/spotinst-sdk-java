package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;

    private ApiImageSpecAzure           image;
    private ApiLoadBalancersConfigAzure loadBalancersConfig;
    private List<ApiTagAzure>           tags;
    private List<ApiNetworkAzure>       network;
    private List<ApiLoginAzure>         login;
    private String                      customData;
    //todo add managedServiceIdentities, shutdownScript ,extensions,dataDisks in future


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

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        isSet.add("customData");
        this.customData = customData;
    }


    public List<ApiNetworkAzure> getNetwork() {
        return network;
    }

    public void setNetwork(List<ApiNetworkAzure> network) {
        isSet.add("network");
        this.network = network;
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

    public List<ApiLoginAzure> getLogin() {
        return login;
    }

    public void setLogin(List<ApiLoginAzure> login) {
        isSet.add("login");
        this.login = login;
    }

    public ApiImageSpecAzure getImage() {
        return image;
    }

    public void setImage(ApiImageSpecAzure image) {
        isSet.add("image");
        this.image = image;
    }

    //endregion

    //region isSet methods


    // Is customData Set boolean method
    @JsonIgnore
    public boolean isCustomDataSet() {
        return isSet.contains("customData");
    }

    // Is Login Set boolean method
    @JsonIgnore
    public boolean isLoginaSet() {
        return isSet.contains("login");
    }   //TODO Itzik - typo in name

    // Is network Set boolean method
    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    // Is image Set boolean method
    @JsonIgnore
    public boolean isImageSet() {
        return isSet.contains("image");
    }

    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }
    //endregion
}
