package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiLaunchSpecAutoScaleSpecification {

    private List<ApiLaunchSpecHeadRoomsSpecification> headrooms;

    private Set<String> isSet;

    public ApiLaunchSpecAutoScaleSpecification(){ isSet = new HashSet<>();
    }

    public List<ApiLaunchSpecHeadRoomsSpecification> getHeadrooms(){
        return headrooms;
    }

    public void setHeadrooms(List<ApiLaunchSpecHeadRoomsSpecification> headrooms){

        this.headrooms = headrooms;
    }

    @JsonIgnore
    public boolean isHeadroomsSet() {
        return isSet.contains("headrooms");
    }
}
