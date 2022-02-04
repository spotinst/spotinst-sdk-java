package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiUpdateCapacityAzure;
import com.spotinst.sdkjava.model.api.gcp.*;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupUpdateCapacityConfigurationGcp_old;
import com.spotinst.sdkjava.model.bl.gcp.UpdateCapacityGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.azure.UpdateCapacityRequestAzure;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.UpdateCapacityRequestGcp;
import com.spotinst.sdkjava.model.responses.elastigroup.aws.ElastigroupUpdateCapacityApiResponse;
import com.spotinst.sdkjava.model.responses.elastigroup.azure.v3.UpdateCapacityApiResponseAzure;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScaleDownApiResponse;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScaleUpApiResponse;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupUpdateCapacityApiResponseGcp;
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

    public static List<ApiElastigroupGcp> getAllGroups(GroupFilter filter, String authToken,
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

        // Get the headers for Azure.
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

    public static Boolean updateCapacity(UpdateCapacityRequestGcp request,
                                         String authToken, String account) {
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
        String uri = String.format("%s/gcp/gce/group/%s", apiEndpoint, request.getGroupId());

        // Write to json
        Map<String, UpdateCapacityGcp> groupRequest = new HashMap<>();
        groupRequest.put("capacity", request.getCapacityGcp());
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupUpdateCapacityApiResponseGcp
                castedApiResponse = getCastedResponse(response, ElastigroupUpdateCapacityApiResponseGcp.class);

        if (castedApiResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

//    public static Boolean updateCapacity(String groupId, ElastigroupUpdateCapacityConfigurationGcp_old request,
//                                         String authToken, String account) {
//
//        Boolean retVal = null;
//
//        // Get endpoint
//        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
//        String             apiEndpoint = config.getEndpoint();
//
//        // Build query params
//        Map<String, String> queryParams = new HashMap<>();
//
//        // Add account Id Query param
//        if (account != null) {
//            queryParams.put("accountId", account);
//        }
//
//        // Get the headers
//        Map<String, String> headers = buildHeaders(authToken);
//
//        // Build URI
//        String uri = String.format("%s/gcp/gce/group/%s/capacity", apiEndpoint, groupId);
//
//        // Write to json
//        Map<String, ElastigroupUpdateCapacityConfigurationGcp_old> groupRequest = new HashMap<>();
//        groupRequest.put("capacity", request);
//        String body = JsonMapper.toJson(groupRequest);
//
//        // Send the request.
//        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);
//
//        // Handle the response.
//
//        ElastigroupUpdateCapacityApiResponseGcp
//                castedApiResponse = getCastedResponse(response, ElastigroupUpdateCapacityApiResponseGcp.class);
//
//        if (castedApiResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
//            retVal = true;
//        }
//
//        return retVal;
//
//    }

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
        ElastigroupApiResponseGcp lockResponse = getCastedResponse(response, ElastigroupApiResponseGcp.class);
        if (lockResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
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
        ElastigroupApiResponseGcp unlockResponse = getCastedResponse(response, ElastigroupApiResponseGcp.class);
        if (unlockResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    /*
     * This function is the final step to scaling up your elastigroup.  headers and uri, other parameters to send as a Put request using the Module RestClient. The results
     * are returned unformatted
     *
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @param elastigroupId  ELastigroup ID
     * @param adjustment     adjustment
     * @return ApiElastigroupScalingResponseGcp
     * @throws SpotinstHttpException
     */
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
