package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aharontwizer on 8/24/15.
 */

public class ElastigroupCreationRequest {
    //region Members
    @JsonProperty("group")
    private Elastigroup elastigroup;
    //endregion

    //region Private constructor
    private ElastigroupCreationRequest() {
    }
    //endregion


    //region Getters & Setters

    public Elastigroup getElastigroup() {
        return elastigroup;
    }

    public void setElastigroup(Elastigroup elastigroup) {
        this.elastigroup = elastigroup;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupCreationRequest elastigroupCreationRequest;

        private Builder() {
            this.elastigroupCreationRequest = new ElastigroupCreationRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setElastigroup(final Elastigroup elastigroup) {
            elastigroupCreationRequest.setElastigroup(elastigroup);
            return this;
        }

        public ElastigroupCreationRequest build() {
            // TODO : Validations
            return elastigroupCreationRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiElastigroup apiElastigroupToCreate = ElastigroupConverter.toDal(elastigroup);

        Map<String, ApiElastigroup> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroupToCreate);

        return JsonMapper.toJson(groupRequest);
    }
    //endregion

}
