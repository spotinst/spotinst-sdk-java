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
public class ApiElastigroupUpdateCapacityResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                      isSet;
    private ApiCapacity capacity;

    public ApiElastigroupUpdateCapacityResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiCapacity getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiCapacity capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

}
