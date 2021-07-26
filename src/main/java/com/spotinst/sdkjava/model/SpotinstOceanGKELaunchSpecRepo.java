package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.ApiElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupConverterGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstOceanGKELaunchSpecRepo implements ISpotinstOceanGKECreateLaunchSpecRepo {

    @Override
    public RepoGenericResponse<OceanGKECreateLaunchSpecRes> create(OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes, String authToken, String account) {
        RepoGenericResponse<OceanGKECreateLaunchSpecRes> retVal;

        try {
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpec = OceanGKELaunchSpecConverter.toDal(oceanGKECreateLaunchSpecRes);
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpecification =
                    SpotinstOceanGKELaunchSpecService.createLaunchSpec(apiOceanGKELaunchSpec, authToken, account);
            OceanGKECreateLaunchSpecRes CreatedLaunchSpec = OceanGKELaunchSpecConverter.toBl(apiOceanGKELaunchSpecification);
            retVal = new RepoGenericResponse<>(CreatedLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<OceanGKECreateLaunchSpecRes> get(String launchSpecId,String authToken, String account) {
        RepoGenericResponse<OceanGKECreateLaunchSpecRes> retVal;

        try {
            ApiOceanGKELaunchSpec apiOceanGKELaunchSpec =
                    SpotinstOceanGKELaunchSpecService.getALaunchSpec(authToken, account,launchSpecId);

            OceanGKECreateLaunchSpecRes launchSpecs =OceanGKELaunchSpecConverter.toBl(apiOceanGKELaunchSpec);
            retVal = new RepoGenericResponse<>(launchSpecs);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String launchSpecId, OceanGKECreateLaunchSpecRes launchSpecToUpdate, String authToken,
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
