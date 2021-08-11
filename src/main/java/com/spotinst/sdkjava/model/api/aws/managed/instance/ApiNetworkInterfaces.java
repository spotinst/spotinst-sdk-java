package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiNetworkInterfaces {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     associateIpv6Address;
    private Boolean     associatePublicIpAddress;
    private Integer     deviceIndex;

    private ApiNetworkInterfaces() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getAssociateIpv6Address() {
        return associateIpv6Address;
    }

    public void setAssociateIpv6Address(Boolean associateIpv6Address) {
        isSet.add("associateIpv6Address");
        this.associateIpv6Address = associateIpv6Address;
    }

    public Boolean getAssociatePublicIpAddress() {
        return associatePublicIpAddress;
    }

    public void setAssociatePublicIpAddress(Boolean associatePublicIpAddress) {
        isSet.add("associatePublicIpAddress");
        this.associatePublicIpAddress = associatePublicIpAddress;
    }

    public Integer getDeviceIndex() {
        return deviceIndex;
    }

    public void setDeviceIndex(Integer deviceIndex) {
        isSet.add("deviceIndex");
        this.deviceIndex = deviceIndex;
    }

    @JsonIgnore
    public boolean isAssociateIpv6AddressSet() {
        return isSet.contains("associateIpv6Address");
    }

    @JsonIgnore
    public boolean isassociatePublicIpAddressSet() {
        return isSet.contains("associatePublicIpAddress");
    }

    @JsonIgnore
    public boolean isdeviceIndexSet() {
        return isSet.contains("deviceIndex");
    }

}
