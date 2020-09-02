package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiBlockDeviceAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>       isSet;
    private String            deviceName;
    private ApiEbsDeviceAzure ebs;
    private String            noDevice;
    private String            virtualName;
    //endregion

    public ApiBlockDeviceAzure() {
        isSet = new HashSet<>();
    }


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

    public ApiEbsDeviceAzure getEbs() {
        return ebs;
    }

    public void setEbs(ApiEbsDeviceAzure ebs) {
        isSet.add("ebs");
        this.ebs = ebs;
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
    //endregion

    //region Isset Methods
    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    // Is ebs Set boolean method
    @JsonIgnore
    public boolean isEbsSet() {
        return isSet.contains("ebs");
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


    //endregion
}
