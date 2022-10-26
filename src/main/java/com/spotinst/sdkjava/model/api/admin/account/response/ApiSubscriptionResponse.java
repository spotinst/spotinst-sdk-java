package com.spotinst.sdkjava.model.api.admin.account.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;
import com.spotinst.sdkjava.model.api.admin.account.common.ApiSubscriptionEventFormat;
import com.spotinst.sdkjava.model.bl.admin.account.common.SubscriptionEventFormat;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Janetlin Kiruba on 10/25/22.
 */
public class ApiSubscriptionResponse {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String id;
    private String resourceId;
    private String resourceName;
    private String protocol;
    private String endpoint;
    private String eventType;
    private ApiSubscriptionEventFormat eventFormat;
    private String                   createdAt;
    private String                   updatedAt;

    //endregion

    //region Private Constructor

    private ApiSubscriptionResponse() {
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

    public ApiSubscriptionEventFormat getEventFormat() {
        return eventFormat;
    }

    public void setEventFormat(ApiSubscriptionEventFormat eventFormat) {
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