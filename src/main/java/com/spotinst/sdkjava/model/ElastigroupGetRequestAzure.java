package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;
import org.apache.commons.lang3.StringUtils;

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
            return new Builder();
        }

        public ElastigroupGetRequestAzure.Builder setElastigroupId(final String elastigroupId) {
            elastigroupGetRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetRequestAzure build() {
            if(StringUtils.isEmpty(elastigroupGetRequest.getElastigroupId())){
                throw new SpotinstValidationException(
                        "Invalid Request - elastigroupId must be set");
            }
            return elastigroupGetRequest;
        }

    }
    //endregion
}
