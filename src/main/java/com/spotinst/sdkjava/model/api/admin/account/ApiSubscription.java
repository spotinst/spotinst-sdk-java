package com.spotinst.sdkjava.model.api.admin.account;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.api.admin.account.common.ApiSubscriptionEventFormat;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiSubscription implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     resourceId;
    private String                     protocol;
    private String                     endpoint;
    private String                     eventType;
    private ApiSubscriptionEventFormat eventFormat;

    public ApiSubscription() {
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