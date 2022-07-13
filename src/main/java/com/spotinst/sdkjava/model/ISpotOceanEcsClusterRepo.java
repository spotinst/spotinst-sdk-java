package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.ecs.EcsClusterRollResponse;
import com.spotinst.sdkjava.model.bl.ocean.ecs.EcsInitiateRoll;
import  com.spotinst.sdkjava.model.bl.ocean.ecs.OceanEcsCluster;
import com.spotinst.sdkjava.model.requests.ocean.ecs.OceanEcsUpdateRollRequest;

import java.util.List;

public interface ISpotOceanEcsClusterRepo extends IRepository<OceanEcsCluster, Void, String> {

    RepoGenericResponse<EcsClusterRollResponse> initiateRoll(EcsInitiateRoll rollRequest, String clusterId, String authToken, String account);

    RepoGenericResponse<List<EcsClusterRollResponse>> listRolls(String clusterId, String authToken, String account);

    RepoGenericResponse<EcsClusterRollResponse> getRoll(String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<EcsClusterRollResponse> updateRoll(OceanEcsUpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account);

}
