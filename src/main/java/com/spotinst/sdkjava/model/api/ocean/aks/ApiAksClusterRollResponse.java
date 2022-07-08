package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.k8sClusterRollStatusEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAksClusterRollResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                    id;
    private k8sClusterRollStatusEnum              status;
    private Integer                         currentBatch;
    private Integer                         numOfBatches;
    private String                               comment;
    private ApiAksInitiateRollProgress           progress;
    private String                               oceanId;
    private List<String>                         vmNames;
    private List<String>             virtualNodeGroupIds;
    private String                             createdAt;
    private String                             updatedAt;


    public ApiAksClusterRollResponse() {
        isSet = new HashSet<>();
    }

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

    public Integer getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Integer currentBatch) {
        isSet.add("currentBatch");
        this.currentBatch = currentBatch;
    }

    public Integer getNumOfBatches() {
        return numOfBatches;
    }

    public void setNumOfBatches(Integer numOfBatches) {
        isSet.add("numOfBatches");
        this.numOfBatches = numOfBatches;
    }

    public k8sClusterRollStatusEnum getStatus() {
        return status;
    }

    public void setStatus(k8sClusterRollStatusEnum status) {
        isSet.add("status");
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        isSet.add("comment");
        this.comment = comment;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public List<String> getVmNames() {
        return vmNames;
    }

    public void setVmNames(List<String> vmNames) {
        isSet.add("vmNames");
        this.vmNames = vmNames;
    }

    public List<String> getVirtualNodeGroupIds() {
        return virtualNodeGroupIds;
    }

    public void setVirtualNodeGroupIds(List<String> virtualNodeGroupIds) {
        isSet.add("virtualNodeGroupIds");
        this.virtualNodeGroupIds = virtualNodeGroupIds;
    }

    public ApiAksInitiateRollProgress getProgress() {
        return progress;
    }

    public void setProgress(ApiAksInitiateRollProgress progress) {
        isSet.add("progress");
        this.progress = progress;
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
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isCurrentBatchSet() {
        return isSet.contains("currentBatch");
    }

    @JsonIgnore
    public boolean isNumOfBatchesSet() {
        return isSet.contains("numOfBatches");
    }

    @JsonIgnore
    public boolean isCommentSet() {
        return isSet.contains("comment");
    }

    @JsonIgnore
    public boolean isProgressSet() {
        return isSet.contains("progress");
    }

    @JsonIgnore
    public boolean isOceanIdSet() {
        return isSet.contains("oceanId");
    }

    @JsonIgnore
    public boolean isVmNamesSet() {
        return isSet.contains("vmNames");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupIdsSet() {
        return isSet.contains("virtualNodeGroupIds");
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