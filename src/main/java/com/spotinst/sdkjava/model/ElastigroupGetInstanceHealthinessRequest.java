package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;

/**
 * Created by yossi.elman on 13/04/2020.
 */
public class ElastigroupGetInstanceHealthinessRequest {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor

    private ElastigroupGetInstanceHealthinessRequest() {
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
        private ElastigroupGetInstanceHealthinessRequest elastigroupInstanceHealthinessRequest;

        private Builder() {
            this.elastigroupInstanceHealthinessRequest = new ElastigroupGetInstanceHealthinessRequest();
        }

        public static ElastigroupGetInstanceHealthinessRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupGetInstanceHealthinessRequest.Builder setElastigroupId(final String elastigroupId) {
            elastigroupInstanceHealthinessRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetInstanceHealthinessRequest build() {

            if (elastigroupInstanceHealthinessRequest.getElastigroupId() == null) {
                throw new SpotinstValidationException("Invalid Request - group id must be specified");
            }

            return elastigroupInstanceHealthinessRequest;
        }

    }
    //endregion
}