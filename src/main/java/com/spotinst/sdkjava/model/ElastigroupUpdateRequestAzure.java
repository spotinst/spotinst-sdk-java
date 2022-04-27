package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;

import java.util.HashMap;
import java.util.Map;


public class ElastigroupUpdateRequestAzure {
    //region Members
    @JsonProperty("group")
    private ElastigroupAzure elastigroup;
    //endregion

    //region Private Constructor

    private ElastigroupUpdateRequestAzure() {
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
    public static class Builder {
        private ElastigroupUpdateRequestAzure elastigroupCreationRequest;

        private Builder() {
            this.elastigroupCreationRequest = new ElastigroupUpdateRequestAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setElastigroup(final ElastigroupAzure elastigroup) {
            elastigroupCreationRequest.setElastigroup(elastigroup);
            return this;
        }

        public ElastigroupUpdateRequestAzure build() {
            // TODO : Validations
            return elastigroupCreationRequest;
        }

    }
    //region Json methods
    public String toJson() {
        ApiElastigroupAzure apiElastigroupToCreate = ElastigroupConverterAzure.toDal(elastigroup);

        Map<String, ApiElastigroupAzure> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroupToCreate);

        return JsonMapper.toJson(groupRequest);
    }
    //endregion

}
