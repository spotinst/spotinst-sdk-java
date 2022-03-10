package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupUpdateCapacityConfiguration;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupUpdateCapacityConfiguration;

public class ElastigroupUpdateCapacityRequest {

    private ElastigroupUpdateCapacityConfiguration elastigroupCapacity;

    private ElastigroupUpdateCapacityRequest() {
    }

    public ElastigroupUpdateCapacityConfiguration getElastigroupUpdateCapacity() {
        return elastigroupCapacity;
    }

    public void setElastigroupUpdateCapacity(ElastigroupUpdateCapacityConfiguration elastigroupCapacity) {
        this.elastigroupCapacity = elastigroupCapacity;
    }

    public static class Builder {
        private ElastigroupUpdateCapacityRequest elastigroupUpdateCapacityRequest;

        private Builder() {
            this.elastigroupUpdateCapacityRequest = new ElastigroupUpdateCapacityRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setElastigroupUpdateCapacity(final ElastigroupUpdateCapacityConfiguration elastigroupCapacity) {
            elastigroupUpdateCapacityRequest.setElastigroupUpdateCapacity(elastigroupCapacity);
            return this;
        }

        public ElastigroupUpdateCapacityRequest build() {
            return elastigroupUpdateCapacityRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupUpdateCapacityConfiguration elastigroupUpdateCapacityRequest = ElastigroupConverter.toDal(elastigroupCapacity);
        return JsonMapper.toJson(elastigroupUpdateCapacityRequest);
    }

    //endregion

}
