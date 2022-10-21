package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cluster {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 lastHeartbeatTime;
    private ClusterControllerInfo  controllerInfo;
    private ClusterClusterInfo     clusterInfo;
    private ClusterNotification    notification;
    private String                 id;
    private String                 createdAt;
    private String                 updatedAt;

    private Cluster() {
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

    public String getLastHeartbeatTime() {
        return lastHeartbeatTime;
    }

    public void setLastHeartbeatTime(String lastHeartbeatTime) {
        isSet.add("lastHeartbeatTime");
        this.lastHeartbeatTime = lastHeartbeatTime;
    }

    public ClusterControllerInfo getControllerInfo() {
        return controllerInfo;
    }

    public void setControllerInfo(ClusterControllerInfo controllerInfo) {
        isSet.add("controllerInfo");
        this.controllerInfo = controllerInfo;
    }

    public ClusterClusterInfo getClusterInfo() {
        return clusterInfo;
    }

    public void setClusterInfo(ClusterClusterInfo clusterInfo) {
        isSet.add("clusterInfo");
        this.clusterInfo = clusterInfo;
    }

    public ClusterNotification getNotification() {
        return notification;
    }

    public void setNotification(ClusterNotification notification) {
        isSet.add("notification");
        this.notification = notification;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private Cluster cluster;

        private Builder() {
            this.cluster = new Cluster();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            cluster.setId(id);
            return this;
        }

        public Builder setSpotDeployment(final SpotDeployment spotDeployment) {
            rolloutsDetails.setSpotDeployment(spotDeployment);
            return this;
        }

        public Builder setStrategy(final String strategy) {
            rolloutsDetails.setStrategy(strategy);
            return this;
        }

        public Builder setStatus(final String status) {
            rolloutsDetails.setStatus(status);
            return this;
        }

        public Builder setStrategyType(final String strategyType) {
            rolloutsDetails.setStrategyType(strategyType);
            return this;
        }

        public Builder setStartTime(final Date startTime) {
            rolloutsDetails.setStartTime(startTime);
            return this;
        }

        public Builder setEndTime(final Date endTime) {
            rolloutsDetails.setEndTime(endTime);
            return this;
        }

        public Builder setClusterId(final String clusterId) {
            rolloutsDetails.setClusterId(clusterId);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            rolloutsDetails.setNamespace(namespace);
            return this;
        }

        public Builder setStrategyName(final String strategyName) {
            rolloutsDetails.setStrategyName(strategyName);
            return this;
        }

        public Builder setRolloutSpec(final String rolloutSpec) {
            rolloutsDetails.setRolloutSpec(rolloutSpec);
            return this;
        }

        public Builder setCloudProvider(final String cloudProvider) {
            rolloutsDetails.setCloudProvider(cloudProvider);
            return this;
        }

        public Cluster build() {
            return cluster;
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
    public boolean isStrategyTypeSet() {
        return isSet.contains("strategyType");
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
    public boolean isStrategyNameSet() {
        return isSet.contains("strategyName");
    }

    @JsonIgnore
    public boolean isRolloutSpecSet() {
        return isSet.contains("rolloutSpec");
    }

    @JsonIgnore
    public boolean isCloudProviderSet() {
        return isSet.contains("cloudProvider");
    }
}