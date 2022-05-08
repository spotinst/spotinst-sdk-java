package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class BlockDeviceMapping {
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String deviceName;
    private String noDevice;
    private String virtualName;
    private EbsDevice ebsDevice;

    //region Constructor

    private BlockDeviceMapping() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        isSet.add("deviceName");
        this.deviceName = deviceName;
    }


    public String getNoDevice() {
        return noDevice;
    }

    public void setNoDevice(String noDevice) {
        isSet.add("noDevice");
        this.noDevice = noDevice;
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        isSet.add("virtualName");
        this.virtualName = virtualName;
    }


    public EbsDevice getEbsDevice() {
        return ebsDevice;
    }

    public void setEbsDevice(EbsDevice ebsDevice) {
        isSet.add("ebsDevice");
        this.ebsDevice = ebsDevice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockDeviceMapping that = (BlockDeviceMapping) o;

        if (!Objects.equals(deviceName, that.deviceName)) return false;
        if (!Objects.equals(noDevice, that.noDevice)) return false;
        if (!Objects.equals(virtualName, that.virtualName)) return false;
        return !(!Objects.equals(ebsDevice, that.ebsDevice));

    }

    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 31 * result + (noDevice != null ? noDevice.hashCode() : 0);
        result = 31 * result + (virtualName != null ? virtualName.hashCode() : 0);
        result = 31 * result + (ebsDevice != null ? ebsDevice.hashCode() : 0);
        return result;
    }

    //region Builder class
    public static class Builder {
        private BlockDeviceMapping blockDeviceMapping;

        private Builder() {
            this.blockDeviceMapping = new BlockDeviceMapping();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDeviceName(final String deviceName) {
            blockDeviceMapping.setDeviceName(deviceName);
            return this;
        }

        public Builder setVirtualName(final String virtualName) {
            blockDeviceMapping.setVirtualName(virtualName);
            return this;
        }

        public Builder setNoDevice(final String noDevice) {
            blockDeviceMapping.setNoDevice(noDevice);
            return this;
        }

        public Builder setEbsDevice(final EbsDevice ebsDevice) {
            blockDeviceMapping.setEbsDevice(ebsDevice);
            return this;
        }

        public BlockDeviceMapping build() {
            // TODO : Validations
            return blockDeviceMapping;
        }
    }
    //endregion

    //region isSet methods
    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }


    // Is noDevice Set boolean method
    @JsonIgnore
    public boolean isNoDeviceSet() {
        return isSet.contains("noDevice");
    }


    // Is virtualName Set boolean method
    @JsonIgnore
    public boolean isVirtualNameSet() {
        return isSet.contains("virtualName");
    }

    // Is ebsDevice Set boolean method
    @JsonIgnore
    public boolean isEbsDeviceSet() {
        return isSet.contains("ebsDevice");
    }

    //endregion
}
