package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 18/01/2017.
 */
public class ElastigroupGetActiveInstancesRequest {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor

    private ElastigroupGetActiveInstancesRequest() {
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
        private ElastigroupGetActiveInstancesRequest elastigroupGetActiveInstancesRequest;

        private Builder() {
            this.elastigroupGetActiveInstancesRequest = new ElastigroupGetActiveInstancesRequest();
        }

        public static ElastigroupGetActiveInstancesRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupGetActiveInstancesRequest.Builder setElastigroupId(final String elastigroupId) {
            elastigroupGetActiveInstancesRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetActiveInstancesRequest build() {
            // TODO : Validations
            return elastigroupGetActiveInstancesRequest;
        }

    }
    //endregion

}
