package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;


/**
 * Created by aharontwizer on 8/24/15.
 */
public class Subscription {
    //region Members
    @JsonIgnore
    private String id;
    private String resourceId;
    private SubscriptionProtocolEnum protocol;
    private String endpoint;
    private SubscriptionEventTypeEnum eventType;
    private String eventFormat;
    //endregion

    //region Private Constructor

    private Subscription() {
    }

    //endregion

    //region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public SubscriptionProtocolEnum getProtocol() {
        return protocol;
    }

    public void setProtocol(SubscriptionProtocolEnum protocol) {
        this.protocol = protocol;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public SubscriptionEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(SubscriptionEventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public String getEventFormat() {
        return eventFormat;
    }

    public void setEventFormat(String eventFormat) {
        this.eventFormat = eventFormat;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private Subscription subscription;
        //endregion


        private Builder() {
            this.subscription = new Subscription();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        protected Builder setId(final String resourceId) {
            subscription.setId(resourceId);
            return this;
        }

        public Builder setResourceId(final String resourceId) {
            subscription.setResourceId(resourceId);
            return this;
        }

        public Builder setEndpoint(final String endpoint) {
            subscription.setEndpoint(endpoint);
            return this;
        }

        public Builder setEventType(final SubscriptionEventTypeEnum eventType) {
            subscription.setEventType(eventType);
            return this;
        }

        public Builder setProtocol(final SubscriptionProtocolEnum protocol) {
            subscription.setProtocol(protocol);
            return this;
        }

        public Builder setEventFormat(final String eventFormat) {
            subscription.setEventFormat(eventFormat);
            return this;
        }


        public Subscription build() {
            // Validations
            return subscription;
        }
        //endregion
    }
    //endregion
}
