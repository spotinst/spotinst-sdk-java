package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiLaunchSpecStrategySpecification {

    private Integer         preemptiblePercentage;
    private Set<String> isSet;

    public ApiLaunchSpecStrategySpecification(){ isSet = new HashSet<>();
    }

    public Integer getPreemptiblePercentage() {
        return preemptiblePercentage;
    }

    public void setPreemptiblePercentage(Integer preemptiblePercentage) {
        isSet.add("preemptiblePercentage");
        this.preemptiblePercentage = preemptiblePercentage;
    }

    @JsonIgnore
    public boolean isPreemptiblePercentageSet() {
        return isSet.contains("preemptiblePercentage");
    }


}
