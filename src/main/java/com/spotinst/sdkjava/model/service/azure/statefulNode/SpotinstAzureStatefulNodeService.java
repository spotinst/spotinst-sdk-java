package com.spotinst.sdkjava.model.service.azure.statefulNode;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.statefulNode.*;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.ApiStatefulNodeStateChangeRequest;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeGetLogsRequest;
import com.spotinst.sdkjava.model.responses.azure.statefulNode.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpotinstAzureStatefulNodeService extends BaseSpotinstService {

    public static ApiStatefulNode createNode(ApiStatefulNode nodeToCreate, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNode retVal = null;

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
        Map<String, ApiStatefulNode> nodeRequest = new HashMap<>();
        nodeRequest.put("statefulNode", nodeToCreate);
        String body = JsonMapper.toJson(nodeRequest);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode", apiEndpoint);

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

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/%s", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeApiResponse statefulNodeGetApiResponse =
                getCastedResponse(response, StatefulNodeApiResponse.class);

        if (statefulNodeGetApiResponse.getResponse().getCount() > 0) {
            retVal = statefulNodeGetApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static ApiStatefulNodeGetStatusResponse getNodeStatus(String nodeId, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNodeGetStatusResponse retVal = null;

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
        String uri = String.format("%s/azure/compute/statefulNode/%s/status", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeApiGetStatusResponse statefulNodegetStatusApiResponse =
                getCastedResponse(response, StatefulNodeApiGetStatusResponse.class);

        if (statefulNodegetStatusApiResponse.getResponse().getCount() > 0) {
            retVal = statefulNodegetStatusApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static ApiStatefulNode updateNode(ApiStatefulNode nodeToUpdate,String nodeId ,String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNode retVal = null;

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
        Map<String, ApiStatefulNode> nodeRequest = new HashMap<>();
        nodeRequest.put("statefulNode", nodeToUpdate);
        String body = JsonMapper.toJson(nodeRequest);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/%s", apiEndpoint, nodeId);

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

        Map<String, String> queryParams = new HashMap<>();

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
        String uri = String.format("%s/azure/compute/statefulNode/%s", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendDelete(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiStatefulNode> getAllNodes(String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiStatefulNode> retVal = new LinkedList<>();

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
        String uri = String.format("%s/azure/compute/statefulNode", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeApiResponse statefulNodeApiResponse = getCastedResponse(response, StatefulNodeApiResponse.class);

        if (statefulNodeApiResponse.getResponse().getItems().size() > 0) {
            retVal = statefulNodeApiResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateNodeState(ApiStatefulNodeStateChangeRequest updateNodeStateRequest, String nodeId , String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        Boolean retVal = null;

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
        String body = JsonMapper.toJson(updateNodeStateRequest);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/%s/state", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }
        return retVal;
    }

    public static ApiImportConfiguration importNode(ApiImportConfiguration nodeToImport, String authToken, String account) throws SpotinstHttpException {

        ApiImportConfiguration retVal = null;

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
        Map<String, ApiImportConfiguration> nodeRequest = new HashMap<>();
        nodeRequest.put("statefulNodeImport", nodeToImport);
        String body = JsonMapper.toJson(nodeRequest);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/import", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        StatefulNodeImportApiResponse nodeApiResponse =
                getCastedResponse(response, StatefulNodeImportApiResponse.class);

        if (nodeApiResponse.getResponse().getCount() > 0) {
            retVal = nodeApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static ApiNodeImportStatusResponse getNodeImportStatus(String importId, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiNodeImportStatusResponse retVal = null;

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
        String uri = String.format("%s/azure/compute/statefulNode/import/%s/status", apiEndpoint, importId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeGetImportStatusApiResponse nodeImportStatusResponse =
                getCastedResponse(response, StatefulNodeGetImportStatusApiResponse.class);

        if (nodeImportStatusResponse.getResponse().getCount() > 0) {
            retVal = nodeImportStatusResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static ApiStatefulNode getImportVmConfiguration(String vmName, String resourceGroupName, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNode retVal = null;

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
        String uri = String.format("%s/azure/compute/statefulNode/resourceGroup/%s/virtualMachine/%s/importConfiguration", apiEndpoint, resourceGroupName, vmName);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeApiResponse statefulNodeGetApiResponse =
                getCastedResponse(response, StatefulNodeApiResponse.class);

        if (statefulNodeGetApiResponse.getResponse().getCount() > 0) {
            retVal = statefulNodeGetApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static List<ApiStatefulNodeLogsResponse> getStatefulNodeLogs(StatefulNodeGetLogsRequest nodeLogsRequest, String nodeId, String authToken) {

        List<ApiStatefulNodeLogsResponse> getNodeLogs = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (nodeLogsRequest.getAccountId() != null) {
            queryParams.put("accountId", nodeLogsRequest.getAccountId());
        }

        // Add from date Query param
        if (nodeLogsRequest.getFromDate() != null) {
            queryParams.put("fromDate", nodeLogsRequest.getFromDate());
        }

        // Add to date Query param
        if (nodeLogsRequest.getToDate() != null) {
            queryParams.put("toDate", nodeLogsRequest.getToDate());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/%s/log", apiEndpoint, nodeId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        StatefulNodeGetLogsApiResponse
                castedApiResponse = getCastedResponse(response, StatefulNodeGetLogsApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            getNodeLogs = castedApiResponse.getResponse().getItems();
        }

        return getNodeLogs;

    }

    public static ApiStatefulNodeResourceResponse getNodeResources(String nodeId, String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNodeResourceResponse retVal = null;

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
        String uri = String.format("%s/azure/compute/statefulNode/%s/resources", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeGetResourcesApiResponse getNodeResourcesResponse =
                getCastedResponse(response, StatefulNodeGetResourcesApiResponse.class);

        if (getNodeResourcesResponse.getResponse().getCount() > 0) {
            retVal = getNodeResourcesResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static List<ApiStatefulNodeGetStatusResponse> getAllNodeStatus(String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiStatefulNodeGetStatusResponse> retVal = new LinkedList<>();

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
        String uri = String.format("%s/azure/compute/statefulNode/status", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        StatefulNodeApiGetStatusResponse nodeStatusApiResponse = getCastedResponse(response, StatefulNodeApiGetStatusResponse.class);

        if (nodeStatusApiResponse.getResponse().getItems().size() > 0) {
            retVal = nodeStatusApiResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiStatefulNodeAttachDataDiskResponse attachDataDisk(ApiStatefulNodeAttachDataDiskConfiguration attachDataDisk, String nodeId , String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiStatefulNodeAttachDataDiskResponse retVal = null;

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
        String body = JsonMapper.toJson(attachDataDisk);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/%s/dataDisk/attach", apiEndpoint, nodeId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        //Handle the response
        StatefulNodeAttachDataDiskApiResponse attachDiskApiResponse =
                getCastedResponse(response, StatefulNodeAttachDataDiskApiResponse.class);

        if (attachDiskApiResponse.getResponse().getCount() > 0) {
            retVal = attachDiskApiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static Boolean detachDataDisk(ApiStatefulNodeDetachDataDiskConfiguration detachDataDisk, String nodeId , String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        Boolean retVal = null;

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
        String body = JsonMapper.toJson(detachDataDisk);

        // Build URI
        String uri = String.format("%s/azure/compute/statefulNode/%s/dataDisk/detach", apiEndpoint, nodeId);

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