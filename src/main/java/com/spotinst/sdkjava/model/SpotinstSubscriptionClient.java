package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
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

    public Subscription subscribeToEvent(SubscriptionCreationRequest subscriptionCreationRequest) {

        Subscription retVal;

        Subscription subscriptionToCreate = subscriptionCreationRequest.getSubscription();
        RepoGenericResponse<Subscription> creationResponse = spotinstSubscriptionRepo.create(subscriptionToCreate, authToken, account);
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

    public Subscription getSubscriptionEvent(SubscriptionGetRequest subscriptionGetRequest) {

        Subscription retVal;
        String subscriptionId = subscriptionGetRequest.getSubscriptionId();
        RepoGenericResponse<Subscription> creationResponse = spotinstSubscriptionRepo.get(subscriptionId, authToken,account);
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

    public Boolean deleteSubscription(SubscriptionDeletionRequest subscriptionDeletionRequest) {

        Boolean retVal;

        String subscriptionId = subscriptionDeletionRequest.getSubscriptionId();

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
}
