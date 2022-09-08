package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.*;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sImportClusterVngToOceanVngRequest;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sVngDeleteRequest;

import java.util.List;

public interface ISpotK8sVngRepo extends IRepository<K8sVngSpec, Void, String>{
    RepoGenericResponse<Boolean> deleteK8sVngSpec(K8sVngDeleteRequest vngDeletionRequest, String authToken, String account);

    default RepoGenericResponse<List<K8sVngSpec>> list(String authToken, String account, String oceanId) {
        throw new SpotinstNotSupportedException();
    }

    RepoGenericResponse<K8sVngSpec> importASGToVng(K8sVngSpec importASGRequest, String autoScalingGroupName, String oceanId, String authToken, String account);

    RepoGenericResponse<K8sVngSpec> importCluterVngToOceanVng(K8sImportClusterVngToOceanVngRequest importClusterVngRequest, String authToken);

    RepoGenericResponse<List<LaunchNodesInVNGResponse>> launchNodesInVNG(LaunchNodesInVNG lauchNodes, String VngId, String authToken, String account);
}