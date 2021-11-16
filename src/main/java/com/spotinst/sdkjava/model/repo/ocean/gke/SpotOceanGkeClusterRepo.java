package com.spotinst.sdkjava.model.repo.ocean.gke;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotOceanGkeClusterRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiOceanGkeCluster;
import com.spotinst.sdkjava.model.bl.ocean.gke.OceanGkeCluster;
import com.spotinst.sdkjava.model.converters.ocean.gke.OceanGkeConverter;
import com.spotinst.sdkjava.model.service.ocean.gke.SpotOceanGkeClusterService;

import java.util.stream.Collectors;
import java.util.List;

public class SpotOceanGkeClusterRepo implements ISpotOceanGkeClusterRepo {

    @Override
    public RepoGenericResponse<OceanGkeCluster> create(OceanGkeCluster clusterToCreate, String authToken, String account) {

        RepoGenericResponse<OceanGkeCluster> retVal;

        try {
            ApiOceanGkeCluster    apiOceanGkeClusterToCreate = OceanGkeConverter.toDal(clusterToCreate);
            ApiOceanGkeCluster apiCreatedCluster          = SpotOceanGkeClusterService.createGkeCluster(apiOceanGkeClusterToCreate, authToken, account);

            OceanGkeCluster createdOceanEcsCluster = OceanGkeConverter.toBl(apiCreatedCluster);
            retVal = new RepoGenericResponse<>(createdOceanEcsCluster);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, OceanGkeCluster clusterUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiOceanGkeCluster apiOceanGkeCluster = OceanGkeConverter.toDal(clusterUpdate);

        try {
            Boolean isSucceeded  = SpotOceanGkeClusterService
                    .updateGkeCluster(clusterId, apiOceanGkeCluster, authToken, account);
            retVal = new RepoGenericResponse<>(isSucceeded );
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<OceanGkeCluster> get(String clusterId, String authToken, String account) {
        RepoGenericResponse<OceanGkeCluster> retVal;

        try {
            ApiOceanGkeCluster apiOceanGkeCluster = SpotOceanGkeClusterService.getGkeCluster(clusterId, authToken, account);
            OceanGkeCluster oceanK8sCluster    = OceanGkeConverter.toBl(apiOceanGkeCluster);
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
            Boolean isDeleted  = SpotOceanGkeClusterService.deleteGkeCluster(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isDeleted );

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OceanGkeCluster>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<OceanGkeCluster>> retVal;

        try {
            List<ApiOceanGkeCluster> apigetAllLaunchSpec =
                    SpotOceanGkeClusterService.getAllGkeCluster(authToken, account);
            List<OceanGkeCluster> allGkeCluster =
                    apigetAllLaunchSpec.stream().map(OceanGkeConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allGkeCluster);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}
