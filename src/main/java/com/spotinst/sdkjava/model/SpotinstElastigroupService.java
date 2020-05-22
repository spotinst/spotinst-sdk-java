package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by aharontwizer on 7/27/15.
 */
class SpotinstElastigroupService extends BaseSpotinstService {

    public static ApiElastigroup createElastigroup(ApiElastigroup groupToCreate, String authToken,
                                                   String account) throws SpotinstHttpException {
        // Init retVal
        ApiElastigroup retVal = null;

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
        Map<String, ApiElastigroup> groupRequest = new HashMap<>();
        groupRequest.put("group", groupToCreate);
        String body = JsonMapper.toJson(groupRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/group", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse elastigroupApiResponse = getCastedResponse(response, ElastigroupApiResponse.class);


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
        String uri = String.format("%s/aws/ec2/group/" + elastigroupId, apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean detachInstances(String elastigroupId, ApiDetachInstancesRequest apiDetachInstancesRequest,
                                          String authToken, String account) throws SpotinstHttpException {
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

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/aws/ec2/group/%s/detachInstances", apiEndpoint, elastigroupId);

        // Write to json
        String body = JsonMapper.toJson(apiDetachInstancesRequest);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiElastigroupActiveInstance> getGroupActiveInstances(String elastigroupId, String authToken,
                                                                             String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiElastigroupActiveInstance> retVal = new LinkedList<>();

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

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/status", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupActiveInstanceApiResponse groupActiveInstanceResponse =
                getCastedResponse(response, ElastigroupActiveInstanceApiResponse.class);
        if (groupActiveInstanceResponse.getResponse().getItems().size() > 0) {
            retVal = groupActiveInstanceResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static List<ApiInstanceHealthiness> getInstanceHealthiness(String elastigroupId, String authToken,
                                                                      String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiInstanceHealthiness> retVal;

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
        String uri = String.format("%s/aws/ec2/group/%s/instanceHealthiness", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupInstanceHealthinessApiResponse groupInstanceHealthinessResponse =
                getCastedResponse(response, ElastigroupInstanceHealthinessApiResponse.class);

        retVal = groupInstanceHealthinessResponse.getResponse().getItems();

        return retVal;
    }

    public static ApiElastigroup getGroup(String elastigroupId, String authToken,
                                          String account) throws SpotinstHttpException {
        // Init retVal
        ApiElastigroup retVal = new ApiElastigroup();

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

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse groupActiveInstanceResponse = getCastedResponse(response, ElastigroupApiResponse.class);

        if (groupActiveInstanceResponse.getResponse().getCount() > 0) {
            retVal = groupActiveInstanceResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiElastigroup> getAllGroups(GroupFilter filter, String authToken,
                                                    String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiElastigroup> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        if (filter != null) {
            if (filter.getMaxCreatedAt() != null) {
                queryParams.put("maxCreatedAt", filter.getMaxCreatedAt());
            }

            if (filter.getMinCreatedAt() != null) {
                queryParams.put("minCreatedAt", filter.getMinCreatedAt());
            }

            if (filter.getActiveFrom() != null) {
                queryParams.put("activeFrom", filter.getActiveFrom());
            }

            if (filter.getActiveTo() != null) {
                queryParams.put("activeTo", filter.getActiveTo());
            }

            if (filter.getIncludeDeleted() != null) {
                queryParams.put("includeDeleted", filter.getIncludeDeleted().toString());
            }

            if (filter.getName() != null) {
                queryParams.put("name", filter.getName());
            }
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse allElastigroupsResponse = getCastedResponse(response, ElastigroupApiResponse.class);

        if (allElastigroupsResponse.getResponse().getCount() > 0) {
            retVal = allElastigroupsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateGroup(String elastigroupId, ApiElastigroup apiElastigroup, String authToken,
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
        String uri = String.format("%s/aws/ec2/group/%s", apiEndpoint, elastigroupId);

        // Write to json
        Map<String, ApiElastigroup> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroup);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse updateResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }


    public static ApiElastigroup cloneGroup(String sourceElastigroupId, ApiElastigroup apiGroupModifications, String authToken,
                                            String account) throws SpotinstHttpException {
        //Init retVal
        ApiElastigroup retVal;

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
        String uri = String.format("%s/aws/ec2/group/%s/clone", apiEndpoint, sourceElastigroupId);

        // Write to json
        Map<String, ApiElastigroup> groupRequest = new HashMap<>();
        groupRequest.put("group", apiGroupModifications);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse cloneResponse = getCastedResponse(response, ElastigroupApiResponse.class);

        retVal = cloneResponse.getResponse().getItems().get(0);

        return retVal;
    }

    public static Boolean enterGroupStandby(ElastigroupStandbyRequest standbyRequest, String authToken,
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
        String uri = String.format("%s/aws/ec2/group/%s/standby", apiEndpoint, standbyRequest.getElastigroupId());

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse updateResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean exitGroupStandby(ElastigroupStandbyRequest standbyRequest, String authToken,
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
        String uri = String.format("%s/aws/ec2/group/%s/standby", apiEndpoint, standbyRequest.getElastigroupId());

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse updateResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    /**
     * This function is the final step to scaling up your elastigroup. It takes in a scaling ElastigroupScalingRequest
     * object and build the queryParams, headers and uri to send as a Put request using the Module RestClient. The results
     * are returned unformatted
     *
     * @param scalingRequest ElastigroupScalingRequest Object send from SpotinstElastigroupRepo
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @return ApiElastigroupScalingResponse
     * @throws SpotinstHttpException
     */
    public static ApiElastigroupScalingResponse scaleGroupUp(ElastigroupScalingRequest scalingRequest, String authToken,
                                                             String account) throws SpotinstHttpException {

        //Init retVal
        ApiElastigroupScalingResponse retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("adjustment", scalingRequest.getAdjustment().toString());

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/scale/up", apiEndpoint, scalingRequest.getElastigroupId());

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        ApiElastigroupScalingResponseResponse scalingResponse =
                getCastedResponse(response, ApiElastigroupScalingResponseResponse.class);
        if (scalingResponse.getResponse().getItems().size() > 0) {
            retVal = scalingResponse.getResponse().getItems().get(0);
        }


        return retVal;
    }


    /**
     * This function is the final step to scaling down your elastigroup. It takes in a scaling ElastigroupScalingRequest
     * object and build the queryParams, headers and uri to send as a Put request using the Module RestClient. The results
     * are returned unformatted
     *
     * @param scalingRequest ElastigroupScalingRequest Object send from SpotinstElastigroupRepo
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @return ApiElastigroupScalingResponse
     * @throws SpotinstHttpException
     */
    public static ApiElastigroupScalingResponse scaleGroupDown(ElastigroupScalingRequest scalingRequest,
                                                               String authToken,
                                                               String account) throws SpotinstHttpException {

        //Init retVal
        ApiElastigroupScalingResponse retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("adjustment", scalingRequest.getAdjustment().toString());

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/scale/down", apiEndpoint, scalingRequest.getElastigroupId());

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        // Handle the response.
        ApiElastigroupScalingResponseResponse scalingResponse =
                getCastedResponse(response, ApiElastigroupScalingResponseResponse.class);
        if (scalingResponse.getResponse().getItems().size() > 0) {
            retVal = scalingResponse.getResponse().getItems().get(0);
        }


        return retVal;
    }

}
