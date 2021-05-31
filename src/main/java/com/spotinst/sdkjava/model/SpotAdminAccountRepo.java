package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

public class SpotAdminAccountRepo implements ISpotAdminAccountRepo{

    @Override
    public RepoGenericResponse<Boolean> deleteWithTokenOnly(String identifier, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotAdminAccountService.deleteAdminAccount(identifier, authToken);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
