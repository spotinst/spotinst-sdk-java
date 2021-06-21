package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolumeConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotStorageAzureVolumeRepo implements ISpotStorageAzureVolumeRepo {

    @Override
    public RepoGenericResponse<AzureStorageVolume> create(AzureStorageVolume volumeToCreate, String authToken,
                                                          String account) {

        RepoGenericResponse<AzureStorageVolume> retVal;

        try {

            ApiAzureStorageVolume         apiVolumeToCreate = AzureStorageVolumeConverter.toDal(volumeToCreate);
            SpotStorageAzureVolumeService volumeService     = new SpotStorageAzureVolumeService();
            ApiAzureStorageVolume apiCreatedVolume = volumeService.createVolume(apiVolumeToCreate, authToken, account);


            AzureStorageVolume createVolume = AzureStorageVolumeConverter.toBl(apiCreatedVolume);
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
    public RepoGenericResponse<Boolean> update(String volumeId, AzureStorageVolume volumeUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiAzureStorageVolume apiVolume = AzureStorageVolumeConverter.toDal(volumeUpdate);

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
    public RepoGenericResponse<AzureStorageVolume> get(String volumeId, String authToken, String account) {
        RepoGenericResponse<AzureStorageVolume> retVal;

        try {
            ApiAzureStorageVolume apiVolume          = SpotStorageAzureVolumeService.getVolume(volumeId, authToken, account);
            AzureStorageVolume    volumeAzureStorage = AzureStorageVolumeConverter.toBl(apiVolume);
            retVal = new RepoGenericResponse<>(volumeAzureStorage);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<AzureStorageVolume>> getAll(Void filter, String authToken, String account) {
        RepoGenericResponse<List<AzureStorageVolume>> retVal;

        try {
            List<ApiAzureStorageVolume> apiVolume = SpotStorageAzureVolumeService.getAllVolumes(authToken, account);
            List<AzureStorageVolume> volumes =
                    apiVolume.stream().map(AzureStorageVolumeConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(volumes);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

}
