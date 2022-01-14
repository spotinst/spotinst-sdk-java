package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiCapacity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Janetlin Kiruba
 * @since: 10/01/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupUpdateCapacity implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private String                     id;
    private ApiCapacity                capacity;
    //endregion

    //region Constructor

    public ApiElastigroupUpdateCapacity() {
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

    String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public ApiCapacity getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiCapacity capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    //endregion

    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    //endregion
}
