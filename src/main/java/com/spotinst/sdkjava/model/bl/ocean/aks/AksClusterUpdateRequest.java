package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterAks;

import java.util.HashMap;
import java.util.Map;

public class AksClusterUpdateRequest {

    @JsonProperty("cluster")
    private OceanClusterAks cluster;

    private AksClusterUpdateRequest() {
    }

    //Getters & Setters
    public OceanClusterAks getCluster() {
        return cluster;
    }

    public void setCluster(OceanClusterAks cluster) {
        this.cluster = cluster;
    }


    //Builder class
    public static class Builder {

        private AksClusterUpdateRequest clusterUpdateRequest;

        private Builder() {
            this.clusterUpdateRequest = new AksClusterUpdateRequest();
        }

        public static AksClusterUpdateRequest.Builder get() {
            return new Builder();
        }

        public AksClusterUpdateRequest.Builder setCluster(final OceanClusterAks clusterAks) {
            clusterUpdateRequest.setCluster(clusterAks);
            return this;
        }

        public AksClusterUpdateRequest build() {
            return clusterUpdateRequest;
        }

    }


    //Json methods
    public String toJson() {
        ApiClusterAks apiClusterToUpdate = ClusterConverterAks.toDal(cluster);

        Map<String, ApiClusterAks> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", apiClusterToUpdate);

        return JsonMapper.toJson(clusterRequest);
    }

}

