package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecNetworkInterfaceAdditionalIpConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private String      privateIpAddressVersion;
    private String      name;

    //region Constructors
    private LaunchSpecNetworkInterfaceAdditionalIpConfiguration() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPrivateIpAddressVersion() {
        return privateIpAddressVersion;
    }

    public void setPrivateIpAddressVersion(String privateIpAddressVersion) {
        isSet.add("privateIpAddressVersion");
        this.privateIpAddressVersion = privateIpAddressVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public static class Builder {

        private LaunchSpecNetworkInterfaceAdditionalIpConfiguration publicIpsConfiguration;

        private Builder() {
            this.publicIpsConfiguration = new LaunchSpecNetworkInterfaceAdditionalIpConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPrivateIpAddressVersion(final String privateIpAddressVersion) {
            publicIpsConfiguration.setPrivateIpAddressVersion(privateIpAddressVersion);
            return this;
        }

        public Builder setName(final String name) {
            publicIpsConfiguration.setName(name);
            return this;
        }

        public LaunchSpecNetworkInterfaceAdditionalIpConfiguration build() {
            return publicIpsConfiguration;
        }
    }

    @JsonIgnore
    public boolean isPrivateIpAddressVersionSet() { return isSet.contains("privateIpAddressVersion"); }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}

