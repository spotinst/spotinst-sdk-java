package com.spotinst.sdkjava.model.bl.admin.account;

public class ListAllAccountsRequest {
    private String cloudAccountId;

    private ListAllAccountsRequest() {
    }

    //Getters & Setters
    public String getCloudAccountId() {
        return cloudAccountId;
    }

    public void setCloudAccountId(String cloudAccountId) {
        this.cloudAccountId = cloudAccountId;
    }

    //Builder class
    public static class Builder {

        private ListAllAccountsRequest listAllAccountsRequest;

        private Builder() {
            this.listAllAccountsRequest = new ListAllAccountsRequest();
        }

        public static ListAllAccountsRequest.Builder get() {
            ListAllAccountsRequest.Builder builder = new ListAllAccountsRequest.Builder();
            return builder;
        }

        public ListAllAccountsRequest.Builder setCloudAccountId(final String cloudAccountId) {
            listAllAccountsRequest.setCloudAccountId(cloudAccountId);
            return this;
        }

        public ListAllAccountsRequest build() {
            return listAllAccountsRequest;
        }
    }
}