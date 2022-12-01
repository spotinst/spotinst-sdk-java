package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiImportOceanClusterAksResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                      isSet;
    private String                                           id;
    private ApiClusterConfigurationAks                       aks;
    private String                                           controllerClusterId;
    private String                                           name;
    private ApiImportClusterAutoScalerConfiguration          autoScaler;
    private ApiImportClusterStrategyConfiguration            strategy;
    private ApiImportClusterHealth                           health;
    private ApiImportClusterVirtualNodeGroupTemplateResponse virtualNodeGroupTemplate;
    private Date                                             createdAt;
    private Date                                             updatedAt;


    private ApiImportOceanClusterAksResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public ApiImportOceanClusterAksResponse setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        return this;
    }

    public ApiClusterConfigurationAks getAks() {
        return aks;
    }

    public void setAks(ApiClusterConfigurationAks aks) {
        isSet.add("aks");
        this.aks = aks;
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        isSet.add("controllerClusterId");
        this.controllerClusterId = controllerClusterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public ApiImportClusterAutoScalerConfiguration getAutoScaler() {

        return autoScaler;
    }

    public void setAutoScaler(ApiImportClusterAutoScalerConfiguration autoScaler) {

        isSet.add("autoScaler");
        this.autoScaler = autoScaler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public ApiImportClusterStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiImportClusterStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiImportClusterHealth getHealth() {
        return health;
    }

    public void setHealth(ApiImportClusterHealth health) {
        isSet.add("health");
        this.health = health;
    }

    public ApiImportClusterVirtualNodeGroupTemplateResponse getVirtualNodeGroupTemplate() {
        return virtualNodeGroupTemplate;
    }

    public void setVirtualNodeGroupTemplate(ApiImportClusterVirtualNodeGroupTemplateResponse virtualNodeGroupTemplate) {
        isSet.add("virtualNodeGroupTemplate");
        this.virtualNodeGroupTemplate = virtualNodeGroupTemplate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public boolean isAksSet() {
        return isSet.contains("aks");
    }

    @JsonIgnore
    public boolean isControllerClusterIdSet() {
        return isSet.contains("controllerClusterId");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupTemplateSet() {
        return isSet.contains("virtualNodeGroupTemplate");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isHealthSet() {
        return isSet.contains("health");
    }

    @JsonIgnore
    public boolean isAutoScalerSet() {
        return isSet.contains("autoScaler");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }

}