package com.spotinst.sdkjava.model.requests.elastigroup.aws;

public class ElastigroupTerminateStatefulInstanceImportRequest {
    //region Members
    private String type;
    //endregion

    //region Private Constructor

    private ElastigroupTerminateStatefulInstanceImportRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //endregion

    //Builder class
    public static class Builder {
        private ElastigroupTerminateStatefulInstanceImportRequest terminateImportRequest;

        private Builder() {
            this.terminateImportRequest = new ElastigroupTerminateStatefulInstanceImportRequest();
        }

        public static ElastigroupTerminateStatefulInstanceImportRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupTerminateStatefulInstanceImportRequest.Builder setType(final String type) {
            terminateImportRequest.setType(type);
            return this;
        }

        public ElastigroupTerminateStatefulInstanceImportRequest build() {
            return terminateImportRequest;
        }
    }
}

