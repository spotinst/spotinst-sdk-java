package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class Account {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         name;
    private String                         organizationId;
    //endregion

    //region Constructor
    private Account() {
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

    public String getId() {
        return this.id;
    }

    public void setId(String accountId) {
        isSet.add("id");
        this.id = accountId;
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

    //endregion

    //region Builder class
    public static class Builder {
        private Account account;

        private Builder() {
            this.account = new Account();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String accountId) {
            account.setId(accountId);
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

        public Account build() {
            return account;
        }
    }
    //endregion

    //region isSet methods
    // Is accountId Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
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

    //endregion
}
