package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAccountUserMapping {
    @JsonIgnore
    private Set<String> isSet;
    private String      accountId;
    private String      role;
    private String      permissionStrategy;

    public GetAccountUserMapping() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        isSet.add("accountId");
        this.accountId = accountId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        isSet.add("role;");
        this.role = role;
    }

    public String getPermissionStrategy() {
        return permissionStrategy;
    }

    public void setPermissionStrategy(String permissionStrategy) {
        isSet.add("permissionStrategy;");
        this.permissionStrategy = permissionStrategy;
    }

    public static class Builder {
        private GetAccountUserMapping user;

        private Builder() {
            this.user = new GetAccountUserMapping();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAccountId(final String accountId) {
            user.setAccountId(accountId);
            return this;
        }

        public Builder setRole(final String role) {
            user.setRole(role);
            return this;
        }

        public Builder setPermissionStrategy(final String permissionStrategy) {
            user.setPermissionStrategy(permissionStrategy);
            return this;
        }

        public GetAccountUserMapping build() {
            return user;
        }
    }

    @JsonIgnore
    public boolean isAccountIdSet() {
        return isSet.contains("accountId");
    }

    @JsonIgnore
    public boolean isRoleSet() {
        return isSet.contains("role");
    }

    @JsonIgnore
    public boolean isPermissionStrategySet() {
        return isSet.contains("permissionStrategy");
    }
}