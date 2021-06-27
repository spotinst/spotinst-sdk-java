package com.spotinst.sdkjava.model;
//TRY here

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpotStorageAzureVolumeService extends BaseSpotinstService {

    public static ApiAzureStorageVolume createVolume(ApiAzureStorageVolume volumeToCreate, String authToken,
                                                     String account) throws SpotinstHttpException {
        ApiAzureStorageVolume retVal = null;

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiAzureStorageVolume> volumeRequest = new HashMap<>();
        volumeRequest.put("volume", volumeToCreate);
        String body = JsonMapper.toJson(volumeRequest);

        // Build URI
        String uri = String.format("%s/azure/storage/volume", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        VolumeApiResponse volumeApiResponse = getCastedResponse(response, VolumeApiResponse.class);


        if (volumeApiResponse.getResponse().getCount() > 0) {
            retVal = volumeApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteVolume(String volumeId, String authToken, String account) throws SpotinstHttpException {

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
        String uri = String.format("%s/azure/storage/volume/%s", apiEndpoint, volumeId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

//    TODO yael: does this return only a boolean? - done
    public static Boolean updateVolume(String volumeId, ApiAzureStorageVolume apiAzureStorageVolume, String authToken,
                                       String account) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = false;

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
        String uri = String.format("%s/azure/storage/volume/%s", apiEndpoint, volumeId);

        // Write to json
//        TODO yael: variable name - done
        Map<String, ApiAzureStorageVolume> volumeRequest = new HashMap<>();
        volumeRequest.put("volume", apiAzureStorageVolume);
        String body = JsonMapper.toJson(volumeRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        VolumeApiResponse updateResponse = getCastedResponse(response, VolumeApiResponse.class);

        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiAzureStorageVolume getVolume(String volumeId, String authToken,
                                                  String account) throws SpotinstHttpException {
        // Init retVal
        ApiAzureStorageVolume retVal = new ApiAzureStorageVolume();

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
        String uri = String.format("%s/azure/storage/volume/%s", apiEndpoint, volumeId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        VolumeApiResponse volumeApiResponse = getCastedResponse(response, VolumeApiResponse.class);

        if (volumeApiResponse.getResponse().getCount() > 0) {
            retVal = volumeApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiAzureStorageVolume> getAllVolumes(String authToken,
                                                            String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiAzureStorageVolume> retVal = new LinkedList<>();

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
        String uri = String.format("%s/azure/storage/volume", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        VolumeApiResponse volumeApiResponse = getCastedResponse(response, VolumeApiResponse.class);

        if (volumeApiResponse.getResponse().getCount() > 0) {
            retVal = volumeApiResponse.getResponse().getItems();
        }

        return retVal;
    }
}
