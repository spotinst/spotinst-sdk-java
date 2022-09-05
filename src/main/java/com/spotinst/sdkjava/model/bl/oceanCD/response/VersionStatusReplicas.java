package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersionStatusReplicas {
    @JsonIgnore
    private Set<String>                    isSet;
    private Integer                        desired;
    private Integer                        ready;
    private Integer                        inProgress;
    private Integer                        failed;

    private VersionStatusReplicas() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getDesired() {
        return desired;
    }

    public void setDesired(Integer desired) {
        isSet.add("desired");
        this.desired = desired;
    }

    public Integer getReady() {
        return ready;
    }

    public void setReady(Integer ready) {
        isSet.add("ready");
        this.ready = ready;
    }

    public Integer getInProgress() {
        return inProgress;
    }

    public void setInProgress(Integer inProgress) {
        isSet.add("inProgress");
        this.inProgress = inProgress;
    }

    public Integer getdFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        isSet.add("failed");
        this.failed = failed;
    }

    public static class Builder {
        private VersionStatusReplicas versionStatusReplicas;

        private Builder() {
            this.versionStatusReplicas = new VersionStatusReplicas();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDesired(final Integer desired) {
            versionStatusReplicas.setDesired(desired);
            return this;
        }

        public Builder setReady(final Integer ready) {
            versionStatusReplicas.setReady(ready);
            return this;
        }

        public Builder setInProgress(final Integer inProgress) {
            versionStatusReplicas.setInProgress(inProgress);
            return this;
        }

        public Builder setFailed(final Integer failed) {
            versionStatusReplicas.setFailed(failed);
            return this;
        }

        public VersionStatusReplicas build() {
            return versionStatusReplicas;
        }
    }

    @JsonIgnore
    public boolean isDesiredSet() {
        return isSet.contains("desired");
    }

    @JsonIgnore
    public boolean isReadySet() {
        return isSet.contains("ready");
    }

    @JsonIgnore
    public boolean isInProgressSet() {
        return isSet.contains("inProgress");
    }

    @JsonIgnore
    public boolean isFailedSet() {
        return isSet.contains("failed");
    }
}