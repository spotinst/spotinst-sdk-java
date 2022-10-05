package com.spotinst.sdkjava.model.service.oceanCD;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.oceanCD.ApiRolloutSpec;
import com.spotinst.sdkjava.model.api.oceanCD.ApiStrategy;
import com.spotinst.sdkjava.model.api.oceanCD.ApiVerificationProvider;
import com.spotinst.sdkjava.model.api.oceanCD.ApiVerificationTemplate;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiRolloutStatus;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiRolloutsDetails;
import com.spotinst.sdkjava.model.requests.oceanCD.RolloutActions;
import com.spotinst.sdkjava.model.responses.oceanCD.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public class OceanCDService extends BaseSpotinstService {
    public static ApiStrategy createStrategy (ApiStrategy strategyRequest, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiStrategy retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiStrategy> strategyReq = new HashMap<>();
        strategyReq.put("strategy", strategyRequest);
        String body = JsonMapper.toJson(strategyReq);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        CreateStrategyApiResponse strategyResponse =
                getCastedResponse(response, CreateStrategyApiResponse.class);

        if (strategyResponse.getResponse().getCount() > 0) {
            retVal = strategyResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiStrategy getStrategy(String strategyName, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiStrategy retVal = new ApiStrategy();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        CreateStrategyApiResponse getStrategyResponse = getCastedResponse(response, CreateStrategyApiResponse.class);

        if (getStrategyResponse.getResponse().getCount() > 0) {
            retVal = getStrategyResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiStrategy> getAllStrategies(String authToken) throws SpotinstHttpException {
        // Init retVal
        List<ApiStrategy> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        CreateStrategyApiResponse allStrategiesResponse = getCastedResponse(response, CreateStrategyApiResponse.class);

        if (allStrategiesResponse.getResponse().getCount() > 0) {
            retVal = allStrategiesResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateStrategy(ApiStrategy strategyUpdateReq, String strategyName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Write to json
        Map<String, ApiStrategy> strategyRequest = new HashMap<>();
        strategyRequest.put("strategy", strategyUpdateReq);
        String body = JsonMapper.toJson(strategyRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean patchStrategy(ApiStrategy strategyUpdateReq, String strategyName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Write to json
        Map<String, ApiStrategy> strategyRequest = new HashMap<>();
        strategyRequest.put("strategy", strategyUpdateReq);
        String body = JsonMapper.toJson(strategyRequest);

        // Send the request.
        RestResponse response = RestClient.sendPatch(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteStrategy(String strategyName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/strategy/%s", apiEndpoint, strategyName);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiRolloutSpec createRolloutSpec (ApiRolloutSpec rolloutSpecReq, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiRolloutSpec retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiRolloutSpec> strategyReq = new HashMap<>();
        strategyReq.put("rolloutSpec", rolloutSpecReq);
        String body = JsonMapper.toJson(strategyReq);

        // Build URI
        String uri = String.format("%s/ocean/cd/rolloutSpec", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        CreateRolloutSpecApiResponse rolloutSpecResponse =
                getCastedResponse(response, CreateRolloutSpecApiResponse.class);

        if (rolloutSpecResponse.getResponse().getCount() > 0) {
            retVal = rolloutSpecResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiRolloutSpec getRolloutSpec(String rolloutSpecName, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiRolloutSpec retVal = new ApiRolloutSpec();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rolloutSpec/%s", apiEndpoint, rolloutSpecName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        CreateRolloutSpecApiResponse getStrategyResponse = getCastedResponse(response, CreateRolloutSpecApiResponse.class);

        if (getStrategyResponse.getResponse().getCount() > 0) {
            retVal = getStrategyResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiRolloutSpec> getAllRolloutSpecs(String authToken) throws SpotinstHttpException {
        // Init retVal
        List<ApiRolloutSpec> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rolloutSpec", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        CreateRolloutSpecApiResponse allStrategiesResponse = getCastedResponse(response, CreateRolloutSpecApiResponse.class);

        if (allStrategiesResponse.getResponse().getCount() > 0) {
            retVal = allStrategiesResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateRolloutSpec(ApiRolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rolloutSpec/%s", apiEndpoint, rolloutSpecName);

        // Write to json
        Map<String, ApiRolloutSpec> rolloutSpecRequest = new HashMap<>();
        rolloutSpecRequest.put("rolloutSpec", rolloutSpecReq);
        String body = JsonMapper.toJson(rolloutSpecRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean patchRolloutSpec(ApiRolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rolloutSpec/%s", apiEndpoint, rolloutSpecName);

        // Write to json
        Map<String, ApiRolloutSpec> rolloutSpecRequest = new HashMap<>();
        rolloutSpecRequest.put("rolloutSpec", rolloutSpecReq);
        String body = JsonMapper.toJson(rolloutSpecRequest);

        // Send the request.
        RestResponse response = RestClient.sendPatch(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteRolloutSpec(String rolloutSpecName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rolloutSpec/%s", apiEndpoint, rolloutSpecName);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiRolloutStatus getRolloutStatus(String rolloutId, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiRolloutStatus retVal = new ApiRolloutStatus();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rollout/%s/status", apiEndpoint, rolloutId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        RolloutStatusApiResponse getRolloutResponse = getCastedResponse(response, RolloutStatusApiResponse.class);

        if (getRolloutResponse.getResponse().getCount() > 0) {
            retVal = getRolloutResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiRolloutsDetails> getAllRollouts(String fromDate, String authToken) throws SpotinstHttpException {
        // Init retVal
        List<ApiRolloutsDetails> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        if (fromDate != null) {
            queryParams.put("fromDate", fromDate);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rollout", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        RolloutDetailsApiResponse allRolloutsResponse = getCastedResponse(response, RolloutDetailsApiResponse.class);

        if (allRolloutsResponse.getResponse().getCount() > 0) {
            retVal = allRolloutsResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean rolloutAction(RolloutActions rolloutActionsReq, String rolloutId, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/rollout/%s", apiEndpoint, rolloutId);

        // Write to json
        String body = JsonMapper.toJson(rolloutActionsReq);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiVerificationProvider createVerificationProvider (ApiVerificationProvider apiVerificationProviderRequest, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiVerificationProvider retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiVerificationProvider> verificationProviderRequest = new HashMap<>();
        verificationProviderRequest.put("verificationProvider", apiVerificationProviderRequest);
        String body = JsonMapper.toJson(verificationProviderRequest);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationProvider", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        VerificationProviderApiResponse verificationProviderResponse =
                getCastedResponse(response, VerificationProviderApiResponse.class);

        if (verificationProviderResponse.getResponse().getCount() > 0) {
            retVal = verificationProviderResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiVerificationProvider getVerificationProvider(String verificationProviderName, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiVerificationProvider retVal = new ApiVerificationProvider();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationProvider/%s", apiEndpoint, verificationProviderName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        VerificationProviderApiResponse getVerificationProviderResponse = getCastedResponse(response, VerificationProviderApiResponse.class);

        if (getVerificationProviderResponse.getResponse().getCount() > 0) {
            retVal = getVerificationProviderResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiVerificationProvider> getAllVerificationProviders(String authToken) throws SpotinstHttpException {
        // Init retVal
        List<ApiVerificationProvider> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationProvider", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        VerificationProviderApiResponse getAllVerificationProviderResponse = getCastedResponse(response, VerificationProviderApiResponse.class);

        if (getAllVerificationProviderResponse.getResponse().getCount() > 0) {
            retVal = getAllVerificationProviderResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateVerificationProvider(ApiVerificationProvider verificationProviderReq, String verificationProviderName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationProvider/%s", apiEndpoint, verificationProviderName);

        // Write to json
        Map<String, ApiVerificationProvider> verificationProviderRequest = new HashMap<>();
        verificationProviderRequest.put("verificationProvider", verificationProviderReq);
        String body = JsonMapper.toJson(verificationProviderRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean patchVerificationProvider(ApiVerificationProvider verificationProviderReq, String verificationProviderName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationProvider/%s", apiEndpoint, verificationProviderName);

        // Write to json
        Map<String, ApiVerificationProvider> verificationProviderRequest = new HashMap<>();
        verificationProviderRequest.put("verificationProvider", verificationProviderReq);
        String body = JsonMapper.toJson(verificationProviderRequest);

        // Send the request.
        RestResponse response = RestClient.sendPatch(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteVerificationProvider(String verificationProviderName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationProvider/%s", apiEndpoint, verificationProviderName);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static ApiVerificationTemplate createVerificationTemplate (ApiVerificationTemplate apiVerificationTemplateRequest, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiVerificationTemplate retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        Map<String, ApiVerificationTemplate> verificationTemplateRequest = new HashMap<>();
        verificationTemplateRequest.put("verificationTemplate", apiVerificationTemplateRequest);
        String body = JsonMapper.toJson(verificationTemplateRequest);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationTemplate", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        VerificationTemplateApiResponse verificationTemplateResponse =
                getCastedResponse(response, VerificationTemplateApiResponse.class);

        if (verificationTemplateResponse.getResponse().getCount() > 0) {
            retVal = verificationTemplateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static ApiVerificationTemplate getVerificationTemplate(String verificationTemplateName, String authToken) throws SpotinstHttpException {
        // Init retVal
        ApiVerificationTemplate retVal = new ApiVerificationTemplate();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationTemplate/%s", apiEndpoint, verificationTemplateName);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        VerificationTemplateApiResponse getVerificationTemplateResponse = getCastedResponse(response, VerificationTemplateApiResponse.class);

        if (getVerificationTemplateResponse.getResponse().getCount() > 0) {
            retVal = getVerificationTemplateResponse.getResponse().getItems().get(0);
        }

        return retVal;
    }

    public static List<ApiVerificationTemplate> getAllVerificationTemplates(String authToken) throws SpotinstHttpException {
        // Init retVal
        List<ApiVerificationTemplate> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationTemplate", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, null);

        // Handle the response.
        VerificationTemplateApiResponse getAllVerificationTemplateResponse = getCastedResponse(response, VerificationTemplateApiResponse.class);

        if (getAllVerificationTemplateResponse.getResponse().getCount() > 0) {
            retVal = getAllVerificationTemplateResponse.getResponse().getItems();
        }

        return retVal;
    }

    public static Boolean updateVerificationTemplate(ApiVerificationTemplate verificationTemplateReq, String verificationTemplateName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationTemplate/%s", apiEndpoint, verificationTemplateName);

        // Write to json
        Map<String, ApiVerificationTemplate> verificationTemplateRequest = new HashMap<>();
        verificationTemplateRequest.put("verificationTemplate", verificationTemplateReq);
        String body = JsonMapper.toJson(verificationTemplateRequest);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean patchVerificationTemplate(ApiVerificationTemplate verificationTemplateReq, String verificationTemplateName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationTemplate/%s", apiEndpoint, verificationTemplateName);

        // Write to json
        Map<String, ApiVerificationTemplate> verificationTemplateRequest = new HashMap<>();
        verificationTemplateRequest.put("verificationTemplate", verificationTemplateReq);
        String body = JsonMapper.toJson(verificationTemplateRequest);

        // Send the request.
        RestResponse response = RestClient.sendPatch(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteVerificationTemplate(String verificationTemplateName, String authToken) throws SpotinstHttpException {

        //Init retVal
        Boolean retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/ocean/cd/verificationTemplate/%s", apiEndpoint, verificationTemplateName);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }
}