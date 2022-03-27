package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class GetClusterNodesRequest {
    //region Members
    private String    accountId;
    private String   instanceId;
    private String launchSpecId;
    //endregion

    //region Private Constructor

    private GetClusterNodesRequest() {
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
        private GetClusterNodesRequest getClusterNodesRequest;

        private Builder() {
            this.getClusterNodesRequest = new GetClusterNodesRequest();
        }

        public static GetClusterNodesRequest.Builder get() {
            return new Builder();
        }

        public GetClusterNodesRequest.Builder setAccountId(final String accountId) {
            getClusterNodesRequest.setAccountId(accountId);
            return this;
        }

        public GetClusterNodesRequest.Builder setInstanceId(final String instanceId) {
            getClusterNodesRequest.setInstanceId(instanceId);
            return this;
        }

        public GetClusterNodesRequest.Builder setLaunchSpecId(final String launchSpecId) {
            getClusterNodesRequest.setLaunchSpecId(launchSpecId);
            return this;
        }

        public GetClusterNodesRequest build() {
            return getClusterNodesRequest;
        }
    }
}

