package com.spotinst.sdkjava.model.bl.OceanKubernetes.aws;

public class ClusterGetRequest {

    private String clusterId;

    private ClusterGetRequest() {
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
        private ClusterGetRequest clusterGetRequest;

        private Builder() {
            this.clusterGetRequest = new ClusterGetRequest();
        }

        public static ClusterGetRequest.Builder get() {
            ClusterGetRequest.Builder builder = new ClusterGetRequest.Builder();
            return builder;
        }

        public ClusterGetRequest.Builder setClusterId(final String oceanCluster) {
            clusterGetRequest.setClusterId(oceanCluster);
            return this;
        }

        public ClusterGetRequest build() {
            return clusterGetRequest;
        }

    }
    //endregion
}
