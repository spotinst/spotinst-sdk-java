package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.account.*;
import com.spotinst.sdkjava.model.bl.admin.organization.Policy;
import com.spotinst.sdkjava.model.requests.admin.account.AssignUsersToAccountsRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateAccountRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateUserPermissionsRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UserDetachRequest;

import java.util.List;

public interface ISpotAccountAdminRepo extends IRepository<BlAccountAdmin, Void, String> {
    RepoGenericResponse<Account> create(String accountName, String authToken);

    RepoGenericResponse<Boolean> update(UpdateAccountRequest request, String authToken, String account);

    RepoGenericResponse<List<Users>> getUsers(String authToken, String accountId);

    RepoGenericResponse<Boolean> updateUserPermissions(String authToken, UpdateUserPermissionsRequest request, String accountId);

    RepoGenericResponse<List<UserPermissions>> getUsersPermissions(String authToken, String accountId);

    RepoGenericResponse<Boolean> assignUsersToAccounts(String authToken, AssignUsersToAccountsRequest request, String accountId);

    RepoGenericResponse<Boolean> detachUser(String accountId, String authToken, UserDetachRequest request);

    RepoGenericResponse<List<Policy>> listAccessPolicies(String authToken, String accountId);
}
