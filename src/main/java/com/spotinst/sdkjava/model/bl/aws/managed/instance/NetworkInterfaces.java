package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkInterfaces {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     associateIpv6Address;
    private Boolean     associatePublicIpAddress;
    private Integer     deviceIndex;

    //endregion

    //region Constructor
    private NetworkInterfaces() {
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

    //endregion

    //region Builder class
    public static class Builder {
        private NetworkInterfaces networkInterfaces;

        private Builder() {
            this.networkInterfaces = new NetworkInterfaces();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAssociateIpv6Address(final Boolean associateIpv6Address) {
            networkInterfaces.setAssociateIpv6Address(associateIpv6Address);
            return this;
        }

        public Builder setAssociatePublicIpAddress(final Boolean associatePublicIpAddress) {
            networkInterfaces.setAssociatePublicIpAddress(associatePublicIpAddress);
            return this;
        }

        public Builder setDeviceIndex(final Integer deviceIndex) {
            networkInterfaces.setDeviceIndex(deviceIndex);
            return this;
        }

        public com.spotinst.sdkjava.model.bl.aws.managed.instance.NetworkInterfaces build() {
            // TODO : Validations
            return networkInterfaces;
        }
    }

    //endregion

    //region isSet methods
    // Is associateIpv6Address Set boolean method
    @JsonIgnore
    public boolean isAssociateIpv6AddressSet() {
        return isSet.contains("associateIpv6Address");
    }

    // Is associatePublicIpAddress Set boolean method
    @JsonIgnore
    public boolean isAssociatePublicIpAddressSet() {
        return isSet.contains("associatePublicIpAddress");
    }

    // Is deviceIndex Set boolean method
    @JsonIgnore
    public boolean isDeviceIndexSet() {
        return isSet.contains("deviceIndex");
    }

    //endregion

}
