package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVirtualNodeGroup;
import com.spotinst.sdkjava.model.responses.OceanK8sVirtualNodeGroupApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class OceanK8sVirtualNodeGroupService extends BaseSpotinstService {
    public static ApiK8sVirtualNodeGroup createK8sVirtualNodeGroup(ApiK8sVirtualNodeGroup virtualNodeGroupToCreate, String authToken,
                                                          String account) throws SpotinstHttpException {
        // Init retVal
        ApiK8sVirtualNodeGroup retVal = null;

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
        Map<String, ApiK8sVirtualNodeGroup> virtualNodeGroupRequest = new HashMap<>();
        virtualNodeGroupRequest.put("launchSpec", virtualNodeGroupToCreate);
        String body = JsonMapper.toJson(virtualNodeGroupRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        OceanK8sVirtualNodeGroupApiResponse virtualNodeGroupApiResponse =
                getCastedResponse(response, OceanK8sVirtualNodeGroupApiResponse.class);

        if (virtualNodeGroupApiResponse.getResponse().getCount() > 0) {
            retVal = virtualNodeGroupApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteK8sVirtualNodeGroup(String oceanLaunchSpecId, String authToken,
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

    public static Boolean updateK8sVirtualNodeGroup(String oceanLaunchSpecId, ApiK8sVirtualNodeGroup virtualNodeGroupToUpdate, String authToken,
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
        Map<String, ApiK8sVirtualNodeGroup> groupRequest = new HashMap<>();
        groupRequest.put("launchSpec", virtualNodeGroupToUpdate);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        OceanK8sVirtualNodeGroupApiResponse updateResponse = getCastedResponse(response, OceanK8sVirtualNodeGroupApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiK8sVirtualNodeGroup getK8sVirtualNodeGroup(String oceanLaunchSpecId, String authToken,
                                                                String account) throws SpotinstHttpException {
        // Init retVal
        ApiK8sVirtualNodeGroup retVal = new ApiK8sVirtualNodeGroup();

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
        OceanK8sVirtualNodeGroupApiResponse virtualNodeGroupApiResponse = getCastedResponse(response, OceanK8sVirtualNodeGroupApiResponse.class);

        if (virtualNodeGroupApiResponse.getResponse().getCount() > 0) {
            retVal = virtualNodeGroupApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }
}