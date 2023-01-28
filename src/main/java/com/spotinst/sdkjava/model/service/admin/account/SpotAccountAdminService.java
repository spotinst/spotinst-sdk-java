package com.spotinst.sdkjava.model.service.admin.account;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.admin.account.ApiAccountAdmin;
import com.spotinst.sdkjava.model.api.admin.account.ApiAccount;
import com.spotinst.sdkjava.model.api.admin.account.ApiUsers;
import com.spotinst.sdkjava.model.api.admin.account.ApiUserPermissions;
import com.spotinst.sdkjava.model.api.admin.organization.ApiPolicy;
import com.spotinst.sdkjava.model.requests.admin.account.AssignUsersToAccountsRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateAccountRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateUserPermissionsRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UserDetachRequest;
import com.spotinst.sdkjava.model.responses.admin.account.*;

import com.spotinst.sdkjava.model.responses.admin.organization.PolicyApiResponse;
import org.apache.http.HttpStatus;

import java.util.*;


public class SpotAccountAdminService extends BaseSpotinstService {

    public static ApiAccount createAccount(String accountName, String authToken) throws SpotinstHttpException {

        // Init retVal
        ApiAccount retVal = null;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, String> acc = new HashMap<>();
        acc.put("name", accountName);
        // Write to json
        Map<String, Map<String, String>> createRequest = new HashMap<>();
        createRequest.put("account", acc);
        String body = JsonMapper.toJson(createRequest);

        //Build URI
        String uri = String.format("%s/setup/account", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        CreateAccountApiResponse apiResponse = getCastedResponse(response, CreateAccountApiResponse.class);

        if (apiResponse.getResponse().getCount() > 0) {
            retVal = apiResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }


    public static Boolean updateAccount(UpdateAccountRequest request, String accountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/account/%s", apiEndpoint, accountId);

        // Write to json
        Map<String, UpdateAccountRequest> updateRequest = new HashMap<>();
        updateRequest.put("account", request);
        String body = JsonMapper.toJson(updateRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }


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

    public static List<ApiUsers> listUsers(String cloudAccountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiUsers> retVal = new ArrayList<>();

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (cloudAccountId != null) {
            queryParams.put("accountId", cloudAccountId);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/user", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetAccountUsersApiResponse accountUsersResponse = getCastedResponse(response, GetAccountUsersApiResponse.class);

        if (accountUsersResponse.getResponse().getCount() > 0) {
            retVal = accountUsersResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updatePermissions(String authToken, UpdateUserPermissionsRequest request, String accountId) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (accountId != null) {
            queryParams.put("accountId", accountId);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/account/%s/user", apiEndpoint, accountId);

        // Write to json
        Map<String, UpdateUserPermissionsRequest> updateRequest = new HashMap<>();
        updateRequest.put("account", request);
        String body = JsonMapper.toJson(updateRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiUserPermissions> getUsersPermissions(String cloudAccountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiUserPermissions> retVal = new ArrayList<>();

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (cloudAccountId != null) {
            queryParams.put("accountId", cloudAccountId);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/user/permission", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        GetUserPermissionsApiResponse accountUsersResponse = getCastedResponse(response, GetUserPermissionsApiResponse.class);

        if (accountUsersResponse.getResponse().getCount() > 0) {
            retVal = accountUsersResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean assignUsersToAccounts(AssignUsersToAccountsRequest request, String accountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (accountId != null) {
            queryParams.put("accountId", accountId);
        }

        //Build URI
        String uri = String.format("%s/setup/accountUserMapping", apiEndpoint);

        // Write to json
        Map<String, AssignUsersToAccountsRequest> updateRequest = new HashMap<>();
        updateRequest.put("account", request);
        String body = JsonMapper.toJson(updateRequest);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean detachUser(String accountId, String authToken, UserDetachRequest request) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/account/%s/user", apiEndpoint, accountId);

        // Write to json
        Map<String, UserDetachRequest> userDetachRequestMap = new HashMap<>();
        userDetachRequestMap.put("account", request);
        String body = JsonMapper.toJson(userDetachRequestMap);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, body, headers, queryParams);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiPolicy> listAccessPolicies(String cloudAccountId, String authToken) throws SpotinstHttpException {

        // Init retVal
        List<ApiPolicy> retVal = new ArrayList<>();

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (cloudAccountId != null) {
            queryParams.put("accountId", cloudAccountId);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/setup/access/policy", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        PolicyApiResponse accessPoliciesResponse = getCastedResponse(response, PolicyApiResponse.class);

        if (accessPoliciesResponse.getResponse().getCount() > 0) {
            retVal = accessPoliciesResponse.getResponse().getItems();
        }

        return retVal;
    }
}
