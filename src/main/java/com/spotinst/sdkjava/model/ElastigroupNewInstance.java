package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 29/01/2017.
 */
public class ElastigroupNewInstance {
    //region Members
    private String instanceId;
    private String availabilityZone;
    private String instanceType;
    //endregion

    //region Getter and Setter methods

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    //endregion
}
