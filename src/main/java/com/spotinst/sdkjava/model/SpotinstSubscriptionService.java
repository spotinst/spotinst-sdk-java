package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aharontwizer on 7/27/15.
 */
class SpotinstSubscriptionService extends BaseSpotinstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSubscriptionService.class);

    static ApiSubscription createSubscription(ApiSubscription subscriptionToCreate, String authToken) throws SpotinstHttpException {

        // Init retVal
        ApiSubscription retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiSubscription> subscriptionRequest = new HashMap<>();
        subscriptionRequest.put("subscription", subscriptionToCreate);
        String body = JsonMapper.toJson(subscriptionRequest);

        // Build URI
        String uri = String.format("%s/events/subscription", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        SubscriptionApiResponse subscriptionApiResponse = getCastedResponse(response, SubscriptionApiResponse.class);

        if (subscriptionApiResponse.getResponse().getCount() > 0) {
            retVal = subscriptionApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiSubscription getSubscription(String subscriptionId, String authToken) throws SpotinstHttpException {

        // Init retVal
        ApiSubscription retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        //Build URI
        String uri = String.format("%s/events/subscription/" + subscriptionId, apiEndpoint);

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

    public static Boolean deleteSubscription(String subscriptionId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        //Build URI
        String uri = String.format("%s/events/subscription/" + subscriptionId, apiEndpoint);

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
}
