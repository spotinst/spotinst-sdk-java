package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutStatus {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 id;
    private String                 status;
    private String                 spotDeployment;
    private String                 originalRolloutId;
    private Date                   startTime;
    private Date                   endTime;
    private String                 clusterId;
    private String                 namespace;
    private String                 strategy;
    private Boolean                hasBackgroundVerification;
    private VersionStatus          newVersionStatus;
    private VersionStatus          stableVersionStatus;

    private RolloutStatus() {
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

    public String getSpotDeployment() {
        return spotDeployment;
    }

    public void setSpotDeployment(String spotDeployment) {
        isSet.add("spotDeployment");
        this.spotDeployment = spotDeployment;
    }

    public String getOriginalRolloutId() {
        return originalRolloutId;
    }

    public void setOriginalRolloutId(String originalRolloutId) {
        isSet.add("originalRolloutId");
        this.originalRolloutId = originalRolloutId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        isSet.add("startTime");
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        isSet.add("endTime");
        this.endTime = endTime;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        isSet.add("clusterId");
        this.clusterId = clusterId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public Boolean getHasBackgroundVerification() {
        return hasBackgroundVerification;
    }

    public void setHasBackgroundVerification(Boolean hasBackgroundVerification) {
        isSet.add("hasBackgroundVerification");
        this.hasBackgroundVerification = hasBackgroundVerification;
    }

    public VersionStatus getNewVersionStatus() {
        return newVersionStatus;
    }

    public void setNewVersionStatus(VersionStatus newVersionStatus) {
        isSet.add("newVersionStatus");
        this.newVersionStatus = newVersionStatus;
    }

    public VersionStatus getStableVersionStatus() {
        return stableVersionStatus;
    }

    public void setStableVersionStatus(VersionStatus stableVersionStatus) {
        isSet.add("stableVersionStatus");
        this.stableVersionStatus = stableVersionStatus;
    }

    public static class Builder {
        private RolloutStatus rolloutStatus;

        private Builder() {
            this.rolloutStatus = new RolloutStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            rolloutStatus.setId(id);
            return this;
        }

        public Builder setSpotDeployment(final String spotDeployment) {
            rolloutStatus.setSpotDeployment(spotDeployment);
            return this;
        }

        public Builder setStrategy(final String strategy) {
            rolloutStatus.setStrategy(strategy);
            return this;
        }

        public Builder setStatus(final String status) {
            rolloutStatus.setStatus(status);
            return this;
        }

        public Builder setOriginalRolloutId(final String originalRolloutId) {
            rolloutStatus.setOriginalRolloutId(originalRolloutId);
            return this;
        }

        public Builder setStartTime(final Date startTime) {
            rolloutStatus.setStartTime(startTime);
            return this;
        }

        public Builder setEndTime(final Date endTime) {
            rolloutStatus.setEndTime(endTime);
            return this;
        }

        public Builder setClusterId(final String clusterId) {
            rolloutStatus.setClusterId(clusterId);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            rolloutStatus.setNamespace(namespace);
            return this;
        }

        public Builder setHasBackgroundVerification(final Boolean hasBackgroundVerification) {
            rolloutStatus.setHasBackgroundVerification(hasBackgroundVerification);
            return this;
        }

        public Builder setNewVersionStatus(final VersionStatus newVersionStatus) {
            rolloutStatus.setNewVersionStatus(newVersionStatus);
            return this;
        }

        public Builder setStableVersionStatus(final VersionStatus stableVersionStatus) {
            rolloutStatus.setStableVersionStatus(stableVersionStatus);
            return this;
        }

        public RolloutStatus build() {
            return rolloutStatus;
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
    public boolean isOriginalRolloutIdSet() {
        return isSet.contains("originalRolloutId");
    }

    @JsonIgnore
    public boolean isStartTimeSet() {
        return isSet.contains("startTime");
    }

    @JsonIgnore
    public boolean isEndTimeSet() {
        return isSet.contains("endTime");
    }

    @JsonIgnore
    public boolean isClusterIdSet() {
        return isSet.contains("clusterId");
    }

    @JsonIgnore
    public boolean isSpotDeploymentSet() {
        return isSet.contains("spotDeployment");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }

    @JsonIgnore
    public boolean isHasBackgroundVerificationSet() {
        return isSet.contains("hasBackgroundVerification");
    }

    @JsonIgnore
    public boolean isNewVersionStatusSet() {
        return isSet.contains("newVersionStatus");
    }

    @JsonIgnore
    public boolean isStableVersionStatusSet() {
        return isSet.contains("stableVersionStatus");
    }
}