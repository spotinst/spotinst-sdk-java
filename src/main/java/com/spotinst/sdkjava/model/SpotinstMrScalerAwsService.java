package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SpotinstMrScalerAwsService extends BaseSpotinstService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstElastigroupService.class);

    static BlMrScalerAws createMrScaler(BlMrScalerAws blMrScalerAws, String authToken, String account)
            throws SpotinstHttpException {
        BlMrScalerAws retVal = null;

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

        Map<String, BlMrScalerAws> mrScalerRequest =  new HashMap<>();
        mrScalerRequest.put("mrScaler", blMrScalerAws);
        String body = JsonMapper.toJson(mrScalerRequest);

        // Build URI
        String uri = String.format("%s/aws/emr/mrScaler", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        MrScalerApiResponse mrScalerApiReponse = getCastedResponse(response, MrScalerApiResponse.class);

        if (mrScalerApiReponse.getResponse().getCount() > 0) {
            retVal = mrScalerApiReponse.getResponse().getItems().get(0);
        }
        return retVal;
    }


    static Boolean updateMrScaler(String clusterId, BlMrScalerAws blMrScalerAws, String authToken, String account)
            throws SpotinstHttpException{
        Boolean retVal = null;

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

        Map<String, BlMrScalerAws> mrScalerRequest =  new HashMap<>();
        mrScalerRequest.put("mrScaler", blMrScalerAws);
        String body = JsonMapper.toJson(mrScalerRequest);

        // Build URI
        String uri = String.format("%s/aws/emr/mrScaler/%s", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        MrScalerApiResponse mrScalerApiReponse = getCastedResponse(response, MrScalerApiResponse.class);

        if (mrScalerApiReponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean deleteMrScaler(String mrScalerId, String authToken,
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
        String uri = String.format("%s/aws/emr/mrScaler/" + mrScalerId, apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, queryParams);
        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);
        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static BlMrScalerAws getMrScaler(String clusterId, String authToken, String account)
            throws SpotinstHttpException{
        BlMrScalerAws retVal = null;

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

        // Build URI
        String uri = String.format("%s/aws/emr/mrScaler/%s", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        MrScalerApiResponse mrScalerApiReponse = getCastedResponse(response, MrScalerApiResponse.class);

        if (mrScalerApiReponse.getResponse().getCount() > 0) {
            retVal = mrScalerApiReponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

    public static List<BlMrScalerAws> getAllMrScaler(String authToken, String account)
            throws SpotinstHttpException{
        List<BlMrScalerAws> retVal = null;

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

        // Build URI
        String uri = String.format("%s/aws/emr/mrScaler", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        MrScalerApiResponse mrScalerApiReponse = getCastedResponse(response, MrScalerApiResponse.class);

        if (mrScalerApiReponse.getResponse().getCount() > 0) {
            retVal = mrScalerApiReponse.getResponse().getItems();
        }
        return retVal;
    }

}
