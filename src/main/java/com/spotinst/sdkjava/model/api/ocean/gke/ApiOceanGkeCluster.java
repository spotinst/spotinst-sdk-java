package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiOceanGkeCluster implements IPartialUpdateEntity{

    @JsonIgnore
    private Set<String>                         isSet;
    private String                              id;
    private String                              name;
    private ApiClusterAutoScalerConfiguration   autoScaler;
    private ApiClusterCapacityConfiguration     capacity;
    private ApiClusterComputeConfiguration      compute;
    private String                              controllerClusterId;
    private ApiClusterGkeConfiguration          gke;
    private ApiClusterSchedulingConfiguration   scheduling;
    private ApiClusterSecurityConfiguration     security;
    private ApiClusterStrategyConfiguration     strategy;

    public ApiOceanGkeCluster() {
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

    public void setId(String launchSpecId) {
        this.id = launchSpecId;
        isSet.add("id");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        isSet.add("name");
    }

    public ApiClusterAutoScalerConfiguration getAutoScaler() {
        return autoScaler;
    }

    public void setAutoScaler(ApiClusterAutoScalerConfiguration autoScaler) {
        this.autoScaler = autoScaler;
        isSet.add("autoScaler");
    }

    public ApiClusterCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiClusterCapacityConfiguration capacity) {
        this.capacity = capacity;
        isSet.add("capacity");
    }

    public ApiClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiClusterComputeConfiguration compute) {
        this.compute = compute;
        isSet.add("compute");
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        this.controllerClusterId = controllerClusterId;
        isSet.add("controllerClusterId");
    }

    public ApiClusterGkeConfiguration getGke() {
        return gke;
    }

    public void setGke(ApiClusterGkeConfiguration gke) {
        isSet.add("gke");
        this.gke = gke;
    }

    public ApiClusterSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiClusterSchedulingConfiguration scheduling) {
        this.scheduling = scheduling;
        isSet.add("scheduling");
    }

    public ApiClusterSecurityConfiguration getSecurity() {
        return security;
    }

    public void setSecurity(ApiClusterSecurityConfiguration security) {
        this.security = security;
        isSet.add("security");
    }

    public ApiClusterStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiClusterStrategyConfiguration strategy) {
        this.strategy = strategy;
        isSet.add("strategy");
    }

    @JsonIgnore
    public Boolean isIdSet() { return isSet.contains("id"); }

    @JsonIgnore
    public Boolean isNameSet() { return isSet.contains("name"); }

    @JsonIgnore
    public Boolean isControllerClusterIdSet() { return isSet.contains("controllerClusterId"); }

    @JsonIgnore
    public boolean isAutoScalerSet() {
        return isSet.contains("autoScaler");
    }

    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isGkeSet() {
        return isSet.contains("gke");
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

}

