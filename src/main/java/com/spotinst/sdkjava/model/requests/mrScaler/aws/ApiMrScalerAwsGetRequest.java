package com.spotinst.sdkjava.model.requests.mrScaler.aws;

public class ApiMrScalerAwsGetRequest {
    //region Members
    private String mrScalerId;
    //endregion

    //region Private constructor
    private ApiMrScalerAwsGetRequest() {
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
        private ApiMrScalerAwsGetRequest  mrScalerGetRequest;

        private Builder() {
            this.mrScalerGetRequest = new ApiMrScalerAwsGetRequest();
        }

        public static ApiMrScalerAwsGetRequest.Builder get() {
            ApiMrScalerAwsGetRequest.Builder builder = new ApiMrScalerAwsGetRequest.Builder();
            return builder;
        }

        public ApiMrScalerAwsGetRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerGetRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public ApiMrScalerAwsGetRequest build() {
            return mrScalerGetRequest;
        }

    }
    //endregion
}
