package com.spotinst.sdkjava.model.api.ocean.ecs;


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

public class ApiClusterComputeConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                          isSet;
    private List<String>                         subnetIds;
    private ApiClusterOptimizeImageConfiguration optimizeImage;
    private ApiClusterLaunchSpecification        launchSpecification;

    public ApiClusterComputeConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    public ApiClusterLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiClusterLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ApiClusterOptimizeImageConfiguration getOptimizeImage() {
        return optimizeImage;
    }

    public void setOptimizeImage(ApiClusterOptimizeImageConfiguration optimizeImage) {
        isSet.add("optimizeImage");
        this.optimizeImage = optimizeImage;
    }


    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isOptimizeImageSet() {
        return isSet.contains("optimizeImage");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }
}