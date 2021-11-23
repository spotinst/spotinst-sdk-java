package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNode implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 id;
    private String                                 name;
    private String                                 region;
    private String                                 resourceGroupName;
    private String                                 description;
    private ApiStatefulNodeStrategyConfiguration   strategy;
    private ApiStatefulNodeComputeConfiguration    compute;
    private ApiStatefulNodeSchedulingConfiguration scheduling;
    private ApiStatefulNodePersistentConfiguration persistent;
    private ApiStatefulNodeHealthConfiguration     health;

    private ApiStatefulNode() {
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public ApiStatefulNodeStrategyConfiguration getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiStatefulNodeStrategyConfiguration strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiStatefulNodeComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiStatefulNodeComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public ApiStatefulNodeSchedulingConfiguration getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiStatefulNodeSchedulingConfiguration scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }

    public ApiStatefulNodePersistentConfiguration getPersistent() {
        return persistent;
    }

    public void setPersistent(ApiStatefulNodePersistentConfiguration persistent) {
        isSet.add("persistent");
        this.persistent = persistent;
    }

    public ApiStatefulNodeHealthConfiguration getHealth() {
        return health;
    }

    public void setHealth(ApiStatefulNodeHealthConfiguration health) {
        isSet.add("health");
        this.health = health;
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
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    @JsonIgnore
    public boolean isPersistentSet() {
        return isSet.contains("persistent");
    }

    @JsonIgnore
    public boolean isHealthSet() {
        return isSet.contains("health");
    }

}