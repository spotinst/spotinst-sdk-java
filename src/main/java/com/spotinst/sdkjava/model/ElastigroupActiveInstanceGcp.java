package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.AwsInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.AwsInstanceTypeEnum;

import java.util.Date;

public class ElastigroupActiveInstanceGcp {
    //region Members
    private String instanceId;
    private String spotInstanceRequestId;
    private AwsInstanceTypeEnum instanceType;
    private String product;
    private String availabilityZone;
    private AwsInstanceLifecycleEnum lifeCycle;
    private String status;
    private Date createdAt;
    //endregion


    public ElastigroupActiveInstanceGcp() {
    }

    //region Getters & Setters
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getSpotInstanceRequestId() {
        return spotInstanceRequestId;
    }

    public void setSpotInstanceRequestId(String spotInstanceRequestId) {
        this.spotInstanceRequestId = spotInstanceRequestId;
    }

    public AwsInstanceTypeEnum getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(AwsInstanceTypeEnum instanceType) {
        this.instanceType = instanceType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AwsInstanceLifecycleEnum getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(AwsInstanceLifecycleEnum lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    //endregion

    //region Object overrides
    @Override
    public String toString() {
        return "BlGroupActiveInstance{" +
                "instanceId='" + instanceId + '\'' +
                ", spotInstanceRequestId='" + spotInstanceRequestId + '\'' +
                ", instanceType=" + instanceType +
                ", product='" + product + '\'' +
                ", availabilityZone='" + availabilityZone + '\'' +
                ", status=" + status +
                ", lifeCycle=" + lifeCycle +
                '}';
    }
    //endregion
}

