package com.spotinst.sdkjava.model.requests.ocean.ecs;

public class GetEcsClusterNodesRequest {
    //region Members
    private String    accountId;
    private String   instanceId;
    private String launchSpecId;
    //endregion

    //region Private Constructor

    private GetEcsClusterNodesRequest() {
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
        private GetEcsClusterNodesRequest getClusterNodesRequest;

        private Builder() {
            this.getClusterNodesRequest = new GetEcsClusterNodesRequest();
        }

        public static GetEcsClusterNodesRequest.Builder get() {
            return new Builder();
        }

        public GetEcsClusterNodesRequest.Builder setAccountId(final String accountId) {
            getClusterNodesRequest.setAccountId(accountId);
            return this;
        }

        public GetEcsClusterNodesRequest.Builder setInstanceId(final String instanceId) {
            getClusterNodesRequest.setInstanceId(instanceId);
            return this;
        }

        public GetEcsClusterNodesRequest.Builder setLaunchSpecId(final String launchSpecId) {
            getClusterNodesRequest.setLaunchSpecId(launchSpecId);
            return this;
        }

        public GetEcsClusterNodesRequest build() {
            return getClusterNodesRequest;
        }
    }
}

