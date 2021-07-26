package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class BlAccountAdmin {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         accountId;
    private String                         name;
    private String                         organizationId;
    private String                         cloudProvider;
    private String                         providerExternalId;
    //endregion

    //region Constructor
    private BlAccountAdmin() {
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

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        isSet.add("accountId");
        this.accountId = accountId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId) {
        isSet.add("organizationId");
        this.organizationId = organizationId;
    }

    public String getCloudProvider() {
        return this.cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        isSet.add("cloudProvider");
        this.cloudProvider = cloudProvider;
    }

    public String getProviderExternalId() {
        return this.providerExternalId;
    }

    public void setProviderExternalId(String providerExternalId) {
        isSet.add("providerExternalId");
        this.providerExternalId = providerExternalId;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private BlAccountAdmin account;

        private Builder() {
            this.account = new BlAccountAdmin();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAccountId(final String accountId) {
            account.setAccountId(accountId);
            return this;
        }

        public Builder setName(final String name) {
            account.setName(name);
            return this;
        }

        public Builder setOrganizationId(final String organizationId) {
            account.setOrganizationId(organizationId);
            return this;
        }

        public Builder setCloudProvider(final String cloudProvider) {
            account.setCloudProvider(cloudProvider);
            return this;
        }

        public Builder setProviderExternalId(final String providerExternalId) {
            account.setProviderExternalId(providerExternalId);
            return this;
        }

        public BlAccountAdmin build() {
            return account;
        }
    }
    //endregion

    //region isSet methods
    // Is accountId Set boolean method
    @JsonIgnore
    public boolean isAccountIdSet() {
        return isSet.contains("accountId");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is organizationId Set boolean method
    @JsonIgnore
    public boolean isOrganizationIdSet() {
        return isSet.contains("organizationId");
    }

    // Is cloudProvider Set boolean method
    @JsonIgnore
    public boolean isCloudProviderSet() {
        return isSet.contains("cloudProvider");
    }

    // Is providerExternalId Set boolean method
    @JsonIgnore
    public boolean isProviderExternalIdSet() {
        return isSet.contains("providerExternalId");
    }

    //endregion
}
