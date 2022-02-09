package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListScalersAws;

public class ApiMrScalerListMrScalersRequest {
    //region Members
    private String                    mrScalerId;
    private ApiMrScalerListScalersAws mrScalerListScalers;
    //endregion

    //region Private constructor
    private ApiMrScalerListMrScalersRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    public ApiMrScalerListScalersAws getMrScalerListScalers(){
        return mrScalerListScalers;
    }

    public void setMrScalerListScalers(ApiMrScalerListScalersAws mrScalerListScalers){
        this.mrScalerListScalers = mrScalerListScalers;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ApiMrScalerListMrScalersRequest mrScalerListScalersRequest;

        private Builder() {
            this.mrScalerListScalersRequest = new ApiMrScalerListMrScalersRequest();
        }

        public static ApiMrScalerListMrScalersRequest.Builder get() {
            ApiMrScalerListMrScalersRequest.Builder builder = new ApiMrScalerListMrScalersRequest.Builder();
            return builder;
        }

        public ApiMrScalerListMrScalersRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerListScalersRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public ApiMrScalerListMrScalersRequest.Builder setMrScalerListScalers(final ApiMrScalerListScalersAws mrScalerListScalers){
            mrScalerListScalersRequest.setMrScalerListScalers(mrScalerListScalers);
            return this;
        }

        public ApiMrScalerListMrScalersRequest build() {
            return mrScalerListScalersRequest;
        }

    }
    //endregion
}