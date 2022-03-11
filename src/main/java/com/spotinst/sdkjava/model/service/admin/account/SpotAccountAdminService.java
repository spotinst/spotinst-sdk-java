package com.spotinst.sdkjava.model.service.admin.account;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.AccountAdminApiResponse;
import com.spotinst.sdkjava.model.api.admin.account.*;
import com.spotinst.sdkjava.model.responses.admin.account.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class SpotAccountAdminService extends BaseSpotinstService {

    public static List<ApiAccountAdmin> listAccounts(String cloudAccountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiAccountAdmin> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (cloudAccountId != null) {
            queryParams.put("cloudAccountId", cloudAccountId);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/account", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        AccountAdminApiResponse allAccountsResponse = getCastedResponse(response, AccountAdminApiResponse.class);

        if (allAccountsResponse.getResponse().getCount() > 0) {
            retVal = allAccountsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean deleteAccount(String accountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/account/%s", apiEndpoint, accountId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiUser createUser(ApiUser apiUserRequest, Boolean generateToken, String authToken ) throws SpotinstHttpException {

        // Init retVal
        ApiUser retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();


        queryParams.put("generateToken", generateToken.toString());

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        String body = JsonMapper.toJson(apiUserRequest);

        //Build URI
        String uri = String.format("%s/setup/user", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        UserApiResponse userApiResponse = getCastedResponse(response, UserApiResponse.class);


        if (userApiResponse.getResponse().getCount() > 0) {
            retVal = userApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiUserDetails getUserDetails(String userId, String authToken ) throws SpotinstHttpException {

        // Init retVal
        ApiUserDetails retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/user/%s", apiEndpoint,userId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        UserDetailsApiResponse userApiResponse = getCastedResponse(response, UserDetailsApiResponse.class);

        if (userApiResponse.getResponse().getCount() > 0) {
            retVal = userApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiProgrammaticUserResponse createProgrammaticUser(ApiProgrammaticUser apiUserRequest, String authToken) throws SpotinstHttpException {

        // Init retVal
        ApiProgrammaticUserResponse retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        String body = JsonMapper.toJson(apiUserRequest);

        //Build URI
        String uri = String.format("%s/setup/user/programmatic", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        ProgrammaticUserApiResponse ApiResponse = getCastedResponse(response, ProgrammaticUserApiResponse.class);


        if (ApiResponse.getResponse().getCount() > 0) {
            retVal = ApiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiOrganizationUsers> getOrganizationUsers(String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiOrganizationUsers> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/organization/user", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        OrganizationUsersApiResponse orgUserApiResponse = getCastedResponse(response, OrganizationUsersApiResponse.class);

        if (orgUserApiResponse.getResponse().getCount() > 0) {
            retVal = orgUserApiResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateGroupsOfUser(String userId, List<String> userGroupIds, String authToken ) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, List<String>> userGroups = new HashMap<>();
        userGroups.put("userGroupIds",userGroupIds);
        String body = JsonMapper.toJson(userGroups);

        //Build URI
        String uri = String.format("%s/setup/user/%s/userGroupMapping", apiEndpoint,userId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateUserDirectPolicies(String userId, ApiUpdateDirectPoliciesRequest apiUpdateRequest, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        String body = JsonMapper.toJson(apiUpdateRequest);

        //Build URI
        String uri = String.format("%s/setup/user/%s/PolicyMapping", apiEndpoint,userId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiPolicy createPolicy(ApiPolicy policyCreateRequest, String authToken) throws SpotinstHttpException {

        // Init retVal
        ApiPolicy retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, ApiPolicy> request = new HashMap<>();
        request.put("policy",policyCreateRequest);
        String body = JsonMapper.toJson(request);

        //Build URI
        String uri = String.format("%s/setup/access/policy", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        PolicyApiResponse apiResponse = getCastedResponse(response, PolicyApiResponse.class);

        if (apiResponse.getResponse().getCount() > 0) {
            retVal = apiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static Boolean updatePolicy(String policyId, ApiPolicy updateRequest, String authToken ) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, ApiPolicy> request = new HashMap<>();
        request.put("policy",updateRequest);
        String body = JsonMapper.toJson(request);

        //Build URI
        String uri = String.format("%s/setup/access/policy/%s", apiEndpoint, policyId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }
        return retVal;
    }

    public static List<ApiPolicy> getAllPolicies(String authToken ) throws SpotinstHttpException {

        // Init retVal
        List<ApiPolicy> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/organization/policy", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        PolicyApiResponse apiResponse = getCastedResponse(response, PolicyApiResponse.class);

        if (apiResponse.getResponse().getCount() > 0) {
            retVal = apiResponse.getResponse().getItems();
        }
        return retVal;
    }

    public static Boolean deletePolicy(String policyId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/access/policy/%s", apiEndpoint,policyId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }
        return retVal;
    }

    public static ApiUserGroup createUserGroup(ApiUserGroup apiCreateRequest, String authToken ) throws SpotinstHttpException {

        // Init retVal
        ApiUserGroup retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        String body = JsonMapper.toJson(apiCreateRequest);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        UserGroupApiResponse apiResponse = getCastedResponse(response, UserGroupApiResponse.class);

        if (apiResponse.getResponse().getCount() > 0) {
            retVal = apiResponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static Boolean updateUserGroupMappedPolicies(String groupId, ApiUpdateDirectPoliciesRequest apiUpdateRequest, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        String body = JsonMapper.toJson(apiUpdateRequest);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup/%s/PolicyMapping", apiEndpoint,groupId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateUserGroupMappedUsers(String groupId, List<String> userIds, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, List<String>> request = new HashMap<>();
        request.put("userIds",userIds);
        String body = JsonMapper.toJson(request);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup/%s/userMapping", apiEndpoint,groupId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean updateUserGroupDetails(String groupId, String name,String description, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, String> request = new HashMap<>();
        request.put("name",name);
        request.put("description",description);
        String body = JsonMapper.toJson(request);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup/%s", apiEndpoint,groupId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteUserGroup(String groupId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup/%s", apiEndpoint,groupId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri,  null, headers, queryParams);

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiUserGroupDetails getUserGroup(String groupId, String authToken ) throws SpotinstHttpException {

        // Init retVal
        ApiUserGroupDetails retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup/%s", apiEndpoint,groupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        UserGroupDetailsApiResponse apiResponse = getCastedResponse(response, UserGroupDetailsApiResponse.class);

        if (apiResponse.getResponse().getCount() > 0) {
            retVal = apiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiOrganizationUserGroups> getOrganizationUserGroups(String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiOrganizationUserGroups> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();
        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/access/userGroup", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        OrganizationUserGroupsApiResponse apiResponse = getCastedResponse(response, OrganizationUserGroupsApiResponse.class);

        if (apiResponse.getResponse().getCount() > 0) {
            retVal = apiResponse.getResponse().getItems();
        }

        return retVal;
    }
}
