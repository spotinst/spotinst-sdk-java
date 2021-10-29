package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.spotinst.sdkjava.enums.ElastigroupSeverityEnumAzure;

public class GetElastilogRequestAzure {

    private String                          groupId;
//    private String                          accountId;
    private String                          fromDate;
    private Integer                         limit;
    private String                          resource_Id;
    private ElastigroupSeverityEnumAzure    severity;
    private String                          toDate;

    private GetElastilogRequestAzure() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

//    public String getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(String accountId) {
//        this.accountId = accountId;
//    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getResource_Id() {
        return resource_Id;
    }

    public void setResource_Id(String resource_Id) {
        this.resource_Id = resource_Id;
    }

    public ElastigroupSeverityEnumAzure getSeverity() {
        return severity;
    }

    public void setSeverity(ElastigroupSeverityEnumAzure severity) {
        this.severity = severity;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public static class Builder {
        private GetElastilogRequestAzure elastilogRequest;

        private Builder() {
            this.elastilogRequest = new GetElastilogRequestAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setGroupId(final String groupId) {
            elastilogRequest.setGroupId(groupId);
            return this;
        }

//        public Builder setAccountId(final String accountId) {
//            elastilogRequest.setAccountId(accountId);
//            return this;
//        }

        public Builder setFromDate(final String fromDate) {
            elastilogRequest.setFromDate(fromDate);
            return this;
        }

        public Builder setLimit(final Integer limit) {
            elastilogRequest.setLimit(limit);
            return this;
        }

        public Builder setResource_Id(final String resource_Id) {
            elastilogRequest.setResource_Id(resource_Id);
            return this;
        }

        public Builder setSeverity(final ElastigroupSeverityEnumAzure severity) {
            elastilogRequest.setSeverity(severity);
            return this;
        }

        public Builder setToDate(final String toDate) {
            elastilogRequest.setToDate(toDate);
            return this;
        }

        public GetElastilogRequestAzure build() {
            return elastilogRequest;
        }

    }
}
