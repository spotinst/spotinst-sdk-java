package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.admin.account.ApiSubscription;
import com.spotinst.sdkjava.model.api.admin.account.response.ApiSubscriptionResponse;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aharontwizer on 7/27/15.
 */
class SpotinstSubscriptionService extends BaseSpotinstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSubscriptionService.class);

    static ApiSubscriptionResponse createSubscription(ApiSubscription subscriptionToCreate, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiSubscriptionResponse retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId",account);
        }

        // Write to json
        Map<String, ApiSubscription> subscriptionRequest = new HashMap<>();
        subscriptionRequest.put("subscription", subscriptionToCreate);
        String body = JsonMapper.toJson(subscriptionRequest);

        // Build URI
        String uri = String.format("%s/events/subscription", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        SubscriptionApiResponse subscriptionApiResponse = getCastedResponse(response, SubscriptionApiResponse.class);

        if (subscriptionApiResponse.getResponse().getCount() > 0) {
            retVal = subscriptionApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiSubscriptionResponse getSubscription(String subscriptionId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiSubscriptionResponse retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId",account);
        }

        //Build URI
        String uri = String.format("%s/events/subscription/%s", apiEndpoint, subscriptionId);

        // Send the request.
        RestResponse response = RestClient
                .sendGet(uri, headers, queryParams);

        // Handle the response.
        SubscriptionApiResponse subscriptionApiResponse = getCastedResponse(response, SubscriptionApiResponse.class);
        if (subscriptionApiResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = subscriptionApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteSubscription(String subscriptionId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId",account);
        }

        //Build URI
        String uri = String.format("%s/events/subscription/%s", apiEndpoint, subscriptionId);

        // Send the request.
        RestResponse response = RestClient
                .sendDelete(uri,
                        null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiSubscriptionResponse> getAllSubscriptionEvents(String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiSubscriptionResponse> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId",account);
        }

        //Build URI
        String uri = String.format("%s/events/subscription", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient
                .sendGet(uri, headers, queryParams);

        // Handle the response.
        SubscriptionApiResponse subscriptionApiResponse = getCastedResponse(response, SubscriptionApiResponse.class);
        if (subscriptionApiResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = subscriptionApiResponse.getResponse().getItems();
        }

        return retVal;
    }

    static Boolean updateSubscription(ApiSubscription subscriptionToUpdate, String subscriptionId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId",account);
        }

        // Write to json
        Map<String, ApiSubscription> subscriptionRequest = new HashMap<>();
        subscriptionRequest.put("subscription", subscriptionToUpdate);
        String body = JsonMapper.toJson(subscriptionRequest);

        // Build URI
        String uri = String.format("%s/events/subscription/%s", apiEndpoint, subscriptionId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }
}
