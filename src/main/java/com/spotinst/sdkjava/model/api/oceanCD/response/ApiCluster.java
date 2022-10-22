package com.spotinst.sdkjava.model.api.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCluster implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 lastHeartbeatTime;
    private ApiClusterControllerInfo controllerInfo;
    private ApiClusterClusterInfo clusterInfo;
    private ApiClusterNotification notification;
    private String                 id;
    private String                 createdAt;
    private String                 updatedAt;

    public ApiCluster() {
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

    public ApiClusterControllerInfo getControllerInfo() {
        return controllerInfo;
    }

    public void setControllerInfo(ApiClusterControllerInfo controllerInfo) {
        isSet.add("controllerInfo");
        this.controllerInfo = controllerInfo;
    }

    public ApiClusterClusterInfo getClusterInfo() {
        return clusterInfo;
    }

    public void setClusterInfo(ApiClusterClusterInfo clusterInfo) {
        isSet.add("clusterInfo");
        this.clusterInfo = clusterInfo;
    }

    public ApiClusterNotification getNotification() {
        return notification;
    }

    public void setNotification(ApiClusterNotification notification) {
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