package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persistence {

    @JsonIgnore
    private Set<String> isSet;
    private String      blockDevicesMode;
    private Boolean     persistBlockDevices;
    private Boolean     persistPrivateIp;
    private Boolean     persistRootDevice;

    private Persistence() {
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

    public static class Builder {
        private Persistence persistence;

        private Builder() {
            this.persistence = new Persistence();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBlockDevicesMode(final String blockDevicesMode) {
            persistence.setBlockDevicesMode(blockDevicesMode);
            return this;
        }

        public Builder setPersistBlockDevices(final Boolean persistBlockDevices) {
            persistence.setPersistBlockDevices(persistBlockDevices);
            return this;
        }

        public Builder setPersistPrivateIp(final Boolean persistPrivateIp) {
            persistence.setPersistPrivateIp(persistPrivateIp);
            return this;
        }

        public Builder setPersistRootDevice(final Boolean persistRootDevice) {
            persistence.setPersistRootDevice(persistRootDevice);
            return this;
        }

        public Persistence build() {
            return persistence;
        }
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
