package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 20/07/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiImportOceanEcsClusterResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 name;
    private String                                 region;
    private String                                 clusterName;
    private ApiImportClusterComputeConfiguration   compute;

    private ApiImportOceanEcsClusterResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setclusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
    }

    public ApiImportClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ApiImportClusterComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

}