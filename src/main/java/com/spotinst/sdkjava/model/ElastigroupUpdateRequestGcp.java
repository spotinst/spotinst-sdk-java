package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.gcp.ApiElastigroupGcp;
import com.spotinst.sdkjava.model.bl.elastigroup.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.converters.elastigroup.gcp.ElastigroupConverterGcp;

import java.util.HashMap;
import java.util.Map;


public class ElastigroupUpdateRequestGcp {
    //region Members
    @JsonProperty("group")
    private ElastigroupGcp elastigroup;
    //endregion

    //region Private Constructor
    private ElastigroupUpdateRequestGcp() {
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
    public static class Builder {
        private ElastigroupUpdateRequestGcp elastigroupCreationRequest;

        private Builder() {
            this.elastigroupCreationRequest = new ElastigroupUpdateRequestGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroup(final ElastigroupGcp elastigroup) {
            elastigroupCreationRequest.setElastigroup(elastigroup);
            return this;
        }

        public ElastigroupUpdateRequestGcp build() {
            return elastigroupCreationRequest;
        }

    }
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
