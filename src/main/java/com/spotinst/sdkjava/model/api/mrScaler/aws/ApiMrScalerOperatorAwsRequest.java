package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.MrScalerOperatorAwsConverter;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;

import java.util.HashMap;
import java.util.Map;

public class ApiMrScalerOperatorAwsRequest {
    //region Members
    @JsonProperty("mrScalerOperator")
    private ApiMrScalerOperatorAws mrScalerOperator;
    //endregion

    //region Private constructor
    private ApiMrScalerOperatorAwsRequest() {
    }
    //endregion


    //region Getters & Setters

    public ApiMrScalerOperatorAws getMrScalerOperator() {
        return mrScalerOperator;
    }

    public void setMrScalerOperator(ApiMrScalerOperatorAws mrScalerOperator) {
        this.mrScalerOperator = mrScalerOperator;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ApiMrScalerOperatorAwsRequest mrScalerOperatorRequest;

        private Builder() {
            this.mrScalerOperatorRequest = new ApiMrScalerOperatorAwsRequest();
        }

        public static ApiMrScalerOperatorAwsRequest.Builder get() {
            ApiMrScalerOperatorAwsRequest.Builder builder = new ApiMrScalerOperatorAwsRequest.Builder();
            return builder;
        }

        public ApiMrScalerOperatorAwsRequest.Builder setMrScalerOperator(final ApiMrScalerOperatorAws mrScalerOperator) {
            mrScalerOperatorRequest.setMrScalerOperator(mrScalerOperator);
            return this;
        }

        public ApiMrScalerOperatorAwsRequest build() {
            return mrScalerOperatorRequest;
        }

    }
    //endregion

    //region Json methods

    //todo liron - remove
    public String toJson() {
        BlMrScalerOperatorAws blMrScalerOpertor = MrScalerOperatorAwsConverter.toBl(mrScalerOperator);

        Map<String, BlMrScalerOperatorAws> mrScalerOpertorRequest = new HashMap<>();
        mrScalerOpertorRequest.put("createMrScalerOperator", blMrScalerOpertor);
        String mrScalerJson = JsonMapper.toJson(mrScalerOpertorRequest);

        return mrScalerJson;
    }
    //endregion

}
