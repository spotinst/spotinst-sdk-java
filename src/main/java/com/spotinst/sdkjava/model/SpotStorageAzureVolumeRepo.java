package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.VolumeAzureStorage;
import com.spotinst.sdkjava.model.bl.spotStorage.VolumeConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotStorageAzureVolumeRepo implements ISpotStorageAzureVolumeRepo {

    @Override
    public RepoGenericResponse<VolumeAzureStorage> create(VolumeAzureStorage volumeToCreate, String authToken,
                                                          String account) {

        RepoGenericResponse<VolumeAzureStorage> retVal;

        try {

            ApiAzureStorageVolume         apiVolumeToCreate = VolumeConverter.toDal(volumeToCreate);
            SpotStorageAzureVolumeService volumeService     = new SpotStorageAzureVolumeService();
            ApiAzureStorageVolume apiCreatedVolume = volumeService.createVolume(apiVolumeToCreate, authToken, account);


            VolumeAzureStorage createVolume = VolumeConverter.toBl(apiCreatedVolume);
            retVal = new RepoGenericResponse<>(createVolume);
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
            Boolean updated = SpotStorageAzureVolumeService.deleteVolume(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String volumeId, VolumeAzureStorage volumeUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiAzureStorageVolume apiVolume = VolumeConverter.toDal(volumeUpdate);

        try {
            Boolean success = SpotStorageAzureVolumeService.updateVolume(volumeId, apiVolume, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<VolumeAzureStorage> get(String volumeId, String authToken, String account) {
        RepoGenericResponse<VolumeAzureStorage> retVal;

        try {
            ApiAzureStorageVolume apiVolume = SpotStorageAzureVolumeService.getVolume(volumeId, authToken, account);
            VolumeAzureStorage volumeAzureStorage = VolumeConverter.toBl(apiVolume);
            retVal = new RepoGenericResponse<>(volumeAzureStorage);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<VolumeAzureStorage>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<VolumeAzureStorage>> retVal;

        try {
            List<ApiAzureStorageVolume> apiVolume = SpotStorageAzureVolumeService.getAllVolumes(authToken, account);
            List<VolumeAzureStorage> volumes =
                    apiVolume.stream().map(VolumeConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(volumes);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
