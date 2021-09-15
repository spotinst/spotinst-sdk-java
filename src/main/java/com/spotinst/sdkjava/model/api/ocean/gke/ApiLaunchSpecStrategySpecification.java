package com.spotinst.sdkjava.model.api.ocean.gke;

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
public class ApiLaunchSpecStrategySpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>     isSet;
    private Integer         preemptiblePercentage;

    public ApiLaunchSpecStrategySpecification(){ isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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