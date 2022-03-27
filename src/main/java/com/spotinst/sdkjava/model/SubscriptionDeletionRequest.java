package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 18/01/2017.
 */
public class SubscriptionDeletionRequest {
    //region Members
    private String subscriptionId;
    //endregion

    //region Private Constructor
    private SubscriptionDeletionRequest() {
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
        private SubscriptionDeletionRequest subscriptionDeletionRequest;

        private Builder() {
            this.subscriptionDeletionRequest = new SubscriptionDeletionRequest();
        }

        public static SubscriptionDeletionRequest.Builder get() {
            return new Builder();
        }

        public SubscriptionDeletionRequest.Builder setSubscriptionId(final String subscriptionId) {
            subscriptionDeletionRequest.setSubscriptionId(subscriptionId);
            return this;
        }

        public SubscriptionDeletionRequest build() {
            // TODO : Validations
            return subscriptionDeletionRequest;
        }

    }
    //endregion

}
