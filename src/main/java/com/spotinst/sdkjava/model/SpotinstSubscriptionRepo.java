package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

/**
 * Created by talzur on 11/01/2017.
 */
class SpotinstSubscriptionRepo implements ISpotinstSubscriptionRepo {
    @Override
    public RepoGenericResponse<Subscription> create(Subscription subscriptionToCreate, String authToken, String account) {
        RepoGenericResponse<Subscription> retVal;

        try {
            ApiSubscription apiSubscriptionToCreate = SubscriptionConverter.toDal(subscriptionToCreate);
            ApiSubscription apiCreatedSubscription = SpotinstSubscriptionService.createSubscription(apiSubscriptionToCreate, authToken);
            Subscription createdSubscription = SubscriptionConverter.toBl(apiCreatedSubscription);
            retVal = new RepoGenericResponse<>(createdSubscription);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String subscriptionId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstSubscriptionService.deleteSubscription(subscriptionId, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Subscription> get(String subscriptionId, String authToken, String account) {
        RepoGenericResponse<Subscription> retVal;

        try {
            ApiSubscription apiSubscription = SpotinstSubscriptionService.getSubscription(subscriptionId, authToken, account);
            Subscription subscription = SubscriptionConverter.toBl(apiSubscription);
            retVal = new RepoGenericResponse<>(subscription);

        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
