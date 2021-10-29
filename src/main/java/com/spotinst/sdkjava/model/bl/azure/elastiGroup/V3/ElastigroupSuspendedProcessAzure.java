package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ProcessNameEnumsAzure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupSuspendedProcessAzure {

    @JsonIgnore
    private Set<String>             isSet;
    private ProcessNameEnumsAzure   name;
    private Date                    expiresAt;

    private ElastigroupSuspendedProcessAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ProcessNameEnumsAzure getName() {
        return name;
    }

    public void setName(ProcessNameEnumsAzure name) {
        isSet.add("name");
        this.name = name;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        isSet.add("expiresAt");
        this.expiresAt = expiresAt;
    }

    public static class Builder {
        private ElastigroupSuspendedProcessAzure suspendProcesses;

        private Builder() {
            this.suspendProcesses = new ElastigroupSuspendedProcessAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final ProcessNameEnumsAzure name) {
            suspendProcesses.setName(name);
            return this;
        }

        public Builder setExpiresAt(final Date expiresAt) {
            suspendProcesses.setExpiresAt(expiresAt);
            return this;
        }

        public ElastigroupSuspendedProcessAzure build() {
            return suspendProcesses;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isExpiresAtSet() {
        return isSet.contains("expiresAt");
    }
}
