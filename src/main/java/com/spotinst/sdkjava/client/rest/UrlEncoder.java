package com.spotinst.sdkjava.client.rest;

/**
 * Created by ohadmuchnik on 31/05/2016.
 */
public class UrlEncoder {

    public static String encode(String url) {
        String encodedUrl = url.replaceAll(" ", "%20");
        return encodedUrl;
    }
}
