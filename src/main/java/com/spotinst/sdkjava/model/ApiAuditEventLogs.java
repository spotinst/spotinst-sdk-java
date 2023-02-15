package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ramrutha on 13/02/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiAuditEventLogs {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String actionType;
    private String agent;
    private String context;
    private String createdAt;
    private String namespace;
    private String resourceId;
    private String resourceType;
    private Integer responseStatus;
    private String source;
    private String user;
    //endregion

    //region Constructor
    private ApiAuditEventLogs() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter & Setter

    //region Getter & Setter
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //region isSet methods
    @JsonIgnore
    public boolean isActionTypeSet() {
        return isSet.contains("actionType");
    }

    @JsonIgnore
    public boolean isAgentSet() {
        return isSet.contains("agent");
    }

    @JsonIgnore
    public boolean isContextSet() {
        return isSet.contains("context");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isNameSpaceSet() {
        return isSet.contains("namespace");
    }

    @JsonIgnore
    public boolean isRecourceIdSet() {
        return isSet.contains("resourceId");
    }

    @JsonIgnore
    public boolean isResourceTypeSet() { return isSet.contains("resourceType"); }

    @JsonIgnore
    public boolean isResponseStatusSet() {
        return isSet.contains("responseStatus");
    }

    @JsonIgnore
    public boolean isSourceSet() {
        return isSet.contains("source");
    }

    @JsonIgnore
    public boolean isUserSet() {
        return isSet.contains("user");
    }
    //endregion
}
