package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupImportEC2Instance;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupImportEC2Instance;

public class ElastigroupImportEC2InstanceRequest {

    private ElastigroupImportEC2Instance elastigroupImportEC2Instance;

    private ElastigroupImportEC2InstanceRequest() {
    }

    public ElastigroupImportEC2Instance getElastigroupImportEC2Instance() {
        return elastigroupImportEC2Instance;
    }

    public void setElastigroupImportEC2Instance(ElastigroupImportEC2Instance elastigroupImportEC2Instance) {
        this.elastigroupImportEC2Instance = elastigroupImportEC2Instance;
    }

    public static class Builder {
        private ElastigroupImportEC2InstanceRequest elastigroupImportEC2InstanceRequest;

        private Builder() {
            this.elastigroupImportEC2InstanceRequest = new ElastigroupImportEC2InstanceRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setElastigroupImportEC2Instance(ElastigroupImportEC2Instance elastigroupImportEC2Instance) {
            elastigroupImportEC2InstanceRequest.setElastigroupImportEC2Instance(elastigroupImportEC2Instance);
            return this;
        }

        public ElastigroupImportEC2InstanceRequest build() {
            return elastigroupImportEC2InstanceRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupImportEC2Instance elastigroupImportEC2InstanceRequest = ElastigroupConverter.toDal(elastigroupImportEC2Instance);
        return JsonMapper.toJson(elastigroupImportEC2InstanceRequest);
    }

    //endregion

}
