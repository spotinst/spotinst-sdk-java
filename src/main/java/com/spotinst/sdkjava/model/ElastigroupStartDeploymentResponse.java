package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentProgress;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupStartDeploymentResponse {

    @JsonIgnore
    private Set<String>                   isSet;
    private String                        id;
    private String                        status;
    private Integer                       currentBatch;
    private Integer                       numOfBatches;
    private ElastigroupDeploymentProgress progress;

    public ElastigroupStartDeploymentResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() { return id; }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
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

    public ElastigroupDeploymentProgress getProgress() {
        return progress;
    }

    public void setProgress(ElastigroupDeploymentProgress progress) {
        isSet.add("progress");
        this.progress = progress;
    }

    public static class Builder {
        private ElastigroupStartDeploymentResponse items;

        private Builder() {
            this.items = new ElastigroupStartDeploymentResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            items.setId(id);
            return this;
        }

        public Builder setStatus(final String status) {
            items.setStatus(status);
            return this;
        }

        public Builder setCurrentBatch(final Integer currentBatch) {
            items.setCurrentBatch(currentBatch);
            return this;
        }

        public Builder setNumOfBatches(final Integer numOfBatches) {
            items.setNumOfBatches(numOfBatches);
            return this;
        }

        public Builder setProgress(final ElastigroupDeploymentProgress progress) {
            items.setProgress(progress);
            return this;
        }

        public ElastigroupStartDeploymentResponse build() {
            return items;
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
    public boolean isNumOfBatchesSet() { return isSet.contains("numOfBatches");  }

    @JsonIgnore
    public boolean isProgressSet() {
        return isSet.contains("progress");
    }


}

