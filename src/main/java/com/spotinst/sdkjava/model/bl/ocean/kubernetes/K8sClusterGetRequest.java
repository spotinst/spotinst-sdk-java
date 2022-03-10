package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

public class K8sClusterGetRequest {

    private String clusterId;

    private K8sClusterGetRequest() {
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
        private K8sClusterGetRequest k8sClusterGetRequest;

        private Builder() {
            this.k8sClusterGetRequest = new K8sClusterGetRequest();
        }

        public static K8sClusterGetRequest.Builder get() {
            return new Builder();
        }

        public K8sClusterGetRequest.Builder setClusterId(final String oceanCluster) {
            k8sClusterGetRequest.setClusterId(oceanCluster);
            return this;
        }

        public K8sClusterGetRequest build() {
            return k8sClusterGetRequest;
        }

    }
    //endregion
}
