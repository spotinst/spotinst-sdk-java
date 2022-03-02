package com.spotinst.sdkjava.client.rest;

/**
 * Created by talzur on 16/01/2017.
 */
public class SpotinstDefaults {
    public static final String DEFAULT_API_ENDPOINT = "https://api.spotinst.io";
    public static final Integer DEFAULT_TIMEOUT_IN_MILLIS = 10000;
    public static final Integer DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS = 10000;
    public static final Integer DEFAULT_CONNECTION_REQUEST_TIMEOUT_IN_MILLIS = 10000;
    public static final Integer TIME_TO_LIVE_IN_HOURS = 1;
    public static final boolean COOKIES_ENABLED = false;
    public static final Integer MAX_CONNECTIONS = 1024;
    public static final Integer MAX_CONNECTIONS_PER_ROUTE = 1024;
    public static final Integer KEEP_ALIVE_IN_MILLIS = 0;
    public static final Integer RETRIES = 0;
    //TODO: enforce on all REST calls
    public static final int HTTP_PAYLOAD_THRESHOLD_IN_BYTES = (int) (50 * 1000 * 0.95); // almost 50kB
}
