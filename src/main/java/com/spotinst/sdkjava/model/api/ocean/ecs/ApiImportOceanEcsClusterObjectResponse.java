package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ImportOceanEcsClusterResponse;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 20/07/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiImportOceanEcsClusterObjectResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                            isSet;
    private ApiImportOceanEcsClusterResponse          cluster;


    private ApiImportOceanEcsClusterObjectResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiImportOceanEcsClusterResponse getCluster() {
        return cluster;
    }

    public void setCluster(ApiImportOceanEcsClusterResponse cluster) {
        isSet.add("cluster");
        this.cluster = cluster;
    }

    @JsonIgnore
    public boolean isClusterSet() {
        return isSet.contains("cluster");
    }

}