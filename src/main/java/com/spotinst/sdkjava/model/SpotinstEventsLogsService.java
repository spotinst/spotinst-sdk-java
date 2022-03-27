package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.RestClient;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.client.rest.SpotinstHttpConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by danielsarisrael on 09/05/2021.
 */
public class SpotinstEventsLogsService extends BaseSpotinstService {

    public static List<ApiEventLog> getEventsLogs(String fromDate, String toDate, String severity, String resourceId,
                                                  String limit, String elastigroupId, String authToken,
                                                  String account) {
        // Init retVal
        List<ApiEventLog> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<>();

        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }
        // Add fromDate Query param
        if (fromDate != null) {
            queryParams.put("fromDate", fromDate);
        }
        // Add toDate Query param
        if (toDate != null) {
            queryParams.put("toDate", toDate);
        }
        // Add severity Query param
        if (severity != null) {
            queryParams.put("severity", severity);
        }
        // Add resourceId Query param
        if (resourceId != null) {
            queryParams.put("resourceId", resourceId);
        }
        // Add limit Query param
        if (limit != null) {
            queryParams.put("limit", limit);
        }

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/aws/ec2/group/%s/logs", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        EventsLogsApiResponse eventsLogsResponse = getCastedResponse(response, EventsLogsApiResponse.class);
        if (eventsLogsResponse.getResponse().getItems().size() > 0) {
            retVal = eventsLogsResponse.getResponse().getItems();
        }

        return retVal;
    }
}