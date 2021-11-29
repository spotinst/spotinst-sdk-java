package com.spotinst.sdkjava.model.service.azure.statefulNode;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNode;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNodeDeallocationConfig;
import com.spotinst.sdkjava.model.responses.azure.statefulNode.StatefulNodeApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class SpotinstAzureStatefulNodeService extends BaseSpotinstService {

    public static ApiStatefulNode createNode(ApiStatefulNode nodeToCreate, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNode retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiStatefulNode> nodeRequest = new HashMap<>();
        nodeRequest.put("node", nodeToCreate);
        String body = JsonMapper.toJson(nodeRequest);

        // Build URI
        String uri = String.format("%s/azure/stateful/node", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        StatefulNodeApiResponse elastigroupApiResponse =
                getCastedResponse(response, StatefulNodeApiResponse.class);

        if (elastigroupApiResponse.getResponse().getCount() > 0) {
            retVal = elastigroupApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static ApiStatefulNode getNode(String nodeId, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNode retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/azure/stateful/node/%s", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeApiResponse elastigroupApiResponse =
                getCastedResponse(response, StatefulNodeApiResponse.class);

        if (elastigroupApiResponse.getResponse().getCount() > 0) {
            retVal = elastigroupApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static ApiStatefulNode updateNode(ApiStatefulNode nodeToUpdate,String nodeId ,String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNode retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiStatefulNode> nodeRequest = new HashMap<>();
        nodeRequest.put("node", nodeToUpdate);
        String body = JsonMapper.toJson(nodeRequest);

        // Build URI
        String uri = String.format("%s/azure/stateful/node/%s", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        StatefulNodeApiResponse statefulNodeApiResponse =
                getCastedResponse(response, StatefulNodeApiResponse.class);

        if (statefulNodeApiResponse.getResponse().getCount() > 0) {
            retVal = statefulNodeApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static Boolean deleteNode(ApiStatefulNodeDeallocationConfig nodeToDelete, String nodeId , String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiStatefulNodeDeallocationConfig> nodeToDeleteRequest = new HashMap<>();
        nodeToDeleteRequest.put("deallocationConfig", nodeToDelete);
        String body = JsonMapper.toJson(nodeToDeleteRequest);

        // Build URI
        String uri = String.format("%s/azure/stateful/node/%s", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendDelete(uri, body, headers, queryParams);

        System.out.println("********************************* "+response.getBody() + " "+ response.getStatusCode());

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

}