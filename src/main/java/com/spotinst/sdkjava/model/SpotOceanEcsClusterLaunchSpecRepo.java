package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.ecs.ApiClusterLaunchSpecification;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ClusterLaunchSpecification;
import com.spotinst.sdkjava.model.converters.OceanEcsLaunchSpecConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanEcsClusterLaunchSpecRepo implements ISpotOceanEcsClusterLaunchSpecRepo {

    @Override
    public RepoGenericResponse<ClusterLaunchSpecification> create(ClusterLaunchSpecification launchSpecToCreate,
                                                                  String authToken, String account) {

        RepoGenericResponse<ClusterLaunchSpecification> retVal;

        try {
            ApiClusterLaunchSpecification apiLaunchSpecToCreate = OceanEcsLaunchSpecConverter.toDal(launchSpecToCreate);
            ApiClusterLaunchSpecification apiCreatedLaunchSpec =
                    SpotOceanEcsClusterService.createLaunchSpecification(apiLaunchSpecToCreate, authToken, account);
            ClusterLaunchSpecification createdLaunchSpec = OceanEcsLaunchSpecConverter.toBl(apiCreatedLaunchSpec);
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
                    SpotOceanEcsClusterService.deleteLaunchSpecification(identifier, authToken, account);
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
            ApiClusterLaunchSpecification apiLaunchSpecToUpdate = OceanEcsLaunchSpecConverter.toDal(launchSpecToUpdate);
            Boolean isLaunchSpecUpdated = SpotOceanEcsClusterService
                    .updateLaunchSpecification(identifier, apiLaunchSpecToUpdate, authToken, account);
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
                    SpotOceanEcsClusterService.getLaunchSpecification(identifier, authToken, account);
            ClusterLaunchSpecification getLaunchSpec = OceanEcsLaunchSpecConverter.toBl(apiGetLaunchSpec);
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
                    SpotOceanEcsClusterService.getAllLaunchSpecification(authToken, account);
            List<ClusterLaunchSpecification> allLaunchSpec =
                    apigetAllLaunchSpec.stream().map(OceanEcsLaunchSpecConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allLaunchSpec);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }
}
