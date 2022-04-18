package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.GetStatus;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.Import;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.ImportResponse;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.ManagedInstance;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceDeletionRequest;

public interface ISpotAwsManagedInstanceRepo extends IRepository<ManagedInstance, Void, String> {

    default RepoGenericResponse<Boolean> delete(AwsManagedInstanceDeletionRequest deletionRequest, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> pause(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> resume(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> recycle(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<GetStatus> getStatus(String managedInstanceId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ImportResponse> importInstance(Import importInstance, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }
}
