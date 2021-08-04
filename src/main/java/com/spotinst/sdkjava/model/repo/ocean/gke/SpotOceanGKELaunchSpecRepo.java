package com.spotinst.sdkjava.model.repo.ocean.gke;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotOceanGKELaunchSpecRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiLaunchSpecSpecification;
import com.spotinst.sdkjava.model.bl.ocean.gke.LaunchSpecSpecification;
import com.spotinst.sdkjava.model.converters.ocean.gke.OceanGKELaunchSpecConverter;
import com.spotinst.sdkjava.model.service.ocean.gke.SpotOceanGKELaunchSpecService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanGKELaunchSpecRepo implements ISpotOceanGKELaunchSpecRepo {

    @Override
    public RepoGenericResponse<LaunchSpecSpecification> create(LaunchSpecSpecification oceanGKECreateLaunchSpecRes, String authToken, String account) {
        RepoGenericResponse<LaunchSpecSpecification> retVal;

        try {
            ApiLaunchSpecSpecification
                    apiLaunchSpecSpecification = OceanGKELaunchSpecConverter.toDal(oceanGKECreateLaunchSpecRes);
            ApiLaunchSpecSpecification apiLaunchSpecificationSpecification =
                    SpotOceanGKELaunchSpecService.createLaunchSpec(apiLaunchSpecSpecification, authToken, account);
            LaunchSpecSpecification CreatedLaunchSpec = OceanGKELaunchSpecConverter.toBl(
                    apiLaunchSpecificationSpecification);
            retVal = new RepoGenericResponse<>(CreatedLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<LaunchSpecSpecification> get(String launchSpecId, String authToken, String account) {
        RepoGenericResponse<LaunchSpecSpecification> retVal;

        try {
            ApiLaunchSpecSpecification apiLaunchSpecSpecification =
                    SpotOceanGKELaunchSpecService.getLaunchSpec(authToken, account, launchSpecId);

            LaunchSpecSpecification launchSpecs =OceanGKELaunchSpecConverter.toBl(apiLaunchSpecSpecification);
            retVal = new RepoGenericResponse<>(launchSpecs);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<LaunchSpecSpecification>> getAllStatus(String authToken, String account,String oceanId) {
        RepoGenericResponse<List<LaunchSpecSpecification>> retVal;

        try {
            List<ApiLaunchSpecSpecification> apiLaunchSpecSpecification =
                    SpotOceanGKELaunchSpecService.getAllLaunchSpec(authToken, account,oceanId);
            List<LaunchSpecSpecification> launchSpecs = apiLaunchSpecSpecification.stream().map(OceanGKELaunchSpecConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<List<LaunchSpecSpecification>>(launchSpecs);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String launchSpecId, LaunchSpecSpecification launchSpecToUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiLaunchSpecSpecification
                    apiLaunchSpecSpecification = OceanGKELaunchSpecConverter.toDal(launchSpecToUpdate);
            Boolean success =
                    SpotOceanGKELaunchSpecService
                            .updateLaunchSpec(apiLaunchSpecSpecification, launchSpecId, authToken, account);
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
            Boolean updated = SpotOceanGKELaunchSpecService.deleteLaunchSpec(launchSpecId, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
