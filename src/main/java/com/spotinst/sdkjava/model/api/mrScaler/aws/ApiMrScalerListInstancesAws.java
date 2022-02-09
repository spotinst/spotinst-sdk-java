package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerListInstancesAws {
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

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public Boolean isInstanceIdSet(){
        return isSet.contains("instanceId");
    }

    public String getInstanceGroupId() {
        return instanceGroupId;
    }

    public void setInstanceGroupId(String instanceGroupId) {
        isSet.add("instanceGroupId");
        this.instanceGroupId = instanceGroupId;
    }

    public Boolean isInstanceGroupIdSet(){
        return isSet.contains("instanceGroupId");
    }

    public String getInstanceGroupRole() {
        return instanceGroupRole;
    }

    public void setInstanceGroupRole(String instanceGroupRole) {
        isSet.add("instanceGroupRole");
        this.instanceGroupRole = instanceGroupRole;
    }

    public Boolean isInstanceGroupRoleSet(){
        return isSet.contains("instanceGroupRole");
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public Boolean isInstanceTypeSet(){
        return isSet.contains("instanceType");
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public Boolean isAvailabilityZoneSet(){
        return isSet.contains("availabilityZone");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public Boolean isStatusSet(){
        return isSet.contains("status");
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Boolean isCreatedAtSet(){
        return isSet.contains("createdAt");
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public Boolean isUpdatedAtSet(){
        return isSet.contains("updatedAt");
    }

    public static class Builder {
        private ApiMrScalerListInstancesAws apiMrScalerListInstancesAws;

        private Builder() {
            this.apiMrScalerListInstancesAws = new ApiMrScalerListInstancesAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setInstanceId(final String instanceId) {
            apiMrScalerListInstancesAws.setInstanceId(instanceId);
            return this;
        }

        public Builder setInstanceGroupId(final String instanceGroupId) {
            apiMrScalerListInstancesAws.setInstanceGroupId(instanceGroupId);
            return this;
        }

        public Builder setInstanceGroupRole(final String instanceGroupRole) {
            apiMrScalerListInstancesAws.setInstanceGroupRole(instanceGroupRole);
            return this;
        }

        public Builder setInstanceType(final String instanceType) {
            apiMrScalerListInstancesAws.setInstanceType(instanceType);
            return this;
        }

        public Builder setAvailabilityZone(final String availabilityZone) {
            apiMrScalerListInstancesAws.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setStatus(final String status) {
            apiMrScalerListInstancesAws.setStatus(status);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            apiMrScalerListInstancesAws.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            apiMrScalerListInstancesAws.setUpdatedAt(updatedAt);
            return this;
        }

        public ApiMrScalerListInstancesAws build() {
            return apiMrScalerListInstancesAws;
        }
        // endregion
    }
}