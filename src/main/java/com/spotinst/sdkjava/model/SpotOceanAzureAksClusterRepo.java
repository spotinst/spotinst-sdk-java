package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterAks;

import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterAks;
import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterConverterAks;


import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanAzureAksClusterRepo implements ISpotOceanAzureAksClusterRepo{

    @Override
    public RepoGenericResponse<ClusterAks> create(ClusterAks clusterToCreate, String authToken, String account) {

        RepoGenericResponse<ClusterAks> retVal;

        try {
           ApiClusterAks apiClusterAks = ClusterConverterAks.toDal(clusterToCreate);
           ApiClusterAks apiCreatedCluster = SpotOceanAzureAksClusterService.createAksCluster(apiClusterAks, authToken, account);

           ClusterAks createdOceanCluster = ClusterConverterAks.toBl(apiCreatedCluster);
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
            Boolean updated = SpotOceanAzureAksClusterService.deleteAksCluster(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, ClusterAks clusterUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiClusterAks apiOceanCluster = ClusterConverterAks.toDal(clusterUpdate);

        try {
            Boolean success = SpotOceanAzureAksClusterService
                    .updateAksCluster(clusterId, apiOceanCluster, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ClusterAks> get(String clusterId, String authToken, String account) {
        RepoGenericResponse<ClusterAks> retVal;

        try {
            ApiClusterAks apiOceanCluster   = SpotOceanAzureAksClusterService.getAksCluster(clusterId, authToken, account);
            ClusterAks aksCluster           = ClusterConverterAks.toBl(apiOceanCluster);
            retVal = new RepoGenericResponse<>(aksCluster);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<ClusterAks>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<ClusterAks>> retVal;

        try {
            List<ApiClusterAks> apiClusters =
                    SpotOceanAzureAksClusterService.getAllClusters(authToken, account);
            List<ClusterAks> clusters =
                    apiClusters.stream().map(ClusterConverterAks::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(clusters);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
