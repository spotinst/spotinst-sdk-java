package com.spotinst.sdkjava.model;

/**
 * Created by itzik hazzan on 30/11/2020.
 */
public class ElastigroupGetRequestAzure {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor
    private ElastigroupGetRequestAzure() {
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
        private ElastigroupGetRequestAzure elastigroupGetRequest;

        private Builder() {
            this.elastigroupGetRequest = new ElastigroupGetRequestAzure();
        }

        public static ElastigroupGetRequestAzure.Builder get() {
            ElastigroupGetRequestAzure.Builder builder = new ElastigroupGetRequestAzure.Builder();
            return builder;
        }

        public ElastigroupGetRequestAzure.Builder setElastigroupId(final String elastigroupId) {
            elastigroupGetRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetRequestAzure build() {
            // TODO : Validations
            return elastigroupGetRequest;
        }

    }
    //endregion

}
