package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.AwsInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.InstanceHealthStatusEnum;

/**
 * Created by yossi.elman on 13/04/2020.
 */

public class ElastigroupInstanceHealthiness {
    //region Members
    private String                   instanceId;
    private String                   spotRequestId;
    private String                   groupId;
    private String                   availabilityZone;
    private AwsInstanceLifecycleEnum lifeCycle;
    private InstanceHealthStatusEnum healthStatus;
    private String                   privateIp;
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

    public AwsInstanceLifecycleEnum getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(AwsInstanceLifecycleEnum lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public InstanceHealthStatusEnum getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(InstanceHealthStatusEnum healthStatus) {
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
