package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiGetK8sClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiOceanK8sCluster;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.GetK8sClusterHeartBeatStatusApiResponse;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
