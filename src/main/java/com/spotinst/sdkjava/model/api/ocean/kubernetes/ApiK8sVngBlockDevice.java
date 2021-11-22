package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiK8sVngBlockDevice implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>  	    isSet;
    private String       	    deviceName;
    private ApiK8sVngEbsDevice  ebs;

    public ApiK8sVngBlockDevice() {
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

    public ApiK8sVngEbsDevice getEbs() {
        return ebs;
    }

    public void setEbs(ApiK8sVngEbsDevice ebs) {
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