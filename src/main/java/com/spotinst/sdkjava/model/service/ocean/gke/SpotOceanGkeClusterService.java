package com.spotinst.sdkjava.model.service.ocean.gke;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiLaunchSpecSpecification;
import com.spotinst.sdkjava.model.responses.ocean.gke.OceanGkeLaunchSpecResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotOceanGkeClusterService extends BaseSpotinstService {

    public static ApiLaunchSpecSpecification createLaunchSpec(ApiLaunchSpecSpecification launchSpecToCreate, String authToken,
                                                              String account) throws SpotinstHttpException {
        // Init retVal
        ApiLaunchSpecSpecification retVal = null;

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
        Map<String, ApiLaunchSpecSpecification> groupRequest = new HashMap<>();
        groupRequest.put("launchSpec", launchSpecToCreate);
        String body = JsonMapper.toJson(groupRequest);

        // Build URI
        String uri = String.format("%s/ocean/gcp/k8s/launchSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        OceanGkeLaunchSpecResponse
                launchSpecCreateResponse = getCastedResponse(response, OceanGkeLaunchSpecResponse.class);


        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiLaunchSpecSpecification getLaunchSpec(String authToken,
                                                           String account, String OceanId) throws SpotinstHttpException {
        // Init retVal
        ApiLaunchSpecSpecification retVal = new ApiLaunchSpecSpecification();

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
        OceanGkeLaunchSpecResponse launchSpecCreateResponse =
                getCastedResponse(response, OceanGkeLaunchSpecResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiLaunchSpecSpecification> getAllLaunchSpec(String authToken,
                                                           String account,String oceanId) throws SpotinstHttpException {
        // Init retVal
        List<ApiLaunchSpecSpecification> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
            queryParams.put("oceanId",oceanId);
        }


        // Get the headers for Gcp.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/gcp/k8s/launchSpec", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        OceanGkeLaunchSpecResponse launchSpecCreateResponse =
                getCastedResponse(response, OceanGkeLaunchSpecResponse.class);

        if (launchSpecCreateResponse.getResponse().getCount() > 0) {
            retVal = launchSpecCreateResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateLaunchSpec(ApiLaunchSpecSpecification apiLaunchSpec, String launchSpecId, String authToken,
                                           String account) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = false;

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
        Map<String, ApiLaunchSpecSpecification> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", apiLaunchSpec);
        String body = JsonMapper.toJson(launchSpecRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        OceanGkeLaunchSpecResponse updateResponse = getCastedResponse(response, OceanGkeLaunchSpecResponse.class);
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
