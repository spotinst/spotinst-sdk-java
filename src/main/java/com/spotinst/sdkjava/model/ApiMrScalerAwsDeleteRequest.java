package com.spotinst.sdkjava.model;

public class ApiMrScalerAwsDeleteRequest {
    //region Members
    private String mrScalerId;
    //endregion

    //region Private constructor
    private ApiMrScalerAwsDeleteRequest() {
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
        private ApiMrScalerAwsDeleteRequest  mrScalerDeletionRequest;

        private Builder() {
            this.mrScalerDeletionRequest = new ApiMrScalerAwsDeleteRequest();
        }

        public static ApiMrScalerAwsDeleteRequest.Builder get() {
            ApiMrScalerAwsDeleteRequest.Builder builder = new ApiMrScalerAwsDeleteRequest.Builder();
            return builder;
        }

        public ApiMrScalerAwsDeleteRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerDeletionRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public ApiMrScalerAwsDeleteRequest build() {
            return mrScalerDeletionRequest;
        }

    }
    //endregion
}
