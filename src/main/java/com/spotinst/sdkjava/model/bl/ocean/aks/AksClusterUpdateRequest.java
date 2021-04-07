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

    //region Getters & Setters
    public ClusterAks getCluster() {
        return cluster;
    }

    public void setCluster(ClusterAks cluster) {
        this.cluster = cluster;
    }

    //endregion

    //region Builder class
    public static class Builder {

        private AksClusterUpdateRequest clusterCreationRequest;

        private Builder() {
            this.clusterCreationRequest = new AksClusterUpdateRequest();
        }

        public static AksClusterUpdateRequest.Builder get() {
            AksClusterUpdateRequest.Builder builder = new AksClusterUpdateRequest.Builder();
            return builder;
        }

        public AksClusterUpdateRequest.Builder setCluster(final ClusterAks clusterAks) {
            clusterCreationRequest.setCluster(clusterAks);
            return this;
        }

        public AksClusterUpdateRequest build() {
            return clusterCreationRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiClusterAks apiClusterToCreate = ClusterConverterAks.toDal(cluster);

        Map<String, ApiClusterAks> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", apiClusterToCreate);
        String clusterJson = JsonMapper.toJson(clusterRequest);

        return clusterJson;
    }
    //endregion
}

