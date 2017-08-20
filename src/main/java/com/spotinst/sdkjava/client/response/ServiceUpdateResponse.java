package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceUpdateResponse {

    public ServiceUpdateResponse()
    {

    }

    @JsonProperty
    private UpdateInnerResponse response;

    public UpdateInnerResponse getResponse() {
        return response;
    }

    public void setResponse(UpdateInnerResponse response) {
        this.response = response;
    }
}

