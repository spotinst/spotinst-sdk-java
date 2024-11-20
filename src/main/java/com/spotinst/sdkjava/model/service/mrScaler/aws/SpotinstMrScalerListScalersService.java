package com.spotinst.sdkjava.model.service.mrScaler.aws;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.RestClient;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.client.rest.SpotinstHttpConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListScalersAws;
import com.spotinst.sdkjava.model.responses.mrScaler.aws.MrScalerListMrScalersApiResponse;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotinstMrScalerListScalersService extends BaseSpotinstService {
    public static List<ApiMrScalerListScalersAws> listMrScalerInstances(String clusterId, String authToken, String account)
            throws SpotinstHttpException {
        List<ApiMrScalerListScalersAws> retVal = null;

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

        MrScalerListMrScalersApiResponse
                mrScalerListMrScalersApiResponse = getCastedResponse(response, MrScalerListMrScalersApiResponse.class);

        if (mrScalerListMrScalersApiResponse.getResponse().getCount() > 0) {
            retVal = mrScalerListMrScalersApiResponse.getResponse().getItems();
        }
        return retVal;
    }
}