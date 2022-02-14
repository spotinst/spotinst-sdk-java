package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.kubernetes.GetK8sClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.OceanK8sCluster;

import java.util.List;

public interface ISpotOceanK8sClusterRepo extends IRepository<OceanK8sCluster, Void, String>{
    RepoGenericResponse<List<OceanK8sCluster>> getAllK8sClusters(String authToken, String account);

    RepoGenericResponse<GetK8sClusterHeartBeatStatusResponse> getK8sClusterHeartBeatStatus(String clusterId, String authToken, String account);

}
