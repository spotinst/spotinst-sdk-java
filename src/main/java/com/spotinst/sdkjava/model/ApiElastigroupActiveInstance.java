package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by talzur on 12/12/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiElastigroupActiveInstance {
    //region Members
    private String instanceId;
    private String spotInstanceRequestId;
    private String instanceType;
    private String product;
    private String availabilityZone;
    private String groupId;
    private String privateIp;
    private String publicIp;
    private String ipv6Address;
    private String status;
    private Date   createdAt;
    //endregion

    //region Getter and setter methods

    String getInstanceId() {
        return instanceId;
    }

    void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    String getSpotInstanceRequestId() {
        return spotInstanceRequestId;
    }

    void setSpotInstanceRequestId(String spotInstanceRequestId) {
        this.spotInstanceRequestId = spotInstanceRequestId;
    }

    String getInstanceType() {
        return instanceType;
    }

    void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    String getProduct() {
        return product;
    }

    void setProduct(String product) {
        this.product = product;
    }

    String getAvailabilityZone() {
        return availabilityZone;
    }

    void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
