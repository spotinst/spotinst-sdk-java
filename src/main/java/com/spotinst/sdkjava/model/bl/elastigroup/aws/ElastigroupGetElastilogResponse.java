package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetElastilogResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             message;
    private String                                             severity;
    private String                                             createdAt;

    public ElastigroupGetElastilogResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        isSet.add("message");
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        isSet.add("severity");
        this.severity = severity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public static class Builder {
        private ElastigroupGetElastilogResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupGetElastilogResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupGetElastilogResponse.Builder setMessage(final String message) {
            elastigroupGetDeploymentStatusInstances.setMessage(message);
            return this;
        }

        public ElastigroupGetElastilogResponse.Builder setSeverity(final String severity) {
            elastigroupGetDeploymentStatusInstances.setSeverity(severity);
            return this;
        }

        public ElastigroupGetElastilogResponse.Builder setCreatedAt(final String createdAt) {
            elastigroupGetDeploymentStatusInstances.setCreatedAt(createdAt);
            return this;
        }

        public ElastigroupGetElastilogResponse build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isMessageSet() {
        return isSet.contains("message");
    }

    @JsonIgnore
    public boolean isSeveritySet() {
        return isSet.contains("severity");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

}
