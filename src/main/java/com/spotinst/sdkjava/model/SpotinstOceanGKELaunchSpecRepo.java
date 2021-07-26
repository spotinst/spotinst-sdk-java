package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKELaunchSpec;

public class SpotinstOceanGKELaunchSpecRepo implements ISpotinstOceanGKECreateLaunchSpecRepo {

    @Override
    public RepoGenericResponse<OceanGKELaunchSpec> create(OceanGKELaunchSpec oceanGKECreateLaunchSpecRes, String authToken, String account) {
        RepoGenericResponse<OceanGKELaunchSpec> retVal;

        try {
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpec = OceanGKELaunchSpecConverter.toDal(oceanGKECreateLaunchSpecRes);
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpecification =
                    SpotinstOceanGKELaunchSpecService.createLaunchSpec(apiOceanGKELaunchSpec, authToken, account);
            OceanGKELaunchSpec CreatedLaunchSpec = OceanGKELaunchSpecConverter.toBl(apiOceanGKELaunchSpecification);
            retVal = new RepoGenericResponse<>(CreatedLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<OceanGKELaunchSpec> get(String launchSpecId,String authToken, String account) {
        RepoGenericResponse<OceanGKELaunchSpec> retVal;

        try {
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpec =
                    SpotinstOceanGKELaunchSpecService.getALaunchSpec(authToken, account,launchSpecId);

            OceanGKELaunchSpec launchSpecs =OceanGKELaunchSpecConverter.toBl(apiOceanGKELaunchSpec);
            retVal = new RepoGenericResponse<>(launchSpecs);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String launchSpecId, OceanGKELaunchSpec launchSpecToUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpec = OceanGKELaunchSpecConverter.toDal(launchSpecToUpdate);
            Boolean success =
                    SpotinstOceanGKELaunchSpecService.updateLaunchSpec(apiOceanGKELaunchSpec,launchSpecId,authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String launchSpecId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstOceanGKELaunchSpecService.deleteLaunchSpec(launchSpecId, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
