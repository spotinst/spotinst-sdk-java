package com.spotinst.sdkjava.client.http;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpPost;

import java.net.URI;

@Contract(threading = ThreadingBehavior.UNSAFE)
public class DeleteRequestWithBody extends HttpPost {

    @Override
    public String getMethod() {
        return "DELETE";
    }

    public DeleteRequestWithBody(final String requestUri) {
        super();
        setURI(URI.create(requestUri));
    }
}
