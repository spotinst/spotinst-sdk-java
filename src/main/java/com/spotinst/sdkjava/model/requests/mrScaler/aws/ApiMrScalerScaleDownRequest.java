package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleDownAws;

public class ApiMrScalerScaleDownRequest {
    //region Members
    private String                mrScalerId;
    private Integer               adjustment;
    private ApiMrScalerScaleDownAws mrScalerScaleDownAws;
    //endregion

    //region Private constructor
    private ApiMrScalerScaleDownRequest() {
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

    public ApiMrScalerScaleDownAws getMrScalerScaleDownAws(){
        return mrScalerScaleDownAws;
    }

    public void setMrScalerScaleDownAws(ApiMrScalerScaleDownAws mrScalerScaleDownAws){
        this.mrScalerScaleDownAws = mrScalerScaleDownAws;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ApiMrScalerScaleDownRequest mrScalerScaleDownRequest;

        private Builder() {
            this.mrScalerScaleDownRequest = new ApiMrScalerScaleDownRequest();
        }

        public static ApiMrScalerScaleDownRequest.Builder get() {
            ApiMrScalerScaleDownRequest.Builder builder = new ApiMrScalerScaleDownRequest.Builder();
            return builder;
        }

        public ApiMrScalerScaleDownRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerScaleDownRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public ApiMrScalerScaleDownRequest.Builder setAdjustment(final Integer adjustment) {
            mrScalerScaleDownRequest.setAdjustment(adjustment);
            return this;
        }

        public ApiMrScalerScaleDownRequest.Builder setMrScalerScaleDownAws(final ApiMrScalerScaleDownAws mrScalerScaleDownAws){
            mrScalerScaleDownRequest.setMrScalerScaleDownAws(mrScalerScaleDownAws);
            return this;
        }

        public ApiMrScalerScaleDownRequest build() {
            return mrScalerScaleDownRequest;
        }

    }
    //endregion
}