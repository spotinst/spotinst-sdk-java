package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sVngSpec;
import com.spotinst.sdkjava.model.requests.ocean.kubernetes.K8sImportClusterVngToOceanVngRequest;

import java.util.List;

public interface ISpotK8sVngRepo extends IRepository<K8sVngSpec, Void, String>{
    default RepoGenericResponse<List<K8sVngSpec>> list(String authToken, String account, String oceanId) {
        throw new SpotinstNotSupportedException();
    }

    RepoGenericResponse<K8sVngSpec> importASGToVng(K8sVngSpec importASGRequest, String autoScalingGroupName, String oceanId, String authToken, String account);

    RepoGenericResponse<K8sVngSpec> importCluterVngToOceanVng(K8sImportClusterVngToOceanVngRequest importClusterVngRequest, String authToken);
}