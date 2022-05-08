package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeLogsResponse {


    @JsonIgnore
    private Set<String>             isSet;
    private String                  message;
    private String                  severity;
    private String                  createdAt;

    private StatefulNodeLogsResponse() {
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
        private StatefulNodeLogsResponse nodeLogsResponse;

        private Builder() {
            this.nodeLogsResponse = new StatefulNodeLogsResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMessage(final String message) {
            nodeLogsResponse.setMessage(message);
            return this;
        }

        public Builder setSeverity(final String severity) {
            nodeLogsResponse.setSeverity(severity);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            nodeLogsResponse.setCreatedAt(createdAt);
            return this;
        }

        public StatefulNodeLogsResponse build() {
            return nodeLogsResponse;
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
