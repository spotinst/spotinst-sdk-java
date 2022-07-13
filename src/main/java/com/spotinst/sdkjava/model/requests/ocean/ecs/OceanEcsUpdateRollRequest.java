package com.spotinst.sdkjava.model.requests.ocean.ecs;

public class OceanEcsUpdateRollRequest {
    //region Members
    private String status;
    //endregion

    //region Private Constructor

    private OceanEcsUpdateRollRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //endregion

    //Builder class
    public static class Builder {
        private OceanEcsUpdateRollRequest updateRollRequest;

        private Builder() {
            this.updateRollRequest = new OceanEcsUpdateRollRequest();
        }

        public static OceanEcsUpdateRollRequest.Builder get() {
            return new Builder();
        }

        public OceanEcsUpdateRollRequest.Builder setStatus(final String status) {
            updateRollRequest.setStatus(status);
            return this;
        }

        public OceanEcsUpdateRollRequest build() {
            return updateRollRequest;
        }
    }
}

