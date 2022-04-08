package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterVirtualNodeGroup;
import com.spotinst.sdkjava.model.bl.ocean.aks.LaunchNodesInAksVNG;
import com.spotinst.sdkjava.model.bl.ocean.aks.LaunchNodesInAksVNGResponse;

import java.util.List;

public interface ISpotAzureAksVngRepo extends IRepository<ClusterVirtualNodeGroup, Void, String>{

    RepoGenericResponse<List<ClusterVirtualNodeGroup>> list(String authToken, String account, String oceanId);

    RepoGenericResponse<List<LaunchNodesInAksVNGResponse>> launchNodesInVNG(LaunchNodesInAksVNG lauchNodes, String vngId, String authToken, String account);
}