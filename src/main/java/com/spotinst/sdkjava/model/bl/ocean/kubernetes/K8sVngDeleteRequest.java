package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

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

    //endregion

    //Builder class
    public static class Builder {
        private K8sVngDeleteRequest vngDeleteRequest;

        private Builder() {
            this.vngDeleteRequest = new K8sVngDeleteRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
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