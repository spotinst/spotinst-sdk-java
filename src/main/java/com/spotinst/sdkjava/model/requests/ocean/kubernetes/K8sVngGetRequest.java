package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class K8sVngGetRequest {

    private String oceanLaunchSpecId;

    private K8sVngGetRequest() {
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
        private K8sVngGetRequest k8sVngGetRequest;

        private Builder() {
            this.k8sVngGetRequest = new K8sVngGetRequest();
        }

        public static K8sVngGetRequest.Builder get() {
            K8sVngGetRequest.Builder builder = new K8sVngGetRequest.Builder();
            return builder;
        }

        public K8sVngGetRequest.Builder setOceanLaunchSpecId(final String k8sVng) {
            k8sVngGetRequest.setOceanLaunchSpecId(k8sVng);
            return this;
        }

        public K8sVngGetRequest build() {
            return k8sVngGetRequest;
        }

    }
}
