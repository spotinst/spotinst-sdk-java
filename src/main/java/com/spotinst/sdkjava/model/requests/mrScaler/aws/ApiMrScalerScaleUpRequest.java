package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleUpAws;

public class ApiMrScalerScaleUpRequest {
    //region Members
    private String                mrScalerId;
    private Integer               adjustment;
    private ApiMrScalerScaleUpAws mrScalerScaleUpAws;
    //endregion

    //region Private constructor
    private ApiMrScalerScaleUpRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    public Integer getAdjustment(){
        return adjustment;
    }

    public void setAdjustment(Integer adjustment){
        this.adjustment = adjustment;
    }

    public ApiMrScalerScaleUpAws getMrScalerScaleUpAws(){
        return mrScalerScaleUpAws;
    }

    public void setMrScalerScaleUpAws(ApiMrScalerScaleUpAws mrScalerScaleUpAws){
        this.mrScalerScaleUpAws = mrScalerScaleUpAws;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ApiMrScalerScaleUpRequest mrScalerScaleUpRequest;

        private Builder() {
            this.mrScalerScaleUpRequest = new ApiMrScalerScaleUpRequest();
        }

        public static ApiMrScalerScaleUpRequest.Builder get() {
            ApiMrScalerScaleUpRequest.Builder builder = new ApiMrScalerScaleUpRequest.Builder();
            return builder;
        }

        public ApiMrScalerScaleUpRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerScaleUpRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public ApiMrScalerScaleUpRequest.Builder setAdjustment(final Integer adjustment) {
            mrScalerScaleUpRequest.setAdjustment(adjustment);
            return this;
        }

        public ApiMrScalerScaleUpRequest.Builder setMrScalerScaleUpAws(final ApiMrScalerScaleUpAws mrScalerScaleUpAws){
            mrScalerScaleUpRequest.setMrScalerScaleUpAws(mrScalerScaleUpAws);
            return this;
        }

        public ApiMrScalerScaleUpRequest build() {
            return mrScalerScaleUpRequest;
        }

    }
    //endregion
}