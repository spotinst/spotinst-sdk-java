package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.account.Subscription;
import com.spotinst.sdkjava.model.bl.admin.account.response.SubscriptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by talzur on 18/01/2017.
 */
public class SpotinstSubscriptionClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSubscriptionClient.class);
    //region Members
    private String authToken;
    private String account;
    private ISpotinstSubscriptionRepo spotinstSubscriptionRepo;

    public SpotinstSubscriptionClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;
        this.spotinstSubscriptionRepo = SpotinstRepoManager.getInstance().getSpotinstSubscriptionRepo();
    }

    public SubscriptionResponse subscribeToEvent(Subscription subscriptionCreationRequest) {

        SubscriptionResponse retVal;

        RepoGenericResponse<SubscriptionResponse> creationResponse = spotinstSubscriptionRepo.create(subscriptionCreationRequest, authToken, account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        } else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to subscribe to event. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public SubscriptionResponse getSubscriptionEvent(String subscriptionId) {

        SubscriptionResponse retVal;

        RepoGenericResponse<SubscriptionResponse> creationResponse = spotinstSubscriptionRepo.get(subscriptionId, authToken,account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        } else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to subscribe to event. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteSubscription(String subscriptionId) {

        Boolean retVal;

        RepoGenericResponse<Boolean> subscriptionDeletionResponse = spotinstSubscriptionRepo.delete(subscriptionId, authToken, account);
        if (subscriptionDeletionResponse.isRequestSucceed()) {
            retVal = subscriptionDeletionResponse.getValue();
        } else {
            List<HttpError> httpExceptions = subscriptionDeletionResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to delete subscription. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<SubscriptionResponse> getAllSubscriptionEvents() {

        List<SubscriptionResponse> retVal;

        RepoGenericResponse<List<SubscriptionResponse>> creationResponse = spotinstSubscriptionRepo.getAllSubscriptionEvents(authToken,account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        } else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get all subscriptions. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateSubscription(Subscription subscriptionUpdationRequest, String subscriptionId) {

        Boolean retVal;

        RepoGenericResponse<Boolean> creationResponse = spotinstSubscriptionRepo.updateSubscription(subscriptionUpdationRequest, subscriptionId, authToken, account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        } else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to update the subscription. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

}
