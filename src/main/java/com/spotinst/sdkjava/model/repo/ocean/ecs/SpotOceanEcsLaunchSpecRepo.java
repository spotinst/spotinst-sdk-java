package com.spotinst.sdkjava.model.repo.ocean.ecs;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotOceanEcsLaunchSpecRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.ocean.ecs.ApiClusterLaunchSpecification;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ClusterLaunchSpecification;
import com.spotinst.sdkjava.model.converters.ocean.ecs.OceanEcsConverter;
import com.spotinst.sdkjava.model.service.ocean.ecs.SpotOceanEcsClusterService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanEcsLaunchSpecRepo implements ISpotOceanEcsLaunchSpecRepo {

    @Override
    public RepoGenericResponse<ClusterLaunchSpecification> create(ClusterLaunchSpecification launchSpecToCreate,
                                                                  String authToken, String account) {

        RepoGenericResponse<ClusterLaunchSpecification> retVal;

        try {
            ApiClusterLaunchSpecification apiLaunchSpecToCreate = OceanEcsConverter.toDal(launchSpecToCreate);
            ApiClusterLaunchSpecification apiCreatedLaunchSpec =
                    SpotOceanEcsClusterService.createLaunchSpec(apiLaunchSpecToCreate, authToken, account);
            ClusterLaunchSpecification createdLaunchSpec = OceanEcsConverter.toBl(apiCreatedLaunchSpec);
            retVal = new RepoGenericResponse<>(createdLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean isLaunchSpecDeleted =
                    SpotOceanEcsClusterService.deleteLaunchSpec(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isLaunchSpecDeleted);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String identifier, ClusterLaunchSpecification launchSpecToUpdate,
                                               String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiClusterLaunchSpecification apiLaunchSpecToUpdate = OceanEcsConverter.toDal(launchSpecToUpdate);
            Boolean isLaunchSpecUpdated = SpotOceanEcsClusterService
                    .updateLaunchSpec(identifier, apiLaunchSpecToUpdate, authToken, account);
            retVal = new RepoGenericResponse<>(isLaunchSpecUpdated);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ClusterLaunchSpecification> get(String identifier, String authToken, String account) {
        RepoGenericResponse<ClusterLaunchSpecification> retVal;

        try {
            ApiClusterLaunchSpecification apiGetLaunchSpec =
                    SpotOceanEcsClusterService.getLaunchSpec(identifier, authToken, account);
            ClusterLaunchSpecification getLaunchSpec = OceanEcsConverter.toBl(apiGetLaunchSpec);
            retVal = new RepoGenericResponse<>(getLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<ClusterLaunchSpecification>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<ClusterLaunchSpecification>> retVal;

        try {
            List<ApiClusterLaunchSpecification> apigetAllLaunchSpec =
                    SpotOceanEcsClusterService.getAllLaunchSpec(authToken, account);
            List<ClusterLaunchSpecification> allLaunchSpec =
                    apigetAllLaunchSpec.stream().map(OceanEcsConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}
