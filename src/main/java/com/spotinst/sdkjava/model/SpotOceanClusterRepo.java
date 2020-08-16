package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiOceanCluster;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.OceanCluster;

public class SpotOceanClusterRepo implements ISpotOceanClusterRepo {

    @Override
    public RepoGenericResponse<OceanCluster> create(OceanCluster clusterToCreate, String authToken, String account) {

        RepoGenericResponse<OceanCluster> retVal;

        try {
            ApiOceanCluster apiOceanClusterToCreate = OceanConverter.toDal(clusterToCreate);
            ApiOceanCluster apiCreatedCluster =
                    SpotOceanClusterService.createK8sCluster(apiOceanClusterToCreate, authToken, account);
            OceanCluster createdOceanCluster = OceanConverter.toBl(apiCreatedCluster);
            retVal = new RepoGenericResponse<>(createdOceanCluster);
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
            Boolean updated = SpotOceanClusterService.deleteK8sCluster(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, OceanCluster clusterUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiOceanCluster apiOceanCluster = OceanConverter.toDal(clusterUpdate);

        try {
            Boolean success = SpotOceanClusterService.updateK8sCluster(clusterId, apiOceanCluster, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<OceanCluster> get(String clusterId, String authToken, String account) {
        RepoGenericResponse<OceanCluster> retVal;

        try {
            ApiOceanCluster apiOceanCluster = SpotOceanClusterService.getK8sCluster(clusterId, authToken, account);
            OceanCluster    oceanCluster    = OceanConverter.toBl(apiOceanCluster);
            retVal = new RepoGenericResponse<>(oceanCluster);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
