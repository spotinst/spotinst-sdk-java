package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;
import org.apache.commons.lang3.StringUtils;


// todo oz: check with Ziv - if this should be a client parameter or as a separate request - DONE kee[ that way of convention
public class ElastigroupGetRequestGcp {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private Constructor
    private ElastigroupGetRequestGcp() {
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
        private ElastigroupGetRequestGcp elastigroupGetRequest;

        private Builder() {
            this.elastigroupGetRequest = new ElastigroupGetRequestGcp();
        }

        public static ElastigroupGetRequestGcp.Builder get() {
            ElastigroupGetRequestGcp.Builder builder = new ElastigroupGetRequestGcp.Builder();
            return builder;
        }

        public ElastigroupGetRequestGcp.Builder setElastigroupId(final String elastigroupId) {
            elastigroupGetRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupGetRequestGcp build() {
            if(StringUtils.isEmpty(elastigroupGetRequest.getElastigroupId())){
                throw new SpotinstValidationException(
                        "Invalid Request - elastigroupId must be set");
            }
            return elastigroupGetRequest;
        }

    }
    //endregion
}
