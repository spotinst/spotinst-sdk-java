package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.admin.account.ApiSubscription;
import com.spotinst.sdkjava.model.api.admin.account.response.ApiSubscriptionResponse;
import com.spotinst.sdkjava.model.bl.admin.account.Subscription;
import com.spotinst.sdkjava.model.bl.admin.account.response.SubscriptionResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by talzur on 11/01/2017.
 * Modified by Janetlin Kiruba 25/10/2022.
 */
class SpotinstSubscriptionRepo implements ISpotinstSubscriptionRepo {
    @Override
    public RepoGenericResponse<SubscriptionResponse> create(Subscription subscriptionToCreate, String authToken, String account) {
        RepoGenericResponse<SubscriptionResponse> retVal;

        try {
            ApiSubscription apiSubscriptionToCreate = SubscriptionConverter.toDal(subscriptionToCreate);
            ApiSubscriptionResponse apiCreatedSubscription = SpotinstSubscriptionService.createSubscription(apiSubscriptionToCreate, authToken, account);
            SubscriptionResponse createdSubscription = SubscriptionConverter.toBl(apiCreatedSubscription);
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
    public RepoGenericResponse<SubscriptionResponse> get(String subscriptionId, String authToken, String account) {
        RepoGenericResponse<SubscriptionResponse> retVal;

        try {
            ApiSubscriptionResponse apiSubscription = SpotinstSubscriptionService.getSubscription(subscriptionId, authToken, account);
            SubscriptionResponse subscription = SubscriptionConverter.toBl(apiSubscription);
            retVal = new RepoGenericResponse<>(subscription);

        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<SubscriptionResponse>> getAllSubscriptionEvents(String authToken, String account) {
        RepoGenericResponse<List<SubscriptionResponse>> retVal;

        try {
            List<ApiSubscriptionResponse> apiCreateSubscription = SpotinstSubscriptionService.getAllSubscriptionEvents(authToken, account);
            List<SubscriptionResponse> subscriptions = apiCreateSubscription.stream().map(SubscriptionConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(subscriptions);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updatSubscription(Subscription subscriptionUpdateReq, String subscriptionId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiSubscription apiSubscription = SubscriptionConverter.toDal(subscriptionUpdateReq);

        try {
            Boolean success = SpotinstSubscriptionService.updatSubscription(apiSubscription, subscriptionId, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
