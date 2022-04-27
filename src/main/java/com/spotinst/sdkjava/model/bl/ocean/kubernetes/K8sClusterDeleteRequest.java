package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

public class K8sClusterDeleteRequest {

    private String clusterId;

    private K8sClusterDeleteRequest() {
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
        private K8sClusterDeleteRequest clusterDeletionRequest;

        private Builder() {
            this.clusterDeletionRequest = new K8sClusterDeleteRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setClusterId(final String oceanCluster) {
            clusterDeletionRequest.setClusterId(oceanCluster);
            return this;
        }

        public K8sClusterDeleteRequest build() {
            return clusterDeletionRequest;
        }

    }
    //endregion
}
