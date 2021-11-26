package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupStartDeployment;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupStartDeployment;

public class ElastigroupStartDeploymentRequest {

    private ElastigroupStartDeployment elastigroupDeployment;
    private String                     GroupId;

    private ElastigroupStartDeploymentRequest() {
    }

    public ElastigroupStartDeployment getElastigroupDeployment() {
        return elastigroupDeployment;
    }

    public void setElastigroupDeployment(ElastigroupStartDeployment elastigroupDeployment) {
        this.elastigroupDeployment = elastigroupDeployment;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }


    public static class Builder {
        private ElastigroupStartDeploymentRequest elastigroupDeploymentRequest;

        private Builder() {
            this.elastigroupDeploymentRequest = new ElastigroupStartDeploymentRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupDeployment(final ElastigroupStartDeployment elastigroupDeployment) {
            elastigroupDeploymentRequest.setElastigroupDeployment(elastigroupDeployment);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            elastigroupDeploymentRequest.setGroupId(groupId);
            return this;
        }


        public ElastigroupStartDeploymentRequest build() {
            return elastigroupDeploymentRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupStartDeployment elastigroupDeploymentRequest = ElastigroupConverter.toDal(elastigroupDeployment);
        String                        startDeployment              = JsonMapper.toJson(elastigroupDeploymentRequest);
        return startDeployment;
    }

    //endregion

}
