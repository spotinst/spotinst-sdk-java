package com.spotinst.sdkjava.model.repo.admin.account;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAccountAdminRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.admin.account.ApiAccountAdmin;
import com.spotinst.sdkjava.model.api.admin.account.ApiAccount;
import com.spotinst.sdkjava.model.api.admin.account.ApiUsers;
import com.spotinst.sdkjava.model.api.admin.account.ApiUsersPermissions;
import com.spotinst.sdkjava.model.bl.admin.account.Users;
import com.spotinst.sdkjava.model.bl.admin.account.UsersPermissions;
import com.spotinst.sdkjava.model.converters.admin.account.AccountConverter;
import com.spotinst.sdkjava.model.bl.admin.account.BlAccountAdmin;
import com.spotinst.sdkjava.model.bl.admin.account.Account;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateAccountRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateUsersPermissionsRequest;
import com.spotinst.sdkjava.model.service.admin.account.SpotAccountAdminService;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.stream.Collectors;

public class SpotAccountAdminRepo implements ISpotAccountAdminRepo {

    @Override
    // the in our case the client only gets token that's why the account identifier to delete,
    // and the account who deletes are the same one. (delete in repo gets 3 attributes)
    public RepoGenericResponse<Account> create(String accountName, String authToken) {
        RepoGenericResponse<Account> retVal;

        try {
            ApiAccount apiResponse = SpotAccountAdminService.createAccount(accountName, authToken);
            Account response = AccountConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(response);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }


    // To Do
    @Override
    // The base 'IRepository' class getAll() method requires 3 parameters but this implementation needs only
    // 'authToken' and 'cloudAccountId', therefore, 'filter' parameter is unused.
    public RepoGenericResponse<List<BlAccountAdmin>> getAll(Void filter, String authToken, String cloudAccountId) {
        RepoGenericResponse<List<BlAccountAdmin>> retVal;

        try {
            List<ApiAccountAdmin> apiAccountsList = SpotAccountAdminService.listAccounts(cloudAccountId, authToken);
            List<BlAccountAdmin> accountsList = apiAccountsList.stream().map(AccountConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(accountsList);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(UpdateAccountRequest request, String authToken, String accountId) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotAccountAdminService.updateAccount(request, authToken, accountId);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }


    @Override
    // the in our case the client only gets token that's why the account identifier to delete,
    // and the account who deletes are the same one. (delete in repo gets 3 attributes)
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotAccountAdminService.deleteAccount(identifier, authToken);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<Users>> getUsers(String authToken, String accountId) {
        RepoGenericResponse<List<Users>> retVal;

        try {
            List<ApiUsers> apiUsersList = SpotAccountAdminService.listUsers(accountId, authToken);
            List<Users> usersList = apiUsersList.stream().map(AccountConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(usersList);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateUsersPermission(String authToken, UpdateUsersPermissionsRequest request, String accountId) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updatePermissions = SpotAccountAdminService.updatePermissions(authToken, request, accountId);
            retVal = new RepoGenericResponse<>(updatePermissions);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<UsersPermissions>> getUserPermissions(String authToken, String accountId) {
        RepoGenericResponse<List<UsersPermissions>> retVal;

        try {
            List<ApiUsersPermissions> apiUsersPermissions = SpotAccountAdminService.apiUsersPermissions(accountId, authToken);
            List<UsersPermissions> userPermissions = apiUsersPermissions.stream().map(AccountConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(userPermissions);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
