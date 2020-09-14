package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;

import java.util.HashMap;
import java.util.Map;

public class ElastigroupDeletionRequestAzure {
    //region Members
    private String elastigroupId;
    //endregion

    //region Private constructor
    private ElastigroupDeletionRequestAzure() {
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
        private ElastigroupDeletionRequestAzure elastigroupDeletionRequest;

        private Builder() {
            this.elastigroupDeletionRequest = new ElastigroupDeletionRequestAzure();
        }

        public static ElastigroupDeletionRequestAzure.Builder get() {
            ElastigroupDeletionRequestAzure.Builder builder = new ElastigroupDeletionRequestAzure.Builder();
            return builder;
        }

        public ElastigroupDeletionRequestAzure.Builder setElastigroupId(final String elastigroupId) {
            elastigroupDeletionRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public ElastigroupDeletionRequestAzure build() {
            // TODO : Validations
            return elastigroupDeletionRequest;
        }

    }
    //endregion
}
