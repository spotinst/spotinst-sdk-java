package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;

/**
 * Created by yossi.elman on 13/04/2020.
 */
public class ElastigroupGetInstanceHealthinessRequestGcp {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor

    private ElastigroupGetInstanceHealthinessRequestGcp() {
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
        private ElastigroupGetInstanceHealthinessRequestGcp elastigroupInstanceHealthinessRequest;

        private Builder() {
            this.elastigroupInstanceHealthinessRequest = new ElastigroupGetInstanceHealthinessRequestGcp();
        }

        public static ElastigroupGetInstanceHealthinessRequestGcp.Builder get() {
            ElastigroupGetInstanceHealthinessRequestGcp.Builder builder =
                    new ElastigroupGetInstanceHealthinessRequestGcp.Builder();
            return builder;
        }

        public ElastigroupGetInstanceHealthinessRequestGcp.Builder setElastigroupId(final String elastigroupId) {
            elastigroupInstanceHealthinessRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetInstanceHealthinessRequestGcp build() {

            if (elastigroupInstanceHealthinessRequest.getElastigroupId() == null) {
                throw new SpotinstValidationException("Invalid Request - group id must be specified");
            }

            return elastigroupInstanceHealthinessRequest;
        }

    }
    //endregion
}