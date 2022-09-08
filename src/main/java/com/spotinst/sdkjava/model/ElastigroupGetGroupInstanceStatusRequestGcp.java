package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;


public class ElastigroupGetGroupInstanceStatusRequestGcp {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor
    private ElastigroupGetGroupInstanceStatusRequestGcp() {
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
        private ElastigroupGetGroupInstanceStatusRequestGcp elastigroupInstanceHealthinessRequest;

        private Builder() {
            this.elastigroupInstanceHealthinessRequest = new ElastigroupGetGroupInstanceStatusRequestGcp();
        }

        public static ElastigroupGetGroupInstanceStatusRequestGcp.Builder get() {
            return new Builder();
        }

        public ElastigroupGetGroupInstanceStatusRequestGcp.Builder setElastigroupId(final String elastigroupId) {
            elastigroupInstanceHealthinessRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetGroupInstanceStatusRequestGcp build() {

            if (elastigroupInstanceHealthinessRequest.getElastigroupId() == null) {
                throw new SpotinstValidationException("Invalid Request - group id must be specified");
            }

            return elastigroupInstanceHealthinessRequest;
        }

    }
    //endregion
}