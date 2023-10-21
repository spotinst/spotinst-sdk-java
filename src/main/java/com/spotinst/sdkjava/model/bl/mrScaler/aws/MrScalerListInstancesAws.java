package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerListInstancesAws {
    @JsonIgnore
    private Set<String>     isSet;
    private String          instanceId;
    private String          instanceGroupId;
    private String          instanceGroupRole;
    private String          instanceType;
    private String          availabilityZone;
    private String          status;
    private Date            createdAt;
    private Date            updatedAt;

    private MrScalerListInstancesAws()  {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getInstanceGroupId() {
        return this.instanceGroupId;
    }

    public void setInstanceGroupId(String instanceGroupId) {
        isSet.add("instanceGroupId");
        this.instanceGroupId = instanceGroupId;
    }

    public String getInstanceGroupRole() {
        return this.instanceGroupRole;
    }

    public void setInstanceGroupRole(String instanceGroupRole) {
        isSet.add("instanceGroupRole");
        this.instanceGroupRole = instanceGroupRole;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private MrScalerListInstancesAws mrScalerListInstancesAws;

        private Builder() {
            this.mrScalerListInstancesAws = new MrScalerListInstancesAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setInstanceId(final String instanceId) {
            mrScalerListInstancesAws.setInstanceId(instanceId);
            return this;
        }

        public Builder setInstanceGroupId(final String instanceGroupId) {
            mrScalerListInstancesAws.setInstanceGroupId(instanceGroupId);
            return this;
        }

        public Builder setInstanceGroupRole(final String instanceGroupRole) {
            mrScalerListInstancesAws.setInstanceGroupRole(instanceGroupRole);
            return this;
        }

        public Builder setInstanceType(final String instanceType) {
            mrScalerListInstancesAws.setInstanceType(instanceType);
            return this;
        }

        public Builder setAvailabilityZone(final String availabilityZone) {
            mrScalerListInstancesAws.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setStatus(final String status) {
            mrScalerListInstancesAws.setStatus(status);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            mrScalerListInstancesAws.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            mrScalerListInstancesAws.setUpdatedAt(updatedAt);
            return this;
        }

        public MrScalerListInstancesAws build() {
            return mrScalerListInstancesAws;
        }
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