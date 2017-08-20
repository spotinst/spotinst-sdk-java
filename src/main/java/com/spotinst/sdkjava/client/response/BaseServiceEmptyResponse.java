package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/22/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseServiceEmptyResponse {

    @JsonProperty
    private BaseInnerResponse response;

    public BaseInnerResponse getResponse() {
        return response;
    }

    public void setResponse(BaseInnerResponse response) {
        this.response = response;
    }
}
