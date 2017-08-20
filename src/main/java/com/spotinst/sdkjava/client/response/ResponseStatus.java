package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/18/15.
 */
public class ResponseStatus
{
    @JsonProperty
    private int code;

    @JsonProperty
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
