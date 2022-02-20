package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiImportASG;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ImportASG;

public class ImportASGRequest {

    private ImportASG importASG;

    private ImportASGRequest() {
    }

    public ImportASG getImportASG() {
        return importASG;
    }

    public void setImportASG(ImportASG importASG) {
        this.importASG = importASG;
    }

    public static class Builder {
        private ImportASGRequest importASGRequest;

        private Builder() {
            this.importASGRequest = new ImportASGRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupImportASG(ImportASG importASG) {
            importASGRequest.setImportASG(importASG);
            return this;
        }

        public ImportASGRequest build() {
            return importASGRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiImportASG elastigroupImportASGRequest = ElastigroupConverter.toDal(importASG);
        String                        importASG              = JsonMapper.toJson(elastigroupImportASGRequest);
        return importASG;
    }

    //endregion

}
