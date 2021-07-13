package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.AwsInstanceLifecycleEnum;
import com.spotinst.sdkjava.enums.AwsInstanceTypeEnum;

import java.util.Date;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupActiveInstance {
    //region Members
    private String                   instanceId;
    private String                   spotInstanceRequestId;
    private AwsInstanceTypeEnum      instanceType;
    private String                   product;
    private String                   availabilityZone;
    private AwsInstanceLifecycleEnum lifeCycle;
    private String                   groupId;
    private String                   privateIp;
    private String                   publicIp;
    private String                   ipv6Address;
    private String                   status;
    private Date                     createdAt;
    //endregion


    public ElastigroupActiveInstance() {
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public String getIpv6Address() {
        return ipv6Address;
    }

    public void setIpv6Address(String ipv6Address) {
        this.ipv6Address = ipv6Address;
    }

    //endregion

    //region Object overrides
    @Override
    public String toString() {
        return "ElastigroupActiveInstance{" + "instanceId='" + instanceId + '\'' + ", spotInstanceRequestId='" +
               spotInstanceRequestId + '\'' + ", instanceType=" + instanceType + ", product='" + product + '\'' +
               ", availabilityZone='" + availabilityZone + '\'' + ", lifeCycle=" + lifeCycle + ", groupId='" + groupId +
               '\'' + ", privateIp='" + privateIp + '\'' + ", publicIp='" + publicIp + '\'' + ", ipv6Address='" +
               ipv6Address + '\'' + ", status='" + status + '\'' + ", createdAt=" + createdAt + '}';
    }
    //endregion
}

