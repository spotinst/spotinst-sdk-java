package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupUpdateCapacity;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupUpdateCapacity;

public class ElastigroupUpdateCapacityRequest {

    private ElastigroupUpdateCapacity elastigroupCapacity;
    private String                     GroupId;

    private ElastigroupUpdateCapacityRequest() {
    }

    public ElastigroupUpdateCapacity getElastigroupUpdateCapacity() {
        return elastigroupCapacity;
    }

    public void setElastigroupUpdateCapacity(ElastigroupUpdateCapacity elastigroupCapacity) {
        this.elastigroupCapacity = elastigroupCapacity;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }


    public static class Builder {
        private ElastigroupUpdateCapacityRequest elastigroupUpdateCapacityRequest;

        private Builder() {
            this.elastigroupUpdateCapacityRequest = new ElastigroupUpdateCapacityRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupUpdateCapacity(final ElastigroupUpdateCapacity elastigroupCapacity) {
            elastigroupUpdateCapacityRequest.setElastigroupUpdateCapacity(elastigroupCapacity);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            elastigroupUpdateCapacityRequest.setGroupId(groupId);
            return this;
        }


        public ElastigroupUpdateCapacityRequest build() {
            return elastigroupUpdateCapacityRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupUpdateCapacity elastigroupUpdateCapacityRequest = ElastigroupConverter.toDal(elastigroupCapacity);
        String                        updateCapacity              = JsonMapper.toJson(elastigroupUpdateCapacityRequest);
        return updateCapacity;
    }

    //endregion

}
