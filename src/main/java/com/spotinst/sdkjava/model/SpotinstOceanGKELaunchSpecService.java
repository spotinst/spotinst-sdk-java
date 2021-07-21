package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.HashMap;
import java.util.Map;

public class SpotinstOceanGKELaunchSpecService extends BaseSpotinstService {

    public static ApiOceanGKELaunchSpec createLaunchSpec(ApiOceanGKELaunchSpec groupToCreate, String authToken,
                                                   String account) throws SpotinstHttpException {
        // Init retVal
        ApiOceanGKELaunchSpec retVal = null;

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


        // Write to json
        Map<String, ApiOceanGKELaunchSpec> groupRequest = new HashMap<>();
        groupRequest.put("group", groupToCreate);
        String body = JsonMapper.toJson(groupRequest);

        // Build URI
        String uri = String.format("%s/aws/ec2/group", apiEndpoint);

        // Send the request
        RestResponse response = RestClient.sendPost(uri, body, headers, queryParams);

        // Handle the response.
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = getCastedResponse(response, OceanGKECreateLaunchSpecRes.class);


        if (oceanGKECreateLaunchSpecRes.getResponse().getCount() > 0) {
            retVal = oceanGKECreateLaunchSpecRes.getResponse().getItems().get(0);
        }

        return retVal;
    }

}
