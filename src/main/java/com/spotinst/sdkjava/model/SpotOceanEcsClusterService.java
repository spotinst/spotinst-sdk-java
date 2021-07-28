package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.ecs.ApiClusterLaunchSpecification;
import com.spotinst.sdkjava.model.responses.ClusterEcsLaunchSpecApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpotOceanEcsClusterService extends BaseSpotinstService {
    public static ApiClusterLaunchSpecification createLaunchSpecification(
            ApiClusterLaunchSpecification launchSpecsToCreate, String authToken,
            String account) throws SpotinstHttpException {
        // Init retVal
        ApiClusterLaunchSpecification retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiClusterLaunchSpecification> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", launchSpecsToCreate);
        String body = JsonMapper.toJson(launchSpecRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ClusterEcsLaunchSpecApiResponse launchSpecCreateResponse =
                getCastedResponse(response, ClusterEcsLaunchSpecApiResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean updateLaunchSpecification(String oceanLaunchSpecId,
                                                    ApiClusterLaunchSpecification launchSpecsToUpdate, String authToken,
                                                    String account) throws SpotinstHttpException {
        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiClusterLaunchSpecification> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", launchSpecsToUpdate);
        String body = JsonMapper.toJson(launchSpecRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/launchSpec/%s", apiEndpoint, oceanLaunchSpecId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ClusterEcsLaunchSpecApiResponse launchUpdateResponse =
                getCastedResponse(response, ClusterEcsLaunchSpecApiResponse.class);

        if (launchUpdateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }


    public static Boolean deleteLaunchSpecification(String oceanLaunchSpecId, String authToken,
                                                    String account) throws SpotinstHttpException {
        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/launchSpec/%s", apiEndpoint, oceanLaunchSpecId);

        // Send the request
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiClusterLaunchSpecification getLaunchSpecification(String oceanLaunchSpecId, String authToken,
                                                                       String account) throws SpotinstHttpException {
        // Init retVal
        ApiClusterLaunchSpecification retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/launchSpec/%s", apiEndpoint, oceanLaunchSpecId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ClusterEcsLaunchSpecApiResponse launchSpecCreateResponse =
                getCastedResponse(response, ClusterEcsLaunchSpecApiResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiClusterLaunchSpecification> getAllLaunchSpecification(String authToken,
                                                                                String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiClusterLaunchSpecification> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ClusterEcsLaunchSpecApiResponse launchSpecCreateResponse =
                getCastedResponse(response, ClusterEcsLaunchSpecApiResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems();
        }

        return retVal;
    }

}
