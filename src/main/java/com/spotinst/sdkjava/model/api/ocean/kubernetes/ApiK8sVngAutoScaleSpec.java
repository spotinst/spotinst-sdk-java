package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiK8sVngAutoScaleSpec {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ApiK8sVngHeadroomSpec>  headrooms;

    public ApiK8sVngAutoScaleSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiK8sVngHeadroomSpec> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ApiK8sVngHeadroomSpec> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }
}
