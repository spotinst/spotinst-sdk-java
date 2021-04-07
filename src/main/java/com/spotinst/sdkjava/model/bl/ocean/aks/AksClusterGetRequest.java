package com.spotinst.sdkjava.model.bl.ocean.aks;

public class AksClusterGetRequest {

    private String clusterId;

    private AksClusterGetRequest() {
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
        private AksClusterGetRequest aksClusterGetRequest;

        private Builder() {
            this.aksClusterGetRequest = new AksClusterGetRequest();
        }

        public static AksClusterGetRequest.Builder get() {
            AksClusterGetRequest.Builder builder = new AksClusterGetRequest.Builder();
            return builder;
        }

        public AksClusterGetRequest.Builder setClusterId(final String oceanCluster) {
            aksClusterGetRequest.setClusterId(oceanCluster);
            return this;
        }

        public AksClusterGetRequest build() {
            return aksClusterGetRequest;
        }

    }
    //endregion
}
