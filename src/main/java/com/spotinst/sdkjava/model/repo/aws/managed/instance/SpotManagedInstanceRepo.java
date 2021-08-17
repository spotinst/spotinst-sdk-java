package com.spotinst.sdkjava.model.repo.aws.managed.instance;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotManagedInstanceRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.aws.managed.instance.ApiManagedInstance;
import com.spotinst.sdkjava.model.bl.aws.managed.instance.ManagedInstance;
import com.spotinst.sdkjava.model.converters.aws.managed.instance.AwsManagedInstanceConverter;
import com.spotinst.sdkjava.model.service.aws.managed.instance.AwsManagedInstanceService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotManagedInstanceRepo implements ISpotManagedInstanceRepo {

    @Override
    public RepoGenericResponse<ManagedInstance> create(ManagedInstance managedInstanceToCreate,
                                                       String authToken, String account) {

        RepoGenericResponse<ManagedInstance> retVal;

        try {
            ApiManagedInstance apiManagedInstaneToCreate = AwsManagedInstanceConverter.toDal(managedInstanceToCreate);
            ApiManagedInstance apiCreatedManagedInstance =
                    AwsManagedInstanceService.createManagedInstance(apiManagedInstaneToCreate, authToken, account);
            ManagedInstance createdManagedInstance = AwsManagedInstanceConverter.toBl(apiCreatedManagedInstance);
            retVal = new RepoGenericResponse<>(createdManagedInstance);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String identifier, ManagedInstance managedInstanceToUpdate,
                                               String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiManagedInstance apiManagedInstanceToUpdate = AwsManagedInstanceConverter.toDal(managedInstanceToUpdate);
            Boolean isManagedInstanceUpdated = AwsManagedInstanceService
                    .updateManagedInstance(identifier, apiManagedInstanceToUpdate, authToken, account);
            retVal = new RepoGenericResponse<>(isManagedInstanceUpdated);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
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
    public RepoGenericResponse<List<ManagedInstance>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<ManagedInstance>> retVal;

        try {
            List<ApiManagedInstance> apigetAllManagedInstance =
                    AwsManagedInstanceService.getAllManagedInstance(authToken, account);
            List<ManagedInstance> allManagedInstance =
                    apigetAllManagedInstance.stream().map(AwsManagedInstanceConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allManagedInstance);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean isManagedInstanceDeleted =
                    AwsManagedInstanceService.deleteManagedInstance(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isManagedInstanceDeleted);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> pause(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean isManagedInstancePaused =
                    AwsManagedInstanceService.pauseManagedInstance(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isManagedInstancePaused);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> resume(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean isManagedInstanceResumed =
                    AwsManagedInstanceService.resumeManagedInstance(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isManagedInstanceResumed);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> recycle(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean isManagedInstanceRecycled =
                    AwsManagedInstanceService.recycleManagedInstance(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(isManagedInstanceRecycled);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}