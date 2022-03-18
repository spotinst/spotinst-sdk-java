package com.spotinst.sdkjava.client.http;

import org.apache.http.client.methods.HttpPost;

import java.net.URI;

public class GetRequestWithBody extends HttpPost {

    @Override
    public String getMethod() {
        return "GET";
    }

    public GetRequestWithBody(final String requestUri) {
        super();
        setURI(URI.create(requestUri));
    }
}
