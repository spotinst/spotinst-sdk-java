package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.*;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScaleDownApiResponse;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScaleUpApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class SpotinstElastigroupServiceGcp extends BaseSpotinstService {

    public ApiElastigroupGcp createElastigroup(ApiElastigroupGcp groupToCreate, String authToken,
                                                        String account) throws SpotinstHttpException {
        // Init retVal
        ApiElastigroupGcp retVal = null;

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
        Map<String, ApiElastigroupGcp> groupRequest = new HashMap<>();
        groupRequest.put("group", groupToCreate);
        String body = JsonMapper.toJson(groupRequest);

        // Build URI
        String uri = String.format("%s/gcp/gce/group", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseGcp elastigroupApiResponse =
                getCastedResponse(response, ElastigroupApiResponseGcp.class);


        if (elastigroupApiResponse.getResponse().getCount() > 0) {
            retVal = elastigroupApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static Boolean deleteElastigroup(String elastigroupId, String authToken,
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
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/gcp/gce/group/%s", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }



    public static List<ApiElastigroupGcp> getAllGroups( String authToken,
                                                         String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiElastigroupGcp> retVal = new LinkedList<>();

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
        String uri = String.format("%s/gcp/gce/group", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseGcp allElastigroupsResponse =
                getCastedResponse(response, ElastigroupApiResponseGcp.class);

        if (allElastigroupsResponse.getResponse().getCount() > 0) {
            retVal = allElastigroupsResponse.getResponse().getItems();
        }

        return retVal;
    }


    public static Boolean updateGroup(String elastigroupId, ApiElastigroupGcp apiElastigroup, String authToken,
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
        String uri = String.format("%s/gcp/gce/group/%s", apiEndpoint, elastigroupId);

        // Write to json
        Map<String, ApiElastigroupGcp> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroup);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseGcp updateResponse = getCastedResponse(response, ElastigroupApiResponseGcp.class);

        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiElastigroupGcp getGroup(String elastigroupId, String authToken,
                                          String account) throws SpotinstHttpException {
        // Init retVal
        ApiElastigroupGcp retVal = new ApiElastigroupGcp();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for Gcp.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/gcp/gce/group/%s", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse getGroupResponse = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseGcp groupActiveInstanceResponse = getCastedResponse(getGroupResponse, ElastigroupApiResponseGcp.class);

        if (groupActiveInstanceResponse.getResponse().getCount() > 0) {
            retVal = groupActiveInstanceResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiGroupActiveInstanceStatusGcp> getGroupStatus(String elastigroupId, String authToken,
                                                                               String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiGroupActiveInstanceStatusGcp> retVal;

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
        String uri = String.format("%s/gcp/gce/group/%s/status", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupInstanceStatusApiResponseGcp groupInstanceHealthinessResponse =
                getCastedResponse(response, ElastigroupInstanceStatusApiResponseGcp.class);

        retVal = groupInstanceHealthinessResponse.getResponse().getItems();

        return retVal;
    }

    public static Boolean lockInstance(String authToken, String accountId, String ttlInMinutes, String instanceId) throws SpotinstHttpException {
        //Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        queryParams.put("accountId", accountId);
        queryParams.put("ttlInMinutes", ttlInMinutes);

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/gcp/gce/instance/%s/lock", apiEndpoint, instanceId);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean unlockInstance(String authToken, String accountId, String instanceId) throws SpotinstHttpException {
        //Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        queryParams.put("accountId", accountId);

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/gcp/gce/instance/%s/unlock", apiEndpoint, instanceId);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiElastigroupScaleUpResponseGcp> scaleUpGroup(String elastigroupId, String adjustment, String authToken,
                                                                String account) throws SpotinstHttpException {

        //Init retVal
        List<ApiElastigroupScaleUpResponseGcp> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("adjustment",adjustment);

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/gcp/gce/group/%s/scale/up", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        ElastigroupScaleUpApiResponse scalingResponseGcp =
                getCastedResponse(response, ElastigroupScaleUpApiResponse.class);
        if (scalingResponseGcp.getResponse().getCount() > 0) {
            retVal = scalingResponseGcp.getResponse().getItems();
        }

        return retVal;
    }

    public static List<ApiElastigroupScaleDownResponseGcp> scaleDownGroup(String elastigroupId, String adjustment, String authToken,
                                                                      String account) throws SpotinstHttpException {

        //Init retVal
        List<ApiElastigroupScaleDownResponseGcp> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("adjustment",adjustment);

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/gcp/gce/group/%s/scale/down", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        ElastigroupScaleDownApiResponse scalingResponseGcp =
                getCastedResponse(response, ElastigroupScaleDownApiResponse.class);
        if (scalingResponseGcp.getResponse().getCount() > 0) {
            retVal = scalingResponseGcp.getResponse().getItems();
        }

        return retVal;
    }


}
