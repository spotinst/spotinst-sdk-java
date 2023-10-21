package com.spotinst.sdkjava.model.service.mrScaler.aws;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.RestClient;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.client.rest.SpotinstHttpConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.*;
import com.spotinst.sdkjava.model.responses.mrScaler.aws.MrScalerListInstancesApiResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotinstMrScalerListInstancesService extends BaseSpotinstService {
    public static List<ApiMrScalerListInstancesAws> listMrScalerInstances(String clusterId, String authToken, String account)
            throws SpotinstHttpException {
        List<ApiMrScalerListInstancesAws> retVal = null;

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
        String uri = String.format("%s/aws/emr/mrScaler/%s/instance", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        MrScalerListInstancesApiResponse mrScalerListInstancesApiResponse = getCastedResponse(response, MrScalerListInstancesApiResponse.class);

        if (mrScalerListInstancesApiResponse.getResponse().getCount() > 0) {
            retVal = mrScalerListInstancesApiResponse.getResponse().getItems();
        }
        return retVal;
    }
}
