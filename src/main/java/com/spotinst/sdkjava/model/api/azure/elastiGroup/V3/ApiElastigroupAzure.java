package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiElastigroupAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 id;
    private String                                 name;
    private String                                 region;
    private String                                 resourceGroupName;
    private ApiCapacityAzure                       capacity;
    private ApiStrategyAzure                       strategy;
    private ApiElastigroupHealthConfigurationAzure health;
    private ApiGroupComputeAzure                   compute;
    private ApiScalingAzure                        scaling;
    private ApiElastigroupSchedulingAzure          scheduling;
    private Date                                   createdAt;
    private Date                                   updatedAt;
    //endregion

    //region Constructor
    public ApiElastigroupAzure() {
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
    public String getId() {
        return this.id;
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public ApiCapacityAzure getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiCapacityAzure capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ApiScalingAzure getScaling() {
        return scaling;
    }

    public void setScaling(ApiScalingAzure scaling) {
        isSet.add("scaling");
        this.scaling = scaling;
    }

    public ApiStrategyAzure getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiStrategyAzure strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiGroupComputeAzure getCompute() {
        return compute;
    }

    public void setCompute(ApiGroupComputeAzure compute) {
        isSet.add("compute");
        this.compute = compute;
    }
    public ApiElastigroupHealthConfigurationAzure getHealth() {
        return health;
    }

    public void setHealth(ApiElastigroupHealthConfigurationAzure health) {
        isSet.add("health");
        this.health = health;
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

    public ApiElastigroupSchedulingAzure getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiElastigroupSchedulingAzure scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }
    //endregion

    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is resourceGroupName Set boolean method
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    @JsonIgnore
    public boolean isScalingSet() {
        return isSet.contains("scaling");
    }

    // Is strategy Set boolean method
    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    // Is health Set boolean method
    @JsonIgnore
    public boolean isHealthSet() {
        return isSet.contains("health");
    }

    // Is compute Set boolean method
    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

    // Is compute Set boolean method
    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    // Is scheduling Set boolean method
    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }
    //endregion
}
