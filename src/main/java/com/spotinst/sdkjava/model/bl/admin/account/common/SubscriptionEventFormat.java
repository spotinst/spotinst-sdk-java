package com.spotinst.sdkjava.model.bl.admin.account.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Janetlin Kiruba on 10/24/22.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionEventFormat {
    @JsonIgnore
    private Set<String>              isSet;
    private String                   resourceId;
    private String                   event;
    private String                   resourceName;
    private String                   instanceId;
    private String                   myCustomKey;

    private SubscriptionEventFormat() {
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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        isSet.add("event");
        this.event = event;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        isSet.add("resourceName");
        this.resourceName = resourceName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getMyCustomKey() {
        return myCustomKey;
    }

    public void setMyCustomKey(String myCustomKey) {
        isSet.add("myCustomKey");
        this.myCustomKey = myCustomKey;
    }

    public static class Builder {
        private SubscriptionEventFormat subscriptionEventFormat;

        private Builder() {
            this.subscriptionEventFormat = new SubscriptionEventFormat();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setEvent(final String event) {
            subscriptionEventFormat.setEvent(event);
            return this;
        }

        public Builder setResourceId(final String resourceId) {
            subscriptionEventFormat.setResourceId(resourceId);
            return this;
        }

        public Builder setInstanceId(final String instanceId) {
            subscriptionEventFormat.setInstanceId(instanceId);
            return this;
        }

        public Builder setResourceName(final String resourceName) {
            subscriptionEventFormat.setResourceName(resourceName);
            return this;
        }

        public Builder setMyCustomKey(final String myCustomKey) {
            subscriptionEventFormat.setMyCustomKey(myCustomKey);
            return this;
        }

        public SubscriptionEventFormat build() {
            return subscriptionEventFormat;
        }
    }

    @JsonIgnore
    public boolean isEventSet() {
        return isSet.contains("event");
    }

    @JsonIgnore
    public boolean isResourceIdSet() {
        return isSet.contains("resourceId");
    }

    @JsonIgnore
    public boolean isResourceNameSet() {
        return isSet.contains("resourceName");
    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isMyCustomKeySet() {
        return isSet.contains("myCustomKey");
    }
}