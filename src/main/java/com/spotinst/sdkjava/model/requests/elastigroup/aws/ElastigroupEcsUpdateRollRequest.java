package com.spotinst.sdkjava.model.requests.elastigroup.aws;

public class ElastigroupEcsUpdateRollRequest {
    //region Members
    private String status;
    //endregion

    //region Private Constructor

    private ElastigroupEcsUpdateRollRequest() {
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
        private ElastigroupEcsUpdateRollRequest updateRollRequest;

        private Builder() {
            this.updateRollRequest = new ElastigroupEcsUpdateRollRequest();
        }

        public static ElastigroupEcsUpdateRollRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupEcsUpdateRollRequest.Builder setStatus(final String status) {
            updateRollRequest.setStatus(status);
            return this;
        }

        public ElastigroupEcsUpdateRollRequest build() {
            return updateRollRequest;
        }
    }
}

