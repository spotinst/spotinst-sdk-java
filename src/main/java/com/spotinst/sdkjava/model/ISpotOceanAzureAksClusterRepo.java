package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.aks.*;
import com.spotinst.sdkjava.model.requests.ocean.aks.GetAksClusterNodesRequest;

import java.util.List;

public interface ISpotOceanAzureAksClusterRepo extends IRepository<OceanClusterAks, Void, String> {
    RepoGenericResponse<GetAzureAksClusterHeartBeatStatusResponse> getAzureAksClusterHeartBeatStatus(String clusterIdId, String authToken, String account);

    RepoGenericResponse<List<GetAksClusterNodesResponse>> getClusterNodes(GetAksClusterNodesRequest getClusterNodes, String clusterId, String authToken);

    RepoGenericResponse<List<AksDetachInstancesResponse>> detachVms(AksDetachInstances instances, String clusterId, String authToken, String account);
}
