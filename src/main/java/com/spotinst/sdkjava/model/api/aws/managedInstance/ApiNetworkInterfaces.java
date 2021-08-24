package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiNetworkInterfaces {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     associateIpv6Address;
    private Boolean     associatePublicIpAddress;
    private Integer     deviceIndex;

    public ApiNetworkInterfaces() {
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
    public boolean isAssociatePublicIpAddressSet() {
        return isSet.contains("associatePublicIpAddress");
    }

    @JsonIgnore
    public boolean isDeviceIndexSet() {
        return isSet.contains("deviceIndex");
    }

}
