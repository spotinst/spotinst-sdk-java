package com.spotinst.sdkjava.model.repo.ocean.ecs;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.ecs.*;
import com.spotinst.sdkjava.model.ISpotOceanEcsClusterRepo;
import com.spotinst.sdkjava.model.api.ocean.ecs.*;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.requests.ocean.ecs.GetEcsClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsUpdateRollRequest;
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

    @Override
    public RepoGenericResponse<EcsClusterRollResponse> initiateRoll(EcsInitiateRoll rollRequest, String clusterId, String authToken, String account) {
        RepoGenericResponse<EcsClusterRollResponse> retVal;

        try {

            ApiEcsInitiateRoll apiRollRequest = OceanEcsConverter.toDal(rollRequest);

            ApiEcsClusterRollResponse rollResponse = SpotOceanEcsClusterService.initiateRoll(apiRollRequest, clusterId, authToken, account);
            EcsClusterRollResponse getRollResponse = OceanEcsConverter.toBl(rollResponse);

            retVal = new RepoGenericResponse<>(getRollResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<EcsClusterRollResponse>> listRolls(String clusterId, String authToken, String account) {
        RepoGenericResponse<List<EcsClusterRollResponse>> retVal;

        try {

            List<ApiEcsClusterRollResponse> apiListRolls = SpotOceanEcsClusterService.listRolls(clusterId, authToken, account);
            List<EcsClusterRollResponse> listRollsResponse = apiListRolls.stream().map(OceanEcsConverter::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(listRollsResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<EcsClusterRollResponse> getRoll(String clusterId, String rollId, String authToken, String account) {
        RepoGenericResponse<EcsClusterRollResponse> retVal;

        try {

            ApiEcsClusterRollResponse apiGetRoll = SpotOceanEcsClusterService.getRoll(clusterId, rollId, authToken, account);
            EcsClusterRollResponse getRollResponse = OceanEcsConverter.toBl(apiGetRoll);

            retVal = new RepoGenericResponse<>(getRollResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<EcsClusterRollResponse> updateRoll(OceanEcsUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account) {
        RepoGenericResponse<EcsClusterRollResponse> retVal;

        try {

            ApiEcsClusterRollResponse apiGetRoll = SpotOceanEcsClusterService.updateRoll(updateRollRequest, clusterId, rollId, authToken, account);
            EcsClusterRollResponse updateRollResponse = OceanEcsConverter.toBl(apiGetRoll);

            retVal = new RepoGenericResponse<>(updateRollResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<GetEcsClusterNodesResponse>> getClusterContainerInstances(GetEcsClusterNodesRequest getClusterNodes, String clusterId, String authToken) {
        RepoGenericResponse<List<GetEcsClusterNodesResponse>> retVal;

        try {

            List<ApiGetEcsClusterNodesResponse> apiGetClusterNodes = SpotOceanEcsClusterService.getClusterContainerInstances(getClusterNodes, clusterId, authToken);
            List<GetEcsClusterNodesResponse> getClusterNodesResponse = apiGetClusterNodes.stream().map(OceanEcsConverter::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getClusterNodesResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ImportOceanEcsClusterResponse> importEcsCluster(ImportEcsCluster importEcsCluster, String ecsClusterName, String authToken, String account) {
        RepoGenericResponse<ImportOceanEcsClusterResponse> retVal;

        try {

            ApiImportOceanEcsClusterResponse apiImportEcsCluster = SpotOceanEcsClusterService.importEcsCluster(importEcsCluster, ecsClusterName, authToken, account);
            ImportOceanEcsClusterResponse importEcsClusterResponse = OceanEcsConverter.toBl(apiImportEcsCluster);

            retVal = new RepoGenericResponse<>(importEcsClusterResponse);
        }

        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}