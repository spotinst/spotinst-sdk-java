package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.aks.GetAzureAksClusterHeartBeatStatusResponse;
import com.spotinst.sdkjava.model.bl.ocean.aks.OceanClusterAks;

public interface ISpotOceanAzureAksClusterRepo extends IRepository<OceanClusterAks, Void, String> {
    RepoGenericResponse<GetAzureAksClusterHeartBeatStatusResponse> getAzureAksClusterHeartBeatStatus(String clusterIdId, String authToken, String account);
}
