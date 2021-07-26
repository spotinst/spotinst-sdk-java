package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.admin.account.ApiAccountAdmin;
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

        if (allAccountsResponse != null && allAccountsResponse.getResponse().getCount() > 0) {
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

}
