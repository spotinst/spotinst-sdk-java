package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;

import java.util.HashMap;
import java.util.Map;

public class ElastigroupStopDeploymentRequest {

    //region Members
    @JsonProperty("roll")
    private ElastigroupDeploymentRoll stopDeployment;
    //endregion

    //region Private constructor
    private ElastigroupStopDeploymentRequest() {
    }
    //endregion

    //region Getters & Setters
    public ElastigroupDeploymentRoll getStopDeployment() {
        return stopDeployment;
    }

    public void setStopDeployment(ElastigroupDeploymentRoll stopDeployment) {
        this.stopDeployment = stopDeployment;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupStopDeploymentRequest elastigroupStopDeploymentRequest;

        private Builder() {
            this.elastigroupStopDeploymentRequest = new ElastigroupStopDeploymentRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setStopDeployment(final ElastigroupDeploymentRoll stopDeployment) {
            elastigroupStopDeploymentRequest.setStopDeployment(stopDeployment);
            return this;
        }

        public ElastigroupStopDeploymentRequest build() {
            return elastigroupStopDeploymentRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiElastigroupDeploymentRoll              apiElastigroupStopDeployment = ElastigroupConverter.toDal(stopDeployment);
        Map<String, ApiElastigroupDeploymentRoll> groupRequest                 = new HashMap<>();
        groupRequest.put("roll", apiElastigroupStopDeployment);
        String elastigroupJson = JsonMapper.toJson(groupRequest);
        return elastigroupJson;
    }
    //endregion

}
