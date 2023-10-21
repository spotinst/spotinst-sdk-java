package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerScaleUpAws;

public class MrScalerScaleUpRequest {
    //region Members
    private String                mrScalerId;
    private Integer               adjustment;
    private MrScalerScaleUpAws mrScalerScaleUpAws;
    //endregion

    //region Private constructor
    private MrScalerScaleUpRequest() {
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

    public MrScalerScaleUpAws getMrScalerScaleUpAws(){
        return mrScalerScaleUpAws;
    }

    public void setMrScalerScaleUpAws(MrScalerScaleUpAws mrScalerScaleUpAws){
        this.mrScalerScaleUpAws = mrScalerScaleUpAws;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private MrScalerScaleUpRequest mrScalerScaleUpRequest;

        private Builder() {
            this.mrScalerScaleUpRequest = new MrScalerScaleUpRequest();
        }

        public static MrScalerScaleUpRequest.Builder get() {
            MrScalerScaleUpRequest.Builder builder = new MrScalerScaleUpRequest.Builder();
            return builder;
        }

        public MrScalerScaleUpRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerScaleUpRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public MrScalerScaleUpRequest.Builder setAdjustment(final Integer adjustment) {
            mrScalerScaleUpRequest.setAdjustment(adjustment);
            return this;
        }

        public MrScalerScaleUpRequest.Builder setMrScalerScaleUpAws(final MrScalerScaleUpAws mrScalerScaleUpAws){
            mrScalerScaleUpRequest.setMrScalerScaleUpAws(mrScalerScaleUpAws);
            return this;
        }

        public MrScalerScaleUpRequest build() {
            return mrScalerScaleUpRequest;
        }

    }
    //endregion
}