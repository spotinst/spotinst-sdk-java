package com.spotinst.sdkjava.model.service.ocean.ecs;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.ecs.*;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ImportEcsCluster;
import com.spotinst.sdkjava.model.requests.ocean.ecs.GetEcsClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsUpdateRollRequest;
import com.spotinst.sdkjava.model.responses.ocean.ecs.*;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpotOceanEcsClusterService extends BaseSpotinstService {
    public static ApiClusterLaunchSpecification createLaunchSpec (
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
        OceanEcsLaunchSpecApiResponse launchSpecCreateResponse =
                getCastedResponse(response, OceanEcsLaunchSpecApiResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean updateLaunchSpec(String oceanLaunchSpecId,
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
        OceanEcsLaunchSpecApiResponse launchUpdateResponse =
                getCastedResponse(response, OceanEcsLaunchSpecApiResponse.class);

        if (launchUpdateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }


    public static Boolean deleteLaunchSpec(String oceanLaunchSpecId, String authToken,
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

    public static ApiClusterLaunchSpecification getLaunchSpec(String oceanLaunchSpecId, String authToken,
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
        OceanEcsLaunchSpecApiResponse launchSpecCreateResponse =
                getCastedResponse(response, OceanEcsLaunchSpecApiResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiClusterLaunchSpecification> getAllLaunchSpec(String authToken,
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
        OceanEcsLaunchSpecApiResponse launchSpecCreateResponse =
                getCastedResponse(response, OceanEcsLaunchSpecApiResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiOceanEcsCluster createEcsCluster(ApiOceanEcsCluster clusterToCreate, String authToken,
                                                      String account) throws SpotinstHttpException {
        // Init retVal
        ApiOceanEcsCluster retVal = null;

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
        Map<String, ApiOceanEcsCluster> clusterRequest = new HashMap<>();
        clusterRequest.put("cluster", clusterToCreate);
        String body = JsonMapper.toJson(clusterRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/cluster", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        OceanEcsClusterApiResponse clusterApiResponse = getCastedResponse(response, OceanEcsClusterApiResponse.class);


        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }


    public static Boolean updateEcsCluster(String clusterId, ApiOceanEcsCluster apiCluster, String authToken,
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
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s", apiEndpoint, clusterId);

        // Write to json
        Map<String, ApiOceanEcsCluster> groupRequest = new HashMap<>();
        groupRequest.put("cluster", apiCluster);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        OceanEcsClusterApiResponse updateResponse = getCastedResponse(response, OceanEcsClusterApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiOceanEcsCluster getEcsCluster(String clusterId, String authToken,
                                                   String account) throws SpotinstHttpException {
        // Init retVal
        ApiOceanEcsCluster retVal = new ApiOceanEcsCluster();

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
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        OceanEcsClusterApiResponse clusterApiResponse = getCastedResponse(response, OceanEcsClusterApiResponse.class);

        if (clusterApiResponse.getResponse().getCount() > 0) {
            retVal = clusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }


    public static Boolean deleteEcsCluster(String clusterId, String authToken,
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
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s", apiEndpoint, clusterId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiOceanEcsCluster> getAllEcsCluster(String authToken,
                                                                       String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiOceanEcsCluster> retVal = new LinkedList<>();

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
        String uri = String.format("%s/ocean/aws/ecs/cluster", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        OceanEcsClusterApiResponse oceanEcsGetResponse =
                getCastedResponse(response, OceanEcsClusterApiResponse.class);

        if (oceanEcsGetResponse.getResponse().getCount() > 0) {
            retVal = oceanEcsGetResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiEcsClusterRollResponse initiateRoll(ApiEcsInitiateRoll initiateRollRequest, String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiEcsClusterRollResponse retVal = null;

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
        Map<String, ApiEcsInitiateRoll> rollRequest = new HashMap<>();
        rollRequest.put("roll", initiateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s/roll", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        EcsInitiateRollApiResponse initiateRollApiResponse =
                getCastedResponse(response, EcsInitiateRollApiResponse.class);

        if (initiateRollApiResponse.getResponse().getCount() > 0) {
            retVal = initiateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiEcsClusterRollResponse> listRolls(String clusterId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiEcsClusterRollResponse> retVal = null;

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
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s/roll", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        EcsInitiateRollApiResponse listRollsResponse =
                getCastedResponse(response, EcsInitiateRollApiResponse.class);

        if (listRollsResponse.getResponse().getCount() > 0) {
            retVal = listRollsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiEcsClusterRollResponse getRoll(String clusterId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiEcsClusterRollResponse retVal = null;

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
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s/roll/%s", apiEndpoint, clusterId, rollId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        EcsInitiateRollApiResponse getRollApiResponse =
                getCastedResponse(response, EcsInitiateRollApiResponse.class);

        if (getRollApiResponse.getResponse().getCount() > 0) {
            retVal = getRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiEcsClusterRollResponse updateRoll(OceanEcsUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiEcsClusterRollResponse retVal = null;

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
        Map<String, OceanEcsUpdateRollRequest> rollRequest = new HashMap<>();
        rollRequest.put("roll", updateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s/roll/%s", apiEndpoint, clusterId, rollId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        EcsInitiateRollApiResponse updateRollApiResponse =
                getCastedResponse(response, EcsInitiateRollApiResponse.class);

        if (updateRollApiResponse.getResponse().getCount() > 0) {
            retVal = updateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiGetEcsClusterNodesResponse> getClusterContainerInstances(GetEcsClusterNodesRequest getClusterNodes, String clusterId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiGetEcsClusterNodesResponse> retVal = null;

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
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s/containerInstances", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetEcsClusterContainerInstancesApiResponse getNodesResponse =
                getCastedResponse(response, GetEcsClusterContainerInstancesApiResponse.class);

        if (getNodesResponse.getResponse().getCount() > 0) {
            retVal = getNodesResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiImportOceanEcsClusterResponse importEcsCluster(ImportEcsCluster importEcsCluster, String ecsClusterName, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiImportOceanEcsClusterResponse retVal = null;

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
        Map<String, ImportEcsCluster> importEcsClusterRequest = new HashMap<>();
        importEcsClusterRequest.put("roll", importEcsCluster);
        String body = JsonMapper.toJson(importEcsClusterRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/ecs/cluster/%s/import", apiEndpoint, ecsClusterName);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ImportOceanEcsClusterApiResponse importOceanEcsClusterApiResponse = getCastedResponse(response, ImportOceanEcsClusterApiResponse.class);

        if (importOceanEcsClusterApiResponse.getResponse().getCount() > 0) {
            retVal = importOceanEcsClusterApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }
}