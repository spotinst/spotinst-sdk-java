package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ohadmuchnik on 14/07/2016.
 */
public class ElastigroupEbsVolumePool {
    @JsonIgnore
    private Set<String> isSet;
    private String deviceName;
    private List<String> volumeIds;

    //region Constructor

    private ElastigroupEbsVolumePool() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getVolumeIds() {
        return volumeIds;
    }

    public void setVolumeIds(List<String> volumeIds) {
        isSet.add("volumeIds");
        this.volumeIds = volumeIds;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        isSet.add("deviceName");
        this.deviceName = deviceName;
    }

    //region Builder class
    public static class Builder {
        private ElastigroupEbsVolumePool ebsVolumePool;

        private Builder() {
            this.ebsVolumePool = new ElastigroupEbsVolumePool();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeviceName(final String deviceName) {
            ebsVolumePool.setDeviceName(deviceName);
            return this;
        }

        public Builder setVolumeIds(final List<String> volumeIds) {
            ebsVolumePool.setVolumeIds(volumeIds);
            return this;
        }

        public ElastigroupEbsVolumePool build() {
            // TODO : Validations
            return ebsVolumePool;
        }
    }

    //endregion

    //region isSet methods
    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    // Is volumeIds Set boolean method
    @JsonIgnore
    public boolean isVolumeIdsSet() {
        return isSet.contains("volumeIds");
    }

    //endregion
}
