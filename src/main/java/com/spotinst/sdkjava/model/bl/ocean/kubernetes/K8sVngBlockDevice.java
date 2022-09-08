package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class K8sVngBlockDevice {

    @JsonIgnore
    private Set<String>     isSet;
    private String          deviceName;
    private K8sVngEbsDevice ebsDevice;

    private K8sVngBlockDevice() {
        isSet = new HashSet<>();
    }

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

    public K8sVngEbsDevice getEbsDevice() {
        return ebsDevice;
    }

    public void setK8sVngEbsDevice(K8sVngEbsDevice ebsDevice) {
        isSet.add("ebsDevice");
        this.ebsDevice = ebsDevice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        K8sVngBlockDevice that = (K8sVngBlockDevice) o;

        if (!Objects.equals(deviceName, that.deviceName)) return false;
        return !(!Objects.equals(ebsDevice, that.ebsDevice));

    }

    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 31 * result + (ebsDevice != null ? ebsDevice.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private K8sVngBlockDevice blockDeviceMapping;

        private Builder() {
            this.blockDeviceMapping = new K8sVngBlockDevice();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDeviceName(final String deviceName) {
            blockDeviceMapping.setDeviceName(deviceName);
            return this;
        }

        public Builder setEbsDevice(final K8sVngEbsDevice ebsDevice) {
            blockDeviceMapping.setK8sVngEbsDevice(ebsDevice);
            return this;
        }

        public K8sVngBlockDevice build() {
            // TODO : Validations
            return blockDeviceMapping;
        }
    }


    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    @JsonIgnore
    public boolean isEbsDeviceSet() {
        return isSet.contains("ebsDevice");
    }
}