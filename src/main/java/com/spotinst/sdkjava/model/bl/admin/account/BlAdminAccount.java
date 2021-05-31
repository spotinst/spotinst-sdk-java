package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupInitializeParamsGcp;

import java.util.HashSet;
import java.util.Set;

public class BlAdminAccount {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         id;
    private String                         name;
    //endregion

    //region Constructor
    private BlAdminAccount() {
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

    //endregion

    //region Builder class
    public static class Builder {
        private BlAdminAccount account;

        private Builder() {
            this.account = new BlAdminAccount();
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

        public BlAdminAccount build() {
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

    //endregion
}
