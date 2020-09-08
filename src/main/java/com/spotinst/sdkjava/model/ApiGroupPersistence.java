package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Caduri Katzav
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGroupPersistence implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();

    private Boolean shouldPersistPrivateIp;
    private Boolean shouldPersistBlockDevices;
    private Boolean shouldPersistRootDevice;
    private String  blockDevicesMode;
    //endregion

    //region Getters & Setters
    public Boolean getShouldPersistPrivateIp() {
        return shouldPersistPrivateIp;
    }

    public void setShouldPersistPrivateIp(Boolean shouldPersistPrivateIp) {
        isSet.add("shouldPersistPrivateIp");
        this.shouldPersistPrivateIp = shouldPersistPrivateIp;
    }

    @JsonIgnore
    public boolean isShouldPersistPrivateIpSet() {

        return isSet.contains("shouldPersistPrivateIp");
    }

    public Boolean getShouldPersistBlockDevices() {
        return shouldPersistBlockDevices;
    }

    public void setShouldPersistBlockDevices(Boolean shouldPersistBlockDevices) {
        isSet.add("shouldPersistBlockDevices");
        this.shouldPersistBlockDevices = shouldPersistBlockDevices;
    }

    @JsonIgnore
    public boolean isShouldPersistBlockDevicesSet() {
        return isSet.contains("shouldPersistBlockDevices");
    }

    public Boolean getShouldPersistRootDevice() {
        return shouldPersistRootDevice;
    }

    public void setShouldPersistRootDevice(Boolean shouldPersistRootDevice) {
        isSet.add("shouldPersistRootDevice");
        this.shouldPersistRootDevice = shouldPersistRootDevice;
    }

    @JsonIgnore
    public boolean isShouldPersistRootDeviceSet() {

        return isSet.contains("shouldPersistRootDevice");
    }

    public String getBlockDevicesMode() {
        return blockDevicesMode;
    }

    public void setBlockDevicesMode(String blockDevicesMode) {
        isSet.add("blockDevicesMode");
        this.blockDevicesMode = blockDevicesMode;
    }

    @JsonIgnore
    public boolean isBlockDevicesModeSet() {

        return isSet.contains("blockDevicesMode");
    }

    @Override
    public Set<String> getIsSet() {
        return isSet;
    }
    //endregion
}
