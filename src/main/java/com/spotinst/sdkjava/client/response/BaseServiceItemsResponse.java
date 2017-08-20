package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseServiceItemsResponse<T> {

    public BaseServiceItemsResponse()
    {

    }

    @JsonProperty
    public ItemsInnerResponse<T> getResponse() {
        return response;
    }

    @JsonProperty
    public void setResponse(ItemsInnerResponse<T> response) {
        this.response = response;
    }

    @JsonProperty
    private ItemsInnerResponse<T> response;
}

