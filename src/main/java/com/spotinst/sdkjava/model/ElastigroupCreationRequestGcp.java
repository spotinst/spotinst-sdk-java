package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.gcp.ApiElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupConverterGcp;

import java.util.HashMap;
import java.util.Map;


public class ElastigroupCreationRequestGcp {
    //region Members
    @JsonProperty("group")
    private ElastigroupGcp elastigroup;
    //endregion

    //region Private constructor
    private ElastigroupCreationRequestGcp() {
    }
    //endregion


    //region Getters & Setters
    public ElastigroupGcp getElastigroup() {
        return elastigroup;
    }

    public void setElastigroup(ElastigroupGcp elastigroup) {
        this.elastigroup = elastigroup;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupCreationRequestGcp elastigroupCreationRequest;

        private Builder() {
            this.elastigroupCreationRequest = new ElastigroupCreationRequestGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroup(final ElastigroupGcp elastigroup) {
            elastigroupCreationRequest.setElastigroup(elastigroup);
            return this;
        }

        public ElastigroupCreationRequestGcp build() {
            return elastigroupCreationRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiElastigroupGcp apiElastigroupToCreate = ElastigroupConverterGcp.toDal(elastigroup);

        Map<String, ApiElastigroupGcp> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroupToCreate);
        String elastigroupJson = JsonMapper.toJson(groupRequest);

        return elastigroupJson;
    }
    //endregion

}
