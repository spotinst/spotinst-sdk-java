package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aditya on 11/10/23.
 */

public class ElastigroupVolume {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String deviceName;
    private String volumeId;


    //endregion

    //region Constructor

    private ElastigroupVolume() {
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

        private ElastigroupVolume volume;

        private Builder() {
            this.volume = new ElastigroupVolume();
        }

        public static ElastigroupVolume.Builder get() {
            return new ElastigroupVolume.Builder();
        }

        public ElastigroupVolume.Builder setDeviceName(final String deviceName) {
            volume.setDeviceName(deviceName);
            return this;
        }

        public ElastigroupVolume.Builder setVolumeId(final String volumeId) {
            volume.setVolumeId(volumeId);
            return this;
        }
        public ElastigroupVolume build() {
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
