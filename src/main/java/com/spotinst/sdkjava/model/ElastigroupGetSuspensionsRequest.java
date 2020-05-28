package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;

/**
 * Created by yossi.elman on 24/05/2020.
 */

public class ElastigroupGetSuspensionsRequest {
    //region Members
    private String elastigroupId;
    //endregion

    public String getElastigroupId() {
        return elastigroupId;
    }

    private void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }

    //region Builder
    public static class Builder {
        private ElastigroupGetSuspensionsRequest request;

        private Builder() {
            this.request = new ElastigroupGetSuspensionsRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupId(final String elastigroupId) {
            request.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetSuspensionsRequest build() {
            if (request.getElastigroupId() == null) {
                throw new SpotinstValidationException("Invalid Request - elastigroupId must be set");
            }

            return request;
        }
    }
    //endregion
}
