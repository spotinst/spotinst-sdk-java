package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.k8sClusterRollStatusEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AksClusterRollResponse {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                    id;
    private k8sClusterRollStatusEnum              status;
    private Integer                         currentBatch;
    private Integer                         numOfBatches;
    private String                               comment;
    private AksInitiateRollProgress             progress;
    private String                               oceanId;
    private List<String>                         vmNames;
    private List<String>             virtualNodeGroupIds;
    private String                             createdAt;
    private String                             updatedAt;

    private AksClusterRollResponse() {
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

    public AksInitiateRollProgress getProgress() {
        return progress;
    }

    public void setProgress(AksInitiateRollProgress progress) {
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

    public static class Builder {
        private AksClusterRollResponse initiateRollResponse;

        private Builder() {
            this.initiateRollResponse = new AksClusterRollResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            initiateRollResponse.setId(id);
            return this;
        }

        public Builder setStatus(final k8sClusterRollStatusEnum status) {
            initiateRollResponse.setStatus(status);
            return this;
        }


        public Builder setCurrentBatch(final Integer currentBatch) {
            initiateRollResponse.setCurrentBatch(currentBatch);
            return this;
        }

        public Builder setNumOfBatches(final Integer numOfBatches) {
            initiateRollResponse.setNumOfBatches(numOfBatches);
            return this;
        }

        public Builder setComment(final String comment) {
            initiateRollResponse.setComment(comment);
            return this;
        }

        public Builder setProgress(final AksInitiateRollProgress progress) {
            initiateRollResponse.setProgress(progress);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            initiateRollResponse.setOceanId(oceanId);
            return this;
        }

        public Builder setVmNames(final List<String> vmNames) {
            initiateRollResponse.setVmNames(vmNames);
            return this;
        }

        public Builder setVirtualNodeGroupIds(final List<String> launchSpecIds) {
            initiateRollResponse.setVirtualNodeGroupIds(launchSpecIds);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            initiateRollResponse.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final String updatedAt) {
            initiateRollResponse.setUpdatedAt(updatedAt);
            return this;
        }

        public AksClusterRollResponse build() {
            return initiateRollResponse;
        }
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