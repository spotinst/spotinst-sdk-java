package com.spotinst.sdkjava.model.service.aws.managedInstance;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.aws.managedInstance.*;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceDeletionRequest;
import com.spotinst.sdkjava.model.responses.aws.managedInstance.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AwsManagedInstanceService extends BaseSpotinstService {

    public static ApiManagedInstance createManagedInstance(ApiManagedInstance managedInstanceToCreate, String authToken,
                                                           String account) throws SpotinstHttpException {
        // Init isCreated
        ApiManagedInstance isCreated = null;

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
            isCreated = managedInstanceCreateResponse.getResponse().getItems().get(0);
        }

        return isCreated;
    }

    public static Boolean updateManagedInstance(String managedInstanceId, ApiManagedInstance managedInstanceToUpdate,
                                                String authToken, String account) throws SpotinstHttpException {
        // Init isUpdated
        Boolean isUpdated = false;

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
            isUpdated = true;
        }

        return isUpdated;
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

    public static List<APIGetAllManagedInstancesResponse> getAllManagedInstances(String authToken,
                                                                  String account) throws SpotinstHttpException {
        // Init retVal
        List<APIGetAllManagedInstancesResponse> retVal = new LinkedList<>();

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
        AwsManagedInstanceGetAllApiResponse managedInstanceListResponse =
                getCastedResponse(response, AwsManagedInstanceGetAllApiResponse.class);

        if (managedInstanceListResponse.getResponse().getCount() > 0) {
            retVal = managedInstanceListResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean deleteManagedInstance(AwsManagedInstanceDeletionRequest deletionRequest, String authToken,
                                                String account) throws SpotinstHttpException {
        // Init isDeleted
        Boolean isDeleted = false;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add managedInstanceId Query param
        if (deletionRequest.getManagedInstanceId() != null) {
            queryParams.put("MI_ID", deletionRequest.getManagedInstanceId());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s", apiEndpoint, deletionRequest.getManagedInstanceId());

        // Send the request
        RestResponse response = RestClient.sendDelete(uri, deletionRequest.toJson(), headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            isDeleted = true;
        }

        return isDeleted;
    }

    public static Boolean pauseManagedInstance(String managedInstanceId, String authToken, String account) throws SpotinstHttpException {
        // Init isPaused
        Boolean isPaused = false;

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
            isPaused = true;
        }

        return isPaused;
    }

    public static Boolean resumeManagedInstance(String managedInstanceId, String authToken, String account) throws SpotinstHttpException {
        // Init isResumed
        Boolean isResumed = false;

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
            isResumed = true;
        }

        return isResumed;
    }

    public static Boolean recycleManagedInstance(String managedInstanceId, String authToken, String account) throws SpotinstHttpException {
        // Init isrecycled
        Boolean isrecycled = false;

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
            isrecycled = true;
        }

        return isrecycled;
    }

    public static ApiGetStatus getManagedInstanceStatus(String managedInstanceId, String authToken,
                                                        String account) throws SpotinstHttpException {
        // Init status
        ApiGetStatus getStatus = null;

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
        String uri = String.format("%s/aws/ec2/managedInstance/%s/status", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceApiGetStatusResponse managedInstanceStatusResponse =
                getCastedResponse(response, AwsManagedInstanceApiGetStatusResponse.class);

        if (managedInstanceStatusResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            getStatus = managedInstanceStatusResponse.getResponse().getItems().get(0);
        }

        return getStatus;
    }

    public static ApiImportResponse importManagedInstance(ApiImport managedInstanceToImport, String authToken, String account) throws SpotinstHttpException {
        // Init isImported
        ApiImportResponse isImported = null;

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
        Map<String, ApiImport> managedInstanceImportRequest = new HashMap<>();
        managedInstanceImportRequest.put("migration", managedInstanceToImport);
        String body = JsonMapper.toJson(managedInstanceImportRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/migration", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceImportApiResponse managedInstanceImportResponse =
                getCastedResponse(response, AwsManagedInstanceImportApiResponse.class);

        if (managedInstanceImportResponse.getResponse().getCount() > 0) {
            isImported = managedInstanceImportResponse.getResponse().getItems().get(0);
        }

        return isImported;
    }

    public static ApiGetMigrationStatus getManagedInstanceMigrationStatus(String managedInstanceId, String authToken,
                                                                          String account) throws SpotinstHttpException {
        // Init status
        ApiGetMigrationStatus getMigrationStatus = null;

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
        String uri = String.format("%s/aws/ec2/managedInstance/migration/%s", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceGetMigrationStatusApiRespponse managedInstanceStatusResponse =
                getCastedResponse(response, AwsManagedInstanceGetMigrationStatusApiRespponse.class);

        if (managedInstanceStatusResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            getMigrationStatus = managedInstanceStatusResponse.getResponse().getItems().get(0);
        }

        return getMigrationStatus;
    }

    public static ApiGetInstanceCost getManagedInstanceCosts(String managedInstanceId, String fromDate, String toDate, String authToken,
                                                                          String account) throws SpotinstHttpException {
        // Init status
        ApiGetInstanceCost getInstanceCosts = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add fromDate Query param
        if (fromDate != null) {
            queryParams.put("fromDate", fromDate);
        }

        // Add toDate Query param
        if (toDate != null) {
            queryParams.put("toDate", toDate);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/%s/costs", apiEndpoint, managedInstanceId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceGetInstanceCostsApiRespponse managedInstanceStatusResponse =
                getCastedResponse(response, AwsManagedInstanceGetInstanceCostsApiRespponse.class);

        if (managedInstanceStatusResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            getInstanceCosts = managedInstanceStatusResponse.getResponse().getItems().get(0);
        }

        return getInstanceCosts;
    }

    public static Boolean deleteManagedInstanceVolume(String managedInstanceId, String volumeId, String authToken,
                                                              String account) throws SpotinstHttpException {
        // Init status
        Boolean isDeleteVolume = null;

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
        String uri = String.format("%s/aws/ec2/managedInstance/%s/volume/%s", apiEndpoint, managedInstanceId, volumeId);

        // Send the request
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            isDeleteVolume = true;
        }

        return isDeleteVolume;
    }

    public static Boolean updateManagedInstanceStates(String managedInstanceId, ApiManagedInstanceUpdate managedInstanceToUpdate,
                                                String authToken, String account) throws SpotinstHttpException {
        // Init isUpdated
        Boolean isStateUpdated = false;

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
        Map<String, ApiManagedInstanceUpdate> managedInstanceUpdateRequest = new HashMap<>();
        managedInstanceUpdateRequest.put("managedInstanceUpdate", managedInstanceToUpdate);
        String body = JsonMapper.toJson(managedInstanceUpdateRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/managedInstance/state", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        AwsManagedInstanceApiResponse managedInstanceUpdateResponse =
                getCastedResponse(response, AwsManagedInstanceApiResponse.class);

        if (managedInstanceUpdateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            isStateUpdated = true;
        }

        return isStateUpdated;
    }
}