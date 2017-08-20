package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceErrorsResponse {

    public ServiceErrorsResponse()
    {

    }

    @JsonProperty
    private ErrorsInnerResponse response;

    public ErrorsInnerResponse getResponse() {
        return response;
    }

    public void setResponse(ErrorsInnerResponse response) {
        this.response = response;
    }
}

