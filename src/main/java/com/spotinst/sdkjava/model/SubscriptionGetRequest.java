package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 18/01/2017.
 */
public class SubscriptionGetRequest {
    //region Members
    private String subscriptionId;
    //endregion

    //region Private Constructor
    private SubscriptionGetRequest() {
    }
    //endregion

    //region Getter and Setter methods

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private SubscriptionGetRequest subscriptionGetRequest;

        private Builder() {
            this.subscriptionGetRequest = new SubscriptionGetRequest();
        }

        public static SubscriptionGetRequest.Builder get() {
            SubscriptionGetRequest.Builder builder = new SubscriptionGetRequest.Builder();
            return builder;
        }

        public SubscriptionGetRequest.Builder setSubscriptionId(final String subscriptionId) {
            subscriptionGetRequest.setSubscriptionId(subscriptionId);
            return this;
        }

        public SubscriptionGetRequest build() {
            // TODO : Validations
            return subscriptionGetRequest;
        }

    }
    //endregion

}
