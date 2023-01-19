package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.*;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceDeletionRequest;

import java.util.List;

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

    default RepoGenericResponse<GetMigrationStatus> getMigrationStatus(String managedInstanceMigrationId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<GetAllManagedInstancesResponse>> getAllManagedInstances(String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    RepoGenericResponse<GetInstanceCost> getInstanceCosts(String migrationId, String fromDate, String toDate, String authToken, String account);

    RepoGenericResponse<Boolean> deleteManagedInstanceVolume(String managedInstanceId, String volumeId,
                                                             String authToken, String account);

    RepoGenericResponse<Boolean> updateState(String identifier, ManagedInstanceUpdate managedInstanceToUpdate,
                                             String authToken, String account);
}
