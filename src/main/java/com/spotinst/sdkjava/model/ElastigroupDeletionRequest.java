package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 18/01/2017.
 */
public class ElastigroupDeletionRequest {
    //region Members
    private String elastigroupId;
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

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDeletionRequest elastigroupDeletionRequest;

        private Builder() {
            this.elastigroupDeletionRequest = new ElastigroupDeletionRequest();
        }

        public static ElastigroupDeletionRequest.Builder get() {
            ElastigroupDeletionRequest.Builder builder = new ElastigroupDeletionRequest.Builder();
            return builder;
        }

        public ElastigroupDeletionRequest.Builder setElastigroupId(final String elastigroupId) {
            elastigroupDeletionRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupDeletionRequest build() {
            // TODO : Validations
            return elastigroupDeletionRequest;
        }

    }
    //endregion

}
