package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterAks;

import java.util.HashMap;
import java.util.Map;

public class AksClusterUpdateRequest {

    @JsonProperty("cluster")
    private ClusterAks cluster;

    private AksClusterUpdateRequest() {
    }

    //Getters & Setters
    public ClusterAks getCluster() {
        return cluster;
    }

    public void setCluster(ClusterAks cluster) {
        this.cluster = cluster;
    }


    //Builder class
    public static class Builder {

        private AksClusterUpdateRequest clusterUpdateRequest;

        private Builder() {
            this.clusterUpdateRequest = new AksClusterUpdateRequest();
        }

        public static AksClusterUpdateRequest.Builder get() {
            AksClusterUpdateRequest.Builder builder = new AksClusterUpdateRequest.Builder();
            return builder;
        }

        public AksClusterUpdateRequest.Builder setCluster(final ClusterAks clusterAks) {
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
        String clusterJson = JsonMapper.toJson(clusterRequest);

        return clusterJson;
    }

}

