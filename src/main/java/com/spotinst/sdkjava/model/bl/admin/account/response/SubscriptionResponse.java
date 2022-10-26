package com.spotinst.sdkjava.model.bl.admin.account.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;
import com.spotinst.sdkjava.model.bl.admin.account.common.SubscriptionEventFormat;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Janetlin Kiruba on 10/25/22.
 */
public class SubscriptionResponse {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String id;
    private String resourceId;
    private String resourceName;
    private String protocol;
    private String endpoint;
    private String eventType;
    private SubscriptionEventFormat eventFormat;
    private String                   createdAt;
    private String                   updatedAt;
    //endregion

    //region Private Constructor

    private SubscriptionResponse() {
        isSet = new HashSet<>();
    }

    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        isSet.add("resourceName");
        this.resourceName = resourceName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        isSet.add("resourceId");
        this.resourceId = resourceId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private SubscriptionResponse subscriptionResponse;

        private Builder() {
            this.subscriptionResponse = new SubscriptionResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            subscriptionResponse.setId(id);
            return this;
        }

        public Builder setResourceName(final String resourceName) {
            subscriptionResponse.setResourceName(resourceName);
            return this;
        }

        public Builder setResourceId(final String resourceId) {
            subscriptionResponse.setResourceId(resourceId);
            return this;
        }

        public Builder setProtocol(final String protocol) {
            subscriptionResponse.setProtocol(protocol);
            return this;
        }

        public Builder setEndpoint(final String endpoint) {
            subscriptionResponse.setEndpoint(endpoint);
            return this;
        }

        public Builder setEventType(final String eventType) {
            subscriptionResponse.setEventType(eventType);
            return this;
        }

        public Builder setEventFormat(final SubscriptionEventFormat eventFormat) {
            subscriptionResponse.setEventFormat(eventFormat);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            subscriptionResponse.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final String updatedAt) {
            subscriptionResponse.setUpdatedAt(updatedAt);
            return this;
        }

        public SubscriptionResponse build() {
            return subscriptionResponse;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isResourceNameSet() {
        return isSet.contains("resourceName");
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

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
}