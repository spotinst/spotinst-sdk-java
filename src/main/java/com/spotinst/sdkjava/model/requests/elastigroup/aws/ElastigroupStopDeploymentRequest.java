package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupDeploymentRoll;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentRoll;

import java.util.HashMap;
import java.util.Map;

public class ElastigroupStopDeploymentRequest {

    //region Members
    private ElastigroupDeploymentRoll roll;
    //endregion

    //region Private constructor
    private ElastigroupStopDeploymentRequest() {
    }
    //endregion

    //region Getters & Setters
    public ElastigroupDeploymentRoll getRoll() {
        return roll;
    }

    public void setRoll(ElastigroupDeploymentRoll roll) {
        this.roll = roll;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupStopDeploymentRequest elastigroupStopDeploymentRequest;

        private Builder() {
            this.elastigroupStopDeploymentRequest = new ElastigroupStopDeploymentRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setRoll(final ElastigroupDeploymentRoll roll) {
            elastigroupStopDeploymentRequest.setRoll(roll);
            return this;
        }

        public ElastigroupStopDeploymentRequest build() {
            return elastigroupStopDeploymentRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiElastigroupDeploymentRoll              apiElastigroupStopDeployment = ElastigroupConverter.toDal(roll);
        Map<String, ApiElastigroupDeploymentRoll> groupRequest                 = new HashMap<>();
        groupRequest.put("roll", apiElastigroupStopDeployment);
        return JsonMapper.toJson(groupRequest);
    }

    //endregion

}
