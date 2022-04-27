package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupListStatefulInstancesDevices {

    @JsonIgnore
    private Set<String> isSet;

    private String      deviceName;
    private String      volumeId;
    private String      snapshotId;

    public ElastigroupListStatefulInstancesDevices() {
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

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        isSet.add("volumeId");
        this.volumeId = volumeId;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        isSet.add("snapshotId");
        this.snapshotId = snapshotId;
    }

    public static class Builder {
        private ElastigroupListStatefulInstancesDevices elastigroupListStatefulInstanceDevices;

        private Builder() {
            this.elastigroupListStatefulInstanceDevices = new ElastigroupListStatefulInstancesDevices();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDeviceName(final String deviceName) {
            elastigroupListStatefulInstanceDevices.setDeviceName(deviceName);
            return this;
        }

        public Builder setVolumeId(final String volumeId) {
            elastigroupListStatefulInstanceDevices.setVolumeId(volumeId);
            return this;
        }

        public Builder setSnapshotId(final String snapshotId) {
            elastigroupListStatefulInstanceDevices.setSnapshotId(snapshotId);
            return this;
        }

        public ElastigroupListStatefulInstancesDevices build() {
            return elastigroupListStatefulInstanceDevices;
        }

    }

    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    @JsonIgnore
    public boolean isVolumeIdSet() {
        return isSet.contains("volumeId");
    }

    @JsonIgnore
    public boolean isSnapshotIdSet() {
        return isSet.contains("snapshotId");
    }

}
