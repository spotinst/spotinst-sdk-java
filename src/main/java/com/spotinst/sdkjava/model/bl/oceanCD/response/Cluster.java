package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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

        public Builder setLastHeartbeatTime(final String lastHeartbeatTime) {
            cluster.setLastHeartbeatTime(lastHeartbeatTime);
            return this;
        }

        public Builder setControllerInfo(final ClusterControllerInfo controllerInfo) {
            cluster.setControllerInfo(controllerInfo);
            return this;
        }

        public Builder setClusterInfo(final ClusterClusterInfo clusterInfo) {
            cluster.setClusterInfo(clusterInfo);
            return this;
        }

        public Builder setNotification(final ClusterNotification notification) {
            cluster.setNotification(notification);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            cluster.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final String updatedAt) {
            cluster.setUpdatedAt(updatedAt);
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
    public boolean isLastHeartbeatTimeSet() {
        return isSet.contains("lastHeartbeatTime");
    }

    @JsonIgnore
    public boolean isControllerInfoSet() {
        return isSet.contains("controllerInfo");
    }

    @JsonIgnore
    public boolean isClusterInfoSet() {
        return isSet.contains("clusterInfo");
    }

    @JsonIgnore
    public boolean isNotificationSet() {
        return isSet.contains("notification");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
}