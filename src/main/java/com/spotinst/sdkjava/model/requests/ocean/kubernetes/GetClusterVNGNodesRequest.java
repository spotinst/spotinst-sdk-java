package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class GetClusterVNGNodesRequest {
    //region Members
    private String    accountId;
    private String   instanceId;
    private String launchSpecId;
    //endregion

    //region Private Constructor

    private GetClusterVNGNodesRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getLaunchSpecId() {
        return this.launchSpecId;
    }

    public void setLaunchSpecId(String launchSpecId) {
        this.launchSpecId = launchSpecId;
    }
    //endregion

    //Builder class
    public static class Builder {
        private GetClusterVNGNodesRequest getClusterVNGNodesRequest;

        private Builder() {
            this.getClusterVNGNodesRequest = new GetClusterVNGNodesRequest();
        }

        public static GetClusterVNGNodesRequest.Builder get() {
            return new Builder();
        }

        public GetClusterVNGNodesRequest.Builder setAccountId(final String accountId) {
            getClusterVNGNodesRequest.setAccountId(accountId);
            return this;
        }

        public GetClusterVNGNodesRequest.Builder setInstanceId(final String instanceId) {
            getClusterVNGNodesRequest.setInstanceId(instanceId);
            return this;
        }

        public GetClusterVNGNodesRequest.Builder setLaunchSpecId(final String launchSpecId) {
            getClusterVNGNodesRequest.setLaunchSpecId(launchSpecId);
            return this;
        }

        public GetClusterVNGNodesRequest build() {
            return getClusterVNGNodesRequest;
        }
    }
}

