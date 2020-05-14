package com.spotinst.sdkjava.client.http;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * Created by aharontwizer on 8/9/15.
 *
**/
@NotThreadSafe
public class DeleteRequestWithBody extends HttpEntityEnclosingRequestBase {
    private static final String HTTP_METHOD_NAME = "DELETE";

    @Override
    public String getMethod() { return HTTP_METHOD_NAME; }

    public DeleteRequestWithBody(final String requestUri) {
        super();
        setURI(URI.create(requestUri));
    }
}
