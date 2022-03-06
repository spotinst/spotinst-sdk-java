package com.spotinst.sdkjava.client.rest;

/**
 * Created by ohadmuchnik on 31/05/2016.
 */
public class UrlEncoder {

    public static String encode(String url) {
        return url.replaceAll(" ", "%20");
    }
}
