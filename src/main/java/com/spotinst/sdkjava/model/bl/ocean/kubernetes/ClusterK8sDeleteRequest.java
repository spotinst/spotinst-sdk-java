package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

public class ClusterK8sDeleteRequest {

    private String clusterId;

    private ClusterK8sDeleteRequest() {
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
        private ClusterK8sDeleteRequest clusterDeletionRequest;

        private Builder() {
            this.clusterDeletionRequest = new ClusterK8sDeleteRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setClusterId(final String oceanCluster) {
            clusterDeletionRequest.setClusterId(oceanCluster);
            return this;
        }

        public ClusterK8sDeleteRequest build() {
            return clusterDeletionRequest;
        }

    }
    //endregion
}
