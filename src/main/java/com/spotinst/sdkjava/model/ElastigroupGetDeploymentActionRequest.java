package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.aws.elastigroup.ApiElastigroupDeploymentStrategyOnFailure;
import com.spotinst.sdkjava.model.bl.aws.elastigroup.ElastigroupDeploymentStrategyOnFailure;


public class ElastigroupGetDeploymentActionRequest {

    @JsonIgnore
    private ElastigroupDeploymentStrategyOnFailure elastigroupDeploymentAction;

    private ElastigroupGetDeploymentActionRequest() {
    }

    public ElastigroupDeploymentStrategyOnFailure getElastigroupDeploymentAction() {
        return elastigroupDeploymentAction;
    }

    public void setElastigroupDeploymentAction(ElastigroupDeploymentStrategyOnFailure elastigroupDeploymentAction) {
        this.elastigroupDeploymentAction = elastigroupDeploymentAction;
    }

    public static class Builder {
        private ElastigroupGetDeploymentActionRequest elastigroupDeploymentRequest;

        private Builder() {
            this.elastigroupDeploymentRequest = new ElastigroupGetDeploymentActionRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setElastigroupDeploymentAction(final ElastigroupDeploymentStrategyOnFailure elastigroupDeploymentAction) {
            elastigroupDeploymentRequest.setElastigroupDeploymentAction(elastigroupDeploymentAction);
            return this;
        }

        public ElastigroupGetDeploymentActionRequest build() {
            return elastigroupDeploymentRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupDeploymentStrategyOnFailure elastigroupDeploymentActionRequest = ElastigroupConverter.toDal(elastigroupDeploymentAction);
        String  startDeployment              = JsonMapper.toJson(elastigroupDeploymentActionRequest);
        return startDeployment;
    }
}
