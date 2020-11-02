package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class GroupDeploymentCreateAzure {
    //region Members
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           id;
    private String                           groupId;
    private GroupDeploymentStateEnumAzure    status;
    private Integer                          currentBatch;
    private Integer                          numOfBatches;
    private DeploymentProgressIndicatorAzure progress;
    private Date                             createdAt;
    private Date                             updatedAt;
    //endregion

    //region constructor
    public GroupDeploymentCreateAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters and Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        touch("isSet");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        touch("id");
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
        touch("groupId");
    }

    public GroupDeploymentStateEnumAzure getStatus() {
        return status;
    }

    public void setStatus(GroupDeploymentStateEnumAzure status) {
        this.status = status;
        touch("status");
    }

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        this.currentBatch = currentBatch;
        touch("currentBatch");
    }

    public Integer getNumOfBatches() {
        return numOfBatches;
    }

    public void setNumOfBatches(Integer numOfBatches) {
        this.numOfBatches = numOfBatches;
        touch("numOfBatches");
    }

    public DeploymentProgressIndicatorAzure getProgress() {
        return progress;
    }

    public void setProgress(DeploymentProgressIndicatorAzure progress) {
        this.progress = progress;
        touch("progress");
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        touch("createdAt");
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        touch("updatedAt");
    }

    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isIdSet() {
        return this.isSet.contains("id");
    }
    @JsonIgnore
    public Boolean isGroupIdSet() {
        return this.isSet.contains("groupId");
    }
    @JsonIgnore
    public Boolean isStatusSet() {
        return this.isSet.contains("status");
    }
    @JsonIgnore
    public Boolean isCurrentBatchSet() {
        return this.isSet.contains("currentBatch");
    }
    @JsonIgnore
    public Boolean isNumOfBatchesSet() {
        return this.isSet.contains("numOfBatches");
    }
    @JsonIgnore
    public Boolean isProgressSet() {
        return this.isSet.contains("progress");
    }
    @JsonIgnore
    public Boolean isCreatedAtSet() {
        return this.isSet.contains("createdAt");
    }
    @JsonIgnore
    public Boolean isUpdatedAtSet() {
        return this.isSet.contains("updatedAt");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
