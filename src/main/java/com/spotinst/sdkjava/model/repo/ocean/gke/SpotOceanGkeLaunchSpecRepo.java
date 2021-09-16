package com.spotinst.sdkjava.model.repo.ocean.gke;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotOceanGKELaunchSpecRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiLaunchSpecSpecification;
import com.spotinst.sdkjava.model.bl.ocean.gke.LaunchSpecSpecification;
import com.spotinst.sdkjava.model.converters.ocean.gke.OceanGkeConverter;
import com.spotinst.sdkjava.model.service.ocean.gke.SpotOceanGkeClusterService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanGkeLaunchSpecRepo implements ISpotOceanGKELaunchSpecRepo {

    @Override
    public RepoGenericResponse<LaunchSpecSpecification> create(LaunchSpecSpecification oceanGKECreateLaunchSpecRes, String authToken, String account) {
        RepoGenericResponse<LaunchSpecSpecification> retVal;

        try {
            ApiLaunchSpecSpecification
                    apiLaunchSpecSpecification = OceanGkeConverter.toDal(oceanGKECreateLaunchSpecRes);
            ApiLaunchSpecSpecification apiLaunchSpecificationSpecification =
                    SpotOceanGkeClusterService.createLaunchSpec(apiLaunchSpecSpecification, authToken, account);
            LaunchSpecSpecification CreatedLaunchSpec = OceanGkeConverter.toBl(
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
                    SpotOceanGkeClusterService.getLaunchSpec(authToken, account, launchSpecId);

            LaunchSpecSpecification launchSpecs =OceanGkeConverter.toBl(apiLaunchSpecSpecification);
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
                    SpotOceanGkeClusterService.getAllLaunchSpec(authToken, account, oceanId);
            List<LaunchSpecSpecification> launchSpecs = apiLaunchSpecSpecification.stream().map(OceanGkeConverter::toBl).collect(Collectors.toList());
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
                    apiLaunchSpecSpecification = OceanGkeConverter.toDal(launchSpecToUpdate);
            Boolean success =
                    SpotOceanGkeClusterService
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
            Boolean updated = SpotOceanGkeClusterService.deleteLaunchSpec(launchSpecId, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
