package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerListScalersAws;

public class MrScalerListMrScalersRequest {
    //region Members
    private String                    mrScalerId;
    private MrScalerListScalersAws mrScalerListScalers;
    //endregion

    //region Private constructor
    private MrScalerListMrScalersRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    public MrScalerListScalersAws getMrScalerListScalers(){
        return mrScalerListScalers;
    }

    public void setMrScalerListScalers(MrScalerListScalersAws mrScalerListScalers){
        this.mrScalerListScalers = mrScalerListScalers;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private MrScalerListMrScalersRequest mrScalerListScalersRequest;

        private Builder() {
            this.mrScalerListScalersRequest = new MrScalerListMrScalersRequest();
        }

        public static MrScalerListMrScalersRequest.Builder get() {
            MrScalerListMrScalersRequest.Builder builder = new MrScalerListMrScalersRequest.Builder();
            return builder;
        }

        public MrScalerListMrScalersRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerListScalersRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public MrScalerListMrScalersRequest.Builder setMrScalerListScalers(final MrScalerListScalersAws mrScalerListScalers){
            mrScalerListScalersRequest.setMrScalerListScalers(mrScalerListScalers);
            return this;
        }

        public MrScalerListMrScalersRequest build() {
            return mrScalerListScalersRequest;
        }

    }
    //endregion
}