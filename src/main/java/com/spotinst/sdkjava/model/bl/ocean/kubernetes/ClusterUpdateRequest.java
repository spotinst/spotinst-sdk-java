package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClusterUpdateRequest {

    @JsonProperty("cluster")
    private OceanCluster cluster;

    private ClusterUpdateRequest() {
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
        private ClusterUpdateRequest clusterCreationRequest;

        private Builder() {
            this.clusterCreationRequest = new ClusterUpdateRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCluster(final OceanCluster oceanCluster) {
            clusterCreationRequest.setCluster(oceanCluster);
            return this;
        }

        public ClusterUpdateRequest build() {
            return clusterCreationRequest;
        }

    }
    //endregion
}
