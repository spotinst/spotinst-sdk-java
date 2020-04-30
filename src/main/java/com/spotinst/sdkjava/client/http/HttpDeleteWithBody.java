package com.spotinst.sdkjava.client.http;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * Created by aharontwizer on 8/9/15.
 *
 * Based on Stack Overflow article.
 * Ref: https://stackoverflow.com/a/3820549/11325676
 */
@NotThreadSafe
public class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";
    public String getMethod() { return METHOD_NAME; }

    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }
    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }
    public HttpDeleteWithBody() { super(); }
}
