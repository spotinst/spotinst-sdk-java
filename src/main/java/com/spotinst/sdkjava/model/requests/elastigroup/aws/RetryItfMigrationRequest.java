package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.model.bl.elastigroup.aws.ItfMigrationRulesStatus;

public class RetryItfMigrationRequest {
    private ItfMigrationRulesStatus migration;
    private String                  groupId;
    private String                  id;

    private RetryItfMigrationRequest() {
    }

    public ItfMigrationRulesStatus getMigration() {
        return migration;
    }

    public void setMigration(ItfMigrationRulesStatus migration) {
        this.migration = migration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static class Builder {
        private RetryItfMigrationRequest retryItfMigrationRequest;

        private Builder() {
            this.retryItfMigrationRequest = new RetryItfMigrationRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setMigration(final ItfMigrationRulesStatus migration) {
            retryItfMigrationRequest.setMigration(migration);
            return this;
        }

        public Builder setId(final String id){
            retryItfMigrationRequest.setId(id);
            return this;
        }

        public Builder setGroupId(final String groupId){
            retryItfMigrationRequest.setGroupId(groupId);
            return this;
        }

        public RetryItfMigrationRequest build() {
            return retryItfMigrationRequest;
        }
    }
}