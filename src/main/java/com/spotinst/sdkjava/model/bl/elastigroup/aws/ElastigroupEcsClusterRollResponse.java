package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.k8sClusterRollStatusEnum;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupEcsClusterRollResponse {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                    id;
    private k8sClusterRollStatusEnum              status;
    private String                                 scope;
    private Integer                         currentBatch;
    private Integer                         numOfBatches;
    private String                               comment;
    private Integer            batchMinHealthyPercentage;
    private ElastigroupEcsInitiateRollProgress  progress;
    private String                               groupId;
    private String                             createdAt;
    private String                             updatedAt;

    private ElastigroupEcsClusterRollResponse() {
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        isSet.add("scope");
        this.scope = scope;
    }

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    public void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        isSet.add("batchMinHealthyPercentage");
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public ElastigroupEcsInitiateRollProgress getProgress() {
        return progress;
    }

    public void setProgress(ElastigroupEcsInitiateRollProgress progress) {
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
        private ElastigroupEcsClusterRollResponse initiateRollResponse;

        private Builder() {
            this.initiateRollResponse = new ElastigroupEcsClusterRollResponse();
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

        public Builder setScope(final String scope) {
            initiateRollResponse.setScope(scope);
            return this;
        }

        public Builder setProgress(final ElastigroupEcsInitiateRollProgress progress) {
            initiateRollResponse.setProgress(progress);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            initiateRollResponse.setGroupId(groupId);
            return this;
        }

        public Builder setBatchMinHealthyPercentage(final Integer batchMinHealthyPercentage) {
            initiateRollResponse.setBatchMinHealthyPercentage(batchMinHealthyPercentage);
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

        public ElastigroupEcsClusterRollResponse build() {
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
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isScopeSet() {
        return isSet.contains("scope");
    }

    @JsonIgnore
    public boolean isBatchMinHealthyPercentageSet() {
        return isSet.contains("batchMinHealthyPercentage");
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