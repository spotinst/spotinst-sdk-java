package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.admin.account.ApiAccountAdmin;
import com.spotinst.sdkjava.model.bl.admin.account.AccountConverter;
import com.spotinst.sdkjava.model.bl.admin.account.BlAccountAdmin;

import java.util.List;
import java.util.stream.Collectors;

public class SpotAccountAdminRepo implements ISpotAccountAdminRepo {

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

}
