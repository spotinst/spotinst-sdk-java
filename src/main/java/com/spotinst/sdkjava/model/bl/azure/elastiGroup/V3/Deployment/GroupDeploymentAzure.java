package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment;

import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;

import java.util.Date;

public class GroupDeploymentAzure {
    //region Members
    private String                           id;
    private String                           groupId;
    private GroupDeploymentStateEnumAzure    status;
    private Integer                          currentBatch;
    private Integer                          numOfBatches;
    private DeploymentProgressIndicatorAzure progress;
    private Date                             createdAt;
    private Date                             updatedAt;
    //endregion

    //region Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public GroupDeploymentStateEnumAzure getStatus() {
        return status;
    }

    public void setStatus(GroupDeploymentStateEnumAzure status) {
        this.status = status;
    }

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        this.currentBatch = currentBatch;
    }

    public Integer getNumOfBatches() {
        return numOfBatches;
    }

    public void setNumOfBatches(Integer numOfBatches) {
        this.numOfBatches = numOfBatches;
    }

    public DeploymentProgressIndicatorAzure getProgress() {
        return progress;
    }

    public void setProgress(DeploymentProgressIndicatorAzure progress) {
        this.progress = progress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    //endregion
}
