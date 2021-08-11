package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiVirtualNodeGroupAutoScaleSpec {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ApiClusterHeadroomSpecification>  headrooms;

    public ApiVirtualNodeGroupAutoScaleSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiClusterHeadroomSpecification> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ApiClusterHeadroomSpecification> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }
}
