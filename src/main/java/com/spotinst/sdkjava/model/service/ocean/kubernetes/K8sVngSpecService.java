package com.spotinst.sdkjava.model.service.ocean.kubernetes;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportEKSK8sVngSpec;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.LaunchNodesInVNG;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sImportClusterVngToOceanVngRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sVngDeleteRequest;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.K8sVngApiResponse;
import com.spotinst.sdkjava.model.responses.ocean.kubernetes.LaunchNodesInVngApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
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

    public static Boolean deleteK8sVng(K8sVngDeleteRequest vngDeletionRequest, String authToken,
                                       String account) throws SpotinstHttpException {

        String oceanLaunchSpecId = vngDeletionRequest.getOceanLaunchSpecId();

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

        // Add deleteNodes Query param
        if (vngDeletionRequest.getDeleteNodes() != null) {
            queryParams.put("deleteNodes", String.valueOf(vngDeletionRequest.getDeleteNodes()));
        }

        // Add forceDelete Query param
        if (vngDeletionRequest.getForceDelete() != null) {
            queryParams.put("forceDelete", String.valueOf(vngDeletionRequest.getForceDelete()));
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
	
	public static List<ApiK8sVngSpec> listK8sVng(String authToken, String account, String oceanId) throws SpotinstHttpException {
		
        // Init retVal
        List<ApiK8sVngSpec> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        if (oceanId != null) {
            queryParams.put("oceanId", oceanId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse vngCreateResponse =
                getCastedResponse(response, K8sVngApiResponse.class);

        if (vngCreateResponse.getResponse().getCount() > 0) {
            retVal = vngCreateResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiK8sVngSpec importASGToVng(ApiK8sVngSpec importASGRequest, String autoScalingGroupName, String oceanId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiK8sVngSpec retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add autoScalingGroupName Query param
        if (autoScalingGroupName != null) {
            queryParams.put("autoScalingGroupName", autoScalingGroupName);
        }

        // Add ocean Id Query param
        if (oceanId != null) {
            queryParams.put("oceanId", oceanId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiK8sVngSpec> importRequest = new HashMap<>();
        importRequest.put("launchSpec", importASGRequest);
        String body = JsonMapper.toJson(importRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec/autoScalingGroup/import", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse importASGToVngResponse =
                getCastedResponse(response, K8sVngApiResponse.class);

        if (importASGToVngResponse.getResponse().getCount() > 0) {
            retVal = importASGToVngResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiK8sVngSpec importClusterVngToOceanVng(K8sImportClusterVngToOceanVngRequest importClusterVngRequest, String authToken) throws SpotinstHttpException {

        // Init retVal
        ApiK8sVngSpec retVal = null;

        ImportEKSK8sVngSpec importAsgToVng = importClusterVngRequest.getVngLaunchSpec();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (importClusterVngRequest.getAccountId() != null) {
            queryParams.put("accountId", importClusterVngRequest.getAccountId());
        }

        // Add autoScalingGroupName Query param
        if (importClusterVngRequest.getEksClusterName() != null) {
            queryParams.put("eksClusterName", importClusterVngRequest.getEksClusterName());
        }

        // Add autoScalingGroupName Query param
        if (importClusterVngRequest.getEksNodeGroupName() != null) {
            queryParams.put("eksNodeGroupName", importClusterVngRequest.getEksNodeGroupName());
        }

        // Add ocean Id Query param
        if (importClusterVngRequest.getOceanId() != null) {
            queryParams.put("oceanId", importClusterVngRequest.getOceanId());
        }

        // Add ocean Id Query param
        if (importClusterVngRequest.getRegion() != null) {
            queryParams.put("region", importClusterVngRequest.getRegion());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ImportEKSK8sVngSpec> importRequest = new HashMap<>();
        importRequest.put("launchSpec", importAsgToVng);
        String body = JsonMapper.toJson(importRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec/eksNodeGroup/import", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        K8sVngApiResponse importClusterVngToOceanVngResponse =
                getCastedResponse(response, K8sVngApiResponse.class);

        if (importClusterVngToOceanVngResponse.getResponse().getCount() > 0) {
            retVal = importClusterVngToOceanVngResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiLaunchNodesInVNGResponse> launchNodesInVNG(LaunchNodesInVNG launchNodes, String vngId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiLaunchNodesInVNGResponse> retVal = null;

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
        Map<String, LaunchNodesInVNG> launchNodesRequest = new HashMap<>();
        launchNodesRequest.put("launchRequest", launchNodes);
        String body = JsonMapper.toJson(launchNodesRequest);

        // Build URI
        String uri = String.format("%s/ocean/aws/k8s/launchSpec/%s/launchNodes", apiEndpoint, vngId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        LaunchNodesInVngApiResponse launchNodesResponse =
                getCastedResponse(response, LaunchNodesInVngApiResponse.class);

        if (launchNodesResponse.getResponse().getCount() > 0) {
            retVal = launchNodesResponse.getResponse().getItems();
        }

        return retVal;
    }

}