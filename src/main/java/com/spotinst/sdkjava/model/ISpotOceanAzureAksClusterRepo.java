package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import com.spotinst.sdkjava.model.requests.ocean.aks.AksUpdateRollRequest;
import com.spotinst.sdkjava.model.requests.ocean.aks.GetAksClusterNodesRequest;

import java.util.List;

public interface ISpotOceanAzureAksClusterRepo extends IRepository<OceanClusterAks, Void, String> {
    RepoGenericResponse<GetAzureAksClusterHeartBeatStatusResponse> getAzureAksClusterHeartBeatStatus(String clusterIdId, String authToken, String account);

    RepoGenericResponse<List<GetAksClusterNodesResponse>> getClusterNodes(GetAksClusterNodesRequest getClusterNodes, String clusterId, String authToken);

    RepoGenericResponse<List<AksDetachInstancesResponse>> detachVms(AksDetachInstances instances, String clusterId, String authToken, String account);

    RepoGenericResponse<AksClusterRollResponse> initiateRoll(AksInitiateRoll rollRequest, String clusterId, String authToken, String account);

    RepoGenericResponse<AksClusterRollResponse> updateRoll(AksUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<List<AksClusterRollResponse>> listRolls(String clusterId, String authToken, String account);

    RepoGenericResponse<AksClusterRollResponse> getRoll(String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<ImportOceanClusterAksResponse> importAksCluster(ImportOceanClusterAks oceanClusterImportRequest, String acdIdentifier, String authToken, String account);
}
