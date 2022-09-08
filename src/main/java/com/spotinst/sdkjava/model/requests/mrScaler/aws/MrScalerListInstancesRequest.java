package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerListInstancesAws;

public class MrScalerListInstancesRequest {
    //region Members
    private String                      mrScalerId;
    private MrScalerListInstancesAws mrScalerListInstancesAws;
    //endregion

    //region Private constructor
    private MrScalerListInstancesRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }

    public MrScalerListInstancesAws getMrScalerListInstancesAws(){
        return mrScalerListInstancesAws;
    }

    public void setMrScalerListInstancesAws(MrScalerListInstancesAws mrScalerListInstancesAws){
        this.mrScalerListInstancesAws = mrScalerListInstancesAws;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private MrScalerListInstancesRequest mrScalerListInstancesRequest;

        private Builder() {
            this.mrScalerListInstancesRequest = new MrScalerListInstancesRequest();
        }

        public static MrScalerListInstancesRequest.Builder get() {
            MrScalerListInstancesRequest.Builder builder = new MrScalerListInstancesRequest.Builder();
            return builder;
        }

        public MrScalerListInstancesRequest.Builder setMrScalerId(final String mrScalerId) {
            mrScalerListInstancesRequest.setMrScalerId(mrScalerId);
            return this;
        }

        public MrScalerListInstancesRequest.Builder setMrScalerListInstancesAws(final MrScalerListInstancesAws mrScalerListInstancesAws){
            mrScalerListInstancesRequest.setMrScalerListInstancesAws(mrScalerListInstancesAws);
            return this;
        }

        public MrScalerListInstancesRequest build() {
            return mrScalerListInstancesRequest;
        }

    }
    //endregion
}
