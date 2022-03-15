package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sClusterFetchElastilogRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.UpdateRollRequest;

import java.util.List;

public interface ISpotOceanK8sClusterRepo extends IRepository<OceanK8sCluster, Void, String>{
    RepoGenericResponse<List<OceanK8sCluster>> getAllK8sClusters(String authToken, String account);

    RepoGenericResponse<GetK8sClusterHeartBeatStatusResponse> getK8sClusterHeartBeatStatus(String clusterId, String authToken, String account);

    RepoGenericResponse<OceanK8sCluster> importASGToOceanCluster(ImportAsgToClusterConfiguration importRequest, String autoScalingGroupName, String region, String authToken, String account);

    RepoGenericResponse<List<K8sClusterFetchElastilogResponse>> fetchElastilog(K8sClusterFetchElastilogRequest k8sClusterGetElastilogRequest, String clusterId, String authToken);

    RepoGenericResponse<ClusterRollResponse> initiateRoll(InitiateRoll rollRequest, String clusterId, String authToken, String account);

    RepoGenericResponse<List<ClusterRollResponse>> listRolls(String clusterId, String authToken, String account);

    RepoGenericResponse<ClusterRollResponse> getRoll(String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<ClusterRollResponse> updateRoll(UpdateRollRequest updateRollRequest, String clusterId, String rollId, String authToken, String account);

    RepoGenericResponse<Boolean> detachInstances(DetachInstances instances, String clusterId, String authToken, String account);
}
