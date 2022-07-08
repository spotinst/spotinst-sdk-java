package com.spotinst.sdkjava.model.requests.ocean.aks;

public class AksUpdateRollRequest {
    //region Members
    private String status;
    //endregion

    //region Private Constructor

    private AksUpdateRollRequest() {
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
        private AksUpdateRollRequest updateRollRequest;

        private Builder() {
            this.updateRollRequest = new AksUpdateRollRequest();
        }

        public static AksUpdateRollRequest.Builder get() {
            return new Builder();
        }

        public AksUpdateRollRequest.Builder setStatus(final String status) {
            updateRollRequest.setStatus(status);
            return this;
        }

        public AksUpdateRollRequest build() {
            return updateRollRequest;
        }
    }
}

