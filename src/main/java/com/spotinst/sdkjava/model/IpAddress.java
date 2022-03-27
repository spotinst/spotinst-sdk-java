package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/25/15.
 */
public class IpAddress {

    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String privateIpAddress;
    private boolean primary;

    //region Constructor

    private IpAddress() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        isSet.add("privateIpAddress");
        this.privateIpAddress = privateIpAddress;
    }

    public boolean getPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        isSet.add("primary");
        this.primary = primary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IpAddress that = (IpAddress) o;

        if (primary != that.primary) return false;
        return privateIpAddress.equals(that.privateIpAddress);

    }

    @Override
    public int hashCode() {
        int result = privateIpAddress.hashCode();
        result = 31 * result + (primary ? 1 : 0);
        return result;
    }
    //region Builder class
    public static class Builder {
        private IpAddress ipAddress;

        private Builder() {
            this.ipAddress = new IpAddress();
        }

        public static Builder get(){
            return new Builder();
        }

        public Builder setPrivateIpAddress(final String privateIdAddress) {
            ipAddress.setPrivateIpAddress(privateIdAddress);
            return this;
        }

        public Builder setPrimary(final Boolean primary) {
            ipAddress.setPrimary(primary);
            return this;
        }

        public IpAddress build() {
            // TODO : Validations
            return ipAddress;
        }
    }
    //endregion
    //region isSet methods
    // Is privateIpAddress Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressSet() {
        return isSet.contains("privateIpAddress");
    }

    // Is primary Set boolean method
    @JsonIgnore
    public boolean isPrimarySet() {
        return isSet.contains("primary");
    }

    //endregion
}
