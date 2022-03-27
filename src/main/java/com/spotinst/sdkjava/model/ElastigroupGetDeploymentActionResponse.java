package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetDeploymentActionResponse {

    @JsonIgnore
    private Set<String>  isSet;
    private String       groupId;
    private String       rollId;
    private String       actionType;
    private List<String> detachedInstances;

    public ElastigroupGetDeploymentActionResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public String getRollId() {
        return rollId;
    }

    public void setRollId(String rollId) {
        isSet.add("rollId");
        this.rollId = rollId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        isSet.add("actionType");
        this.actionType = actionType;
    }

    public List<String> getDetachedInstances() {
        return detachedInstances;
    }

    public void setDetachedInstances(List<String> detachedInstances) {
        isSet.add("detachedInstances");
        this.detachedInstances = detachedInstances;
    }


    public static class Builder {
        private ElastigroupGetDeploymentActionResponse getDeploymentAction;

        private Builder() {
            this.getDeploymentAction = new ElastigroupGetDeploymentActionResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setGroupId(final String groupId) {
            getDeploymentAction.setGroupId(groupId);
            return this;
        }

        public Builder setRollId(final String rollId) {
            getDeploymentAction.setRollId(rollId);
            return this;
        }

        public Builder setActionType(final String actionType) {
            getDeploymentAction.setActionType(actionType);
            return this;
        }

        public Builder setDetachedInstances(final List<String> detachedInstances) {
            getDeploymentAction.setDetachedInstances(detachedInstances);
            return this;
        }

        public ElastigroupGetDeploymentActionResponse build() {
            return getDeploymentAction;
        }
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isRollIdSet() {
        return isSet.contains("rollId");
    }

    @JsonIgnore
    public boolean isActionTypeSet() {
        return isSet.contains("actionType");
    }

    @JsonIgnore
    public boolean isDetachedInstancesSet() {
        return isSet.contains("detachedInstances");
    }



}

