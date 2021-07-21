package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;

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

}
