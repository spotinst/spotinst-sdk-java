package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupListStatefulInstancesDevices implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;

    private String      deviceName;
    private String      volumeId;
    private String      snapshotId;

    public ApiElastigroupListStatefulInstancesDevices() {
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
