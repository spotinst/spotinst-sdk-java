package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 18/01/2017.
 */
public class ElastigroupDeletionRequest {
    //region Members
    private String elastigroupId;
    private ApiDeleteGroupRequest deleteRequest;
    //endregion

    //region Private constructor
    private ElastigroupDeletionRequest() {
    }
    //endregion

    //region Getter and Setter methods
    public String getElastigroupId() {
        return elastigroupId;
    }

    public void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }

    public ApiDeleteGroupRequest getDeleteRequest() {
        return deleteRequest;
    }

    public void setDeleteRequest(ApiDeleteGroupRequest deleteRequest) {
        this.deleteRequest = deleteRequest;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDeletionRequest elastigroupDeletionRequest;

        private Builder() {
            this.elastigroupDeletionRequest = new ElastigroupDeletionRequest();
        }

        public static ElastigroupDeletionRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupDeletionRequest.Builder setElastigroupId(final String elastigroupId) {
            elastigroupDeletionRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupDeletionRequest.Builder setDeleteRequest(final ApiDeleteGroupRequest deleteRequest) {
            elastigroupDeletionRequest.setDeleteRequest(deleteRequest);
            return this;
        }

        public ElastigroupDeletionRequest build() {
            // TODO : Validations
            return elastigroupDeletionRequest;
        }

    }
    //endregion

}
