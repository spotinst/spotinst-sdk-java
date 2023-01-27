package com.spotinst.sdkjava.model.requests.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

public class UpdateUserPermissionsRequest {
    //region Members
    @JsonIgnore
    private String                         permissionStrategy;
    private String                         role;
    private String                         policyIds;
    private String                         userId;
    //endregion

    //region Constructor
    private UpdateUserPermissionsRequest() {
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
        private UpdateUserPermissionsRequest request;

        private Builder() {
            this.request = new UpdateUserPermissionsRequest();
        }

        public static UpdateUserPermissionsRequest.Builder get() {
            return new Builder();
        }

        public UpdateUserPermissionsRequest.Builder setPermissionStrategy(final String permissionStrategy) {
            request.setPermissionStrategy(permissionStrategy);
            return this;
        }

        public UpdateUserPermissionsRequest.Builder setRole(final String role) {
            request.setRole(role);
            return this;
        }

        public UpdateUserPermissionsRequest.Builder setPolicyIds(final String policyIds) {
            request.setPolicyIds(policyIds);
            return this;
        }

        public UpdateUserPermissionsRequest.Builder setUserId(final String userId) {
            request.setUserId(userId);
            return this;
        }

        public UpdateUserPermissionsRequest build() {
            return request;
        }
    }
    //endregion

}
