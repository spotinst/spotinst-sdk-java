package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by talzur on 26/01/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiNewSpotRequest {
    //region Members
    private String spotInstanceRequestId;
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
