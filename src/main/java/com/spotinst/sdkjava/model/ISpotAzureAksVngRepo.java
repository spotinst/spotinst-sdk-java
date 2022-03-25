package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.ocean.aks.ClusterVirtualNodeGroup;

import java.util.List;

public interface ISpotAzureAksVngRepo extends IRepository<ClusterVirtualNodeGroup, Void, String>{

    RepoGenericResponse<List<ClusterVirtualNodeGroup>> list(String authToken, String account, String oceanId);
}