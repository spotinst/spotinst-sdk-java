package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sobhana p on 9/12/2023.
 */
public class PrivateIpAddresses {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                   primary;
    private String                    privateIpAddress;
    //endregion

    //region Constructor
    public PrivateIpAddresses() {
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

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        isSet.add("primary");
        this.primary = primary;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        isSet.add("privateIpAddress");
        this.privateIpAddress = privateIpAddress;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private PrivateIpAddresses privateIpAddresses;

        private Builder() {
            this.privateIpAddresses = new PrivateIpAddresses();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPrimary(final Boolean primary) {
            privateIpAddresses.setPrimary(primary);
            return this;
        }

        public Builder setPrivateIpAddress(final String privateIpAddress) {
            privateIpAddresses.setPrivateIpAddress(privateIpAddress);
            return this;
        }

        public PrivateIpAddresses build() {
            return privateIpAddresses;
        }
    }

    //endregion

    //region isSet methods
    // Is primary Set boolean method
    @JsonIgnore
    public boolean isPrimarySet() {
        return isSet.contains("primary");
    }

    // Is privateIpAddress Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressSet() {
        return isSet.contains("privateIpAddress");
    }

    //endregion
}
