package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupGetDeploymentStatusInstances implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                             isSet;
    private List<ApiElastigroupGetDeploymentStatusInstancesBlue>    blue;
    private List<ApiElastigroupGetDeploymentStatusInstancesGreen>   green;

    public ApiElastigroupGetDeploymentStatusInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupGetDeploymentStatusInstancesBlue> getBlue() {
        return blue;
    }

    public void setBlue(List<ApiElastigroupGetDeploymentStatusInstancesBlue> blue) {
        isSet.add("blue");
        this.blue = blue;
    }

    public List<ApiElastigroupGetDeploymentStatusInstancesGreen> getGreen() {
        return green;
    }

    public void setGreen(List<ApiElastigroupGetDeploymentStatusInstancesGreen> green) {
        isSet.add("green");
        this.green = green;
    }

    @JsonIgnore
    public boolean isBlueSet() {
        return isSet.contains("blue");
    }

    @JsonIgnore
    public boolean isGreenSet() {
        return isSet.contains("green");
    }

}