package com.spotinst.sdkjava.model.api.admin.account.common;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Janetlin Kiruba on 10/24/22.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiSubscriptionEventFormat implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>              isSet;
    private String                   resourceId;
    private String                   event;
    private String                   resourceName;
    private String                   instanceId;
    private String                   myCustomKey;

    public ApiSubscriptionEventFormat() {
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