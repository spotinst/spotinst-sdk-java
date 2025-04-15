package com.spotinst.sdkjava.model.requests.mrScaler.aws;

public class MrScalerAwsDeleteRequest {
    
    private String mrScalerId;
    
    private MrScalerAwsDeleteRequest() {
    }
    
    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    
    public static class Builder {
        private MrScalerAwsDeleteRequest  mrScalerDeletionRequest;

        private Builder() {
            this.mrScalerDeletionRequest = new MrScalerAwsDeleteRequest();
        }

        public static MrScalerAwsDeleteRequest.Builder get() {
            MrScalerAwsDeleteRequest.Builder builder = new MrScalerAwsDeleteRequest.Builder();
            return builder;
        }

        public MrScalerAwsDeleteRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerDeletionRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public MrScalerAwsDeleteRequest build() {
            return mrScalerDeletionRequest;
        }

    }
}
