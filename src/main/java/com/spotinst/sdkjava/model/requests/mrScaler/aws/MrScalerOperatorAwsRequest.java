package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerOperatorAws;

public class MrScalerOperatorAwsRequest {
//    @JsonProperty("mrScalerOperator")
    private MrScalerOperatorAws mrScalerOperator;

    private MrScalerOperatorAwsRequest() {
    }

    public MrScalerOperatorAws getMrScalerOperator() {
        return mrScalerOperator;
    }

    public void setMrScalerOperator(MrScalerOperatorAws mrScalerOperator) {
        this.mrScalerOperator = mrScalerOperator;
    }

    public static class Builder {
        private MrScalerOperatorAwsRequest mrScalerOperatorRequest;

        private Builder() {
            this.mrScalerOperatorRequest = new MrScalerOperatorAwsRequest();
        }

        public static MrScalerOperatorAwsRequest.Builder get() {
            MrScalerOperatorAwsRequest.Builder builder = new MrScalerOperatorAwsRequest.Builder();
            return builder;
        }

        public MrScalerOperatorAwsRequest.Builder setMrScalerOperator(final MrScalerOperatorAws mrScalerOperator) {
            mrScalerOperatorRequest.setMrScalerOperator(mrScalerOperator);
            return this;
        }

        public MrScalerOperatorAwsRequest build() {
            return mrScalerOperatorRequest;
        }

    }
}
