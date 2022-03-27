package com.spotinst.sdkjava.model.requests.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.ecs.ApiOceanEcsCluster;
import com.spotinst.sdkjava.model.bl.ocean.ecs.OceanEcsCluster;
import com.spotinst.sdkjava.model.converters.ocean.ecs.OceanEcsConverter;

import java.util.HashMap;
import java.util.Map;

public class OceanEcsClusterRequest {

    @JsonProperty("cluster")
    private OceanEcsCluster cluster;
    private String          clusterId;

    private OceanEcsClusterRequest(){

    }

    //region Getters & Setters

    public void setCluster(OceanEcsCluster cluster) {
        this.cluster = cluster;
    }

    public OceanEcsCluster getCluster() {
        return cluster;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private OceanEcsClusterRequest clusterRequest;

        private Builder() {
            this.clusterRequest = new OceanEcsClusterRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCluster(final OceanEcsCluster oceanEcsCluster) {
            clusterRequest.setCluster(oceanEcsCluster);
            return this;
        }

        public Builder setClusterId(final String clusterId) {
            clusterRequest.setClusterId(clusterId);
            return this;
        }


        public OceanEcsClusterRequest build() {
            return clusterRequest;
        }

    }
    //endregion
    //region Json methods
    public String toJson() {
        ApiOceanEcsCluster apiClusterToCreate = OceanEcsConverter.toDal(cluster);
        Map<String, ApiOceanEcsCluster> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", apiClusterToCreate);

        return JsonMapper.toJson(clusterRequest);
    }
    //endregion
}