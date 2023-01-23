package com.spotinst.sdkjava.model.requests.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

public class UpdateUsersPermissionsRequest {
    //region Members
    @JsonIgnore
    private String                         permissionStrategy;
    private String                         role;
    private String                         policyIds;
    private String                         userId;
    //endregion

    //region Constructor
    private UpdateUsersPermissionsRequest() {
    }
    //endregion

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

    //endregion

    //region Builder class
    public static class Builder {
        private UpdateUsersPermissionsRequest request;

        private Builder() {
            this.request = new UpdateUsersPermissionsRequest();
        }

        public static UpdateUsersPermissionsRequest.Builder get() {
            return new Builder();
        }

        public UpdateUsersPermissionsRequest.Builder setPermissionStrategy(final String permissionStrategy) {
            request.setPermissionStrategy(permissionStrategy);
            return this;
        }

        public UpdateUsersPermissionsRequest.Builder setRole(final String role) {
            request.setRole(role);
            return this;
        }

        public UpdateUsersPermissionsRequest.Builder setPolicyIds(final String policyIds) {
            request.setPolicyIds(policyIds);
            return this;
        }

        public UpdateUsersPermissionsRequest.Builder setUserId(final String userId) {
            request.setUserId(userId);
            return this;
        }

        public UpdateUsersPermissionsRequest build() {
            return request;
        }
    }
    //endregion

}
