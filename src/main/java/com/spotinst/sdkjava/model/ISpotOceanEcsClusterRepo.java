package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.ecs.*;
import com.spotinst.sdkjava.model.requests.ocean.ecs.GetEcsClusterNodesRequest;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsUpdateRollRequest;

import java.util.List;

public interface ISpotOceanEcsClusterRepo extends IRepository<OceanEcsCluster, Void, String> {

    RepoGenericResponse<EcsClusterRollResponse> initiateRoll(EcsInitiateRoll rollRequest, String clusterId, String authToken, String account);

    RepoGenericResponse<List<EcsClusterRollResponse>> listRolls(String clusterId, String authToken, String account);

    RepoGenericResponse<EcsClusterRollResponse> getRoll(String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<EcsClusterRollResponse> updateRoll(OceanEcsUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<List<GetEcsClusterNodesResponse>> getClusterContainerInstances(GetEcsClusterNodesRequest getClusterNodes, String clusterId, String authToken);

    RepoGenericResponse<ImportOceanEcsClusterResponse> importEcsCluster(ImportEcsCluster importEcsCluster, String ecsClusterName, String authToken, String account);
}
