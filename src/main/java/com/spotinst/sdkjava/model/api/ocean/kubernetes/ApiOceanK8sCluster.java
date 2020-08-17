package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lihi Shoham on 3/7/2020.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiOceanK8sCluster implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                       isSet;
    private String                            id;
    private String                            name;
    private String                            controllerClusterId;
    private String                            region;
    private ApiClusterAutoScalerConfiguration autoScaler;
    private ApiClusterCapacityConfiguration   capacity;
    private ApiClusterStrategyConfiguration   strategy;
    private ApiClusterSchedulingConfiguration scheduling;
    private ApiClusterSecurityConfiguration   security;
    private ApiClusterComputeConfiguration    compute;
    private Date                              createdAt;
    private Date                              updatedAt;

    public ApiOceanK8sCluster() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        isSet.add("controllerClusterId");
        this.controllerClusterId = controllerClusterId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public ApiClusterAutoScalerConfiguration getAutoScaler() {
        return autoScaler;
    }

    public void setAutoScaler(ApiClusterAutoScalerConfiguration autoScaler) {
        isSet.add("autoScaler");
        this.autoScaler = autoScaler;
    }

    public ApiClusterCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiClusterCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ApiClusterSecurityConfiguration getSecurity() {
        return security;
    }

    public void setSecurity(ApiClusterSecurityConfiguration security) {
        isSet.add("security");
        this.security = security;
    }

    public ApiClusterSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiClusterSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public ApiClusterStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiClusterStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiClusterComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
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
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isControllerClusterIdSet() {
        return isSet.contains("controllerClusterId");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isAutoScalerSet() {
        return isSet.contains("autoScaler");
    }

    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    @JsonIgnore
    public boolean isSecuritySet() {
        return isSet.contains("security");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
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
