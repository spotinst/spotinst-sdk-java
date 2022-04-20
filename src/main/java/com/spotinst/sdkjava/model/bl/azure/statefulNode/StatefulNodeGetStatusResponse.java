package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeGetStatusResponse {

    @JsonIgnore
    private Set<String> isSet;
    private String      id;
    private String      name;
    private String      region;
    private String      zone;
    private String      resourceGroupName;
    private String      status;
    private String      vmName;
    private String      vmSize;
    private String      lifeCycle;
    private String      rollbackReason;
    private String      errorReason;
    private String      privateIp;
    private String      publicIp;
    private Date        createdAt;
    private Date        updatedAt;

    private StatefulNodeGetStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        isSet.add("zone");
        this.zone = zone;
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public String getVmSize() {
        return vmSize;
    }

    public void setVmSize(String vmSize) {
        isSet.add("vmSize");
        this.vmSize = vmSize;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public String getRollbackReason() {
        return rollbackReason;
    }

    public void setRollbackReason(String rollbackReason) {
        isSet.add("rollbackReason");
        this.rollbackReason = rollbackReason;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        isSet.add("errorReason");
        this.errorReason = errorReason;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        isSet.add("privateIp");
        this.privateIp = privateIp;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        isSet.add("publicIp");
        this.publicIp = publicIp;
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

    public static class Builder {
        private StatefulNodeGetStatusResponse statefulNode;

        private Builder() {
            this.statefulNode = new StatefulNodeGetStatusResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            statefulNode.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            statefulNode.setName(name);
            return this;
        }

        public Builder setRegion(final String region) {
            statefulNode.setRegion(region);
            return this;
        }

        public Builder setZone(final String zone) {
            statefulNode.setZone(zone);
            return this;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            statefulNode.setResourceGroupName(resourceGroupName);
            return this;
        }
        public Builder setStatus(final String status) {
            statefulNode.setStatus(status);
            return this;
        }

        public Builder setVmName(final String vmName) {
            statefulNode.setVmName(vmName);
            return this;
        }

        public Builder setVmSize(final String vmSize) {
            statefulNode.setVmSize(vmSize);
            return this;
        }

        public Builder setLifeCycle(final String lifeCycle) {
            statefulNode.setLifeCycle(lifeCycle);
            return this;
        }
        public Builder setRollbackReason(final String rollbackReason) {
            statefulNode.setRollbackReason(rollbackReason);
            return this;
        }

        public Builder setErrorReason(final String errorReason) {
            statefulNode.setErrorReason(errorReason);
            return this;
        }

        public Builder setPrivateIp(final String privateIp) {
            statefulNode.setPrivateIp(privateIp);
            return this;
        }

        public Builder setPublicIp(final String publicIp) {
            statefulNode.setPublicIp(publicIp);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            statefulNode.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            statefulNode.setUpdatedAt(updatedAt);
            return this;
        }

        public StatefulNodeGetStatusResponse build() {
            return statefulNode;
        }
    }
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isZoneSet() {
        return isSet.contains("zone");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }

    @JsonIgnore
    public boolean isVmSizeSet() {
        return isSet.contains("vmSize");
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    @JsonIgnore
    public boolean isRollbackReasonSet() {
        return isSet.contains("rollbackReason");
    }

    @JsonIgnore
    public boolean isErrorReasonSet() {
        return isSet.contains("errorReason");
    }

    @JsonIgnore
    public boolean isPrivateIpSet() {
        return isSet.contains("privateIp");
    }

    @JsonIgnore
    public boolean isPublicIpSet() {
        return isSet.contains("publicIp");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }

}