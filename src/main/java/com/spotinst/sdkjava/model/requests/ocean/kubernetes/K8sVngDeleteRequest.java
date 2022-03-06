package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class K8sVngDeleteRequest {

    private String oceanLaunchSpecId;

    private K8sVngDeleteRequest() {
    }

    public String getOceanLaunchSpecId() {
        return oceanLaunchSpecId;
    }

    public void setOceanLaunchSpecId(String oceanLaunchSpecId) {
        this.oceanLaunchSpecId = oceanLaunchSpecId;
    }

    //Builder class
    public static class Builder {
        private K8sVngDeleteRequest vngDeleteRequest;

        private Builder() {
            this.vngDeleteRequest = new K8sVngDeleteRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOceanLaunchSpecId(final String oceanLaunchSpecId) {
            vngDeleteRequest.setOceanLaunchSpecId(oceanLaunchSpecId);
            return this;
        }

        public K8sVngDeleteRequest build() {
            return vngDeleteRequest;
        }

    }
}
