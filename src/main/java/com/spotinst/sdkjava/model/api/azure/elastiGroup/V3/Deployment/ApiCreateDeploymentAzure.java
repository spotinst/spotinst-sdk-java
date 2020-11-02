package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCreateDeploymentAzure implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>                         isSet;
    private String                              id;
    private String                              groupId;
    private String                              status;
    private Integer                             currentBatch;
    private Integer                             numOfBatches;
    private ApiDeploymentProgressIndicatorAzure progress;
    private Date                                createdAt;
    private Date                                updatedAt;
    //endregion


    public ApiCreateDeploymentAzure() {
        isSet = new HashSet<>();
    }

    //region Getters and Setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public ApiDeploymentProgressIndicatorAzure getProgress() {
        return progress;
    }

    public void setProgress(ApiDeploymentProgressIndicatorAzure progress) {
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
