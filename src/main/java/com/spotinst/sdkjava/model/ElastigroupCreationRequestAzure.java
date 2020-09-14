package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;

import java.util.HashMap;
import java.util.Map;


public class ElastigroupCreationRequestAzure {
    //region Members
    @JsonProperty("group")
    private ElastigroupAzure elastigroup;
    //endregion

    //region Private constructor
    private ElastigroupCreationRequestAzure() {
    }
    //endregion


    //region Getters & Setters

    public ElastigroupAzure getElastigroup() {
        return elastigroup;
    }

    public void setElastigroup(ElastigroupAzure elastigroup) {
        this.elastigroup = elastigroup;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupCreationRequestAzure elastigroupCreationRequest;

        private Builder() {
            this.elastigroupCreationRequest = new ElastigroupCreationRequestAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroup(final ElastigroupAzure elastigroup) {
            elastigroupCreationRequest.setElastigroup(elastigroup);
            return this;
        }

        public ElastigroupCreationRequestAzure build() {
            // TODO : Validations
            return elastigroupCreationRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiElastigroupAzure apiElastigroupToCreate = ElastigroupConverterAzure.toDal(elastigroup);

        Map<String, ApiElastigroupAzure> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroupToCreate);
        String elastigroupJson = JsonMapper.toJson(groupRequest);

        return elastigroupJson;
    }
    //endregion

}
