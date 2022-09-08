package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportClusterAdditionalIpConfigurationsAksResponse {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    name;
    private String                    privateIpAddressVersion;

    public ImportClusterAdditionalIpConfigurationsAksResponse() {
        isSet = new HashSet<>();
    }

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

    public static class Builder {

        private ImportClusterAdditionalIpConfigurationsAksResponse additionalIpConfigurationsAks;

        private Builder() {
            this.additionalIpConfigurationsAks = new ImportClusterAdditionalIpConfigurationsAksResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            additionalIpConfigurationsAks.setName(name);
            return this;
        }

        public Builder setPrivateIpAddressVersion(final String privateIpAddressVersion) {
            additionalIpConfigurationsAks.setPrivateIpAddressVersion(privateIpAddressVersion);
            return this;
        }

        public ImportClusterAdditionalIpConfigurationsAksResponse build() {
            return additionalIpConfigurationsAks;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPrivateIpAddressVersionSet() {
        return isSet.contains("privateIpAddressVersion");
    }
}
