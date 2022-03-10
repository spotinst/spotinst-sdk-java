package com.spotinst.sdkjava.model;


public class ElastigroupDeletionRequestGcp {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private constructor
    private ElastigroupDeletionRequestGcp() {
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
        private ElastigroupDeletionRequestGcp elastigroupDeletionRequest;

        private Builder() {
            this.elastigroupDeletionRequest = new ElastigroupDeletionRequestGcp();
        }

        public static ElastigroupDeletionRequestGcp.Builder get() {
            return new Builder();
        }

        public ElastigroupDeletionRequestGcp.Builder setElastigroupId(final String elastigroupId) {
            elastigroupDeletionRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupDeletionRequestGcp build() {
            return elastigroupDeletionRequest;
        }

    }
    //endregion
}
