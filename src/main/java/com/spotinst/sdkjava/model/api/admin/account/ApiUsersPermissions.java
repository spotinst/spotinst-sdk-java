package com.spotinst.sdkjava.model.api.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiUsersPermissions {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         permissionStrategy;
    private String                         role;
    private String                         policyIds;
    private String                         userId;
    //endregion

    //region Constructor
    private ApiUsersPermissions() {
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

    public String getPermissionStrategy() {
        return permissionStrategy;
    }

    public void setPermissionStrategy(String permissionStrategy) {
        isSet.add("permissionStrategy");
        this.permissionStrategy = permissionStrategy;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        isSet.add("role");
        this.role = role;
    }

    public String getPolicyIds() {
        return policyIds;
    }

    public void setPolicyIds(String policyIds) {
        isSet.add("policyIds");
        this.policyIds = policyIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        isSet.add("userId");
        this.userId = userId;
    }

    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isPermissionStrategySet() {
        return isSet.contains("permissionStrategy");
    }

    @JsonIgnore
    public boolean isRoleSet() {
        return isSet.contains("role");
    }

    @JsonIgnore
    public boolean isPolicyIdsSet() {
        return isSet.contains("PolicyIds");
    }

    @JsonIgnore
    public boolean isUserIdSet() {
        return isSet.contains("userId");
    }

    //endregion
}
