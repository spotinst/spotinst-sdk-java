package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiImportASG;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ImportASG;

public class ImportASGRequest {

    private ImportASG importASG;

    private String    accountId;
    private String    autoScalingGroupName;
    private String    dryRun;
    private String    region;

    private ImportASGRequest() {
    }

    public ImportASG getImportASG() {
        return importASG;
    }

    public void setImportASG(ImportASG importASG) {
        this.importASG = importASG;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAutoScalingGroupName() {
        return autoScalingGroupName;
    }

    public void setAutoScalingGroupName(String autoScalingGroupName) { this.autoScalingGroupName = autoScalingGroupName; }

    public String getDryRun() {
        return dryRun;
    }

    public void setDryRun(String dryRun) {
        this.dryRun = dryRun;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public static class Builder {
        private ImportASGRequest importASGRequest;

        private Builder() {
            this.importASGRequest = new ImportASGRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setImportASG(ImportASG importASG) {
            importASGRequest.setImportASG(importASG);
            return this;
        }

        public Builder setAccountId(final String accountId) {
            importASGRequest.setAccountId(accountId);
            return this;
        }

        public Builder setAutoScalingGroupName(final String autoScalingGroupName) {
            importASGRequest.setAutoScalingGroupName(autoScalingGroupName);
            return this;
        }

        public Builder setDryRun(final String dryRun) {
            importASGRequest.setDryRun(dryRun);
            return this;
        }

        public Builder setRegion(final String region) {
            importASGRequest.setRegion(region);
            return this;
        }

        public ImportASGRequest build() {
            return importASGRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiImportASG apiImportASG = ElastigroupConverter.toDal(importASG);
        return JsonMapper.toJson(apiImportASG);
    }

    //endregion

}
