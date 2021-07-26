package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.ApiElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpotinstOceanGKELaunchSpecService extends BaseSpotinstService {

    public static ApiOceanGKELaunchSpec createLaunchSpec(ApiOceanGKELaunchSpec launchSpecToCreate, String authToken,
                                                   String account) throws SpotinstHttpException {
        // Init retVal
        ApiOceanGKELaunchSpec retVal = null;

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
        Map<String, ApiOceanGKELaunchSpec> groupRequest = new HashMap<>();
        groupRequest.put("launchSpec", launchSpecToCreate);
        String body = JsonMapper.toJson(groupRequest);

        // Build URI
        String uri = String.format("%s/ocean/gcp/k8s/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        OceanGKECreateLaunchSpecResponse
                oceanGKECreateLaunchSpecRes = getCastedResponse(response, OceanGKECreateLaunchSpecResponse.class);


        if (oceanGKECreateLaunchSpecRes.getResponse().getCount() > 0) {
            retVal = oceanGKECreateLaunchSpecRes.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiOceanGKELaunchSpec getALaunchSpec(String authToken,
                                                       String account,String OceanId) throws SpotinstHttpException {
        // Init retVal
        ApiOceanGKELaunchSpec retVal = ApiOceanGKELaunchSpec.Builder.get().build();

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
        String uri = String.format("%s/ocean/gcp/k8s/launchSpec/%s", apiEndpoint,OceanId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        OceanGKECreateLaunchSpecResponse allLaunchSpecResponse =
                getCastedResponse(response, OceanGKECreateLaunchSpecResponse.class);

        if (allLaunchSpecResponse.getResponse().getCount() > 0) {
            retVal = allLaunchSpecResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean updateLaunchSpec(ApiOceanGKELaunchSpec apiLaunchSpec,String launchSpecId, String authToken,
                                      String account) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/gcp/k8s/launchSpec/%s", apiEndpoint, launchSpecId);

        // Write to json
        Map<String, ApiOceanGKELaunchSpec> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", apiLaunchSpec);
        String body = JsonMapper.toJson(launchSpecRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        OceanGKECreateLaunchSpecResponse updateResponse = getCastedResponse(response, OceanGKECreateLaunchSpecResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteLaunchSpec(String launchSpecId, String authToken,
                                            String account) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
            queryParams.put("deleteNodes","true");
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/ocean/gcp/k8s/launchSpec/%s", apiEndpoint, launchSpecId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }
}
