package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.EbsDevice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class BlockDeviceMappingAzure {
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String deviceName;
    private String noDevice;
    private String virtualName;
    private EbsDeviceAzure ebsDevice;

    //region Constructor

    private BlockDeviceMappingAzure() {
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


    public EbsDeviceAzure getEbsDevice() {
        return ebsDevice;
    }

    public void setEbsDevice(EbsDeviceAzure ebsDevice) {
        isSet.add("ebsDevice");
        this.ebsDevice = ebsDevice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockDeviceMappingAzure that = (BlockDeviceMappingAzure) o;

        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (noDevice != null ? !noDevice.equals(that.noDevice) : that.noDevice != null) return false;
        if (virtualName != null ? !virtualName.equals(that.virtualName) : that.virtualName != null) return false;
        return !(ebsDevice != null ? !ebsDevice.equals(that.ebsDevice) : that.ebsDevice != null);

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
        private BlockDeviceMappingAzure blockDeviceMapping;

        private Builder() {
            this.blockDeviceMapping = new BlockDeviceMappingAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
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

        public Builder setEbsDevice(final EbsDeviceAzure ebsDevice) {
            blockDeviceMapping.setEbsDevice(ebsDevice);
            return this;
        }

        public BlockDeviceMappingAzure build() {
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
