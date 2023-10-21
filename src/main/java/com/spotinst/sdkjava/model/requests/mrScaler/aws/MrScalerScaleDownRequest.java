package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerScaleDownAws;

public class MrScalerScaleDownRequest {
    //region Members
    private String                 mrScalerId;
    private Integer                adjustment;
    private MrScalerScaleDownAws mrScalerScaleDownAws;
    //endregion

    //region Private constructor
    private MrScalerScaleDownRequest() {
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

    public MrScalerScaleDownAws getMrScalerScaleDownAws(){
        return mrScalerScaleDownAws;
    }

    public void setMrScalerScaleDownAws(MrScalerScaleDownAws mrScalerScaleDownAws){
        this.mrScalerScaleDownAws = mrScalerScaleDownAws;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private MrScalerScaleDownRequest mrScalerScaleDownRequest;

        private Builder() {
            this.mrScalerScaleDownRequest = new MrScalerScaleDownRequest();
        }

        public static MrScalerScaleDownRequest.Builder get() {
            MrScalerScaleDownRequest.Builder builder = new MrScalerScaleDownRequest.Builder();
            return builder;
        }

        public MrScalerScaleDownRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerScaleDownRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public MrScalerScaleDownRequest.Builder setAdjustment(final Integer adjustment) {
            mrScalerScaleDownRequest.setAdjustment(adjustment);
            return this;
        }

        public MrScalerScaleDownRequest.Builder setMrScalerScaleDownAws(final MrScalerScaleDownAws mrScalerScaleDownAws){
            mrScalerScaleDownRequest.setMrScalerScaleDownAws(mrScalerScaleDownAws);
            return this;
        }

        public MrScalerScaleDownRequest build() {
            return mrScalerScaleDownRequest;
        }

    }
    //endregion
}