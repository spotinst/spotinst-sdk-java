package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by Bansi Chapla on 21/07/2021.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiOceanEcsCluster implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 id;
    private String                                 name;
    private String                                 region;
    private String                                 clusterName;
    private ApiClusterAutoScalerConfiguration      autoScaler;
    private ApiClusterCapacityConfiguration        capacity;
    private ApiClusterComputeConfiguration         compute;
    private ApiClusterSchedulingConfiguration      scheduling;
    private ApiClusterStrategyConfiguration        strategy;

    public ApiOceanEcsCluster() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setclusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
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

    public ApiClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiClusterComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
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

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
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
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

}