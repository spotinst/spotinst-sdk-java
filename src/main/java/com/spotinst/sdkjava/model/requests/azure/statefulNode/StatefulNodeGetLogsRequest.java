package com.spotinst.sdkjava.model.requests.azure.statefulNode;

public class StatefulNodeGetLogsRequest {
    private String accountId;
    private String fromDate;
    private String toDate;

    private StatefulNodeGetLogsRequest() {
    }

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

    public String getToDate() {
        return this.toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public static class Builder {
        private StatefulNodeGetLogsRequest statefulNodeGetLogsRequest;

        private Builder() {
            this.statefulNodeGetLogsRequest = new StatefulNodeGetLogsRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAccountId(final String accountId) {
            statefulNodeGetLogsRequest.setAccountId(accountId);
            return this;
        }

        public Builder setFromDate(final String fromDate) {
            statefulNodeGetLogsRequest.setFromDate(fromDate);
            return this;
        }

        public Builder setToDate(final String toDate) {
            statefulNodeGetLogsRequest.setToDate(toDate);
            return this;
        }

        public StatefulNodeGetLogsRequest build() {
            return statefulNodeGetLogsRequest;
        }
    }
}
