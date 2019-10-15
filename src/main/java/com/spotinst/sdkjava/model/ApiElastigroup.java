package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: sniramsalem
 * @since: 06/12/2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
class ApiElastigroup implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private String                     id;
    private String                     name;
    private String                     description;
    private ApiCapacity                capacity;
    private ApiStrategy                strategy;
    private ApiGroupCompute            compute;
    private Date                       createdAt;
    private Date                       updatedAt;
    private ApiThirdPartiesIntegration thirdPartiesIntegration;
    private ApiScheduling scheduling;
    //endregion

    //region Constructor

    public ApiElastigroup() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public ApiThirdPartiesIntegration getThirdPartiesIntegration() {
        return thirdPartiesIntegration;
    }

    public void setThirdPartiesIntegration(ApiThirdPartiesIntegration thirdPartiesIntegration) {
        isSet.add("thirdPartiesIntegration");
        this.thirdPartiesIntegration = thirdPartiesIntegration;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    String getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public ApiCapacity getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiCapacity capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ApiStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiStrategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiGroupCompute getCompute() {
        return compute;
    }

    public void setCompute(ApiGroupCompute compute) {
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

    public ApiScheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(ApiScheduling scheduling) {
        isSet.add("scheduling");
        this.scheduling = scheduling;
    }
    //endregion

    //region isSet methods

    // Is thirdPartiesIntegration Set boolean method
    @JsonIgnore
    public boolean isThirdPartiesIntegrationSet() {
        return isSet.contains("thirdPartiesIntegration");
    }

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


    // Is description Set boolean method
    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }


    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }


    // Is strategy Set boolean method
    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
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

    // Is updatedAt Set boolean method
    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }

    // Is scheduling Set boolean method
    @JsonIgnore
    public boolean isSchedulingSet() {
        return isSet.contains("scheduling");
    }

    //endregion
}
