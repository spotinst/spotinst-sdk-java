package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiLaunchSpecStorageSpecification {

    private Set<String> isSet;
    private Integer         localSsdCount;

    public ApiLaunchSpecStorageSpecification(){ isSet = new HashSet<>();
    }
    public Integer getLocalSsdCount() {
        return localSsdCount;
    }

    public void setLocalSsdCount(Integer localSsdCount) {
        isSet.add("localSsdCount");
        this.localSsdCount = localSsdCount;
    }

    @JsonIgnore
    public boolean isLocalSsdCountSet() {
        return isSet.contains("localSsdCount");
    }

}
