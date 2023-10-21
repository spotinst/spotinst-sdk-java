package com.spotinst.sdkjava.model.requests.mrScaler.aws;

public class MrScalerAwsGetRequest {
    
    private String mrScalerId;
    
    private MrScalerAwsGetRequest() {
    }

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    public static class Builder {
        private MrScalerAwsGetRequest mrScalerGetRequest;

        private Builder() {
            this.mrScalerGetRequest = new MrScalerAwsGetRequest();
        }

        public static MrScalerAwsGetRequest.Builder get() {
            MrScalerAwsGetRequest.Builder builder = new MrScalerAwsGetRequest.Builder();
            return builder;
        }

        public MrScalerAwsGetRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerGetRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public MrScalerAwsGetRequest build() {
            return mrScalerGetRequest;
        }

    }
}
