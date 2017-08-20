package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ohadmuchnik on 3/13/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceDeleteResponse {

    public ServiceDeleteResponse()
    {

    }

    @JsonProperty
    private DeleteInnerResponse response;

    public DeleteInnerResponse getResponse() {
        return response;
    }

    public void setResponse(DeleteInnerResponse response) {
        this.response = response;
    }
}

