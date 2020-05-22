package com.spotinst.sdkjava.model;

/**
 * Created by Adiv.s. on 18/05/2020.
 */
public class ElastigroupStandbyRequest {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private constructor
    private ElastigroupStandbyRequest() {
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
        private ElastigroupStandbyRequest elastigroupStandbyRequest;

        private Builder() {
            this.elastigroupStandbyRequest = new ElastigroupStandbyRequest();
        }

        public static ElastigroupStandbyRequest.Builder get() {
            ElastigroupStandbyRequest.Builder builder = new ElastigroupStandbyRequest.Builder();
            return builder;
        }

        public ElastigroupStandbyRequest.Builder setElastigroupId(final String elastigroupId) {
            elastigroupStandbyRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupStandbyRequest build() {
            return elastigroupStandbyRequest;
        }
    }
    //endregion
}
