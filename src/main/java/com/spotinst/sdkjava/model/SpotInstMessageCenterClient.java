package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.messageCenter.*;
import com.spotinst.sdkjava.model.requests.admin.messageCenter.ListAllMessagesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotInstMessageCenterClient {
    private static final Logger                      LOGGER =
            LoggerFactory.getLogger(SpotInstMessageCenterClient.class);
    //Members
    private              String                      authToken;
    private              IMessageCenterRepo  messageCenterRepo;

    //Constructor
    public SpotInstMessageCenterClient(String authToken) {
        this.authToken = authToken;
        this.messageCenterRepo = SpotinstRepoManager.getInstance().getSpotMessageCenterRepo();
    }

    private IMessageCenterRepo getMessageCenterRepo() {
        return messageCenterRepo;

    }

    //Methods
    public Boolean createMessage(CreateMessage messageRequestToCreate) {
        Boolean retVal;


        RepoGenericResponse<Boolean> creationResponse =
                getMessageCenterRepo().create(messageRequestToCreate, authToken);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create a notification message. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<GetMessageResponse> getAllMessages(ListAllMessagesRequest listAllMessagesRequest) {

        List<GetMessageResponse> retVal = null;

        RepoGenericResponse<List<GetMessageResponse>> getResponse =
                getMessageCenterRepo().getAll(listAllMessagesRequest,authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get all messages. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateMessage(UpdateMessage requestToUpdate, String messageId) {
        Boolean retVal;


        RepoGenericResponse<Boolean> updateResponse =
                getMessageCenterRepo().update(requestToUpdate, messageId,authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create a notification message. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean bulkUpdateMessages(BulkUpdateMessages requestToUpdate) {
        Boolean retVal;


        RepoGenericResponse<Boolean> updateResponse =
                getMessageCenterRepo().bulkUpdate(requestToUpdate,authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create a notification message. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean bulkDeleteMessages(BulkDeleteMessages requestToDelete) {
        Boolean retVal;


        RepoGenericResponse<Boolean> updateResponse =
                getMessageCenterRepo().bulkDelete(requestToDelete,authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create a notification message. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }


    public Boolean deleteMessage(String messageId) {
        Boolean retVal;


        RepoGenericResponse<Boolean> updateResponse =
                getMessageCenterRepo().delete(messageId,authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create a notification message. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
}
