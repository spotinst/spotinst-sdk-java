package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

public class SpotAdminAccountRepo implements ISpotAdminAccountRepo{

    @Override
    public RepoGenericResponse<Boolean> deleteWithTokenOnly(String identifier, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        // TODO or: as we talked use delete here, and put short comment about the special case of accounts.
        try {
            // TODO or: method should be called deleteAccount
            Boolean updated = SpotAdminAccountService.deleteAdminAccount(identifier, authToken);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
