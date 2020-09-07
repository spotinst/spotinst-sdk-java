package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SpotinstMrScalerOperatorAwsService extends BaseSpotinstService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstElastigroupService.class);

    static BlMrScalerOperatorResponse createMrScalerOperator(BlMrScalerOperatorAws blMrScalerOperatorAws, String authToken, String account)
            throws SpotinstHttpException {
        BlMrScalerOperatorResponse retVal = null;

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

        // body
        String body = JsonMapper.toJson(blMrScalerOperatorAws);

        // Build URI
        String uri = String.format("%s/aws/emr/mrScalerOperator", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        MrScalerOperatorApiResponse mrScalerOperatorApiReponse = getCastedResponse(response, MrScalerOperatorApiResponse.class);

        if (mrScalerOperatorApiReponse.getResponse().getCount() > 0) {
            retVal = mrScalerOperatorApiReponse.getResponse().getItems().get(0);
        }
        return retVal;
    }

}
