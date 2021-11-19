package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetGroupDeploymentStatusResponse {

    @JsonIgnore
    private Set<String>                   isSet;
    private String                        id;
    private String                        status;
    private ElastigroupDeploymentProgress progress;

    public ElastigroupGetGroupDeploymentStatusResponse() {
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
        private ElastigroupGetGroupDeploymentStatusResponse getGroupDeploymentStatusResponse;

        private Builder() {
            this.getGroupDeploymentStatusResponse = new ElastigroupGetGroupDeploymentStatusResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            getGroupDeploymentStatusResponse.setId(id);
            return this;
        }

        public Builder setStatus(final String status) {
            getGroupDeploymentStatusResponse.setStatus(status);
            return this;
        }

        public Builder setProgress(final ElastigroupDeploymentProgress progress) {
            getGroupDeploymentStatusResponse.setProgress(progress);
            return this;
        }

        public ElastigroupGetGroupDeploymentStatusResponse build() {
            return getGroupDeploymentStatusResponse;
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
