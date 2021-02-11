package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiInstanceHealthinessGcp {
    //region Members
    private String instanceName;
    private String zone;
    private String groupId;
    private String machineType;
    private String lifeCycle;
    private String statusName;
    private String privateIpAddress;
    private String createdAt;
    private String updatedAt;
    //endregion

    //region Getters & Setters
    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String spotRequestId) {
        this.zone = spotRequestId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String availabilityZone) {
        this.machineType = machineType;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String healthStatus) {
        this.statusName = healthStatus;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIp) {
        this.privateIpAddress = privateIp;
    }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
    //endregion
}
