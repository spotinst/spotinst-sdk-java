package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by aharontwizer on 8/25/15.
 */
public class NetworkInterface {

    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String description;
    private Integer deviceIndex;
    private Integer secondaryPrivateIpAddressCount;
    private Boolean associatePublicIpAddress;
    private Boolean deleteOnTermination;
    private String networkInterfaceId;
    private String privateIpAddress;
    private List<IpAddress> privateIpAddresses;
    private Boolean associateIpv6Address;

    //region Constructor

    private NetworkInterface() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public Integer getDeviceIndex() {
        return deviceIndex;
    }

    public void setDeviceIndex(Integer deviceIndex) {
        isSet.add("deviceIndex");
        this.deviceIndex = deviceIndex;
    }

    public Integer getSecondaryPrivateIpAddressCount() {
        return secondaryPrivateIpAddressCount;
    }

    public void setSecondaryPrivateIpAddressCount(Integer secondaryPrivateIpAddressCount) {
        isSet.add("secondaryPrivateIpAddressCount");
        this.secondaryPrivateIpAddressCount = secondaryPrivateIpAddressCount;
    }

    public Boolean getAssociatePublicIpAddress() {
        return associatePublicIpAddress;
    }

    public void setAssociatePublicIpAddress(Boolean associatePublicIpAddress) {
        isSet.add("associatePublicIpAddress");
        this.associatePublicIpAddress = associatePublicIpAddress;
    }

    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        isSet.add("deleteOnTermination");
        this.deleteOnTermination = deleteOnTermination;
    }

    public String getNetworkInterfaceId() {
        return networkInterfaceId;
    }

    public void setNetworkInterfaceId(String networkInterfaceId) {
        isSet.add("networkInterfaceId");
        this.networkInterfaceId = networkInterfaceId;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        isSet.add("privateIpAddress");
        this.privateIpAddress = privateIpAddress;
    }

    public List<IpAddress> getPrivateIpAddresses() {
        return privateIpAddresses;
    }

    public void setPrivateIpAddresses(List<IpAddress> privateIpAddresses) {
        isSet.add("privateIpAddresses");
        this.privateIpAddresses = privateIpAddresses;
    }

    public Boolean getAssociateIpv6Address() {
        return associateIpv6Address;
    }

    public void setAssociateIpv6Address(Boolean associateIpv6Address) {
        isSet.add("associateIpv6Address");
        this.associateIpv6Address = associateIpv6Address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkInterface that = (NetworkInterface) o;

        if (associatePublicIpAddress != that.associatePublicIpAddress) return false;
        if (deleteOnTermination != that.deleteOnTermination) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(deviceIndex, that.deviceIndex)) return false;
        if (!Objects.equals(secondaryPrivateIpAddressCount, that.secondaryPrivateIpAddressCount))
            return false;
        if (!Objects.equals(networkInterfaceId, that.networkInterfaceId))
            return false;
        if (!Objects.equals(privateIpAddress, that.privateIpAddress))
            return false;
        return !(!Objects.equals(privateIpAddresses, that.privateIpAddresses));

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (deviceIndex != null ? deviceIndex.hashCode() : 0);
        result = 31 * result + (secondaryPrivateIpAddressCount != null ? secondaryPrivateIpAddressCount.hashCode() : 0);
        result = 31 * result + (associatePublicIpAddress ? 1 : 0);
        result = 31 * result + (deleteOnTermination ? 1 : 0);
        result = 31 * result + (networkInterfaceId != null ? networkInterfaceId.hashCode() : 0);
        result = 31 * result + (privateIpAddress != null ? privateIpAddress.hashCode() : 0);
        result = 31 * result + (privateIpAddresses != null ? privateIpAddresses.hashCode() : 0);
        return result;
    }

    //region Builder class
    public static class Builder {
        private NetworkInterface networkInterface;

        private Builder() {
            this.networkInterface = new NetworkInterface();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDeleteOnTermination(final Boolean deleteOnTermination) {
            networkInterface.setDeleteOnTermination(deleteOnTermination);
            return this;
        }

        public Builder setAssociatePublicIpAddress(final Boolean associatePublicIpAddress) {
            networkInterface.setAssociatePublicIpAddress(associatePublicIpAddress);
            return this;
        }

        public Builder setDescription(final String description) {
            networkInterface.setDescription(description);
            return this;
        }

        public Builder setDeviceIndex(final Integer deviceIndex) {
            networkInterface.setDeviceIndex(deviceIndex);
            return this;
        }

        public Builder setNetworkInterfaceId(final String networkInterfaceId) {
            networkInterface.setNetworkInterfaceId(networkInterfaceId);
            return this;
        }

        public Builder setPrivateIpAddress(final String privateIpAddress) {
            networkInterface.setPrivateIpAddress(privateIpAddress);
            return this;
        }

        public Builder setPrivateIpAddresses(final List<IpAddress> ipAddresses) {
            networkInterface.setPrivateIpAddresses(ipAddresses);
            return this;
        }

        public Builder setSecondaryPrivateIpAddressCount(final Integer secondaryPrivateIpAddressCount) {
            networkInterface.setSecondaryPrivateIpAddressCount(secondaryPrivateIpAddressCount);
            return this;
        }

        public Builder setAssociateIpv6Address(final Boolean associateIpv6Address)  {
            networkInterface.setAssociateIpv6Address(associateIpv6Address);
            return this;
        }


        public NetworkInterface build() {
            // TODO : Validations
            return networkInterface;
        }
    }
    //endregion
    //region isSet methods
    // Is description Set boolean method
    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }


    // Is deviceIndex Set boolean method
    @JsonIgnore
    public boolean isDeviceIndexSet() {
        return isSet.contains("deviceIndex");
    }


    // Is secondaryPrivateIpAddressCount Set boolean method
    @JsonIgnore
    public boolean isSecondaryPrivateIpAddressCountSet() {
        return isSet.contains("secondaryPrivateIpAddressCount");
    }


    // Is associatePublicIpAddress Set boolean method
    @JsonIgnore
    public boolean isAssociatePublicIpAddressSet() {
        return isSet.contains("associatePublicIpAddress");
    }


    // Is deleteOnTermination Set boolean method
    @JsonIgnore
    public boolean isDeleteOnTerminationSet() {
        return isSet.contains("deleteOnTermination");
    }


    // Is networkInterfaceId Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfaceIdSet() {
        return isSet.contains("networkInterfaceId");
    }


    // Is privateIpAddress Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressSet() {
        return isSet.contains("privateIpAddress");
    }

    // Is privateIpAddresses Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressesSet() {
        return isSet.contains("privateIpAddresses");
    }

    // Is associateIpv6Address Set boolean method
    @JsonIgnore
    public boolean isAssociateIpv6AddressSet() {
        return isSet.contains("associateIpv6Address");
    }

    //endregion
}
