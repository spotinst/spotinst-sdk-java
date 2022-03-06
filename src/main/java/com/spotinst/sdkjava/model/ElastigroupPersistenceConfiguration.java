package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Caduri Katzav
 */
public class ElastigroupPersistenceConfiguration {

    //region Members
    @JsonIgnore
    private Map<String, Boolean> isSet = new HashMap<>();

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
        isSet.put("shouldPersistPrivateIp", true);
        this.shouldPersistPrivateIp = shouldPersistPrivateIp;
    }

    @JsonIgnore
    public boolean isShouldPersistPrivateIpSet() {

        return isSet.containsKey("shouldPersistPrivateIp");
    }

    public Boolean getShouldPersistBlockDevices() {
        return shouldPersistBlockDevices;
    }

    public void setShouldPersistBlockDevices(Boolean shouldPersistBlockDevices) {
        isSet.put("shouldPersistBlockDevices", true);
        this.shouldPersistBlockDevices = shouldPersistBlockDevices;
    }

    @JsonIgnore
    public boolean isShouldPersistBlockDevicesSet() {
        return isSet.containsKey("shouldPersistBlockDevices");
    }

    public Boolean getShouldPersistRootDevice() {
        return shouldPersistRootDevice;
    }

    public void setShouldPersistRootDevice(Boolean shouldPersistRootDevice) {
        isSet.put("shouldPersistRootDevice", true);
        this.shouldPersistRootDevice = shouldPersistRootDevice;
    }

    @JsonIgnore
    public boolean isShouldPersistRootDeviceSet() {

        return isSet.containsKey("shouldPersistRootDevice");
    }

    public String getBlockDevicesMode() {
        return blockDevicesMode;
    }

    public void setBlockDevicesMode(String blockDevicesMode) {
        isSet.put("blockDevicesMode", true);
        this.blockDevicesMode = blockDevicesMode;
    }

    @JsonIgnore
    public boolean isBlockDevicesModeSet() {

        return isSet.containsKey("blockDevicesMode");
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupPersistenceConfiguration persistence;

        private Builder() {
            this.persistence = new ElastigroupPersistenceConfiguration();
        }

        public static ElastigroupPersistenceConfiguration.Builder get() {
            return new Builder();
        }

        public ElastigroupPersistenceConfiguration.Builder setShouldPersistPrivateIp(final Boolean shouldPersistPrivateIp) {
            persistence.setShouldPersistPrivateIp(shouldPersistPrivateIp);
            return this;
        }

        public ElastigroupPersistenceConfiguration.Builder setShouldPersistBlockDevices(final Boolean shouldPersistBlockDevices) {
            persistence.setShouldPersistBlockDevices(shouldPersistBlockDevices);
            return this;
        }

        public ElastigroupPersistenceConfiguration.Builder setShouldPersistRootDevice(final Boolean shouldPersistRootDevice) {
            persistence.setShouldPersistRootDevice(shouldPersistRootDevice);
            return this;
        }

        public ElastigroupPersistenceConfiguration.Builder setBlockDevicesMode(final String blockDevicesMode) {
            persistence.setBlockDevicesMode(blockDevicesMode);
            return this;
        }

        public ElastigroupPersistenceConfiguration build() {
            return persistence;
        }
    }
    //endregion
}
