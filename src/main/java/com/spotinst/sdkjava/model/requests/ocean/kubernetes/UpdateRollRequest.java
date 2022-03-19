package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

public class UpdateRollRequest {
    //region Members
    private String status;
    //endregion

    //region Private Constructor

    private UpdateRollRequest() {
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
        private UpdateRollRequest updateRolllogRequest;

        private Builder() {
            this.updateRolllogRequest = new UpdateRollRequest();
        }

        public static UpdateRollRequest.Builder get() {
            return new Builder();
        }

        public UpdateRollRequest.Builder setStatus(final String status) {
            updateRolllogRequest.setStatus(status);
            return this;
        }

        public UpdateRollRequest build() {
            return updateRolllogRequest;
        }
    }
}

