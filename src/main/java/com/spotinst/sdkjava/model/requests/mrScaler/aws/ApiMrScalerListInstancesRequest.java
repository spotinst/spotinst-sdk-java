package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListInstancesAws;

public class ApiMrScalerListInstancesRequest {
    //region Members
    private String                      mrScalerId;
    private ApiMrScalerListInstancesAws mrScalerListInstancesAws;
    //endregion

    //region Private constructor
    private ApiMrScalerListInstancesRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    public ApiMrScalerListInstancesAws getMrScalerListInstancesAws(){
        return mrScalerListInstancesAws;
    }

    public void setMrScalerListInstancesAws(ApiMrScalerListInstancesAws mrScalerListInstancesAws){
        this.mrScalerListInstancesAws = mrScalerListInstancesAws;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ApiMrScalerListInstancesRequest mrScalerListInstancesRequest;

        private Builder() {
            this.mrScalerListInstancesRequest = new ApiMrScalerListInstancesRequest();
        }

        public static ApiMrScalerListInstancesRequest.Builder get() {
            ApiMrScalerListInstancesRequest.Builder builder = new ApiMrScalerListInstancesRequest.Builder();
            return builder;
        }

        public ApiMrScalerListInstancesRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerListInstancesRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public ApiMrScalerListInstancesRequest.Builder setMrScalerListInstancesAws(final ApiMrScalerListInstancesAws mrScalerListInstancesAws){
            mrScalerListInstancesRequest.setMrScalerListInstancesAws(mrScalerListInstancesAws);
            return this;
        }

        public ApiMrScalerListInstancesRequest build() {
            return mrScalerListInstancesRequest;
        }

    }
    //endregion
}
