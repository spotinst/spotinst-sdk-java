package com.spotinst.sdkjava.model.requests.ocean.aks;

public class GetAksClusterNodesRequest {
    //region Members
    private String           accountId;
    private String           virtualNodeGroupId;
    private String           vmName;
    //endregion

    //region Private Constructor

    private GetAksClusterNodesRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getVirtualNodeGroupId() {
        return this.virtualNodeGroupId;
    }

    public void setVirtualNodeGroupId(String virtualNodeGroupId) {
        this.virtualNodeGroupId = virtualNodeGroupId;
    }

    public String getVmName() {
        return this.vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }
    //endregion

    //Builder class
    public static class Builder {
        private GetAksClusterNodesRequest getClusterNodesRequest;

        private Builder() {
            this.getClusterNodesRequest = new GetAksClusterNodesRequest();
        }

        public static GetAksClusterNodesRequest.Builder get() {
            return new Builder();
        }

        public GetAksClusterNodesRequest.Builder setAccountId(final String accountId) {
            getClusterNodesRequest.setAccountId(accountId);
            return this;
        }

        public GetAksClusterNodesRequest.Builder setVirtualNodeGroupId(final String virtualNodeGroupId) {
            getClusterNodesRequest.setVirtualNodeGroupId(virtualNodeGroupId);
            return this;
        }

        public GetAksClusterNodesRequest.Builder setVmName(final String vmName) {
            getClusterNodesRequest.setVmName(vmName);
            return this;
        }

        public GetAksClusterNodesRequest build() {
            return getClusterNodesRequest;
        }
    }
}

