package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class K8sVngDeleteRequest {

    private String  oceanLaunchSpecId;
    private Boolean deleteNodes;
    private Boolean forceDelete;

    private K8sVngDeleteRequest() {
    }

    public String getOceanLaunchSpecId() {
        return oceanLaunchSpecId;
    }

    public void setOceanLaunchSpecId(String oceanLaunchSpecId) {
        this.oceanLaunchSpecId = oceanLaunchSpecId;
    }

    public Boolean getDeleteNodes() {
        return deleteNodes;
    }

    public void setDeleteNodes(Boolean deleteNodes) {
        this.deleteNodes = deleteNodes;
    }

    public Boolean getForceDelete() {
        return forceDelete;
    }

    public void setForceDelete(Boolean forceDelete) {
        this.forceDelete = forceDelete;
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

        public Builder setDeleteNodes(final Boolean deleteNodes) {
            vngDeleteRequest.setDeleteNodes(deleteNodes);
            return this;
        }

        public Builder setForceDelete(final Boolean forceDelete) {
            vngDeleteRequest.setForceDelete(forceDelete);
            return this;
        }

        public K8sVngDeleteRequest build() {
            return vngDeleteRequest;
        }

    }
}
