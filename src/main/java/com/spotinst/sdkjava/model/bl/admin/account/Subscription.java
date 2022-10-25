package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.bl.admin.account.common.SubscriptionEventFormat;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     resourceId;
    private SubscriptionProtocolEnum   protocol;
    private String                     endpoint;
    private SubscriptionEventTypeEnum  eventType;
    private SubscriptionEventFormat    eventFormat;

    private Subscription() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        isSet.add("resourceId");
        this.resourceId = resourceId;
    }

    public SubscriptionProtocolEnum getProtocol() {
        return protocol;
    }

    public void setProtocol(SubscriptionProtocolEnum protocol) {
        isSet.add("protocol");
        this.protocol = protocol;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        isSet.add("endpoint");
        this.endpoint = endpoint;
    }

    public SubscriptionEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(SubscriptionEventTypeEnum eventType) {
        isSet.add("eventType");
        this.eventType = eventType;
    }

    public SubscriptionEventFormat getEventFormat() {
        return eventFormat;
    }

    public void setEventFormat(SubscriptionEventFormat eventFormat) {
        isSet.add("eventFormat");
        this.eventFormat = eventFormat;
    }

    public static class Builder {
        private Subscription subscription;

        private Builder() {
            this.subscription = new Subscription();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setResourceId(final String resourceId) {
            subscription.setResourceId(resourceId);
            return this;
        }

        public Builder setProtocol(final SubscriptionProtocolEnum protocol) {
            subscription.setProtocol(protocol);
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

        public Builder setEventFormat(final SubscriptionEventFormat eventFormat) {
            subscription.setEventFormat(eventFormat);
            return this;
        }

        public Subscription build() {
            return subscription;
        }
    }

    @JsonIgnore
    public boolean isResourceIdSet() {
        return isSet.contains("resourceId");
    }

    @JsonIgnore
    public boolean isProtocolSet() {
        return isSet.contains("protocol");
    }

    @JsonIgnore
    public boolean isEndpointSet() {
        return isSet.contains("endpoint");
    }

    @JsonIgnore
    public boolean isEventTypeSet() {
        return isSet.contains("eventType");
    }

    @JsonIgnore
    public boolean isEventFormatSet() {
        return isSet.contains("eventFormat");
    }
}