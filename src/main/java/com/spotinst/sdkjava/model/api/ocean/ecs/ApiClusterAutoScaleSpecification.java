package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ClusterHeadroomsSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterAutoScaleSpecification implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                            isSet;
    private List<ApiClusterHeadroomsSpecification> headrooms;

    public ApiClusterAutoScaleSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiClusterHeadroomsSpecification> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ApiClusterHeadroomsSpecification> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }
}
