package com.spotinst.sdkjava.model;

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
class ApiInstanceTypesWeights implements IPartialUpdateEntity {
    //region Members

    @JsonIgnore
    private Set<String>  isSet;
    private String       instanceType;
    private Integer      weightedCapacity;

    //endregion

    //region Constructor

    public ApiInstanceTypesWeights() {
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

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public Integer getWeightedCapacity() {
        return weightedCapacity;
    }

    public void setWeightedCapacity(Integer weightedCapacity) {
        isSet.add("weightedCapacity");
        this.weightedCapacity = weightedCapacity;
    }

    //endregion
    
    //region isSet methods
    // Is instanceType Set boolean method
    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

    // Is weightedCapacity Set boolean method
    @JsonIgnore
    public boolean isWeightedCapacitySet() {
        return isSet.contains("weightedCapacity");
    }

    //endregion
}
