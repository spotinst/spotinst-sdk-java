package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.aks.ApiClusterAks;

import com.spotinst.sdkjava.model.api.ocean.aks.ApiGetAzureAksClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.bl.ocean.aks.GetAzureAksClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.bl.ocean.aks.OceanClusterAks;
import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterConverterAks;


import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanAzureAksClusterRepo implements ISpotOceanAzureAksClusterRepo{

    @Override
    public RepoGenericResponse<OceanClusterAks> create(OceanClusterAks clusterToCreate, String authToken, String account) {

        RepoGenericResponse<OceanClusterAks> retVal;

        try {
           ApiClusterAks apiClusterAks = ClusterConverterAks.toDal(clusterToCreate);
           ApiClusterAks apiCreatedCluster = SpotOceanAzureAksClusterService.createAksCluster(apiClusterAks, authToken, account);

           OceanClusterAks createdOceanCluster = ClusterConverterAks.toBl(apiCreatedCluster);
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
    public RepoGenericResponse<Boolean> update(String clusterId, OceanClusterAks clusterUpdate, String authToken,
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
    public RepoGenericResponse<OceanClusterAks> get(String clusterId, String authToken, String account) {
        RepoGenericResponse<OceanClusterAks> retVal;

        try {
            ApiClusterAks apiOceanCluster   = SpotOceanAzureAksClusterService.getAksCluster(clusterId, authToken, account);
            OceanClusterAks aksCluster           = ClusterConverterAks.toBl(apiOceanCluster);
            retVal = new RepoGenericResponse<>(aksCluster);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OceanClusterAks>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<OceanClusterAks>> retVal;

        try {
            List<ApiClusterAks> apiClusters =
                    SpotOceanAzureAksClusterService.getAllClusters(authToken, account);
            List<OceanClusterAks> clusters =
                    apiClusters.stream().map(ClusterConverterAks::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(clusters);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<GetAzureAksClusterHeartBeatStatusResponse> getAzureAksClusterHeartBeatStatus(String clusterIdId, String authToken, String account) {
        RepoGenericResponse<GetAzureAksClusterHeartBeatStatusResponse> retVal;

        try {

            ApiGetAzureAksClusterHeartBeatStatusResponse getClusterHeartBeatResponse = SpotOceanAzureAksClusterService
                    .getAzureAksClusterHeartBeatStatus( clusterIdId, authToken, account);
            GetAzureAksClusterHeartBeatStatusResponse getClusterHeartBeat = ClusterConverterAks.toBl(getClusterHeartBeatResponse);

            retVal = new RepoGenericResponse<>(getClusterHeartBeat);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }
}
