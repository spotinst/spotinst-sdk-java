package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiItfMigrationRulesStatus;

public class ApiRetryItfMigrationRequest {
    private ApiItfMigrationRulesStatus migration;
    private String                     id;

    public ApiRetryItfMigrationRequest() {
    }

    public ApiItfMigrationRulesStatus getMigration() {
        return migration;
    }

    public void setMigration(ApiItfMigrationRulesStatus migration) {
        this.migration = migration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}