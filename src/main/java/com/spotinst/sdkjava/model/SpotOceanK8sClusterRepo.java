package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiGetK8sClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiOceanK8sCluster;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.GetK8sClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.OceanK8sCluster;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sClusterFetchElastilogResponse;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportAsgToClusterConfiguration;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sClusterFetchElastilogResponse;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sClusterFetchElastilogRequest;

import java.util.List;
import java.util.stream.Collectors;

public class SpotOceanK8sClusterRepo implements ISpotOceanK8sClusterRepo {

    @Override
    public RepoGenericResponse<OceanK8sCluster> create(OceanK8sCluster clusterToCreate, String authToken, String account) {

        RepoGenericResponse<OceanK8sCluster> retVal;

        try {
            ApiOceanK8sCluster apiOceanK8sClusterToCreate = OceanK8sConverter.toDal(clusterToCreate);
            ApiOceanK8sCluster apiCreatedCluster =
                    SpotOceanK8sClusterService.createK8sCluster(apiOceanK8sClusterToCreate, authToken, account);
            OceanK8sCluster createdOceanK8sCluster = OceanK8sConverter.toBl(apiCreatedCluster);
            retVal = new RepoGenericResponse<>(createdOceanK8sCluster);
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
            Boolean updated = SpotOceanK8sClusterService.deleteK8sCluster(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, OceanK8sCluster clusterUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiOceanK8sCluster apiOceanK8sCluster = OceanK8sConverter.toDal(clusterUpdate);

        try {
            Boolean success = SpotOceanK8sClusterService
                    .updateK8sCluster(clusterId, apiOceanK8sCluster, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<OceanK8sCluster> get(String clusterId, String authToken, String account) {
        RepoGenericResponse<OceanK8sCluster> retVal;

        try {
            ApiOceanK8sCluster
                            apiOceanK8sCluster = SpotOceanK8sClusterService.getK8sCluster(clusterId, authToken, account);
            OceanK8sCluster oceanK8sCluster    = OceanK8sConverter.toBl(apiOceanK8sCluster);
            retVal = new RepoGenericResponse<>(oceanK8sCluster);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OceanK8sCluster>> getAllK8sClusters(String authToken, String account) {
        RepoGenericResponse<List<OceanK8sCluster>> retVal;

        try {

            List<ApiOceanK8sCluster> getAllClustersApi = SpotOceanK8sClusterService
                    .getAllK8sClusters(authToken, account);
            List<OceanK8sCluster> getAllClusters = getAllClustersApi.stream().map(OceanK8sConverter::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getAllClusters);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<GetK8sClusterHeartBeatStatusResponse> getK8sClusterHeartBeatStatus(String clusterIdId, String authToken, String account) {
        RepoGenericResponse<GetK8sClusterHeartBeatStatusResponse> retVal;

        try {

            ApiGetK8sClusterHeartBeatStatusResponse getClusterHeartBeatResponse = SpotOceanK8sClusterService
                    .getK8sClusterHeartBeatStatus( clusterIdId, authToken, account);
            GetK8sClusterHeartBeatStatusResponse getClusterHeartBeat = OceanK8sConverter.toBl(getClusterHeartBeatResponse);

            retVal = new RepoGenericResponse<>(getClusterHeartBeat);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<OceanK8sCluster> importASGToOceanCluster(ImportAsgToClusterConfiguration importRequest, String autoScalingGroupName, String region, String authToken, String account) {
        RepoGenericResponse<OceanK8sCluster> retVal;

        try {

            ApiOceanK8sCluster importASGToOceanClusterResponse = SpotOceanK8sClusterService
                    .importASGToOceanCluster(importRequest, autoScalingGroupName, region, authToken, account);
            OceanK8sCluster importASGToOceanCluster = OceanK8sConverter.toBl(importASGToOceanClusterResponse);

            retVal = new RepoGenericResponse<>(importASGToOceanCluster);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<List<K8sClusterFetchElastilogResponse>> fetchElastilog(K8sClusterFetchElastilogRequest k8sClusterGetElastilogRequest, String clusterId, String authToken) {
        RepoGenericResponse<List<K8sClusterFetchElastilogResponse>> retVal;

        try {

            List<ApiK8sClusterFetchElastilogResponse> getLogs = SpotOceanK8sClusterService
                    .fetchElastilog(k8sClusterGetElastilogRequest, clusterId, authToken);
            List<K8sClusterFetchElastilogResponse> getAllLogs = getLogs.stream().map(OceanK8sConverter::toBl)
                    .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getAllLogs);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }
}
