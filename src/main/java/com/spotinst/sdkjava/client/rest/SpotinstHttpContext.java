package com.spotinst.sdkjava.client.rest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;


/**
 * Created by aharontwizer on 7/17/15.
 */
public class SpotinstHttpContext {
    //region Members
    private static SpotinstHttpContext instance;
    private SpotinstHttpConfig configuration;
    private HttpClient httpClient;
    private HttpClient httpsClient;
    //endregion

    //region Constructors
    private SpotinstHttpContext()    {
        this.configuration = new SpotinstHttpConfig();
        this.httpClient = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build()).build();
        this.httpsClient = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD).build()).build();
    }

    private CloseableHttpClient getNewClient() {
        RequestConfig.Builder requestBuilder = RequestConfig.custom();
        requestBuilder = requestBuilder.setConnectTimeout(configuration.getConnectionTimeoutInMillis());
        requestBuilder = requestBuilder.setConnectionRequestTimeout(configuration.getConnectionRequestTimeoutInsMillis());

        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setDefaultRequestConfig(requestBuilder.build());

        return builder.build();
    }
    //endregion

    //region Getters & Setters

    public static void setInstance(SpotinstHttpContext instance) {
        SpotinstHttpContext.instance = instance;
    }

    public SpotinstHttpConfig getConfiguration() {
        return configuration;
    }

    public void setConfiguration(SpotinstHttpConfig configuration) {
        this.configuration = configuration;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpClient getHttpsClient() {
        return httpsClient;
    }

    public void setHttpsClient(HttpClient httpsClient) {
        this.httpsClient = httpsClient;
    }

    //endregion

    //region Methods
    public static SpotinstHttpContext getInstance() {
        // Lazy Initialization (If required then only)
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (SpotinstHttpContext.class) {
                if (instance == null) {
                    instance = new SpotinstHttpContext();
                }
            }
        }
        return instance;
    }
    //endregion
}
