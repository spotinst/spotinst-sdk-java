package com.spotinst.sdkjava.model.service.admin.messageCenter;

import com.spotinst.sdkjava.client.response.BaseServiceEmptyResponse;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.admin.messageCenter.*;
import com.spotinst.sdkjava.model.requests.admin.account.messageCenter.ListAllMessagesRequest;
import com.spotinst.sdkjava.model.responses.admin.messageCenter.GetMessageApiResponse;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MessageCenterService extends BaseSpotinstService {

    public static Boolean createMessage(ApiCreateMessage messageToCreate, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = "http://message-center-public.dev.spotinst.com";//config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        String body = JsonMapper.toJson(messageToCreate);

        //Build URI
        String uri = String.format("%s/messageCenter/message", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPost(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static List<ApiGetMessage> getAllMessages(ListAllMessagesRequest listAllMessagesRequest, String authToken) {

        List<ApiGetMessage> getMessages = new LinkedList<>();

        // Get endpoint
        SpotinstHttpConfig config      = SpotinstHttpContext.getInstance().getConfiguration();
        String             apiEndpoint = "http://message-center-public.dev.spotinst.com";//config.getEndpoint();

        // Build query params
        Map<String, String> queryParams = new HashMap<>();

        // Add limit Query param
        if (listAllMessagesRequest.getLimit()!= null) {
            queryParams.put("limit", String.valueOf(listAllMessagesRequest.getLimit()));
        }

        // Add nonStickyMaxTimeStamp Query param
        if (listAllMessagesRequest.getNonStickyMaxTimestamp() != null) {
            queryParams.put("nonStickyMaxTimestamp",  String.valueOf(listAllMessagesRequest.getNonStickyMaxTimestamp()));
        }

        // Add nonStickyMinTimeStamp Query param
        if (listAllMessagesRequest.getNonStickyMinTimestamp() != null) {
            queryParams.put("nonStickyMinTimestamp ",  String.valueOf(listAllMessagesRequest.getNonStickyMinTimestamp()));
        }

        // Add starred Query param
        if (listAllMessagesRequest.getStarred() != null) {
            queryParams.put("isStarred",  String.valueOf(listAllMessagesRequest.getStarred()));
        }

        // Get the headers
        Map<String, String> headers = buildHeaders(authToken);

        // Build URI
        String uri = String.format("%s/messageCenter/userMessage", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendGet(uri, headers, queryParams);

        // Handle the response.

        GetMessageApiResponse
                castedApiResponse = getCastedResponse(response, GetMessageApiResponse.class);

        if (castedApiResponse.getResponse().getCount() > 0) {
            getMessages = castedApiResponse.getResponse().getItems();
        }

        return getMessages;
    }

    public static Boolean updateMessage(ApiUpdateMessage requestToUpdate, String messageId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = "http://message-center-public.dev.spotinst.com";//config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        String body = JsonMapper.toJson(requestToUpdate);

        //Build URI
        String uri = String.format("%s/messageCenter/userMessage/%s", apiEndpoint,messageId);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean bulkUpdateMessages(ApiBulkUpdateMessages requestToUpdate, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = "http://message-center-public.dev.spotinst.com";//config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        String body = JsonMapper.toJson(requestToUpdate);

        //Build URI
        String uri = String.format("%s/messageCenter/userMessage/bulk", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendPut(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }

    public static Boolean bulkDeleteMessages(ApiBulkDeleteMessages requestToDelete, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = "http://message-center-public.dev.spotinst.com";//config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        // Write to json
        String body = JsonMapper.toJson(requestToDelete);

        //Build URI
        String uri = String.format("%s/messageCenter/userMessage/bulk", apiEndpoint);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, body, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }


    public static Boolean deleteMessage(String messageId, String authToken) throws SpotinstHttpException {

        // Init retVal
        Boolean retVal = false;

        // Get endpoint
        SpotinstHttpConfig config = SpotinstHttpContext.getInstance().getConfiguration();
        String apiEndpoint = "http://message-center-public.dev.spotinst.com";//config.getEndpoint();

        // Get the headers for AWS.
        Map<String, String> headers = buildHeaders(authToken);

        //Build URI
        String uri = String.format("%s/messageCenter/userMessage/%s", apiEndpoint,messageId);

        // Send the request.
        RestResponse response = RestClient.sendDelete(uri, null, headers, null);

        // Handle the response.
        BaseServiceEmptyResponse emptyResponse = getCastedResponse(response, BaseServiceEmptyResponse.class);

        if (emptyResponse.getResponse().getStatus().getCode() == HttpStatus.SC_OK) {
            retVal = true;
        }

        return retVal;
    }
}
