package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.kubernetes.GetK8sClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportAsgToClusterConfiguration;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sClusterFetchElastilogResponse;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.OceanK8sCluster;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sClusterFetchElastilogRequest;

import java.util.List;

public interface ISpotOceanK8sClusterRepo extends IRepository<OceanK8sCluster, Void, String>{
    RepoGenericResponse<List<OceanK8sCluster>> getAllK8sClusters(String authToken, String account);

    RepoGenericResponse<GetK8sClusterHeartBeatStatusResponse> getK8sClusterHeartBeatStatus(String clusterId, String authToken, String account);

    RepoGenericResponse<OceanK8sCluster> importASGToOceanCluster(ImportAsgToClusterConfiguration importRequest, String autoScalingGroupName, String region, String authToken, String account);

    RepoGenericResponse<List<K8sClusterFetchElastilogResponse>> fetchElastilog(K8sClusterFetchElastilogRequest k8sClusterGetElastilogRequest, String clusterId, String authToken);
}
