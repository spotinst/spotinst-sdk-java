package com.spotinst.sdkjava.model.bl.OceanKubernetes.aws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.OceanConverter;
import com.spotinst.sdkjava.model.api.OceanKuberenetes.aws.ApiOceanCluster;

import java.util.HashMap;
import java.util.Map;

public class ClusterDeleteRequest {

    private String clusterId;

    private ClusterDeleteRequest() {
    }

    //region Getters & Setters
    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String cluster) {
        this.clusterId = cluster;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ClusterDeleteRequest clusterDeletionRequest;

        private Builder() {
            this.clusterDeletionRequest = new ClusterDeleteRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setClusterId(final String oceanCluster) {
            clusterDeletionRequest.setClusterId(oceanCluster);
            return this;
        }

        public ClusterDeleteRequest build() {
            return clusterDeletionRequest;
        }

    }
    //endregion
}
