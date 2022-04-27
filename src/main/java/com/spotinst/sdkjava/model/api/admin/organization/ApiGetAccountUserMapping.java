package com.spotinst.sdkjava.model.api.admin.organization;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGetAccountUserMapping implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      accountId;
    private String      role;
    private String      permissionStrategy;

    public ApiGetAccountUserMapping() {
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