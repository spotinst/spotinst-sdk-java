package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AdditionalIpConfigurationsAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String privateIpAddressVersion;
    //endregion

    //region Constructors
    private AdditionalIpConfigurationsAzure() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getPrivateIpAddressVersion() {
        return privateIpAddressVersion;
    }

    public void setPrivateIpAddressVersion(String privateIpAddressVersion) {
        isSet.add("privateIpAddressVersion");
        this.privateIpAddressVersion = privateIpAddressVersion;
    }

    //endregion

    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AdditionalIpConfigurationsAzure tag = (AdditionalIpConfigurationsAzure) o;

        if (!name.equals(tag.name)) {
            return false;
        }
        return privateIpAddressVersion.equals(tag.privateIpAddressVersion);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + privateIpAddressVersion.hashCode();
        return result;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private AdditionalIpConfigurationsAzure additionalIpConfigurations;

        private Builder() {
            this.additionalIpConfigurations = new AdditionalIpConfigurationsAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            additionalIpConfigurations.setName(name);
            return this;
        }

        public Builder setPrivateIpAddressVersion(final String privateIpAddressVersion) {
            additionalIpConfigurations.setPrivateIpAddressVersion(privateIpAddressVersion);
            return this;
        }

        public AdditionalIpConfigurationsAzure build() {
            // TODO : Validations
            return additionalIpConfigurations;
        }
    }
    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is privateIpAddressVersion Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressVersionSet() {
        return isSet.contains("privateIpAddressVersion");
    }

    //endregion
}
