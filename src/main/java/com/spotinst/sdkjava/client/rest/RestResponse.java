package com.spotinst.sdkjava.client.rest;

/**
 * Created by aharontwizer on 7/18/15.
 */
public class RestResponse {

    private int statusCode;
    private String body;

    public RestResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
