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

    public static List<ApiEventLog> getEventsLogs(String severity, String fromDate, String toDate, String elastigroupId, String authToken, String account) {
        // Init retVal
        List<ApiEventLog> retVal = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = config.getEndpoint();

        Map<String, String> queryParams = new HashMap<String, String>();

        // Add severity Query param
        if (severity != null) {
            queryParams.put("severity", severity);
        }
        // Add fromDate Query param
        if (fromDate != null) {
            queryParams.put("fromDate", fromDate);
        }
        // Add toDate Query param
        if (toDate != null) {
            queryParams.put("toDate", toDate);
        }
        // Add elastigroup Id Query param
        if (elastigroupId != null) {
            queryParams.put("resourceId", elastigroupId);
        }
        // Add account Id Query param
        if (account != null) {
            queryParams.put("accountId", account);
        }
        // Add limit with value 1000 Query param
        queryParams.put("limit", "1000");


        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/event/log/v2/search", apiEndpoint, elastigroupId);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.
        EventsLogsApiResponse eventsLogsResponse =
                getCastedResponse(response, EventsLogsApiResponse.class);
        if (eventsLogsResponse.getResponse().getItems().size() > 0) {
            retVal = eventsLogsResponse.getResponse().getItems();
        }

        return retVal;
    }
}
