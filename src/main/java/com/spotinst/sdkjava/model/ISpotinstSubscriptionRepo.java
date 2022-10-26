package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.account.Subscription;
import com.spotinst.sdkjava.model.bl.admin.account.response.SubscriptionResponse;

import java.util.List;

/**
 * Created by talzur on 11/01/2017.
 */
interface ISpotinstSubscriptionRepo extends IRepository<SubscriptionResponse, Void, String> {

    RepoGenericResponse<SubscriptionResponse> create(Subscription subscriptionToCreate, String authToken, String account);

    RepoGenericResponse<List<SubscriptionResponse>> getAllSubscriptionEvents(String authToken, String account);

    RepoGenericResponse<Boolean> updateSubscription(Subscription subscriptionUpdateReq, String subscriptionId, String authToken, String account);
}
