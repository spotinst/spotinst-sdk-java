package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterAks;
import java.util.HashMap;
import java.util.Map;

public class AksClusterCreationRequest {

    @JsonProperty("cluster")
    private OceanClusterAks cluster;

    private AksClusterCreationRequest() {
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
        private AksClusterCreationRequest clusterCreationRequest;

        private Builder() {
            this.clusterCreationRequest = new AksClusterCreationRequest();
        }

        public static AksClusterCreationRequest.Builder get() {
            return new Builder();
        }

        public AksClusterCreationRequest.Builder setCluster(final OceanClusterAks clusterAks) {
            clusterCreationRequest.setCluster(clusterAks);
            return this;
        }

        public AksClusterCreationRequest build() {
            return clusterCreationRequest;
        }

    }

    //Json methods
    public String toJson() {
        ApiClusterAks apiClusterToCreate = ClusterConverterAks.toDal(cluster);

        Map<String, ApiClusterAks> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", apiClusterToCreate);

        return JsonMapper.toJson(clusterRequest);
    }

}
