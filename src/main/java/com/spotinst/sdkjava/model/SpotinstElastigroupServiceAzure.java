package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiCreateDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGetDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentRequestAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;
import com.spotinst.sdkjava.model.responses.*;

import org.apache.http.HttpStatus;

import java.util.*;


class SpotinstElastigroupServiceAzure extends BaseSpotinstService {

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

    ApiCreateDeploymentAzure createDeployment(ApiGroupDeploymentRequestAzure apiDeploymentToCreate, String authToken,
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

        ElastigroupApiCreateDeploymentResponseAzure elastigroupApiResponse =
                getCastedResponse(response, ElastigroupApiCreateDeploymentResponseAzure.class);


        if (elastigroupApiResponse.getResponse().getCount() > 0) {
            retVal = elastigroupApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    List<ApiGetDeploymentAzure> getAllDeployments(String groupId, String authToken, String account,  Integer limit, SortQueryParam sortQueryParam) {


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
        ElastigroupApiGetDeploymentResponseAzure deploymentsResponse =
                getCastedResponse(response, ElastigroupApiGetDeploymentResponseAzure.class);

        if (deploymentsResponse.getResponse().getCount() > 0) {
            retVal = deploymentsResponse.getResponse().getItems();
        }
        return retVal;

    }


    ApiGetDeploymentAzure getDeployment(String deploymentId, String authToken, String account, String groupId) {
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
        ElastigroupApiGetDeploymentResponseAzure deploymentsResponse =
                getCastedResponse(response, ElastigroupApiGetDeploymentResponseAzure.class);

        if (deploymentsResponse.getResponse().getCount() > 0) {
            retVal = deploymentsResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    ApiGroupDeploymentDetailsAzure getDeploymentDetails(String deploymentId, String authToken, String account,
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
        ElastigroupApiDeploymentDetailsResponseAzure deploymentsResponse =
                getCastedResponse(response, ElastigroupApiDeploymentDetailsResponseAzure.class);

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
}
