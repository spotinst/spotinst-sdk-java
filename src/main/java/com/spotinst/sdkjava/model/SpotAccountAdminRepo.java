package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

public class SpotAccountAdminRepo implements ISpotAccountAdminRepo {

    @Override
    // the in our case the client only gets token thats why the account identifier to delete, and the account who deletes are the same one. (delete in repo gets 3 attributes)
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        // TODO or: as we talked use delete here, and put short comment about the special case of accounts. - Done
        try {
            // TODO or: method should be called deleteAccount - Done
            Boolean updated = SpotAccountAdminService.deleteAccount(identifier, authToken);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
