package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import com.spotinst.sdkjava.model.api.ocean.aks.*;
import com.spotinst.sdkjava.model.requests.ocean.aks.AksUpdateRollRequest;
import com.spotinst.sdkjava.model.requests.ocean.aks.GetAksClusterNodesRequest;
import com.spotinst.sdkjava.model.responses.ocean.aks.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpotOceanAzureAksClusterService extends BaseSpotinstService {

    public static ApiClusterAks createAksCluster(ApiClusterAks clusterToCreate, String authToken,
                                                 String account) throws SpotinstHttpException {
        ApiClusterAks retVal = null;

        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiClusterAks> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", clusterToCreate);
        String body = JsonMapper.toJson(clusterRequest);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ClusterAksApiResponse clusterApiResponse = getCastedResponse(response, ClusterAksApiResponse.class);


        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteAksCluster(String clusterId, String authToken,
                                           String account) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateAksCluster(String clusterId, ApiClusterAks apiCluster, String authToken,
                                           String account) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s", apiEndpoint, clusterId);

        // Write to json
        Map<String, ApiClusterAks> groupRequest = new HashMap<>();
        groupRequest.put("cluster", apiCluster);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ClusterApiResponse updateResponse = getCastedResponse(response, ClusterApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiClusterAks getAksCluster(String clusterId, String authToken,
                                              String account) throws SpotinstHttpException {
        // Init retVal
        ApiClusterAks retVal = new ApiClusterAks();

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ClusterAksApiResponse clusterApiResponse = getCastedResponse(response, ClusterAksApiResponse.class);

        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiClusterAks> getAllClusters(String authToken,
                                                       String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiClusterAks> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }


        // Get the headers for Gcp.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ClusterAksApiResponse clusterApiResponse =
                getCastedResponse(response, ClusterAksApiResponse.class);

        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiGetAzureAksClusterHeartBeatStatusResponse getAzureAksClusterHeartBeatStatus(String clusterId, String authToken, String account) {

        ApiGetAzureAksClusterHeartBeatStatusResponse getClusterHeartBeatResponse = null;

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
        String uri = String.format("%s/ocean/k8s/cluster/%s/controllerHeartbeat", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        GetAzureAksClusterHeartBeatStatusApiResponse
                clusterHeartBeatApiResponse = getCastedResponse(response, GetAzureAksClusterHeartBeatStatusApiResponse.class);

        if (clusterHeartBeatApiResponse.getResponse().getCount() > 0) {
            getClusterHeartBeatResponse = clusterHeartBeatApiResponse.getResponse().getItems().get(0);
        }

        return getClusterHeartBeatResponse;

    }

    public static List<ApiGetAksClusterNodesResponse> getClusterNodes(GetAksClusterNodesRequest getClusterNodes, String clusterId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiGetAksClusterNodesResponse> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (getClusterNodes.getAccountId() != null) {
            queryParams.put("accountId", getClusterNodes.getAccountId());
        }

        // Add instanceId Query param
        if (getClusterNodes.getVirtualNodeGroupId() != null) {
            queryParams.put("virtualNodeGroupId", getClusterNodes.getVirtualNodeGroupId());
        }

        // Add launchSpecId Query param
        if (getClusterNodes.getVmName() != null) {
            queryParams.put("vmName", getClusterNodes.getVmName());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s/nodes", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetAksClusterNodesApiResponse getNodesResponse =
                getCastedResponse(response, GetAksClusterNodesApiResponse.class);

        if (getNodesResponse.getResponse().getCount() > 0) {
            retVal = getNodesResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static List<ApiAksDetachInstancesResponse> detachVms(ApiAksDetachInstances instances, String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiAksDetachInstancesResponse> retVal = null;

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
        String body = JsonMapper.toJson(instances);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s/detachVms", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        AksClusterDetachNodesApiResponse detachVmsResponse =
                getCastedResponse(response, AksClusterDetachNodesApiResponse.class);

        if (detachVmsResponse.getResponse().getCount() > 0) {
            retVal = detachVmsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiAksClusterRollResponse initiateRoll(ApiAksInitiateRoll initiateRollRequest, String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiAksClusterRollResponse retVal = null;

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
        Map<String, ApiAksInitiateRoll> rollRequest = new HashMap<>();
        rollRequest.put("roll", initiateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s/roll", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        AksInitiateRollApiResponse initiateRollApiResponse = getCastedResponse(response, AksInitiateRollApiResponse.class);

        if (initiateRollApiResponse.getResponse().getCount() > 0) {
            retVal = initiateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiAksClusterRollResponse updateRoll(AksUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiAksClusterRollResponse retVal = null;

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
        Map<String, AksUpdateRollRequest> rollRequest = new HashMap<>();
        rollRequest.put("roll", updateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s/roll/%s", apiEndpoint, clusterId, rollId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        AksInitiateRollApiResponse updateRollApiResponse = getCastedResponse(response, AksInitiateRollApiResponse.class);

        if (updateRollApiResponse.getResponse().getCount() > 0) {
            retVal = updateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiAksClusterRollResponse> listRolls(String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiAksClusterRollResponse> retVal = null;

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
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s/roll", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AksInitiateRollApiResponse listRollsResponse = getCastedResponse(response, AksInitiateRollApiResponse.class);

        if (listRollsResponse.getResponse().getCount() > 0) {
            retVal = listRollsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiAksClusterRollResponse getRoll(String clusterId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiAksClusterRollResponse retVal = null;

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
        String uri = String.format("%s/ocean/azure/k8s/cluster/%s/roll/%s", apiEndpoint, clusterId, rollId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AksInitiateRollApiResponse getRollApiResponse = getCastedResponse(response, AksInitiateRollApiResponse.class);

        if (getRollApiResponse.getResponse().getCount() > 0) {
            retVal = getRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiImportOceanClusterAksResponse importAksCluster(ApiImportOceanClusterAks oceanClusterImportRequest, String acdIdentifier, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiImportOceanClusterAksResponse retVal = null;

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
        Map<String, ApiImportOceanClusterAks> importRequest = new HashMap<>();
        importRequest.put("cluster", oceanClusterImportRequest);
        String body = JsonMapper.toJson(importRequest);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/cluster/aks/import/%s", apiEndpoint, acdIdentifier);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        AkImportClusterApiResponse importClusterApiResponse = getCastedResponse(response, AkImportClusterApiResponse.class);

        if (importClusterApiResponse.getResponse().getCount() > 0) {
            retVal = importClusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }
}
