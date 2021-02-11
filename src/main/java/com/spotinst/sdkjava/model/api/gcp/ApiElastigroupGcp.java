package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 id;
    private String                                 name;
    private String                                 description;
    private ApiCapacityGcp                         capacity;
    private ApiStrategyGcp                         strategy;
    private ApiGroupComputeGcp                     compute;
    private Date                                   createdAt;
    private Date                                   updatedAt;
    //endregion

    //region Constructor
    public ApiElastigroupGcp() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public ApiCapacityGcp getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiCapacityGcp capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ApiStrategyGcp getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiStrategyGcp strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiGroupComputeGcp getCompute() {
        return compute;
    }

    public void setCompute(ApiGroupComputeGcp compute) {
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

    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }
    //endregion
}
