package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.aws.managed.instance.ManagedInstance;

public interface ISpotManagedInstanceRepo extends IRepository<ManagedInstance, Void, String> {

    default RepoGenericResponse<Boolean> pause(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> resume(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> recycle(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }
}
