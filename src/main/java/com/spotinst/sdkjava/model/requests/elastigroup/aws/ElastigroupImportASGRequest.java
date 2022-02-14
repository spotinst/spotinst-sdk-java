package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupImportASG;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupImportASG;

public class ElastigroupImportASGRequest {

    private ElastigroupImportASG elastigroupImportASG;

    private ElastigroupImportASGRequest() {
    }

    public ElastigroupImportASG getElastigroupImportASG() {
        return elastigroupImportASG;
    }

    public void setElastigroupImportASG(ElastigroupImportASG elastigroupImportASG) {
        this.elastigroupImportASG = elastigroupImportASG;
    }

    public static class Builder {
        private ElastigroupImportASGRequest elastigroupImportASGRequest;

        private Builder() {
            this.elastigroupImportASGRequest = new ElastigroupImportASGRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupImportASG(ElastigroupImportASG elastigroupImportASG) {
            elastigroupImportASGRequest.setElastigroupImportASG(elastigroupImportASG);
            return this;
        }

        public ElastigroupImportASGRequest build() {
            return elastigroupImportASGRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupImportASG elastigroupImportASGRequest = ElastigroupConverter.toDal(elastigroupImportASG);
        String                        importASG              = JsonMapper.toJson(elastigroupImportASGRequest);
        return importASG;
    }

    //endregion

}
