package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

public class K8sVirtualNodeGroupGetRequest {

    private String oceanLaunchSpecId;

    private K8sVirtualNodeGroupGetRequest() {
    }

    //Getters & Setters
    public String getOceanLaunchSpecId() {
        return oceanLaunchSpecId;
    }

    public void setOceanLaunchSpecId(String oceanLaunchSpecId) {
        this.oceanLaunchSpecId = oceanLaunchSpecId;
    }

    //Builder class
    public static class Builder {
        private K8sVirtualNodeGroupGetRequest k8sVirtualNodeGroupGetRequest;

        private Builder() {
            this.k8sVirtualNodeGroupGetRequest = new K8sVirtualNodeGroupGetRequest();
        }

        public static K8sVirtualNodeGroupGetRequest.Builder get() {
            K8sVirtualNodeGroupGetRequest.Builder builder = new K8sVirtualNodeGroupGetRequest.Builder();
            return builder;
        }

        public K8sVirtualNodeGroupGetRequest.Builder setOceanLaunchSpecId(final String oceanVirtualNodeGroup) {
            k8sVirtualNodeGroupGetRequest.setOceanLaunchSpecId(oceanVirtualNodeGroup);
            return this;
        }

        public K8sVirtualNodeGroupGetRequest build() {
            return k8sVirtualNodeGroupGetRequest;
        }

    }
}
