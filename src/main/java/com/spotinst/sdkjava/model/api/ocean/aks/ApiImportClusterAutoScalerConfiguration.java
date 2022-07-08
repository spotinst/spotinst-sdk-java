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

public class ApiImportClusterAutoScalerConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                 isSet;
    private Boolean                                     isEnabled;
    private ApiImportClusterResourceLimitsSpecification resourceLimits;
    private ApiImportClusterDownSpecification           down;
    private ApiImportClusterHeadroomSpecification       headroom;
    private ApiImportClusterStrategyConfiguration       strategy;
    private ApiImportClusterHealth                      health;
    private ApiImportClusterVirtualNodeGroupTemplate    virtualNodeGroupTemplate;
    private Date                                        createdAt;
    private Date                                        updatedAt;

    public ApiImportClusterAutoScalerConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public ApiImportClusterResourceLimitsSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiImportClusterResourceLimitsSpecification resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public ApiImportClusterDownSpecification getDown() {
        return down;
    }

    public void setDown(ApiImportClusterDownSpecification down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiImportClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiImportClusterHeadroomSpecification headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
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

    public ApiImportClusterVirtualNodeGroupTemplate getVirtualNodeGroupTemplate() {
        return virtualNodeGroupTemplate;
    }

    public void setVirtualNodeGroupTemplate(ApiImportClusterVirtualNodeGroupTemplate virtualNodeGroupTemplate) {
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
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isResourceLimits() {
        return isSet.contains("resourceLimits");
    }

    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headroom");
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
    public boolean isVirtualNodeGroupTemplateSet() {
        return isSet.contains("virtualNodeGroupTemplate");
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
