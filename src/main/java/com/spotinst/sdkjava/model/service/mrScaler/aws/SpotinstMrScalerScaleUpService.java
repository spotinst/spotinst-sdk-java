package com.spotinst.sdkjava.model.service.mrScaler.aws;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.RestClient;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.client.rest.SpotinstHttpConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleUpAws;
import com.spotinst.sdkjava.model.responses.mrScaler.aws.MrScalerScaleUpApiResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotinstMrScalerScaleUpService extends BaseSpotinstService {
    public static List<ApiMrScalerScaleUpAws> scaleUpMrScaler(String clusterId, Integer adjustment, String authToken, String account)
            throws SpotinstHttpException {
        List<ApiMrScalerScaleUpAws> retVal = null;

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
            queryParams.put("adjustment", Integer.toString(adjustment));
            queryParams.put("targetGroup","TASK");
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        String body = "";

                // Build URI
        String uri = String.format("%s/aws/emr/mrScaler/%s/scale/up", apiEndpoint, clusterId);

        // Send the request
        RestResponse response = RestClient.sendPut(uri, body, headers, queryParams);

        MrScalerScaleUpApiResponse mrScalerScaleUpApiResponse = getCastedResponse(response, MrScalerScaleUpApiResponse.class);

        if (mrScalerScaleUpApiResponse.getResponse().getCount() > 0) {
            retVal = mrScalerScaleUpApiResponse.getResponse().getItems();
        }
        return retVal;
    }
}