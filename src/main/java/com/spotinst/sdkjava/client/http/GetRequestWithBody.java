package com.spotinst.sdkjava.client.http;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpPost;

import java.net.URI;

/**
 * Created by Saikumar Jalda on 03 Mar 2022
 *
 */

@Contract(threading = ThreadingBehavior.UNSAFE)
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
