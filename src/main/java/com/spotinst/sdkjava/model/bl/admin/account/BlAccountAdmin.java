package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class BlAccountAdmin {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         name;
    private String                         organizationId;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        isSet.add("organizationId");
        this.organizationId = organizationId;
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

        public Builder setId(final String id) {
            account.setId(id);
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

        public BlAccountAdmin build() {
            return account;
        }
    }
    //endregion

    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() { return isSet.contains("id"); }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() { return isSet.contains("name"); }

    // Is organizationId Set boolean method
    @JsonIgnore
    public boolean isOrganizationIdSet() { return isSet.contains("organizationId"); }

    //endregion
}
