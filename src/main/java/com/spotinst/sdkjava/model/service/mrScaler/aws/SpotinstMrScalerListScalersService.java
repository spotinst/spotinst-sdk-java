package com.spotinst.sdkjava.model.service.mrScaler.aws;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.RestClient;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.client.rest.SpotinstHttpConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerListScalersAws;
import com.spotinst.sdkjava.model.responses.mrScaler.aws.ApiMrScalerListMrScalersResponse;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotinstMrScalerListScalersService extends BaseSpotinstService {
    public static List<BlMrScalerListScalersAws> listMrScalerInstances(String clusterId, String authToken, String account)
            throws SpotinstHttpException {
        List<BlMrScalerListScalersAws> retVal = null;

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
        String uri = String.format("%s/aws/emr/mrScaler/%s/cluster", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        ApiMrScalerListMrScalersResponse
                apiMrScalerListMrScalersResponse = getCastedResponse(response, ApiMrScalerListMrScalersResponse.class);

        if (apiMrScalerListMrScalersResponse.getResponse().getCount() > 0) {
            retVal = apiMrScalerListMrScalersResponse.getResponse().getItems();
        }
        return retVal;
    }
}