package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

public class K8sVirtualNodeGroupDeleteRequest {

    private String oceanLaunchSpecId;

    private K8sVirtualNodeGroupDeleteRequest() {
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
        private K8sVirtualNodeGroupDeleteRequest virtualNodeGroupDeletionRequest;

        private Builder() {
            this.virtualNodeGroupDeletionRequest = new K8sVirtualNodeGroupDeleteRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setOceanLaunchSpecId(final String oceanLaunchSpecId) {
            virtualNodeGroupDeletionRequest.setOceanLaunchSpecId(oceanLaunchSpecId);
            return this;
        }

        public K8sVirtualNodeGroupDeleteRequest build() {
            return virtualNodeGroupDeletionRequest;
        }

    }
}
