package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetElastilogAzure {

    @JsonIgnore
    private Set<String>     isSet;
    private String          createdAt;
    private String          message;
    private String          severity;

    private GetElastilogAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
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

    public static class Builder {
        private GetElastilogAzure detachedVms;

        private Builder() {
            this.detachedVms = new GetElastilogAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCreatedAt(final String createdAt) {
            detachedVms.setCreatedAt(createdAt);
            return this;
        }

        public Builder setMessage(final String message) {
            detachedVms.setMessage(message);
            return this;
        }

        public Builder setSeverity(final String severity) {
            detachedVms.setSeverity(severity);
            return this;
        }

        public GetElastilogAzure build() {
            return detachedVms;
        }

    }


    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isMessageSet() {
        return isSet.contains("message");
    }

    @JsonIgnore
    public boolean isSeveritySet() {
        return isSet.contains("severity");
    }
}
