package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.OceanConverter;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiOceanCluster;


import java.util.HashMap;
import java.util.Map;

public class ClusterCreationRequest {

    @JsonProperty("cluster")
    private OceanCluster cluster;

    private ClusterCreationRequest() {
    }

    //region Getters & Setters
    public OceanCluster getCluster() {
        return cluster;
    }

    public void setCluster(OceanCluster cluster) {
        this.cluster = cluster;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ClusterCreationRequest clusterCreationRequest;

        private Builder() {
            this.clusterCreationRequest = new ClusterCreationRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCluster(final OceanCluster oceanCluster) {
            clusterCreationRequest.setCluster(oceanCluster);
            return this;
        }

        public ClusterCreationRequest build() {
            return clusterCreationRequest;
        }

    }
    //endregion
}
