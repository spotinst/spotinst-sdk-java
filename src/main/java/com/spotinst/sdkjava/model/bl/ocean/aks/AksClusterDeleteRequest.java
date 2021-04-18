package com.spotinst.sdkjava.model.bl.ocean.aks;

public class AksClusterDeleteRequest {

    private String clusterId;

    private AksClusterDeleteRequest() {
    }

    //Getters & Setters
    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String cluster) {
        this.clusterId = cluster;
    }



    //Builder class
    public static class Builder {

        private AksClusterDeleteRequest clusterDeletionRequest;

        private Builder() {
            this.clusterDeletionRequest = new AksClusterDeleteRequest();
        }

        public static AksClusterDeleteRequest.Builder get() {
            AksClusterDeleteRequest.Builder builder = new AksClusterDeleteRequest.Builder();
            return builder;
        }

        public AksClusterDeleteRequest.Builder setClusterId(final String oceanCluster) {
            clusterDeletionRequest.setClusterId(oceanCluster);
            return this;
        }

        public AksClusterDeleteRequest build() {
            return clusterDeletionRequest;
        }

    }

}
