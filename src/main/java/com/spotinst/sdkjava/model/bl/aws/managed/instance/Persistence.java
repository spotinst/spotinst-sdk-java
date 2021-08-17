package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persistence {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      blockDevicesMode;
    private Boolean     persistBlockDevices;
    private Boolean     persistPrivateIp;
    private Boolean     persistRootDevice;

    //endregion

    //region constructor
    private Persistence() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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

    //endregion

    //region Builder class
    public static class Builder {
        private Persistence persistence;

        private Builder() {
            this.persistence = new Persistence();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
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
            // TODO : Validations
            return persistence;
        }
    }
    //endregion

    //region isSet methods
    // Is blockDevicesMode Set boolean method
    @JsonIgnore
    public boolean isBlockDevicesModeSet() {
        return isSet.contains("blockDevicesMode");
    }

    // Is persistBlockDevices Set boolean method
    @JsonIgnore
    public boolean isPersistBlockDevicesSet() {
        return isSet.contains("persistBlockDevices");
    }

    // Is persistPrivateIp Set boolean method
    @JsonIgnore
    public boolean isPersistPrivateIpSet() {
        return isSet.contains("persistPrivateIp");
    }

    // Is persistRootDevice Set boolean method
    @JsonIgnore
    public boolean isPersistRootDeviceSet() {
        return isSet.contains("persistRootDevice");
    }

    //endregion
}
