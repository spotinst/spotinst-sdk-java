package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ohadmuchnik on 12/07/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiVolumePool implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       deviceName;
    private List<String> volumeIds;
    //endregion

    //region Constructor

    public ApiVolumePool() {
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

    public List<String> getVolumeIds() {
        return volumeIds;
    }

    public void setVolumeIds(List<String> volumeIds) {
        isSet.add("volumeIds");
        this.volumeIds = volumeIds;
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
