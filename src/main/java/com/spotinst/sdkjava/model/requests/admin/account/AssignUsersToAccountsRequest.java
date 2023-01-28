package com.spotinst.sdkjava.model.requests.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AssignUsersToAccountsRequest {
    //region Members
    @JsonIgnore
    private String                         accountId;
    private String                         permissionStrategy;
    private String                         role;
    private String                         policyIds;
    private String                         userId;
    private String                         userEmail;
    //endregion

    //region Constructor
    private AssignUsersToAccountsRequest() {
    }
    //endregion
    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPermissionStrategy() {
        return this.permissionStrategy;
    }

    public void setPermissionStrategy(String permissionStrategy) {
        this.permissionStrategy = permissionStrategy;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPolicyIds() {
        return this.policyIds;
    }

    public void setPolicyIds(String policyIds) {
        this.policyIds = policyIds;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private AssignUsersToAccountsRequest request;

        private Builder() {
            this.request = new AssignUsersToAccountsRequest();
        }

        public static AssignUsersToAccountsRequest.Builder get() {
            return new Builder();
        }

        public AssignUsersToAccountsRequest.Builder setPermissionStrategy(final String permissionStrategy) {
            request.setPermissionStrategy(permissionStrategy);
            return this;
        }

        public AssignUsersToAccountsRequest.Builder setRole(final String role) {
            request.setRole(role);
            return this;
        }

        public AssignUsersToAccountsRequest.Builder setPolicyIds(final String policyIds) {
            request.setPolicyIds(policyIds);
            return this;
        }

        public AssignUsersToAccountsRequest.Builder setUserId(final String userId) {
            request.setUserId(userId);
            return this;
        }

        public AssignUsersToAccountsRequest build() {
            return request;
        }
    }
    //endregion

}
