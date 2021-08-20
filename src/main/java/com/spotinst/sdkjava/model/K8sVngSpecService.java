package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVngSpec;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.K8sVngApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class K8sVngSpecService extends BaseSpotinstService {
    public static ApiK8sVngSpec createK8sVng(ApiK8sVngSpec vngToCreate, String authToken,
                                             String account) throws SpotinstHttpException {
        ApiK8sVngSpec retVal = null;

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
        Map<String, ApiK8sVngSpec> vngRequest = new HashMap<>();
        vngRequest.put("launchSpec", vngToCreate);
        String body = JsonMapper.toJson(vngRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse vngApiResponse =
                getCastedResponse(response, K8sVngApiResponse.class);

        if (vngApiResponse.getResponse().getCount() > 0) {
            retVal = vngApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteK8sVng(String oceanLaunchSpecId, String authToken,
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

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec/%s", apiEndpoint, oceanLaunchSpecId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateK8sVng(String oceanLaunchSpecId, ApiK8sVngSpec vngToUpdate, String authToken,
                                       String account) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec/%s", apiEndpoint, oceanLaunchSpecId);

        // Write to json
        Map<String, ApiK8sVngSpec> groupRequest = new HashMap<>();
        groupRequest.put("launchSpec", vngToUpdate);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse updateResponse = getCastedResponse(response, K8sVngApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiK8sVngSpec getK8sVng(String oceanLaunchSpecId, String authToken,
                                          String account) throws SpotinstHttpException {
        // Init retVal
        ApiK8sVngSpec retVal = new ApiK8sVngSpec();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec/%s", apiEndpoint, oceanLaunchSpecId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse vngApiResponse = getCastedResponse(response, K8sVngApiResponse.class);

        if (vngApiResponse.getResponse().getCount() > 0) {
            retVal = vngApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiK8sVngSpec listK8sVng(String oceanId, String authToken,
                                                 String account) throws SpotinstHttpException {

        // Init retVal
        ApiK8sVngSpec retVal = new ApiK8sVngSpec();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec", apiEndpoint, oceanId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse vngApiResponse = getCastedResponse(response, K8sVngApiResponse.class);

        if (vngApiResponse.getResponse().getCount() > 0) {
            retVal = vngApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }
}