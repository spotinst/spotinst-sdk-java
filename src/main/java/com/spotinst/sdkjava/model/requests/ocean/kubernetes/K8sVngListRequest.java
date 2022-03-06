package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class K8sVngListRequest {

    private String accountId;
    private String oceanId;

    private K8sVngListRequest() {
    }

    //Getters & Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        this.oceanId = oceanId;
    }

    //Builder class
    public static class Builder {
        private K8sVngListRequest k8sVngListRequest;

        private Builder() {
            this.k8sVngListRequest = new K8sVngListRequest();
        }

        public static K8sVngListRequest.Builder get() {
            return new Builder();
        }

        public K8sVngListRequest.Builder setAccountId(final String accountId) {
            k8sVngListRequest.setAccountId(accountId);
            return this;
        }

        public K8sVngListRequest.Builder setOceanId(final String oceanId) {
            k8sVngListRequest.setOceanId(oceanId);
            return this;
        }

        public K8sVngListRequest build() {
            return k8sVngListRequest;
        }

    }
}