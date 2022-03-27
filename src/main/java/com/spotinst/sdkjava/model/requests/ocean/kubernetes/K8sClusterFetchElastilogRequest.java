package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class K8sClusterFetchElastilogRequest {
    //region Members
    private String accountId;
    private String fromDate;
    private String limit;
    private String resourceId;
    private String severity;
    private String toDate;
    //endregion

    //region Private Constructor

    private K8sClusterFetchElastilogRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLimit() {
        return this.limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSeverity() {
        return this.severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getToDate() {
        return this.toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    //endregion

    //Builder class
    public static class Builder {
        private K8sClusterFetchElastilogRequest elastigroupGetElastilogRequest;

        private Builder() {
            this.elastigroupGetElastilogRequest = new K8sClusterFetchElastilogRequest();
        }

        public static K8sClusterFetchElastilogRequest.Builder get() {
            return new Builder();
        }

        public K8sClusterFetchElastilogRequest.Builder setAccountId(final String accountId) {
            elastigroupGetElastilogRequest.setAccountId(accountId);
            return this;
        }

        public K8sClusterFetchElastilogRequest.Builder setFromDate(final String fromDate) {
            elastigroupGetElastilogRequest.setFromDate(fromDate);
            return this;
        }

        public K8sClusterFetchElastilogRequest.Builder setLimit(final String limit) {
            elastigroupGetElastilogRequest.setLimit(limit);
            return this;
        }

        public K8sClusterFetchElastilogRequest.Builder setResourceId(final String resourceId) {
            elastigroupGetElastilogRequest.setResourceId(resourceId);
            return this;
        }

        public K8sClusterFetchElastilogRequest.Builder setSeverity(final String severity) {
            elastigroupGetElastilogRequest.setSeverity(severity);
            return this;
        }

        public K8sClusterFetchElastilogRequest.Builder setToDate(final String toDate) {
            elastigroupGetElastilogRequest.setToDate(toDate);
            return this;
        }

        public K8sClusterFetchElastilogRequest build() {
            return elastigroupGetElastilogRequest;
        }
    }
}

