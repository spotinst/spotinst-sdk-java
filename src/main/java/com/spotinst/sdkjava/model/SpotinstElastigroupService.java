package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.elastigroup.aws.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceUnLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.*;
import com.spotinst.sdkjava.model.responses.elastigroup.aws.*;
import org.apache.http.HttpStatus;

import java.util.*;

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

        Map<String, String> queryParams = new HashMap<>();

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

        Map<String, String> queryParams = new HashMap<>();

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


        Map<String, String> queryParams = new HashMap<>();

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

        Map<String, String> queryParams = new HashMap<>();

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

        Map<String, String> queryParams = new HashMap<>();

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
        Map<String, String> queryParams = new HashMap<>();

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


    public static ApiElastigroup cloneGroup(String sourceElastigroupId, ApiElastigroup apiGroupModifications,
                                            String authToken, String account) throws SpotinstHttpException {
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

    public static Boolean lockInstance(ElastigroupInstanceLockRequest lockRequest,
                                       String authToken, String instanceId) throws SpotinstHttpException {
        //Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        queryParams.put("accountId", lockRequest.getAccountId());
        queryParams.put("ttlInMinutes", lockRequest.getTtlInMinutes().toString());

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/instance/%s/lock", apiEndpoint, instanceId);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse lockResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (lockResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean unlockInstance(ElastigroupInstanceUnLockRequest unlockRequest,
                                         String authToken, String instanceId) throws SpotinstHttpException {
        //Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        queryParams.put("accountId", unlockRequest.getAccountId());

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/instance/%s/unlock", apiEndpoint, instanceId);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse unlockResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (unlockResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean simulateInstanceInterruption(String authToken, String account, List<String> instanceIds) throws SpotinstHttpException {
        //Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        queryParams.put("accountId", account);

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/instance/interruption", apiEndpoint);

        // Write to json
        Map<String, List<String>> instancesToInterrupt = new HashMap<>();
        instancesToInterrupt.put("instancesToInterrupt", instanceIds);
        String body = JsonMapper.toJson(instancesToInterrupt);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse interruptionResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (interruptionResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean enterInstanceStandby(String instanceId, String authToken,
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
        String uri = String.format("%s/aws/ec2/instance/%s/standby/enter", apiEndpoint, instanceId);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean exitInstanceStandby(String instanceId, String authToken,
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
        String uri = String.format("%s/aws/ec2/instance/%s/standby/exit", apiEndpoint, instanceId);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
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
        Map<String, String> queryParams = new HashMap<>();
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
        Map<String, String> queryParams = new HashMap<>();
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

    public static ApiSuspendedProcesses suspendProcesses(String groupId, ApiSuspendProcessesRequest request,
                                                         String authToken, String account) {
        ApiSuspendedProcesses retVal;

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
        String uri = String.format("%s/aws/ec2/group/%s/suspension", apiEndpoint, groupId);

        // Write to json
        String body = JsonMapper.toJson(request);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupSuspendedProcessesApiResponse castedResponse =
                getCastedResponse(response, ElastigroupSuspendedProcessesApiResponse.class);

        retVal = castedResponse.getResponse().getItems().get(0);

        return retVal;
    }

    public static ApiSuspendedProcesses removeSuspensions(String groupId, ApiRemoveSuspensionsRequest request,
                                                          String authToken, String account) {
        ApiSuspendedProcesses retVal;
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
        String uri = String.format("%s/aws/ec2/group/%s/suspension", apiEndpoint, groupId);

        // Write to json
        String body = JsonMapper.toJson(request);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupSuspendedProcessesApiResponse castedResponse =
                getCastedResponse(response, ElastigroupSuspendedProcessesApiResponse.class);

        //When no remaining suspensions, items will be null
        if (castedResponse.getResponse().getCount() > 0) {
            retVal = castedResponse.getResponse().getItems().get(0);
        }
        else {
            retVal = new ApiSuspendedProcesses(groupId);
        }

        return retVal;
    }

    public static ApiSuspendedProcesses getSuspendedProcesses(String elastigroupId, String authToken, String account) {
        ApiSuspendedProcesses retVal;
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
        String uri = String.format("%s/aws/ec2/group/%s/suspension", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupSuspendedProcessesApiResponse castedResponse =
                getCastedResponse(response, ElastigroupSuspendedProcessesApiResponse.class);

        //When no remaining suspensions, items will be null
        if (castedResponse.getResponse().getCount() > 0) {
            retVal = castedResponse.getResponse().getItems().get(0);
        }
        else {
            retVal = new ApiSuspendedProcesses(elastigroupId);
        }

        return retVal;
    }

    public static Boolean deleteElastigroup(String elastigroupId, String authToken, String account,
                                            ApiDeleteGroupRequest deleteRequest) {
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        String body = null;

        if (deleteRequest != null) {
            body = JsonMapper.toJson(deleteRequest);
        }

        Map<String, String> headers  = buildHeaders(authToken);
        String              uri      = String.format("%s/aws/ec2/group/" + elastigroupId, apiEndpoint);
        RestResponse        response = RestClient.sendDelete(uri, body, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        return true;
    }

    public static ApiSuspendedScalingPolicy suspendScalingPolicies(String elastiGroupId, String policyName,
                                                                   ApiScalingPolicySuspension suspension,
                                                                   String authToken,
                                                                   String account) throws SpotinstHttpException {
        ApiSuspendedScalingPolicy retVal;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if ((account != null) && (policyName != null)) {
            queryParams.put("accountId", account);
            queryParams.put("policyName", policyName);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/scale/suspendPolicy", apiEndpoint, elastiGroupId);

        // Write to json
        Map<String, ApiScalingPolicySuspension> suspensionRequest = new HashMap<>();
        suspensionRequest.put("suspension", suspension);
        String body = JsonMapper.toJson(suspensionRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupSuspendScalingPoliciesApiResponse castedResponse =
                getCastedResponse(response, ElastigroupSuspendScalingPoliciesApiResponse.class);

        retVal = castedResponse.getResponse().getItems().get(0);

        return retVal;
    }

    public static ApiSuspendedScalingPoliciesList getSuspendedScalingPolicies(String elastiGroupId, String authToken,
                                                                              String account) throws SpotinstHttpException {
        ApiSuspendedScalingPoliciesList retVal = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/scale/suspensions", apiEndpoint, elastiGroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupSuspendScalingPoliciesListApiResponse getResponse =
                getCastedResponse(response, ElastigroupSuspendScalingPoliciesListApiResponse.class);

        if (getResponse.getResponse().getCount() > 0) {
            retVal = getResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static Boolean removeSuspendScalingPolicies(String elastiGroupId, String policyName, String authToken,
                                                       String account) throws SpotinstHttpException {

        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if ((account != null) && (policyName != null)) {
            queryParams.put("accountId", account);
            queryParams.put("policyName", policyName);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/scale/resumePolicy", apiEndpoint, elastiGroupId);

        // Send the request.
        RestResponse             response      = RestClient.sendPost(uri, null, headers, queryParams);
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }
        return retVal;
    }

    public static ApiElastigroupStartDeploymentResponse startDeployment(String groupId, ElastigroupStartDeployment request,
                                                                        String authToken, String account) {

        ApiElastigroupStartDeploymentResponse startDeployment = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/roll", apiEndpoint, groupId);

        // Write to json
        String body = JsonMapper.toJson(request);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupStartDeploymentApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupStartDeploymentApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0){
            startDeployment = castedApiResponse.getResponse().getItems().get(0);
        }

        return startDeployment;

    }

    public static ApiElastigroupStopDeploymentResponse stopDeployment(
            ElastigroupStopDeploymentRequest stopDeploymentRequest, String elastiGroupId, String deploymentId,
            String authToken, String account) throws SpotinstHttpException {

        ApiElastigroupStopDeploymentResponse stopDeployment = null;

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

        //Build URI
        String uri = String.format("%s/aws/ec2/group/%s/roll/%s", apiEndpoint, elastiGroupId, deploymentId);

        // Write to json
        String body = JsonMapper.toJson(stopDeploymentRequest);

        //send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        //Handle the response
        ElastigroupStopDeploymentApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupStopDeploymentApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0){
            stopDeployment = castedApiResponse.getResponse().getItems().get(0);
        }

        return stopDeployment;
    }

    public static ApiElastigroupGetDeploymentStatusResponse getDeploymentStatus(String groupId, String deploymentId,
                                                                                String authToken, String account) {

        ApiElastigroupGetDeploymentStatusResponse getDeploymentStatus = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/roll/%s/status", apiEndpoint, groupId, deploymentId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupGetDeploymentStatusApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupGetDeploymentStatusApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0){
            getDeploymentStatus = castedApiResponse.getResponse().getItems().get(0);
        }

        return getDeploymentStatus;

    }

    public static List<ApiElastigroupGetGroupDeploymentStatusResponse> getGroupDeploymentStatus(String groupId, String authToken, String account) {

        List<ApiElastigroupGetGroupDeploymentStatusResponse> getGroupDeploymentStatus = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/roll", apiEndpoint, groupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupGetGroupDeploymentStatusApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupGetGroupDeploymentStatusApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0){
            getGroupDeploymentStatus = castedApiResponse.getResponse().getItems();
        }

        return getGroupDeploymentStatus;

    }

    public static ApiElastigroupGetDeploymentActionResponse applyDeploymentAction(
            ElastigroupDeploymentStrategyOnFailure getDeploymentActionRequest, String groupId, String deploymentId , String authToken, String account) {


        ApiElastigroupGetDeploymentActionResponse getDeploymentActionStatus = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/roll/%s/action", apiEndpoint, groupId, deploymentId);

        // Write to json
        String body = JsonMapper.toJson(getDeploymentActionRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupGetDeploymentActionApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupGetDeploymentActionApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0){
            getDeploymentActionStatus = castedApiResponse.getResponse().getItems().get(0);
        }

        return getDeploymentActionStatus;

    }

    public static List<ApiItfMigrationRulesStatus> getItfMigrationRulesStatus(String elastiGroupId, String authToken,
                                                                              String account) throws SpotinstHttpException {
        List<ApiItfMigrationRulesStatus> retVal = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/itf/migration", apiEndpoint, elastiGroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupItfMigrationListApiResponse getResponse =
                getCastedResponse(response, ElastigroupItfMigrationListApiResponse.class);

        if (getResponse.getResponse().getCount() > 0) {
            retVal = getResponse.getResponse().getItems();
        }
        return retVal;
    }

    public static Boolean retryItfMigration(String groupId, ApiRetryItfMigrationRequest retryRequest,
                                            String authToken, String account) throws SpotinstHttpException {
        //Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        queryParams.put("accountId", account);

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiItfMigrationRulesStatus> migrationRetry = new HashMap<>();
        migrationRetry.put("migration", retryRequest.getMigration());
        String body = JsonMapper.toJson(migrationRetry);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/itf/migration/%s", apiEndpoint, groupId, retryRequest.getId());

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponse retryResponse = getCastedResponse(response, ElastigroupApiResponse.class);
        if (retryResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateCapacity(String groupId, ElastigroupUpdateCapacityConfiguration request,
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
        String uri = String.format("%s/aws/ec2/group/%s/capacity", apiEndpoint, groupId);

        // Write to json
        Map<String, ElastigroupUpdateCapacityConfiguration> groupRequest = new HashMap<>();
        groupRequest.put("capacity", request);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupUpdateCapacityApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupUpdateCapacityApiResponse.class);

        if (castedApiResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;

    }

    public static ApiElastigroup importEC2Instance(ElastigroupImportEC2Instance request, String instanceId, String region,
                                                   String authToken, String account) {

        ApiElastigroup retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add instance Id Query param
        if (instanceId != null) {
            queryParams.put("instanceId", instanceId);
        }

        // Add region Query param
        if (region != null) {
            queryParams.put("region", region);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/instance/import", apiEndpoint);

        // Write to json
        Map<String, ElastigroupImportEC2Instance> groupRequest = new HashMap<>();
        groupRequest.put("group", request);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            retVal = castedApiResponse.getResponse().getItems().get(0);
        }

        return retVal;

    }

    public static Boolean pauseStatefulInstance(String groupId, String statefulInstanceId,
                                                String authToken, String account) {

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
        String uri = String.format("%s/aws/ec2/group/%s/statefulInstance/%s/pause", apiEndpoint, groupId, statefulInstanceId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        // Handle the response.
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;

    }

    public static Boolean resumeStatefulInstance(String groupId, String statefulInstanceId,
                                                 String authToken, String account) {

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
        String uri = String.format("%s/aws/ec2/group/%s/statefulInstance/%s/resume", apiEndpoint, groupId, statefulInstanceId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        // Handle the response.
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;

    }

    public static Boolean recycleStatefulInstance(String groupId, String statefulInstanceId,
                                                  String authToken, String account) {

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
        String uri = String.format("%s/aws/ec2/group/%s/statefulInstance/%s/recycle", apiEndpoint, groupId, statefulInstanceId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        // Handle the response.
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;

    }

    public static Boolean deallocateStatefulInstance(String groupId, String statefulInstanceId,
                                                     String authToken, String account) {

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
        String uri = String.format("%s/aws/ec2/group/%s/statefulInstance/%s/deallocate", apiEndpoint, groupId, statefulInstanceId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        // Handle the response.
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;

    }

    public static List<ApiElastigroupListStatefulInstancesResponse> listStatefulInstances(String elastigroupId, String authToken, String account) {

        List<ApiElastigroupListStatefulInstancesResponse> statefulInstancesList = new LinkedList<>();

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
        String uri = String.format("%s/aws/ec2/group/%s/statefulInstance", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupListStatefulInstancesApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupListStatefulInstancesApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            statefulInstancesList = castedApiResponse.getResponse().getItems();
        }

        return statefulInstancesList;

    }

    public static Boolean deleteVolumeInStatefulInstance(String groupId, String statefulInstanceId, String volumeId, String authToken, String account) {

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
        String uri = String.format("%s/aws/ec2/group/%s/statefulInstance/%s/volume/%s", apiEndpoint, groupId, statefulInstanceId, volumeId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        // Handle the response.
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;

    }

    public static List<ApiElastigroupGetElastilogResponse> getElastilog(ElastigroupGetElastilogRequest elastigroupGetElastilogRequest, String elastigroupId, String authToken) {

        List<ApiElastigroupGetElastilogResponse> getElastilogResponse = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (elastigroupGetElastilogRequest.getAccountId() != null) {
            queryParams.put("accountId", elastigroupGetElastilogRequest.getAccountId());
        }

        // Add from date Query param
        if (elastigroupGetElastilogRequest.getFromDate() != null) {
            queryParams.put("fromDate", elastigroupGetElastilogRequest.getFromDate());
        }

        // Add limit Query param
        if (elastigroupGetElastilogRequest.getLimit() != null) {
            queryParams.put("limit", elastigroupGetElastilogRequest.getLimit());
        }

        // Add resource Id Query param
        if (elastigroupGetElastilogRequest.getResourceId() != null) {
            queryParams.put("resourceId", elastigroupGetElastilogRequest.getResourceId());
        }

        // Add severity Query param
        if (elastigroupGetElastilogRequest.getSeverity() != null) {
            queryParams.put("severity", elastigroupGetElastilogRequest.getSeverity());
        }

        // Add to date Query param
        if (elastigroupGetElastilogRequest.getToDate() != null) {
            queryParams.put("toDate", elastigroupGetElastilogRequest.getToDate());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/logs", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupGetElastilogApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupGetElastilogApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            getElastilogResponse = castedApiResponse.getResponse().getItems();
        }

        return getElastilogResponse;

    }

    public static List<ApiGetInstanceTypesResponse> getInstanceTypesByRegion(String region, String authToken, String account) {

        List<ApiGetInstanceTypesResponse> getInstanceTypesByRegionResponse = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Add region Query param
        if (region != null) {
            queryParams.put("region", region);
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/spotType", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        GetInstanceTypesByRegionApiResponse
                instanceTypesResponse = getCastedResponse(response, GetInstanceTypesByRegionApiResponse.class);

        if (instanceTypesResponse.getResponse().getCount() > 0) {
            getInstanceTypesByRegionResponse = instanceTypesResponse.getResponse().getItems();
        }

        return getInstanceTypesByRegionResponse;
    }
  
    public static ApiElastigroup importASG(ImportASGRequest importASGRequest, String authToken) {

        ApiElastigroup retVal = null;

        ImportASG importASG = importASGRequest.getImportASG();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (importASGRequest.getAccountId() != null) {
            queryParams.put("accountId", importASGRequest.getAccountId());
        }

        // Add auto scaling group name Query param
        if (importASGRequest.getAutoScalingGroupName() != null) {
            queryParams.put("autoScalingGroupName", importASGRequest.getAutoScalingGroupName());
        }

        // Add dry run Query param
        if (importASGRequest.getDryRun() != null) {
            queryParams.put("dryRun", importASGRequest.getDryRun());
        }

        // Add region Query param
        if (importASGRequest.getRegion() != null) {
            queryParams.put("region", importASGRequest.getRegion());
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/autoScalingGroup/import", apiEndpoint);

        // Write to json
        Map<String, ImportASG> groupRequest = new HashMap<>();
        groupRequest.put("group", importASG);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            retVal = castedApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiGetInstanceTypesResponse> getSuggestedInstanceTypes(GetSuggestedInstanceTypeRequest suggestedInstanceTypeRequest, String authToken, String account) {

        List<ApiGetInstanceTypesResponse> getInstanceTypesByRegionResponse = new LinkedList<>();
        GetSuggestedInstanceType suggestedInstanceTypeReq = suggestedInstanceTypeRequest.getSuggestedInstanceType();

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
        String uri = String.format("%s/aws/ec2/instanceTypeRecommendation", apiEndpoint);

        // Write to json
        Map<String, GetSuggestedInstanceType> suggestedInstanceType = new HashMap<>();
        suggestedInstanceType.put("requirements", suggestedInstanceTypeReq);
        String body = JsonMapper.toJson(suggestedInstanceType);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        GetInstanceTypesByRegionApiResponse
                instanceTypesResponse = getCastedResponse(response, GetInstanceTypesByRegionApiResponse.class);

        if (instanceTypesResponse.getResponse().getCount() > 0) {
            getInstanceTypesByRegionResponse = instanceTypesResponse.getResponse().getItems();
        }

        return getInstanceTypesByRegionResponse;
    }

    public static ApiElastigroupEcsClusterRollResponse initiateClusterRollInEGWithECS(ApiElastigroupEcsInitiateRoll initiateRollRequest, String groupId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiElastigroupEcsClusterRollResponse retVal = null;

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
        Map<String, ApiElastigroupEcsInitiateRoll> rollRequest = new HashMap<>();
        rollRequest.put("roll", initiateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/clusterRoll", apiEndpoint, groupId);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupEcsInitiateRollApiResponse initiateRollApiResponse = getCastedResponse(response, ElastigroupEcsInitiateRollApiResponse.class);

        if (initiateRollApiResponse.getResponse().getCount() > 0) {
            retVal = initiateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiElastigroupEcsClusterRollResponse> listECSClusterRollsPerEG(String groupId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        List<ApiElastigroupEcsClusterRollResponse> retVal = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/clusterRoll", apiEndpoint, groupId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupEcsInitiateRollApiResponse listRollsResponse =
                getCastedResponse(response, ElastigroupEcsInitiateRollApiResponse.class);

        if (listRollsResponse.getResponse().getCount() > 0) {
            retVal = listRollsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static ApiElastigroupEcsClusterRollResponse getECSClusterRollinEG(String groupId, String rollId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiElastigroupEcsClusterRollResponse retVal = null;

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
        String uri = String.format("%s/aws/ec2/group/%s/clusterRoll/%s", apiEndpoint, groupId, rollId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupEcsInitiateRollApiResponse getRollApiResponse =
                getCastedResponse(response, ElastigroupEcsInitiateRollApiResponse.class);

        if (getRollApiResponse.getResponse().getCount() > 0) {
            retVal = getRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiElastigroupEcsClusterRollResponse updateECSClusterRollinEG(ElastigroupEcsUpdateRollRequest updateRollRequest, String groupId, String authToken, String account) throws SpotinstHttpException {

        // Init retVal
        ApiElastigroupEcsClusterRollResponse retVal = null;

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
        Map<String, ElastigroupEcsUpdateRollRequest> rollRequest = new HashMap<>();
        rollRequest.put("roll", updateRollRequest);
        String body = JsonMapper.toJson(rollRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/clusterRoll", apiEndpoint, groupId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupEcsInitiateRollApiResponse updateRollApiResponse =
                getCastedResponse(response, ElastigroupEcsInitiateRollApiResponse.class);

        if (updateRollApiResponse.getResponse().getCount() > 0) {
            retVal = updateRollApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiElastigroupImportStatefulInstanceResponse importStatefulInstance(ElastigroupImportStatefulInstance importRequest, String authToken, String account) {

        ApiElastigroupImportStatefulInstanceResponse retVal = null;

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
        String uri = String.format("%s/aws/ec2/statefulMigrationGroup", apiEndpoint);

        // Write to json
        Map<String, ElastigroupImportStatefulInstance> groupRequest = new HashMap<>();
        groupRequest.put("statefulMigrationGroup", importRequest);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupImportStatefulInstanceApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupImportStatefulInstanceApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            retVal = castedApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiElastigroupGetImportStatefulStatusResponse> getStatefulImportStatus(String statefulMigrationGroupID, String authToken, String account) {

        List<ApiElastigroupGetImportStatefulStatusResponse> statefulInstanceImportStatus = new LinkedList<>();

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
        String uri = String.format("%s/aws/ec2/statefulMigrationGroup/%s", apiEndpoint, statefulMigrationGroupID);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        ElastigroupGetImportStatefulStatusApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupGetImportStatefulStatusApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            statefulInstanceImportStatus = castedApiResponse.getResponse().getItems();
        }

        return statefulInstanceImportStatus;

    }

    public static ApiElastigroupTerminateStatefulInstanceImportResponse terminateStatefulInstanceImport(ElastigroupTerminateStatefulInstanceImportRequest terminateRequest, String statefulMigrationGroupID, String authToken, String account) {

        ApiElastigroupTerminateStatefulInstanceImportResponse retVal = null;

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
        String uri = String.format("%s/aws/ec2/statefulMigrationGroup/%s/userAction", apiEndpoint, statefulMigrationGroupID);

        // Write to json
        Map<String, ElastigroupTerminateStatefulInstanceImportRequest> groupRequest = new HashMap<>();
        groupRequest.put("userAction", terminateRequest);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.

        ElastigroupTerminateStatefulInstanceImportApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupTerminateStatefulInstanceImportApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            retVal = castedApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiElastigroupTerminateStatefulInstanceImportResponse deleteStatefulInstanceImport(String statefulMigrationGroupID, String authToken, String account) {

        ApiElastigroupTerminateStatefulInstanceImportResponse retVal = null;

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
        String uri = String.format("%s/aws/ec2/statefulMigrationGroup/%s", apiEndpoint, statefulMigrationGroupID);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.

        ElastigroupTerminateStatefulInstanceImportApiResponse
                castedApiResponse = getCastedResponse(response, ElastigroupTerminateStatefulInstanceImportApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            retVal = castedApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }
}
