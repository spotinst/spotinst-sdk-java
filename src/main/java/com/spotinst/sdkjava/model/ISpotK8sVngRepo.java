package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sVngSpec;
import java.util.List;

public interface ISpotK8sVngRepo<S> extends IRepository<K8sVngSpec, Void, String>{
    default RepoGenericResponse<List<S>> list(String authToken, String account, String oceanId) {
        throw new SpotinstNotSupportedException();
    }
}
