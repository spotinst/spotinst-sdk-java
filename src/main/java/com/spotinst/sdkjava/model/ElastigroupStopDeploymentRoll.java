package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupStopDeploymentRoll {
    @JsonIgnore
    private Set<String> isSet;
    private String      status;

    public ElastigroupStopDeploymentRoll() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() { return isSet; }

    public void setIsSet(Set<String> isSet) { this.isSet = isSet;  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public static class Builder {
        private ElastigroupStopDeploymentRoll stopDeploymentRoll;

        private Builder() {
            this.stopDeploymentRoll = new ElastigroupStopDeploymentRoll();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setStatus(final String status) {
            stopDeploymentRoll.setStatus(status);
            return this;
        }

        public ElastigroupStopDeploymentRoll build() {
            return stopDeploymentRoll;
        }
    }

    @JsonIgnore
    public boolean isStatusSet() { return isSet.contains("status"); }

}
