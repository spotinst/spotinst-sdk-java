package com.spotinst.sdkjava.client.rest;

/**
 * Created by talzur on 11/01/2017.
 */
public class SpotinstHttpConfig {
    private String endpoint;
    private Integer timeoutInMillis;
    private Integer connectionTimeoutInMillis;
    private Integer connectionRequestTimeoutInsMillis;
    private Integer timeToLiveInHours;
    private boolean cookiesEnabled;
    private Integer maxConnections = 1024;
    private Integer maxConnectionsPerRoute = 1024;
    private Integer keepAliveInMillis = 0;
    private Integer retries;

    SpotinstHttpConfig() {
        // get the property value and print it out
        this.endpoint = SpotinstDefaults.DEFAULT_API_ENDPOINT;
        this.timeoutInMillis = SpotinstDefaults.DEFAULT_TIMEOUT_IN_MILLIS;
        this.connectionTimeoutInMillis = SpotinstDefaults.DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS;
        this.connectionRequestTimeoutInsMillis = SpotinstDefaults.DEFAULT_CONNECTION_REQUEST_TIMEOUT_IN_MILLIS;
        this.timeToLiveInHours = SpotinstDefaults.TIME_TO_LIVE_IN_HOURS;
        this.cookiesEnabled = SpotinstDefaults.COOKIES_ENABLED;
        this.maxConnections = SpotinstDefaults.MAX_CONNECTIONS;
        this.maxConnectionsPerRoute = SpotinstDefaults.MAX_CONNECTIONS_PER_ROUTE;
        this.keepAliveInMillis = SpotinstDefaults.KEEP_ALIVE_IN_MILLIS;
        this.retries = SpotinstDefaults.RETRIES;
    }

    //region Getter and Setter methods

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Integer getTimeoutInMillis() {
        return timeoutInMillis;
    }

    public void setTimeoutInMillis(Integer timeoutInMillis) {
        this.timeoutInMillis = timeoutInMillis;
    }

    public Integer getConnectionTimeoutInMillis() {
        return connectionTimeoutInMillis;
    }

    public void setConnectionTimeoutInMillis(Integer connectionTimeoutInMillis) {
        this.connectionTimeoutInMillis = connectionTimeoutInMillis;
    }

    public Integer getConnectionRequestTimeoutInsMillis() {
        return connectionRequestTimeoutInsMillis;
    }

    public void setConnectionRequestTimeoutInsMillis(Integer connectionRequestTimeoutInsMillis) {
        this.connectionRequestTimeoutInsMillis = connectionRequestTimeoutInsMillis;
    }

    public Integer getTimeToLiveInHours() {
        return timeToLiveInHours;
    }

    public void setTimeToLiveInHours(Integer timeToLiveInHours) {
        this.timeToLiveInHours = timeToLiveInHours;
    }

    public boolean isCookiesEnabled() {
        return cookiesEnabled;
    }

    public void setCookiesEnabled(boolean cookiesEnabled) {
        this.cookiesEnabled = cookiesEnabled;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Integer getMaxConnectionsPerRoute() {
        return maxConnectionsPerRoute;
    }

    public void setMaxConnectionsPerRoute(Integer maxConnectionsPerRoute) {
        this.maxConnectionsPerRoute = maxConnectionsPerRoute;
    }

    public Integer getKeepAliveInMillis() {
        return keepAliveInMillis;
    }

    public void setKeepAliveInMillis(Integer keepAliveInMillis) {
        this.keepAliveInMillis = keepAliveInMillis;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    //endregion
}
