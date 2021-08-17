package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.bl.aws.managed.instance.Ebs;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiBlockDeviceMappings {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      deviceName;
    private ApiEbs      ebs;
    //endregion

    //region Constructor

    public ApiBlockDeviceMappings() {
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

    public ApiEbs getEbs() {
        return ebs;
    }

    public void setEbs(ApiEbs ebs) {
        isSet.add("ebs");
        this.ebs = ebs;
    }

    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    @JsonIgnore
    public boolean isEbsSet() {
        return isSet.contains("ebs");
    }

}

