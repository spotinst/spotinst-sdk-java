package com.spotinst.sdkjava.model.repo.aws.managedInstance;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAwsManagedInstanceRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.aws.managedInstance.*;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.*;
import com.spotinst.sdkjava.model.converters.aws.managedInstance.AwsManagedInstanceConverter;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceDeletionRequest;
import com.spotinst.sdkjava.model.service.aws.managedInstance.AwsManagedInstanceService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotAwsManagedInstanceRepo implements ISpotAwsManagedInstanceRepo {

    @Override
    public RepoGenericResponse<ManagedInstance> create(ManagedInstance managedInstanceToCreate,
                                                       String authToken, String account) {

        RepoGenericResponse<ManagedInstance> create;

        try {
            ApiManagedInstance apiManagedInstaneToCreate = AwsManagedInstanceConverter.toDal(managedInstanceToCreate);
            ApiManagedInstance apiCreatedManagedInstance =
                    AwsManagedInstanceService.createManagedInstance(apiManagedInstaneToCreate, authToken, account);
            ManagedInstance createdManagedInstance = AwsManagedInstanceConverter.toBl(apiCreatedManagedInstance);
            create = new RepoGenericResponse<>(createdManagedInstance);
        }
        catch (SpotinstHttpException ex) {
            create = ExceptionHelper.handleHttpException(ex);
        }

        return create;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String identifier, ManagedInstance managedInstanceToUpdate,
                                               String authToken, String account) {
        RepoGenericResponse<Boolean> update;

        try {
            ApiManagedInstance apiManagedInstanceToUpdate = AwsManagedInstanceConverter.toDal(managedInstanceToUpdate);
            Boolean isManagedInstanceUpdated = AwsManagedInstanceService
                    .updateManagedInstance(identifier, apiManagedInstanceToUpdate, authToken, account);
            update = new RepoGenericResponse<>(isManagedInstanceUpdated);
        }
        catch (SpotinstHttpException ex) {
            update = ExceptionHelper.handleHttpException(ex);
        }

        return update;
    }

    @Override
    public RepoGenericResponse<ManagedInstance> get(String identifier, String authToken, String account) {
        RepoGenericResponse<ManagedInstance> retVal;

        try {
            ApiManagedInstance apiGetManagedInstance =
                    AwsManagedInstanceService.getManagedInstance(identifier, authToken, account);
            ManagedInstance getManagedInstance = AwsManagedInstanceConverter.toBl(apiGetManagedInstance);
            retVal = new RepoGenericResponse<>(getManagedInstance);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<GetAllManagedInstancesResponse>> getAllManagedInstances(String authToken, String account) {
        RepoGenericResponse<List<GetAllManagedInstancesResponse>> retVal;

        try {
            List<APIGetAllManagedInstancesResponse> apigetAllManagedInstance =
                    AwsManagedInstanceService.getAllManagedInstances(authToken, account);
            List<GetAllManagedInstancesResponse> allManagedInstance =
                    apigetAllManagedInstance.stream().map(AwsManagedInstanceConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allManagedInstance);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(AwsManagedInstanceDeletionRequest deletionRequest, String authToken, String account) {
        RepoGenericResponse<Boolean> delete;

        try {
            Boolean isManagedInstanceDeleted =
                    AwsManagedInstanceService.deleteManagedInstance(deletionRequest, authToken, account);
            delete = new RepoGenericResponse<>(isManagedInstanceDeleted);
        }
        catch (SpotinstHttpException ex) {
            delete = ExceptionHelper.handleHttpException(ex);
        }

        return delete;
    }

    @Override
    public RepoGenericResponse<Boolean> pause(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> pause;

        try {
            Boolean isManagedInstancePaused =
                    AwsManagedInstanceService.pauseManagedInstance(identifier, authToken, account);
            pause = new RepoGenericResponse<>(isManagedInstancePaused);
        }
        catch (SpotinstHttpException ex) {
            pause = ExceptionHelper.handleHttpException(ex);
        }

        return pause;
    }

    @Override
    public RepoGenericResponse<Boolean> resume(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> resume;

        try {
            Boolean isManagedInstanceResumed =
                    AwsManagedInstanceService.resumeManagedInstance(identifier, authToken, account);
            resume = new RepoGenericResponse<>(isManagedInstanceResumed);
        }
        catch (SpotinstHttpException ex) {
            resume = ExceptionHelper.handleHttpException(ex);
        }

        return resume;
    }

    @Override
    public RepoGenericResponse<Boolean> recycle(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> recycle;

        try {
            Boolean isManagedInstanceRecycled =
                    AwsManagedInstanceService.recycleManagedInstance(identifier, authToken, account);
            recycle = new RepoGenericResponse<>(isManagedInstanceRecycled);
        }
        catch (SpotinstHttpException ex) {
            recycle = ExceptionHelper.handleHttpException(ex);
        }

        return recycle;
    }

    @Override
    public RepoGenericResponse<GetStatus> getStatus(String identifier, String authToken, String account) {
        RepoGenericResponse<GetStatus> status;

        try {
            ApiGetStatus apiGetManagedInstanceStatus = AwsManagedInstanceService
                    .getManagedInstanceStatus(identifier, authToken, account);
            GetStatus getManagedInstanceStatus = AwsManagedInstanceConverter.toBl(apiGetManagedInstanceStatus);
            status = new RepoGenericResponse<>(getManagedInstanceStatus);
        }

       catch (SpotinstHttpException ex) {
            status = ExceptionHelper.handleHttpException(ex);
        }

        return status;
    }

    @Override
    public RepoGenericResponse<ImportResponse> importInstance(Import managedInstanceToImport,
                                                              String authToken, String account) {

        RepoGenericResponse<ImportResponse> importResponse;

        try {
            ApiImport apiManagedInstaneToImport = AwsManagedInstanceConverter.toDal(managedInstanceToImport);
            ApiImportResponse apiImportedManagedInstance =
                    AwsManagedInstanceService.importManagedInstance(apiManagedInstaneToImport, authToken, account);
            ImportResponse importedManagedInstance = AwsManagedInstanceConverter.toBl(apiImportedManagedInstance);
            importResponse = new RepoGenericResponse<>(importedManagedInstance);
        }
        catch (SpotinstHttpException ex) {
            importResponse = ExceptionHelper.handleHttpException(ex);
        }

        return importResponse;
    }

    @Override
    public RepoGenericResponse<GetMigrationStatus> getMigrationStatus(String migrationId, String authToken, String account) {
        RepoGenericResponse<GetMigrationStatus> migrationStatus;

        try {
            ApiGetMigrationStatus apiGetManagedInstanceMigrationStatus = AwsManagedInstanceService
                    .getManagedInstanceMigrationStatus(migrationId, authToken, account);
            GetMigrationStatus getManagedInstanceMigrationStatus = AwsManagedInstanceConverter.toBl(apiGetManagedInstanceMigrationStatus);
            migrationStatus = new RepoGenericResponse<>(getManagedInstanceMigrationStatus);
        }

        catch (SpotinstHttpException ex) {
            migrationStatus = ExceptionHelper.handleHttpException(ex);
        }

        return migrationStatus;
    }

    @Override
    public RepoGenericResponse<GetInstanceCost> getInstanceCosts(String migrationId, String fromDate, String toDate, String authToken, String account) {
        RepoGenericResponse<GetInstanceCost> instanceCosts;

        try {
            ApiGetInstanceCost apiGetInstanceCosts = AwsManagedInstanceService
                    .getManagedInstanceCosts(migrationId, fromDate, toDate, authToken, account);
            GetInstanceCost getManagedInstanceCosts = AwsManagedInstanceConverter.toBl(apiGetInstanceCosts);
            instanceCosts = new RepoGenericResponse<>(getManagedInstanceCosts);
        }

        catch (SpotinstHttpException ex) {
            instanceCosts = ExceptionHelper.handleHttpException(ex);
        }

        return instanceCosts;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteManagedInstanceVolume(String managedInstanceId, String volumeId,
                                                                    String authToken, String account) {
        RepoGenericResponse<Boolean> deleteVolume;

        try {
            Boolean isDeleteMIVolume = AwsManagedInstanceService
                    .deleteManagedInstanceVolume(managedInstanceId, volumeId, authToken, account);
            deleteVolume = new RepoGenericResponse<>(isDeleteMIVolume);
        }
        catch (SpotinstHttpException ex) {
            deleteVolume = ExceptionHelper.handleHttpException(ex);
        }

        return deleteVolume;
    }

    @Override
    public RepoGenericResponse<Boolean> updateState(String identifier, ManagedInstanceUpdate managedInstanceToUpdate,
                                               String authToken, String account) {
        RepoGenericResponse<Boolean> update;

        try {
            ApiManagedInstanceUpdate apiManagedInstanceToUpdate = AwsManagedInstanceConverter.toDal(managedInstanceToUpdate);
            Boolean isManagedInstanceUpdated = AwsManagedInstanceService
                    .updateManagedInstanceStates(identifier, apiManagedInstanceToUpdate, authToken, account);
            update = new RepoGenericResponse<>(isManagedInstanceUpdated);
        }
        catch (SpotinstHttpException ex) {
            update = ExceptionHelper.handleHttpException(ex);
        }

        return update;
    }

}