package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiPersistence {

    @JsonIgnore
    private Set<String> isSet;
    private String      blockDevicesMode;
    private Boolean     persistBlockDevices;
    private Boolean     persistPrivateIp;
    private Boolean     persistRootDevice;

    private ApiPersistence() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getBlockDevicesMode() {
        return blockDevicesMode;
    }

    public void setBlockDevicesMode(String blockDevicesMode) {
        isSet.add("blockDevicesMode");
        this.blockDevicesMode = blockDevicesMode;
    }

    public Boolean getPersistBlockDevices() {
        return persistBlockDevices;
    }

    public void setPersistBlockDevices(Boolean persistBlockDevices) {
        isSet.add("persistBlockDevices");
        this.persistBlockDevices = persistBlockDevices;
    }

    public Boolean getPersistPrivateIp() {
        return persistPrivateIp;
    }

    public void setPersistPrivateIp(Boolean persistPrivateIp) {
        isSet.add("persistPrivateIp");
        this.persistPrivateIp = persistPrivateIp;
    }

    public Boolean getPersistRootDevice() {
        return persistRootDevice;
    }

    public void setPersistRootDevice(Boolean persistRootDevice) {
        isSet.add("persistRootDevice");
        this.persistRootDevice = persistRootDevice;
    }

    @JsonIgnore
    public boolean isBlockDevicesModeSet() {
        return isSet.contains("blockDevicesMode");
    }

    @JsonIgnore
    public boolean isPersistBlockDevicesSet() {
        return isSet.contains("persistBlockDevices");
    }

    @JsonIgnore
    public boolean isPersistPrivateIpSet() {
        return isSet.contains("persistPrivateIp");
    }

    @JsonIgnore
    public boolean isPersistRootDeviceSet() {
        return isSet.contains("persistRootDevice");
    }

}
