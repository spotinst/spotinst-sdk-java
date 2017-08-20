package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.rest.JsonMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by talzur on 18/01/2017.
 */
public class SubscriptionCreationRequest {
    //region Members
    private Subscription subscription;
    //endregion

    //region Private Constructor
    private SubscriptionCreationRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
    //endregion

    //region Json methods
    public String toJson() {
        String retVal = null;
        if (subscription != null) {
            ApiSubscription apiSubscriptionToCreate = SubscriptionConverter.toDal(subscription);

            Map<String, ApiSubscription> subscriptionRequest = new HashMap<>();
            subscriptionRequest.put("subscription", apiSubscriptionToCreate);
            String elastigroupJson = JsonMapper.toJson(subscriptionRequest);

            retVal = elastigroupJson;
        }
        return retVal;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private SubscriptionCreationRequest subscriptionCreationRequest;

        private Builder() {
            this.subscriptionCreationRequest = new SubscriptionCreationRequest();
        }

        public static SubscriptionCreationRequest.Builder get() {
            SubscriptionCreationRequest.Builder builder = new SubscriptionCreationRequest.Builder();
            return builder;
        }

        public SubscriptionCreationRequest.Builder setSubscription(final Subscription subscription) {
            subscriptionCreationRequest.setSubscription(subscription);
            return this;
        }

        public SubscriptionCreationRequest build() {
            // TODO : Validations
            return subscriptionCreationRequest;
        }

    }
    //endregion

}
