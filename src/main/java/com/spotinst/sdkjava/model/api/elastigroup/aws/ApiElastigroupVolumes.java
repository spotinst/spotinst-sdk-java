package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aditya on 9/12/2023.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupVolumes implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String deviceName;
    private String volumeId;
    //endregion

    //region Constructor
    public ApiElastigroupVolumes() {
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
