package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.RestClient;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.client.rest.SpotinstHttpConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

class SpotinstSpectrumService extends BaseSpotinstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSpectrumService.class);

    static Boolean publishMetricData(SpectrumMetricDataRequest dataRequest, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = config.getEndpoint();

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/spectrum/metricData", apiEndpoint);

        // Write to json
        Collection<String> requestsBody = dataRequest.toJsonParts();

        RestResponse response = null;
        for (String body : requestsBody) {
            // Send the request
            response = RestClient.sendPost(uri, body, headers, null);
        }

        // Handle the response.
        SpectrumApiResponse apiResponse = getCastedResponse(response, SpectrumApiResponse.class);

        if (apiResponse.getResponse().getStatus().getCode() == 200) {
            retVal = true;
        }

        return retVal;
    }
}
