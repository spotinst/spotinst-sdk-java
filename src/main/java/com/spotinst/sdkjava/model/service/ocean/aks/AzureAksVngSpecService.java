package com.spotinst.sdkjava.model.service.ocean.aks;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterVirtualNodeGroup;
import com.spotinst.sdkjava.model.responses.ocean.aks.AzureAksVngApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AzureAksVngSpecService extends BaseSpotinstService {
    public static ApiClusterVirtualNodeGroup createAksVng(ApiClusterVirtualNodeGroup vngToCreate, String authToken,
                                                          String account) throws SpotinstHttpException {
        ApiClusterVirtualNodeGroup retVal = null;

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
        Map<String, ApiClusterVirtualNodeGroup> vngRequest = new HashMap<>();
        vngRequest.put("virtualNodeGroup", vngToCreate);
        String body = JsonMapper.toJson(vngRequest);

        // Build URI
        String uri = String.format("%s/ocean/azure/k8s/virtualNodeGroup", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        AzureAksVngApiResponse vngApiResponse =
                getCastedResponse(response, AzureAksVngApiResponse.class);

        if (vngApiResponse.getResponse().getCount() > 0) {
            retVal = vngApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteAksVng(String aksVNGId, String authToken,
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
        String uri = String.format("%s/ocean/azure/k8s/virtualNodeGroup/%s", apiEndpoint, aksVNGId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateAksVng(String aksVNGId, ApiClusterVirtualNodeGroup vngToUpdate, String authToken,
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
        String uri = String.format("%s/ocean/azure/k8s/virtualNodeGroup/%s", apiEndpoint, aksVNGId);

        // Write to json
        Map<String, ApiClusterVirtualNodeGroup> groupRequest = new HashMap<>();
        groupRequest.put("virtualNodeGroup", vngToUpdate);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        AzureAksVngApiResponse updateResponse = getCastedResponse(response, AzureAksVngApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiClusterVirtualNodeGroup getAksVng(String aksVNGId, String authToken,
                                          String account) throws SpotinstHttpException {
        // Init retVal
        ApiClusterVirtualNodeGroup retVal = new ApiClusterVirtualNodeGroup();

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
        String uri = String.format("%s/ocean/azure/k8s/virtualNodeGroup/%s", apiEndpoint, aksVNGId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AzureAksVngApiResponse vngApiResponse = getCastedResponse(response, AzureAksVngApiResponse.class);

        if (vngApiResponse.getResponse().getCount() > 0) {
            retVal = vngApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

	public static List<ApiClusterVirtualNodeGroup> listAksVng(String authToken, String account, String oceanId) throws SpotinstHttpException {

        // Init retVal
        List<ApiClusterVirtualNodeGroup> retVal = new LinkedList<>();

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
        String uri = String.format("%s/ocean/azure/k8s/virtualNodeGroup", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AzureAksVngApiResponse vngCreateResponse =
                getCastedResponse(response, AzureAksVngApiResponse.class);

        if (vngCreateResponse.getResponse().getCount() > 0) {
            retVal = vngCreateResponse.getResponse().getItems();
        }

        return retVal;
    }

}