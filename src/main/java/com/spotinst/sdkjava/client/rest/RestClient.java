package com.spotinst.sdkjava.client.rest;

import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.client.http.DeleteRequestWithBody;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by aharontwizer on 7/18/15.
 */
public class RestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    public static RestResponse sendGet(
            String url,
            Map<String, String> headers,
            Map<String, String> queryParams) throws SpotinstHttpException {

        String encodedUrl = UrlEncoder.encode(url);

        // Build the get request
        HttpGet getRequest = new HttpGet(encodedUrl);

        // Adding query params.
        addQueryParams(getRequest, queryParams);

        // Adding headers.
        addHeaders(getRequest, headers);

        // Sending the request.
        RestResponse retVal = sendRequest(getRequest);

        return retVal;
    }

    public static RestResponse sendPut(
            String url,
            String body,
            Map<String, String> headers,
            Map<String, String> queryParams) throws SpotinstHttpException {

        String encodedUrl = UrlEncoder.encode(url);

        // Build the put request
        HttpPut putRequest = new HttpPut(encodedUrl);

        // Build the request body
        if (body != null) {
            StringEntity entity = null;
            try {
                entity = new StringEntity(body);
            } catch (UnsupportedEncodingException e) {

                // TODO - Handle.
                LOGGER.error("Exception when building put body", e);
            }
            putRequest.setEntity(entity);
        }

        // Adding query params.
        addQueryParams(putRequest, queryParams);

        // Adding headers.
        addHeaders(putRequest, headers);

        // Sending the request.
        RestResponse retVal = sendRequest(putRequest);

        return retVal;
    }

    public static RestResponse sendPost(
            String url,
            String body,
            Map<String, String> headers,
            Map<String, String> queryParams) throws SpotinstHttpException {

        String encodedUrl = UrlEncoder.encode(url);

        // Build the post request
        HttpPost postRequest = new HttpPost(encodedUrl);

        // Build the request body
        if (body != null) {
            StringEntity entity = null;
            try {
                entity = new StringEntity(body);
            } catch (UnsupportedEncodingException e) {

                // TODO - Handle.
                LOGGER.error("Exception when building put body", e);
            }
            postRequest.setEntity(entity);
        }

        // Adding query params.
        addQueryParams(postRequest, queryParams);

        // Adding headers.
        addHeaders(postRequest, headers);

        // Sending the request.
        RestResponse retVal = sendRequest(postRequest);

        return retVal;
    }

    public static RestResponse sendDelete(
            String url,
            String body,
            Map<String, String> headers,
            Map<String, String> queryParams) throws SpotinstHttpException {

        String encodedUrl = UrlEncoder.encode(url);

        // Build the post request
        DeleteRequestWithBody deleteRequest = new DeleteRequestWithBody(encodedUrl);

        // Build the request body
        if (body != null) {
            StringEntity entity = null;
            try {
                entity = new StringEntity(body);
            } catch (UnsupportedEncodingException e) {

                // TODO - Handle.
                LOGGER.error("Exception when building delete body", e);
            }
            deleteRequest.setEntity(entity);
        }

        // Adding query params.
        addQueryParams(deleteRequest, queryParams);

        // Adding headers.
        addHeaders(deleteRequest, headers);

        // Sending the request.
        RestResponse retVal = sendRequest(deleteRequest);

        return retVal;
    }

    private static RestResponse sendRequest(HttpUriRequest urlRequest) throws SpotinstHttpException {
        RestResponse retVal = null;

        // Get the client.
        HttpClient httpclient;
        if (urlRequest.getURI().toString().startsWith("https")) {
            httpclient = SpotinstHttpContext.getInstance().getHttpsClient();
        } else {
            httpclient = SpotinstHttpContext.getInstance().getHttpClient();
        }

        CloseableHttpResponse response = null;
        // Sending the request.
        try {

            LOGGER.debug("About to make HTTP call : " + urlRequest.toString());

            response = (CloseableHttpResponse) httpclient.execute(urlRequest);

            // Build the com.spotinst.sdkjava.client.rest response.
            retVal = buildRestResponse(response);

        } catch (IOException e) {

            LOGGER.error("Exception when executing com.spotinst.sdkjava.client.http request", e);
            throw new SpotinstHttpException("Exception in com.spotinst.sdkjava.client.http request", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOGGER.error("Exception when closing com.spotinst.sdkjava.client.http response", e);
                }
            }
        }

        return retVal;
    }

    private static void addQueryParams(HttpRequestBase request, Map<String, String> queryParams) {
        // Adding query params.
        if (queryParams != null) {
            URIBuilder builder = new URIBuilder(request.getURI());
            for (Map.Entry<String, String> currEntry : queryParams.entrySet()) {
                builder.addParameter(currEntry.getKey(), currEntry.getValue());
            }

            URI newUri = null;
            try {
                newUri = builder.build();
            } catch (URISyntaxException e) {
                // TODO - Handle.
                LOGGER.error("Exception when building get url", e);
            }

            request.setURI(newUri);
        }
    }

    private static void addHeaders(HttpRequestBase request, Map<String, String> headers) {
        // Adding headers.
        if (headers != null) {
            // Adding the headers
            for (Map.Entry<String, String> currEntry : headers.entrySet()) {
                request.addHeader(currEntry.getKey(), currEntry.getValue());
            }
        }

        //   request.addHeader("Connection", "close");
    }

    private static RestResponse buildRestResponse(HttpResponse response) throws SpotinstHttpException {
        RestResponse retVal = null;

        BufferedReader rd = null;
        try {
            StringBuffer result = new StringBuffer();
            if (response.getEntity() != null) {
                rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

            }
            // Build the com.spotinst.sdkjava.client.rest response.
            retVal = new RestResponse(response.getStatusLine().getStatusCode(), result.toString());

        } catch (IOException e) {

            LOGGER.error("Exception when when building Rest response.", e);
            // TODO - Have constant for such error
            retVal = new RestResponse(-1, e.toString());

            throw new SpotinstHttpException("Exception when when building Rest response.", e);
        }

        return retVal;
    }
}
