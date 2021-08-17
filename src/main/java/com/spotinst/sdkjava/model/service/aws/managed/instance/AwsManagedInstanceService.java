package com.spotinst.sdkjava.model.service.aws.managed.instance;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.aws.managed.instance.ApiManagedInstance;
import com.spotinst.sdkjava.model.responses.aws.managed.instance.AwsManagedInstanceApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AwsManagedInstanceService extends BaseSpotinstService {

    public static ApiManagedInstance createManagedInstance (ApiManagedInstance managedInstanceToCreate,
                                                       String authToken, String account) throws SpotinstHttpException {
        // Init retVal
        ApiManagedInstance retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiManagedInstance> managedInstanceCreateRequest = new HashMap<>();
        managedInstanceCreateRequest.put("managedInstance", managedInstanceToCreate);
        String body = JsonMapper.toJson(managedInstanceCreateRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceApiResponse managedInstanceCreateResponse =
                getCastedResponse(response, AwsManagedInstanceApiResponse.class);

        if (managedInstanceCreateResponse.getResponse().getCount() > 0) {
            retVal = managedInstanceCreateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean updateManagedInstance(String managedInstanceId, ApiManagedInstance managedInstanceToUpdate, String authToken,
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

        // Add managedInstanceId Query param
        if (managedInstanceId != null) {
            queryParams.put("MI_ID", managedInstanceId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiManagedInstance> managedInstanceUpdateRequest = new HashMap<>();
        managedInstanceUpdateRequest.put("managedInstance", managedInstanceToUpdate);
        String body = JsonMapper.toJson(managedInstanceUpdateRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceApiResponse managedInstanceUpdateResponse =
                getCastedResponse(response, AwsManagedInstanceApiResponse.class);

        if (managedInstanceUpdateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiManagedInstance getManagedInstance(String managedInstanceId, String authToken,
                                                              String account) throws SpotinstHttpException {
        // Init retVal
        ApiManagedInstance retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add managedInstanceId Query param
        if (managedInstanceId != null) {
            queryParams.put("MI_ID", managedInstanceId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceApiResponse managedInstanceGetResponse =
                getCastedResponse(response, AwsManagedInstanceApiResponse.class);

        if (managedInstanceGetResponse.getResponse().getCount() > 0) {
            retVal = managedInstanceGetResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiManagedInstance> getAllManagedInstance(String authToken,
                                                                       String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiManagedInstance> retVal = new LinkedList<>();

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
        String uri = String.format("%s/aws/ec2/managedInstance", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceApiResponse managedInstanceListResponse =
                getCastedResponse(response, AwsManagedInstanceApiResponse.class);

        if (managedInstanceListResponse.getResponse().getCount() > 0) {
            retVal = managedInstanceListResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean deleteManagedInstance(String managedInstanceId, String authToken,
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

        // Add managedInstanceId Query param
        if (managedInstanceId != null) {
            queryParams.put("MI_ID", managedInstanceId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean pauseManagedInstance(String managedInstanceId, String authToken,
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

        // Add managedInstanceId Query param
        if (managedInstanceId != null) {
            queryParams.put("MI_ID", managedInstanceId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s/pause", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean resumeManagedInstance(String managedInstanceId, String authToken,
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

        // Add managedInstanceId Query param
        if (managedInstanceId != null) {
            queryParams.put("MI_ID", managedInstanceId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s/resume", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean recycleManagedInstance(String managedInstanceId, String authToken,
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

        // Add managedInstanceId Query param
        if (managedInstanceId != null) {
            queryParams.put("MI_ID", managedInstanceId);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s/recycle", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }
}
