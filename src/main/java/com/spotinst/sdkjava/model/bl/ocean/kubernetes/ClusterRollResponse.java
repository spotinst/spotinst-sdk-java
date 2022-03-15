package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.K8sClusterRollEnumAws;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterRollResponse {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                    id;
    private K8sClusterRollEnumAws                 status;
    private Integer                         currentBatch;
    private Integer                         numOfBatches;
    private String                               comment;
    private Integer            batchMinHealthyPercentage;
    private InitiateRollProgress                progress;
    private String                               oceanId;
    private Boolean                           respectPdb;
    private List<String>                     instanceIds;
    private List<String>                   launchSpecIds;
    private String                             createdAt;
    private String                             updatedAt;

    private ClusterRollResponse() {
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

    public K8sClusterRollEnumAws getStatus() {
        return status;
    }

    public void setStatus(K8sClusterRollEnumAws status) {
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

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    public void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        isSet.add("batchMinHealthyPercentage");
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public Boolean getRespectPdb() {
        return respectPdb;
    }

    public void setRespectPdb(Boolean respectPdb) {
        isSet.add("respectPdb");
        this.respectPdb = respectPdb;
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    public void setInstanceIds(List<String> instanceIds) {
        isSet.add("instanceIds");
        this.instanceIds = instanceIds;
    }

    public List<String> getLaunchSpecIds() {
        return launchSpecIds;
    }

    public void setLaunchSpecIds(List<String> launchSpecIds) {
        isSet.add("launchSpecIds");
        this.launchSpecIds = launchSpecIds;
    }

    public InitiateRollProgress getProgress() {
        return progress;
    }

    public void setProgress(InitiateRollProgress progress) {
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
        private ClusterRollResponse initiateRollResponse;

        private Builder() {
            this.initiateRollResponse = new ClusterRollResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            initiateRollResponse.setId(id);
            return this;
        }

        public Builder setStatus(final K8sClusterRollEnumAws status) {
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

        public Builder setProgress(final InitiateRollProgress progress) {
            initiateRollResponse.setProgress(progress);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            initiateRollResponse.setOceanId(oceanId);
            return this;
        }

        public Builder setInstanceIds(final List<String> instanceIds) {
            initiateRollResponse.setInstanceIds(instanceIds);
            return this;
        }

        public Builder setLaunchSpecIds(final List<String> launchSpecIds) {
            initiateRollResponse.setLaunchSpecIds(launchSpecIds);
            return this;
        }

        public Builder setRespectPdb(final Boolean respectPdb) {
            initiateRollResponse.setRespectPdb(respectPdb);
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

        public ClusterRollResponse build() {
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
    public boolean isInstanceIdsSet() {
        return isSet.contains("instanceIds");
    }

    @JsonIgnore
    public boolean isLaunchSpecIdsSet() {
        return isSet.contains("launchSpecIds");
    }

    @JsonIgnore
    public boolean isRespectPdbSet() {
        return isSet.contains("respectPdb");
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