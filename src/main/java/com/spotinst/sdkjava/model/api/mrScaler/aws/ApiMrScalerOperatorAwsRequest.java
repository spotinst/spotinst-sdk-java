package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonProperty;

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
            return new Builder();
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
}
