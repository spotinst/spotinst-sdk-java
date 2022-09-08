package com.spotinst.sdkjava.model.requests.mrScaler.aws;

public class MrScalerAwsDeleteRequest {
    //region Members
    private String mrScalerId;
    //endregion

    //region Private constructor
    private MrScalerAwsDeleteRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    //endregion

    //region Builder class
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
    //endregion
}
