package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiLaunchSpecResourceLimitSpecification {

    private int maxInstanceCount;

    private Set<String> isSet;

    public ApiLaunchSpecResourceLimitSpecification(){ isSet = new HashSet<>();
    }
    public int getMaxInstanceCount(){
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(int maxInstanceCount){
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
