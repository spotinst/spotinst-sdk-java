package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

public class ClusterVirtualNodeGroupTemplateAks {
    @JsonIgnore
    private Set<String>                      isSet;
    private ClusterLaunchSpecificationAks        launchSpecification;

    public ClusterVirtualNodeGroupTemplateAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ClusterLaunchSpecificationAks getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ClusterLaunchSpecificationAks launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }
}
