package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.GcpInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.GroupActiveInstanceStatusEnumGcp;

import java.util.Date;

// todo oz: GroupActiveInstanceStatusGcp - DONE
public class GroupActiveInstanceStatusGcp {
    //region Members
    private String                           instanceName;
    private String                           zone;
    private String                           groupId;
    private String                           machineType;
    private String                           privateIpAddress;
    private String                           publicIpAddress;
    // todo oz: Date - DONE
    private Date                             createdAt;
    private Date                             updatedAt;
    private GcpInstanceLifecycleEnum         lifeCycle;
    private GroupActiveInstanceStatusEnumGcp statusName;
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

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIp) {
        this.privateIpAddress = privateIp;
    }

    public String getPublicIpAddress() {
        return publicIpAddress;
    }

    public void setPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    public String getMachineType() { return machineType; }

    public void setMachineType(String availabilityZone) { this.machineType = machineType; }

    public GcpInstanceLifecycleEnum getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(GcpInstanceLifecycleEnum lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public GroupActiveInstanceStatusEnumGcp getStatusName() {
        return statusName;
    }

    public void setStatusName(GroupActiveInstanceStatusEnumGcp statusName) {
        this.statusName = statusName;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    //endregion
}
