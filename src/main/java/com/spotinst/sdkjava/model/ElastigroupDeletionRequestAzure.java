package com.spotinst.sdkjava.model;


public class ElastigroupDeletionRequestAzure {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private constructor
    private ElastigroupDeletionRequestAzure() {
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
        private ElastigroupDeletionRequestAzure elastigroupDeletionRequest;

        private Builder() {
            this.elastigroupDeletionRequest = new ElastigroupDeletionRequestAzure();
        }

        public static ElastigroupDeletionRequestAzure.Builder get() {
            return new Builder();
        }

        public ElastigroupDeletionRequestAzure.Builder setElastigroupId(final String elastigroupId) {
            elastigroupDeletionRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupDeletionRequestAzure build() {
            // TODO : Validations
            return elastigroupDeletionRequest;
        }

    }
    //endregion
}
