package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiGroupActiveInstanceStatusGcp {
    // todo oz: add isSet, add constructor, add isXset booleans. - DONE
    //region Members
    // todo oz: addd "publicIpAddress" - DONE
    private Set<String> isSet;
    private String      instanceName;
    private String      zone;
    // todo oz: remove groupId, does not return. - DONE
    private String      machineType;
    private String      lifeCycle;
    private String      statusName;
    private String      privateIpAddress;
    private String      publicIpAddress;
    private Date        createdAt;
    private Date        updatedAt;
    //endregion

    //region Constructor
    public ApiGroupActiveInstanceStatusGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String spotRequestId) {
        this.zone = spotRequestId;
    }

    public String getMachineType() {
        return machineType;
    }

    // todo oz: check why setter is ununsed, converter? - DONE converter use get from api and set from bl
    public void setMachineType(String machineType) { this.machineType = machineType; }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public String getStatusName() {
        return statusName;
    }

    // todo oz: check why setter is ununsed, converter? - DONE converter use get from api and set from bl
    public void setStatusName(String healthStatus) {
        this.statusName = healthStatus;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        this.privateIpAddress = privateIpAddress;
    }

    public String getPublicIpAddress() { return publicIpAddress; }

    public void setPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    //endregion

    //region isset methods
    // Is instanceName Set boolean method
    @JsonIgnore
    public boolean isInstanceNameSet() {
        return isSet.contains("instanceName");
    }

    // Is zone Set boolean method
    @JsonIgnore
    public boolean isZoneSet() {
        return isSet.contains("zone");
    }

    // Is machineType Set boolean method
    @JsonIgnore
    public boolean isMachineTypeSet() {
        return isSet.contains("machineType");
    }

    // Is lifeCycle Set boolean method
    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    // Is statusName Set boolean method
    @JsonIgnore
    public boolean isStatusNameSet() {
        return isSet.contains("statusName");
    }

    // Is privateIpAddress Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressSet() {
        return isSet.contains("privateIpAddress");
    }

    // Is publicIpAddress Set boolean method
    @JsonIgnore
    public boolean isPublicIpAddress() {
        return isSet.contains("publicIpAddress");
    }

    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    // Is updatedAt Set boolean method
    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
    //endregion
}
