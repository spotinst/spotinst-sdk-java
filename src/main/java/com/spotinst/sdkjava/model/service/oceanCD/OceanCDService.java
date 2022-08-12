package com.spotinst.sdkjava.model.service.oceanCD;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.oceanCD.ApiStrategy;
import com.spotinst.sdkjava.model.responses.oceanCD.CreateStrategyApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public class OceanCDService extends BaseSpotinstService {
    public static ApiStrategy createStrategy (ApiStrategy strategyRequest, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiStrategy retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiStrategy> strategyReq = new HashMap<>();
        strategyReq.put("strategy", strategyRequest);
        String body = JsonMapper.toJson(strategyReq);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        CreateStrategyApiResponse strategyResponse =
                getCastedResponse(response, CreateStrategyApiResponse.class);

        if (strategyResponse.getResponse().getCount() > 0) {
            retVal = strategyResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiStrategy getStrategy(String strategyName, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiStrategy retVal = new ApiStrategy();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        CreateStrategyApiResponse getStrategyResponse = getCastedResponse(response, CreateStrategyApiResponse.class);

        if (getStrategyResponse.getResponse().getCount() > 0) {
            retVal = getStrategyResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiStrategy> getAllStrategies(String authToken) throws SpotinstHttpException {
        // Init retVal
        List<ApiStrategy> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        CreateStrategyApiResponse allStrategiesResponse = getCastedResponse(response, CreateStrategyApiResponse.class);

        if (allStrategiesResponse.getResponse().getCount() > 0) {
            retVal = allStrategiesResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateStrategy(ApiStrategy strategyUpdateReq, String strategyName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Write to json
        Map<String, ApiStrategy> strategyRequest = new HashMap<>();
        strategyRequest.put("strategy", strategyUpdateReq);
        String body = JsonMapper.toJson(strategyRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean patchStrategy(ApiStrategy strategyUpdateReq, String strategyName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Write to json
        Map<String, ApiStrategy> strategyRequest = new HashMap<>();
        strategyRequest.put("strategy", strategyUpdateReq);
        String body = JsonMapper.toJson(strategyRequest);

        // Send the request.
        RestResponse response = RestClient.sendPatch(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteStrategy(String strategyName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }
}