package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterAks;
import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import com.spotinst.sdkjava.model.bl.admin.account.*;

import java.util.List;
import java.util.stream.Collectors;

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
