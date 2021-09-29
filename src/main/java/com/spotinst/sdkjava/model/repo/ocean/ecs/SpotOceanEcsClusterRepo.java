package com.spotinst.sdkjava.model.repo.ocean.ecs;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.ecs.OceanEcsCluster;
import com.spotinst.sdkjava.model.ISpotOceanEcsClusterRepo;
import com.spotinst.sdkjava.model.api.ocean.ecs.*;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.service.ocean.ecs.SpotOceanEcsClusterService;
import com.spotinst.sdkjava.model.converters.ocean.ecs.OceanEcsConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanEcsClusterRepo implements ISpotOceanEcsClusterRepo {

    @Override
    public RepoGenericResponse<OceanEcsCluster> create(OceanEcsCluster clusterToCreate, String authToken, String account) {

        RepoGenericResponse<OceanEcsCluster> retVal;

        try {
            ApiOceanEcsCluster apiOceanEcsClusterToCreate = OceanEcsConverter.toDal(clusterToCreate);
            ApiOceanEcsCluster apiCreatedCluster = SpotOceanEcsClusterService.createEcsCluster(apiOceanEcsClusterToCreate, authToken, account);

            OceanEcsCluster createdOceanEcsCluster = OceanEcsConverter.toBl(apiCreatedCluster);
            retVal = new RepoGenericResponse<>(createdOceanEcsCluster);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, OceanEcsCluster clusterUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiOceanEcsCluster apiOceanEcsCluster = OceanEcsConverter.toDal(clusterUpdate);

        try {
            Boolean isSucceeded  = SpotOceanEcsClusterService
                    .updateEcsCluster(clusterId, apiOceanEcsCluster, authToken, account);
            retVal = new RepoGenericResponse<>(isSucceeded );
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<OceanEcsCluster> get(String clusterId, String authToken, String account) {
        RepoGenericResponse<OceanEcsCluster> retVal;

        try {
            ApiOceanEcsCluster
                    apiOceanEcsCluster = SpotOceanEcsClusterService.getEcsCluster(clusterId, authToken, account);
            OceanEcsCluster oceanK8sCluster    = OceanEcsConverter.toBl(apiOceanEcsCluster);
            retVal = new RepoGenericResponse<>(oceanK8sCluster);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean isDeleted  = SpotOceanEcsClusterService.deleteEcsCluster(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isDeleted );

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OceanEcsCluster>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<OceanEcsCluster>> retVal;

        try {
            List<ApiOceanEcsCluster> apigetAllLaunchSpec =
                    SpotOceanEcsClusterService.getAllEcsCluster(authToken, account);
            List<OceanEcsCluster> allEcsCluster =
                    apigetAllLaunchSpec.stream().map(OceanEcsConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allEcsCluster);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}