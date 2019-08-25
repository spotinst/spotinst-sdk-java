package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 29/01/2017.
 */
public class ElastigroupNewSpotRequest {
    //region Members
    private String spotInstanceRequestId;
    private String instanceId;
    private String availabilityZone;
    private String instanceType;
    //endregion

    //region Getter and Setter methods

    public String getSpotInstanceRequestId() {
        return spotInstanceRequestId;
    }

    public void setSpotInstanceRequestId(String spotInstanceRequestId) {
        this.spotInstanceRequestId = spotInstanceRequestId;
    }

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
