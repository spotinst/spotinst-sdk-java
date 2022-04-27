package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 18/01/2017.
 */
public class ElastigroupGetRequest {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor

    private ElastigroupGetRequest() {
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
        private ElastigroupGetRequest elastigroupGetRequest;

        private Builder() {
            this.elastigroupGetRequest = new ElastigroupGetRequest();
        }

        public static ElastigroupGetRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupGetRequest.Builder setElastigroupId(final String elastigroupId) {
            elastigroupGetRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetRequest build() {
            // TODO : Validations
            return elastigroupGetRequest;
        }

    }
    //endregion

}
