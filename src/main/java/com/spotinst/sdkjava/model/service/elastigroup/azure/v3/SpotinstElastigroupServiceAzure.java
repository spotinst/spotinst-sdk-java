package com.spotinst.sdkjava.model.service.elastigroup.azure.v3;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.enums.ElastigroupSeverityEnumAzure;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ElastigroupApiResponseAzure;
import com.spotinst.sdkjava.model.GroupFilter;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiCreateDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGetDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentRequestAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;

import com.spotinst.sdkjava.model.requests.elastigroup.azure.*;
import com.spotinst.sdkjava.model.responses.elastigroup.azure.v3.*;
import org.apache.http.HttpStatus;

import java.util.*;


public class SpotinstElastigroupServiceAzure extends BaseSpotinstService {

    public static ApiElastigroupAzure createElastigroup(ApiElastigroupAzure groupToCreate, String authToken,
                                                        String account) throws SpotinstHttpException {
        // Init retVal
        ApiElastigroupAzure retVal = null;

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
        Map<String, ApiElastigroupAzure> groupRequest = new HashMap<>();
        groupRequest.put("group", groupToCreate);
        String body = JsonMapper.toJson(groupRequest);

        // Build URI
        String uri = String.format("%s/azure/compute/group", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseAzure elastigroupApiResponse =
                getCastedResponse(response, ElastigroupApiResponseAzure.class);


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
        String uri = String.format("%s/azure/compute/group/%s", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }
        return retVal;
    }


    public static List<ApiElastigroupAzure> getAllGroups(GroupFilter filter, String authToken,
                                                         String account) throws SpotinstHttpException {
        // Init retVal
        List<ApiElastigroupAzure> retVal = new LinkedList<>();

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
        String uri = String.format("%s/azure/compute/group", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseAzure allElastigroupsResponse =
                getCastedResponse(response, ElastigroupApiResponseAzure.class);

        if (allElastigroupsResponse.getResponse().getCount() > 0) {
            retVal = allElastigroupsResponse.getResponse().getItems();
        }
        return retVal;
    }

    public static Boolean updateGroup(String elastigroupId, ApiElastigroupAzure apiElastigroup, String authToken,
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
        String uri = String.format("%s/azure/compute/group/%s?", apiEndpoint, elastigroupId);

        // Write to json
        Map<String, ApiElastigroupAzure> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroup);
        String body = JsonMapper.toJson(groupRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseAzure updateResponse = getCastedResponse(response, ElastigroupApiResponseAzure.class);
        if (updateResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }
        return retVal;
    }

    public static ApiCreateDeploymentAzure createDeployment(ApiGroupDeploymentRequestAzure apiDeploymentToCreate, String authToken,
                                              String account, String groupId) {
        ApiCreateDeploymentAzure retVal = null;

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();
        String             uri         = String.format("%s/azure/compute/group/%s/deployment", apiEndpoint, groupId);

        Map<String, String>                         queryParams       = new HashMap<>();
        Map<String, ApiGroupDeploymentRequestAzure> deploymentRequest = new HashMap<>();
        deploymentRequest.put("deployment", apiDeploymentToCreate);
        String body = JsonMapper.toJson(deploymentRequest);

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers  = buildHeaders(authToken);
        RestResponse        response = RestClient.sendPost(uri, body, headers, queryParams);

        CreateDeploymentApiResponseAzure elastigroupApiResponse =
                getCastedResponse(response, CreateDeploymentApiResponseAzure.class);


        if (elastigroupApiResponse.getResponse().getCount() > 0) {
            retVal = elastigroupApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiGetDeploymentAzure> getAllDeployments(String groupId, String authToken, String account,  Integer limit, SortQueryParam sortQueryParam) {


        List<ApiGetDeploymentAzure> retVal      = new ArrayList<>();
        Map<String, String>            queryParams = new HashMap<>();
        Map<String, String>            headers     = buildHeaders(authToken);
        SpotinstHttpConfig             config      = SpotinstHttpContext.getInstance().getConfiguration();
        String                         apiEndpoint = config.getEndpoint();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        if (limit != null) {
            queryParams.put("limit", limit.toString());
        }

        if (sortQueryParam != null) {
            String sortQueryString = sortQueryParam.toQueryParamString();
            queryParams.put("sort", sortQueryString);
        }

        String uri = String.format("%s/azure/compute/group/%s/deployment", apiEndpoint, groupId);

        RestResponse response = RestClient.sendGet(uri, headers, queryParams);


        // Handle the response.
        GetDeploymentApiResponseAzure deploymentsResponse =
                getCastedResponse(response, GetDeploymentApiResponseAzure.class);

        if (deploymentsResponse.getResponse().getCount() > 0) {
            retVal = deploymentsResponse.getResponse().getItems();
        }
        return retVal;

    }


    public static ApiGetDeploymentAzure getDeployment(String deploymentId, String authToken, String account, String groupId) {
        ApiGetDeploymentAzure retVal      = null;
        Map<String, String>      headers     = buildHeaders(authToken);
        Map<String, String>      queryParams = new HashMap<>();
        SpotinstHttpConfig       config      = SpotinstHttpContext.getInstance().getConfiguration();
        String                   apiEndpoint = config.getEndpoint();

        if (account != null) {
            queryParams.put("accountId", account);
        }


        String       uri      =
                String.format("%s/azure/compute/group/%s/deployment/%s", apiEndpoint, groupId, deploymentId);
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetDeploymentApiResponseAzure deploymentsResponse =
                getCastedResponse(response, GetDeploymentApiResponseAzure.class);

        if (deploymentsResponse.getResponse().getCount() > 0) {
            retVal = deploymentsResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiGroupDeploymentDetailsAzure getDeploymentDetails(String deploymentId, String authToken, String account,
                                                        String groupId) {
        ApiGroupDeploymentDetailsAzure retVal      = null;
        Map<String, String>            headers     = buildHeaders(authToken);
        Map<String, String>            queryParams = new HashMap<>();
        SpotinstHttpConfig             config      = SpotinstHttpContext.getInstance().getConfiguration();
        String                         apiEndpoint = config.getEndpoint();

        if (account != null) {
            queryParams.put("accountId", account);
        }


        String uri =
                String.format("%s/azure/compute/group/%s/deployment/%s/details", apiEndpoint, groupId, deploymentId);
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        DeploymentDetailsApiResponseAzure deploymentsResponse =
                getCastedResponse(response, DeploymentDetailsApiResponseAzure.class);

        if (deploymentsResponse.getResponse().getCount() > 0) {
            retVal = deploymentsResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiElastigroupAzure getGroup(String elastigroupId, String authToken,
                                          String account) throws SpotinstHttpException {
        // Init retVal
        ApiElastigroupAzure retVal = new ApiElastigroupAzure();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for Azure.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/azure/compute/group/%s", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseAzure groupActiveInstanceResponse = getCastedResponse(response, ElastigroupApiResponseAzure.class);

        if (groupActiveInstanceResponse.getResponse().getCount() > 0) {
            retVal = groupActiveInstanceResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiGetElastigroupStatusResponseAzure getGroupStatus(String groupId, String authToken,
                                                                      String account) throws SpotinstHttpException {
        // Init retVal
        ApiGetElastigroupStatusResponseAzure statusAzure = new ApiGetElastigroupStatusResponseAzure();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }

        // Get the headers for Azure.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/azure/compute/group/%s/status", apiEndpoint, groupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetStatusApiResponseAzure groupStatusResponse = getCastedResponse(response, GetStatusApiResponseAzure.class);

        if (groupStatusResponse.getResponse().getCount() > 0) {
            statusAzure = groupStatusResponse.getResponse().getItems().get(0);
        }

        return statusAzure;
    }

    public static List<ApiScalingResponseVms> scaleGroupUp(String groupId, Integer adjustment, String authToken,
                                                           String account) throws SpotinstHttpException {

        List<ApiScalingResponseVms> scaleUp = new LinkedList<>();
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();
        if (account != null) {
            queryParams.put("accountId", account);
        }

        if(adjustment != null) {
            queryParams.put("adjustment", adjustment.toString());
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/%s/scale/up", apiEndpoint, groupId);

        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        ScalingApiResponseAzure scalingResponse =
                getCastedResponse(response, ScalingApiResponseAzure.class);
        if (scalingResponse.getResponse().getItems().size() > 0) {
            scaleUp = scalingResponse.getResponse().getItems();
        }

        return scaleUp;
    }

    public static List<ApiScalingResponseVms> scaleGroupDown(String groupId, Integer adjustment,
                                                             String authToken, String account) throws SpotinstHttpException {

        List<ApiScalingResponseVms> scaleDown = new LinkedList<>();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();
        if (account != null) {
            queryParams.put("accountId", account);
        }

        if(adjustment != null) {
            queryParams.put("adjustment", adjustment.toString());
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/%s/scale/down", apiEndpoint, groupId);

        RestResponse response = RestClient.sendPut(uri, null, headers, queryParams);

        ScalingApiResponseAzure scalingResponse =
                getCastedResponse(response, ScalingApiResponseAzure.class);
        if (scalingResponse.getResponse().getItems().size() > 0) {
            scaleDown = scalingResponse.getResponse().getItems();
        }

        return scaleDown;
    }

    public static ApiElastigroupAzure importGroupFromScaleSet(String resourceGroupName, String scaleSetName,
                                                           String authToken, String account) {

        ApiElastigroupAzure importGroup = new ApiElastigroupAzure();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/import/resourceGroup/%s/scaleSet/%s", apiEndpoint, resourceGroupName, scaleSetName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseAzure importGroupResponse = getCastedResponse(response, ElastigroupApiResponseAzure.class);

        if (importGroupResponse.getResponse().getCount() > 0) {
            importGroup = importGroupResponse.getResponse().getItems().get(0);
        }
        return importGroup;
    }

    public static ApiElastigroupAzure importGroupFromVirtualMachine(String resourceGroupName, String virtualMachineName,
                                                              String authToken, String account) {

        ApiElastigroupAzure importGroup = new ApiElastigroupAzure();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/import/resourceGroup/%s/virtualMachine/%s", apiEndpoint,
                                    resourceGroupName, virtualMachineName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        ElastigroupApiResponseAzure importGroupResponse = getCastedResponse(response, ElastigroupApiResponseAzure.class);

        if (importGroupResponse.getResponse().getCount() > 0) {
            importGroup = importGroupResponse.getResponse().getItems().get(0);
        }
        return importGroup;
    }

    public static Boolean createVmSignal(CreateVmSignalRequestAzure vmSignalRequestAzure,
                                         String authToken, String account) throws SpotinstHttpException {
        Boolean isCreated = false;

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();
        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);
        String uri = String.format("%s/azure/compute/vm/signal", apiEndpoint, vmSignalRequestAzure.getVmSignalAzure());
        RestResponse response = RestClient.sendPost(uri, vmSignalRequestAzure.toJson(), headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            isCreated = true;
        }
        return isCreated;
    }

    public static ApiUpdateCapacityAzure updateCapacity(UpdateCapacityRequestAzure updateCapacityRequest,
                                                        String authToken, String account) throws SpotinstHttpException {

        ApiUpdateCapacityAzure groupCapacity = new ApiUpdateCapacityAzure();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/%s/capacity", apiEndpoint, updateCapacityRequest.getGroupId());

        RestResponse response = RestClient.sendPut(uri, updateCapacityRequest.toJson(), headers, queryParams);

        UpdateCapacityApiResponseAzure updateResponse = getCastedResponse(response, UpdateCapacityApiResponseAzure.class);

        if (updateResponse.getResponse().getCount() > 0) {
            groupCapacity = updateResponse.getResponse().getItems().get(0);
        }

        return groupCapacity;
    }

    public static List<ApiVmHealthinessAzure> vmHealthiness(String groupId,
                                                      String authToken, String account) throws SpotinstHttpException {

        List<ApiVmHealthinessAzure> vmHealthinessAzure = new LinkedList<>();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/%s/vmHealthiness", apiEndpoint, groupId);

        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        VmHealthinessApiResponseAzure vmHealthinessApiResponse = getCastedResponse(response, VmHealthinessApiResponseAzure.class);

        if (vmHealthinessApiResponse.getResponse().getCount() > 0) {
            vmHealthinessAzure = vmHealthinessApiResponse.getResponse().getItems();
        }

        return vmHealthinessAzure;
    }

    public static Boolean suspendGroup(SuspendgroupRequestAzure suspendgroupRequest, String authToken, String account) {

        Boolean isGroupSuspended = false;

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);
        String uri = String.format("%s/azure/compute/group/%s/suspend", apiEndpoint, suspendgroupRequest.getGroupId());

        RestResponse response = RestClient.sendPut(uri, suspendgroupRequest.toJson(), headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            isGroupSuspended = true;
        }
        return isGroupSuspended;
    }

    public static Boolean resumeGroup(ResumegroupRequestAzure resumegroupRequest, String authToken, String account) {

        Boolean isGroupResumed = false;

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);
        String uri = String.format("%s/azure/compute/group/%s/resume", apiEndpoint, resumegroupRequest.getGroupId());

        RestResponse response = RestClient.sendPut(uri, resumegroupRequest.toJson(), headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            isGroupResumed = true;
        }
        return isGroupResumed;
    }

    public static Boolean vmProtection(String groupId, String vmName, String authToken, String account,  Integer ttlInMinutes) {

        Boolean vmProtect = false;

        SpotinstHttpConfig  config      = SpotinstHttpContext.getInstance().getConfiguration();
        String              apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();
        Map<String, String> headers     = buildHeaders(authToken);

        if (account != null) {
            queryParams.put("accountId", account);
        }

        if (ttlInMinutes != null) {
            queryParams.put("ttlInMinutes", ttlInMinutes.toString());
        }

        String uri = String.format("%s/azure/compute/group/%s/vm/%s/protection", apiEndpoint, groupId, vmName);

        RestResponse response = RestClient.sendPost(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            vmProtect = true;
        }
        return vmProtect;
    }

    public static Boolean vmRemoveProtection(String groupId, String vmName,
                                             String authToken, String account) {

        Boolean vmRemoveProtect = false;

        SpotinstHttpConfig  config      = SpotinstHttpContext.getInstance().getConfiguration();
        String              apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();
        Map<String, String> headers     = buildHeaders(authToken);

        if (account != null) {
            queryParams.put("accountId", account);
        }

        String uri = String.format("%s/azure/compute/group/%s/vm/%s/protection", apiEndpoint,
                groupId, vmName);

        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            vmRemoveProtect = true;
        }
        return vmRemoveProtect;
    }

    public static ApiDetachVmsResponseAzure detachVms(DetachVmsRequestAzure detachVmsRequest,
                                                      String authToken, String account) throws SpotinstHttpException {

        ApiDetachVmsResponseAzure detachedVmsAzure = new ApiDetachVmsResponseAzure();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/%s/detachVms", apiEndpoint, detachVmsRequest.getGroupId());

        RestResponse response = RestClient.sendPut(uri, detachVmsRequest.toJson(), headers, queryParams);

        DetachedVmsApiResponseAzure detachVmsApiResponse = getCastedResponse(response, DetachedVmsApiResponseAzure.class);

        if (detachVmsApiResponse.getResponse().getCount() > 0) {
            detachedVmsAzure = detachVmsApiResponse.getResponse().getItems().get(0);
        }

        return detachedVmsAzure;
    }

    public static ApiGetElastilogResponseAzure getElastilog(String groupId, String authToken, String account,
                                                            String fromDate, Integer limit, String resoucre_Id,
                                                            ElastigroupSeverityEnumAzure severity, String toDate) throws SpotinstHttpException {
        ApiGetElastilogResponseAzure elastilogAzure = new ApiGetElastilogResponseAzure();

        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        if (account != null) {
            queryParams.put("accountId", account);
        }

        if (fromDate != null) {
            queryParams.put("fromDate", fromDate);
        }

        if (limit != null) {
            queryParams.put("limit", limit.toString());
        }

        if (resoucre_Id != null) {
            queryParams.put("RESOURCE_ID", resoucre_Id);
        }

        if (severity != null) {
            queryParams.put("SEVERITY", severity.getName());
        }

        if (toDate != null) {
            queryParams.put("toDate", toDate);
        }

        Map<String, String> headers = buildHeaders(authToken);

        String uri = String.format("%s/azure/compute/group/%s/logs", apiEndpoint, groupId);

        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        GetElastilogApiResponseAzure elastilogResponse = getCastedResponse(response, GetElastilogApiResponseAzure.class);

        if (elastilogResponse.getResponse().getCount() > 0) {
            elastilogAzure = elastilogResponse.getResponse().getItems().get(0);
        }

        return elastilogAzure;
    }
}
