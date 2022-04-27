package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgrammaticUserAccounts {
    @JsonIgnore
    private Set<String>   isSet;
    private String        id;
    private String        role;

    public ProgrammaticUserAccounts() {
        isSet = new HashSet<>();
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        isSet.add("role");
        this.role = role;
    }

    public static class Builder {
        private ProgrammaticUserAccounts userAccount;

        private Builder() {
            this.userAccount = new ProgrammaticUserAccounts();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            userAccount.setId(id);
            return this;
        }

        public Builder setRole(final String role) {
            userAccount.setRole(role);
            return this;
        }

        public ProgrammaticUserAccounts build() {
            return userAccount;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isRoleSet() {
        return isSet.contains("role");
    }
}