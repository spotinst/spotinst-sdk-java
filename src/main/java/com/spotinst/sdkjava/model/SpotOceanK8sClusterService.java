package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.GetClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.UpdateRollRequest;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.GetClusterVNGNodesApiResponse;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.GetK8sClusterHeartBeatStatusApiResponse;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportAsgToClusterConfiguration;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sClusterFetchElastilogRequest;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.InitiateRollApiResponse;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.K8sClusterFetchElastilogApiResponse;
import org.apache.http.HttpStatus;

import java.util.*;

public class SpotOceanK8sClusterService extends BaseSpotinstService {

    public static ApiOceanK8sCluster createK8sCluster(ApiOceanK8sCluster clusterToCreate, String authToken,
                                                      String account) throws SpotinstHttpException {
        // Init retVal
        ApiOceanK8sCluster retVal = null;

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
        Map<String, ApiOceanK8sCluster> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", clusterToCreate);
        String body = JsonMapper.toJson(clusterRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ClusterApiResponse clusterApiResponse = getCastedResponse(response, ClusterApiResponse.class);


        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteK8sCluster(String clusterId, String authToken,
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
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateK8sCluster(String clusterId, ApiOceanK8sCluster apiCluster, String authToken,
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
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s", apiEndpoint, clusterId);

        // Write to json
        Map<String, ApiOceanK8sCluster> groupRequest = new HashMap<>();
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

    public static ApiOceanK8sCluster getK8sCluster(String clusterId, String authToken,
                                                   String account) throws SpotinstHttpException {
        // Init retVal
        ApiOceanK8sCluster retVal = new ApiOceanK8sCluster();

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
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ClusterApiResponse clusterApiResponse = getCastedResponse(response, ClusterApiResponse.class);

        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiOceanK8sCluster> getAllK8sClusters(String authToken, String account) {

        List<ApiOceanK8sCluster> getClustersResponse = new ArrayList<>();

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
        String uri = String.format("%s/ocean/aws/k8s/cluster", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ClusterApiResponse
                clusterApiResponse = getCastedResponse(response, ClusterApiResponse.class);

        if (clusterApiResponse.getResponse().getCount() > 0) {
            getClustersResponse = clusterApiResponse.getResponse().getItems();
        }

        return getClustersResponse;

    }

    public static ApiGetK8sClusterHeartBeatStatusResponse getK8sClusterHeartBeatStatus(String clusterId, String authToken, String account) {

        ApiGetK8sClusterHeartBeatStatusResponse getClusterHeartBeatResponse = null;

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

        GetK8sClusterHeartBeatStatusApiResponse
                clusterHeartBeatApiResponse = getCastedResponse(response, GetK8sClusterHeartBeatStatusApiResponse.class);

        if (clusterHeartBeatApiResponse.getResponse().getCount() > 0) {
            getClusterHeartBeatResponse = clusterHeartBeatApiResponse.getResponse().getItems().get(0);
        }

        return getClusterHeartBeatResponse;

    }

    public static ApiOceanK8sCluster importASGToOceanCluster(ImportAsgToClusterConfiguration importASGConfiguration, String autoScalingGroupName, String region, String authToken, String account) {

        ApiOceanK8sCluster importASGToOceanCluster = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add autoScalingGroupName Query param
        if (autoScalingGroupName != null) {
            queryParams.put("autoScalingGroupName", autoScalingGroupName);
        }

        // Add region Query param
        if (region != null) {
            queryParams.put("region", region);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ImportAsgToClusterConfiguration> importClusterRequest = new HashMap<>();
        importClusterRequest.put("cluster", importASGConfiguration);
        String body = JsonMapper.toJson(importClusterRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster/autoScalingGroup/import", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ClusterApiResponse
                importASGToClusterResponse = getCastedResponse(response, ClusterApiResponse.class);

        if (importASGToClusterResponse.getResponse().getCount() > 0) {
            importASGToOceanCluster = importASGToClusterResponse.getResponse().getItems().get(0);
        }

        return importASGToOceanCluster;

    }

    public static List<ApiK8sClusterFetchElastilogResponse> fetchElastilog(K8sClusterFetchElastilogRequest k8sClusterGetElastilogRequest, String clusterId, String authToken) {

        List<ApiK8sClusterFetchElastilogResponse> getElastilogResponse = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (k8sClusterGetElastilogRequest.getAccountId() != null) {
            queryParams.put("accountId", k8sClusterGetElastilogRequest.getAccountId());
        }

        // Add from date Query param
        if (k8sClusterGetElastilogRequest.getFromDate() != null) {
            queryParams.put("fromDate", k8sClusterGetElastilogRequest.getFromDate());
        }

        // Add limit Query param
        if (k8sClusterGetElastilogRequest.getLimit() != null) {
            queryParams.put("LIMIT", k8sClusterGetElastilogRequest.getLimit());
        }

        // Add resource Id Query param
        if (k8sClusterGetElastilogRequest.getResourceId() != null) {
            queryParams.put("resourceId", k8sClusterGetElastilogRequest.getResourceId());
        }

        // Add severity Query param
        if (k8sClusterGetElastilogRequest.getSeverity() != null) {
            queryParams.put("SEVERITY", k8sClusterGetElastilogRequest.getSeverity());
        }

        // Add to date Query param
        if (k8sClusterGetElastilogRequest.getToDate() != null) {
            queryParams.put("toDate", k8sClusterGetElastilogRequest.getToDate());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/log", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        K8sClusterFetchElastilogApiResponse
                castedApiResponse = getCastedResponse(response, K8sClusterFetchElastilogApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            getElastilogResponse = castedApiResponse.getResponse().getItems();
        }

        return getElastilogResponse;
    }

    public static ApiClusterRollResponse initiateRoll(ApiInitiateRoll initiateRollRequest, String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiClusterRollResponse retVal = null;

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
        Map<String, ApiInitiateRoll> rollRequest = new HashMap<>();
        rollRequest.put("roll", initiateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/roll", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        InitiateRollApiResponse initiateRollApiResponse =
                getCastedResponse(response, InitiateRollApiResponse.class);

        if (initiateRollApiResponse.getResponse().getCount() > 0) {
            retVal = initiateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiClusterRollResponse> listRolls(String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiClusterRollResponse> retVal = null;

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
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/roll", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        InitiateRollApiResponse listRollsResponse =
                getCastedResponse(response, InitiateRollApiResponse.class);

        if (listRollsResponse.getResponse().getCount() > 0) {
            retVal = listRollsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiClusterRollResponse getRoll(String clusterId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiClusterRollResponse retVal = null;

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
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/roll/%s", apiEndpoint, clusterId, rollId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        InitiateRollApiResponse getRollApiResponse =
                getCastedResponse(response, InitiateRollApiResponse.class);

        if (getRollApiResponse.getResponse().getCount() > 0) {
            retVal = getRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiClusterRollResponse updateRoll(UpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiClusterRollResponse retVal = null;

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
        Map<String, UpdateRollRequest> rollRequest = new HashMap<>();
        rollRequest.put("roll", updateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/roll/%s", apiEndpoint, clusterId, rollId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        InitiateRollApiResponse updateRollApiResponse =
                getCastedResponse(response, InitiateRollApiResponse.class);

        if (updateRollApiResponse.getResponse().getCount() > 0) {
            retVal = updateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean detachInstances(ApiDetachInstances instances, String clusterId, String authToken, String account) throws SpotinstHttpException {

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
        String body = JsonMapper.toJson(instances);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/detachInstances", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse =
                getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiGetClusterNodesResponse> getClusterNodes(GetClusterNodesRequest getClusterNodes, String clusterId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiGetClusterNodesResponse> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (getClusterNodes.getAccountId() != null) {
            queryParams.put("accountId", getClusterNodes.getAccountId());
        }

        // Add instanceId Query param
        if (getClusterNodes.getInstanceId() != null) {
            queryParams.put("instanceId", getClusterNodes.getInstanceId());
        }

        // Add launchSpecId Query param
        if (getClusterNodes.getLaunchSpecId() != null) {
            queryParams.put("launchSpecId", getClusterNodes.getLaunchSpecId());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/cluster/%s/nodes", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetClusterVNGNodesApiResponse getNodesResponse =
                getCastedResponse(response, GetClusterVNGNodesApiResponse.class);

        if (getNodesResponse.getResponse().getCount() > 0) {
            retVal = getNodesResponse.getResponse().getItems();
        }

        return retVal;
    }
}
