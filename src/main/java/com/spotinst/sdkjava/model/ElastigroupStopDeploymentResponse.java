package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentProgress;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupStopDeploymentResponse {

    @JsonIgnore
    private Set<String>                   isSet;
    private String                        id;
    private String                        status;
    private ElastigroupDeploymentProgress progress;

    public ElastigroupStopDeploymentResponse() {
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

    public ElastigroupDeploymentProgress getProgress() {
        return progress;
    }

    public void setProgress(ElastigroupDeploymentProgress progress) {
        isSet.add("progress");
        this.progress = progress;
    }

    public static class Builder {
        private ElastigroupStopDeploymentResponse items;

        private Builder() {
            this.items = new ElastigroupStopDeploymentResponse();
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

        public Builder setProgress(final ElastigroupDeploymentProgress progress) {
            items.setProgress(progress);
            return this;
        }

        public ElastigroupStopDeploymentResponse build() {
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
    public boolean isProgressSet() {
        return isSet.contains("progress");
    }


}

