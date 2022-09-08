package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerListInstancesAws implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      instanceId;
    private String      instanceGroupId;
    private String      instanceGroupRole;
    private String      instanceType;
    private String      availabilityZone;
    private String      status;
    private Date        createdAt;
    private Date        updatedAt;

    public ApiMrScalerListInstancesAws() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getInstanceGroupId() {
        return instanceGroupId;
    }

    public void setInstanceGroupId(String instanceGroupId) {
        isSet.add("instanceGroupId");
        this.instanceGroupId = instanceGroupId;
    }

    public String getInstanceGroupRole() {
        return instanceGroupRole;
    }

    public void setInstanceGroupRole(String instanceGroupRole) {
        isSet.add("instanceGroupRole");
        this.instanceGroupRole = instanceGroupRole;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public Boolean isInstanceIdSet(){
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public Boolean isInstanceGroupIdSet(){
        return isSet.contains("instanceGroupId");
    }

    @JsonIgnore
    public Boolean isInstanceGroupRoleSet(){
        return isSet.contains("instanceGroupRole");
    }

    @JsonIgnore
    public Boolean isInstanceTypeSet(){
        return isSet.contains("instanceType");
    }

    @JsonIgnore
    public Boolean isAvailabilityZoneSet(){
        return isSet.contains("availabilityZone");
    }

    @JsonIgnore
    public Boolean isStatusSet(){
        return isSet.contains("status");
    }

    @JsonIgnore
    public Boolean isCreatedAtSet(){
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public Boolean isUpdatedAtSet(){
        return isSet.contains("updatedAt");
    }
}