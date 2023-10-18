package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aditya on 11/10/23.
 */

public class ElastigroupVolumes {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String deviceName;
    private String volumeId;


    //endregion

    //region Constructor

    private ElastigroupVolumes() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

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


    //endregion

    //region Builder class
    public static class Builder {

        private ElastigroupVolumes volume;

        private Builder() {
            this.volume = new ElastigroupVolumes();
        }

        public static ElastigroupVolumes.Builder get() {
            return new ElastigroupVolumes.Builder();
        }

        public ElastigroupVolumes.Builder setDeviceName(final String deviceName) {
            volume.setDeviceName(deviceName);
            return this;
        }

        public ElastigroupVolumes.Builder setVolumeId(final String volumeId) {
            volume.setVolumeId(volumeId);
            return this;
        }
        public ElastigroupVolumes build() {
            return volume;
        }
    }

    //endregion
    //region isSet methods

    // Is volumes Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    @JsonIgnore
    public boolean isVolumeIdSet() {
        return isSet.contains("volumeId");
    }

    //endregion
}
