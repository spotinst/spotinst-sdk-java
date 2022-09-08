package com.spotinst.sdkjava.model.requests.mrScaler.aws;

public class MrScalerAwsGetRequest {
    //region Members
    private String mrScalerId;
    //endregion

    //region Private constructor
    private MrScalerAwsGetRequest() {
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
    //endregion
}
