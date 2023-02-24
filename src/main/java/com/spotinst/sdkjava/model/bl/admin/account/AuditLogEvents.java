package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ramrutha on 13/02/2023.
 */
public class AuditLogEvents {

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
    private AuditLogEvents() {
        isSet = new HashSet<>();
    }
    //endregion

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
        isSet.add("actionType");
        this.actionType = actionType;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        isSet.add("agent");
        this.agent = agent;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        isSet.add("context");
        this.context = context;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        isSet.add("resourceId");
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        isSet.add("resourceType");
        this.resourceType = resourceType;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        isSet.add("resporseStatus");
        this.responseStatus = responseStatus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        isSet.add("source");
        this.source = source;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        isSet.add("user");
        this.user = user;
    }

    //region Builder class
    public static class Builder {
        private AuditLogEvents eventLogs;

        private Builder() {
            this.eventLogs = new AuditLogEvents();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setActionType(final String actionType) {
            eventLogs.setActionType(actionType);
            return this;
        }

        public Builder setAgent(final String agent) {
            eventLogs.setAgent(agent);
            return this;
        }

        public Builder setContext(final String context) {
            eventLogs.setContext(context);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            eventLogs.setCreatedAt(createdAt);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            eventLogs.setNamespace(namespace);
            return this;
        }

        public Builder setResourceId(final String resourceId) {
            eventLogs.setResourceId(resourceId);
            return this;
        }

        public Builder setResourceType(final String resourceType) {
            eventLogs.setResourceType(resourceType);
            return this;
        }

        public Builder setResponseStatus(final Integer responseStatus) {
            eventLogs.setResponseStatus(responseStatus);
            return this;
        }

        public Builder setSource(final String source) {
            eventLogs.setSource(source);
            return this;
        }

        public Builder setUser(final String user) {
            eventLogs.setUser(user);
            return this;
        }

        public AuditLogEvents build() {
            return eventLogs;
        }
    }
    //endregion

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
