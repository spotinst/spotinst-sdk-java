package com.spotinst.sdkjava.model.repo.ocean.aks;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotOceanAzureAksClusterRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.SpotOceanAzureAksClusterService;
import com.spotinst.sdkjava.model.api.ocean.aks.*;

import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import com.spotinst.sdkjava.model.requests.ocean.aks.AksUpdateRollRequest;
import com.spotinst.sdkjava.model.requests.ocean.aks.GetAksClusterNodesRequest;


import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanAzureAksClusterRepo implements ISpotOceanAzureAksClusterRepo {

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

    @Override
    public RepoGenericResponse<List<GetAksClusterNodesResponse>> getClusterNodes(GetAksClusterNodesRequest getClusterNodes, String clusterId, String authToken) {
        RepoGenericResponse<List<GetAksClusterNodesResponse>> retVal;

        try {

            List<ApiGetAksClusterNodesResponse> apiGetClusterNodes = SpotOceanAzureAksClusterService
                    .getClusterNodes(getClusterNodes, clusterId, authToken);
            List<GetAksClusterNodesResponse> getClusterNodesResponse = apiGetClusterNodes.stream().map(ClusterConverterAks::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getClusterNodesResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<AksDetachInstancesResponse>> detachVms(AksDetachInstances instances, String clusterId, String authToken, String account) {
        RepoGenericResponse<List<AksDetachInstancesResponse>> retVal;

        try {
            ApiAksDetachInstances apiDetachInstances = ClusterConverterAks.toDal(instances);

            List<ApiAksDetachInstancesResponse> apiDetachInstancesResponse = SpotOceanAzureAksClusterService
                    .detachVms(apiDetachInstances, clusterId, authToken, account);
            List<AksDetachInstancesResponse> detachInstancesResponse = apiDetachInstancesResponse.stream().map(ClusterConverterAks::toBl)
                    .collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(detachInstancesResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<AksClusterRollResponse> initiateRoll(AksInitiateRoll rollRequest, String clusterId, String authToken, String account) {
        RepoGenericResponse<AksClusterRollResponse> retVal;

        try {

            ApiAksInitiateRoll apiRollRequest = ClusterConverterAks.toDal(rollRequest);

            ApiAksClusterRollResponse rollResponse = SpotOceanAzureAksClusterService
                    .initiateRoll(apiRollRequest, clusterId, authToken, account);
            AksClusterRollResponse getRollResponse = ClusterConverterAks.toBl(rollResponse);

            retVal = new RepoGenericResponse<>(getRollResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<AksClusterRollResponse> updateRoll(AksUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account) {
        RepoGenericResponse<AksClusterRollResponse> retVal;

        try {

            ApiAksClusterRollResponse apiGetRoll = SpotOceanAzureAksClusterService
                    .updateRoll(updateRollRequest, clusterId, rollId, authToken, account);
            AksClusterRollResponse updateRollResponse = ClusterConverterAks.toBl(apiGetRoll);

            retVal = new RepoGenericResponse<>(updateRollResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<AksClusterRollResponse>> listRolls(String clusterId, String authToken, String account) {
        RepoGenericResponse<List<AksClusterRollResponse>> retVal;

        try {

            List<ApiAksClusterRollResponse> apiListRolls = SpotOceanAzureAksClusterService.listRolls(clusterId, authToken, account);
            List<AksClusterRollResponse> listRollsResponse = apiListRolls.stream().map(ClusterConverterAks::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(listRollsResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<AksClusterRollResponse> getRoll(String clusterId, String rollId, String authToken, String account) {
        RepoGenericResponse<AksClusterRollResponse> retVal;

        try {

            ApiAksClusterRollResponse apiGetRoll = SpotOceanAzureAksClusterService.getRoll(clusterId, rollId, authToken, account);
            AksClusterRollResponse getRollResponse = ClusterConverterAks.toBl(apiGetRoll);

            retVal = new RepoGenericResponse<>(getRollResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ImportOceanClusterAksResponse> importAksCluster(ImportOceanClusterAks oceanClusterImportRequest, String acdIdentifier, String authToken, String account) {
        RepoGenericResponse<ImportOceanClusterAksResponse> retVal;

        try {

            ApiImportOceanClusterAks apiOceanClusterImportRequest = ClusterConverterAks.toDal(oceanClusterImportRequest);

            ApiImportOceanClusterAksResponse importResponse = SpotOceanAzureAksClusterService.importAksCluster(apiOceanClusterImportRequest, acdIdentifier, authToken, account);
            ImportOceanClusterAksResponse importAksResponse = ClusterConverterAks.toBl(importResponse);

            retVal = new RepoGenericResponse<>(importAksResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
