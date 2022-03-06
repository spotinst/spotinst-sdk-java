package com.spotinst.sdkjava.model.requests.ocean.gke;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiOceanGkeCluster;
import com.spotinst.sdkjava.model.bl.ocean.gke.OceanGkeCluster;
import com.spotinst.sdkjava.model.converters.ocean.gke.OceanGkeConverter;

import java.util.HashMap;
import java.util.Map;

public class OceanGkeClusterRequest {

    @JsonProperty("cluster")
    private OceanGkeCluster cluster;
    private String          clusterId;

    private OceanGkeClusterRequest(){

    }

    //region Getters & Setters

    public void setCluster(OceanGkeCluster cluster) {
        this.cluster = cluster;
    }

    public OceanGkeCluster getCluster() {
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
        private OceanGkeClusterRequest clusterRequest;

        private Builder() {
            this.clusterRequest = new OceanGkeClusterRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCluster(final OceanGkeCluster oceanGkeCluster) {
            clusterRequest.setCluster(oceanGkeCluster);
            return this;
        }

        public Builder setClusterId(final String clusterId) {
            clusterRequest.setClusterId(clusterId);
            return this;
        }

        public OceanGkeClusterRequest build() {
            return clusterRequest;
        }

    }
    //endregion
    //region Json methods
    public String toJson() {
        ApiOceanGkeCluster              apiClusterToCreate = OceanGkeConverter.toDal(cluster);
        Map<String, ApiOceanGkeCluster> clusterRequest     = new HashMap<>();
        clusterRequest.put("cluster", apiClusterToCreate);

        return JsonMapper.toJson(clusterRequest);
    }
    //endregion
}