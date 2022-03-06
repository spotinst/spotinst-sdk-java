package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDeploymentRoll {
    @JsonIgnore
    private Set<String> isSet;
    private String      status;

    public ElastigroupDeploymentRoll() {
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
        private ElastigroupDeploymentRoll stopDeploymentRoll;

        private Builder() {
            this.stopDeploymentRoll = new ElastigroupDeploymentRoll();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setStatus(final String status) {
            stopDeploymentRoll.setStatus(status);
            return this;
        }

        public ElastigroupDeploymentRoll build() {
            return stopDeploymentRoll;
        }
    }

    @JsonIgnore
    public boolean isStatusSet() { return isSet.contains("status"); }

}
