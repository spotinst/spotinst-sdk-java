package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by yossi.elman on 13/04/2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiInstanceHealthiness {
    //region Members
    private String instanceId;
    private String spotRequestId;
    private String groupId;
    private String availabilityZone;
    private String lifeCycle;
    private String healthStatus;
    private String privateIp;
    //endregion

    //region Getters & Setters
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getSpotRequestId() {
        return spotRequestId;
    }

    public void setSpotRequestId(String spotRequestId) {
        this.spotRequestId = spotRequestId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }
    //endregion
}
