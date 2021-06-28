package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolumeCreationRequest;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolumeDeletionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotStorageAzureVolumeClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotStorageAzureVolumeClient.class);
    //region Members
    private              String authToken;
    private              String account;
    //endregion


    //region Constructor
    public SpotStorageAzureVolumeClient(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotStorageAzureVolumeClient(String authToken, String account,
                                        List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account = account;

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }

    }
    //endregion

    //region Methods
    public AzureStorageVolume createVolume(AzureStorageVolumeCreationRequest azureStorageVolumeCreationRequest) {

        AzureStorageVolume retVal;

        AzureStorageVolume  volumeToCreate  = azureStorageVolumeCreationRequest.getVolume();
        SpotinstRepoManager managerInstance = SpotinstRepoManager.getInstance();
        ISpotStorageAzureVolumeRepo volumeRepo = managerInstance.getSpotStorageAzureVolumeRepo();
        RepoGenericResponse<AzureStorageVolume> creationResponse =
                volumeRepo.create(volumeToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create volume. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateVolume(VolumeUpdateRequest volumeUpdateRequest, String volumeId) {

        Boolean retVal;

        AzureStorageVolume  volumeToUpdate  = volumeUpdateRequest.getVolume();
        SpotinstRepoManager managerInstance = SpotinstRepoManager.getInstance();
        ISpotStorageAzureVolumeRepo  volumeRepo     = managerInstance.getSpotStorageAzureVolumeRepo();
        RepoGenericResponse<Boolean> updateResponse = volumeRepo.update(volumeId, volumeToUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to update volume. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteVolume(AzureStorageVolumeDeletionRequest volumeDeletionRequest) {
        Boolean             retVal;
        String              volumeToDeleteId = volumeDeletionRequest.getVolumeId();
        SpotinstRepoManager managerInstance  = SpotinstRepoManager.getInstance();
        ISpotStorageAzureVolumeRepo  volumeRepo             = managerInstance.getSpotStorageAzureVolumeRepo();
        RepoGenericResponse<Boolean> volumeDeletionResponse = volumeRepo.delete(volumeToDeleteId, authToken, account);

        if (volumeDeletionResponse.isRequestSucceed()) {
            retVal = volumeDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = volumeDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to delete volume. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<AzureStorageVolume> getAllVolumes() {
        List<AzureStorageVolume> retVal;
        SpotinstRepoManager managerInstance = SpotinstRepoManager.getInstance();
        ISpotStorageAzureVolumeRepo volumeRepo = managerInstance.getSpotStorageAzureVolumeRepo();
        RepoGenericResponse<List<AzureStorageVolume>> volumesRepoGenericResponse =
                volumeRepo.getAll(null, authToken, account);

        if (volumesRepoGenericResponse.isRequestSucceed()) {
            retVal = volumesRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = volumesRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get all volumes. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        //        TODO yael: what is the purpose of this? - to print all the volumes (?)
        //          - no need to do this inside of a method. If someone wants to print them they can
        //            call this method and print them themselves.
        System.out.println("GET- List All Volumes:");

        if (retVal.size() == 0) { // No volume for this account
            System.out.println("No volume found for this account");
        }

        for (int i = 0; i < retVal.size(); i++) {
            System.out.println("volume number:" + i + "   " + retVal.get(i).getName() + "   " + retVal.get(i).getId());
        }

        return retVal;
    }

    public AzureStorageVolume getVolume(VolumeGetRequest volumeGetRequest) {

        AzureStorageVolume retVal;

        String              volumeId        = volumeGetRequest.getVolumeId();
        SpotinstRepoManager managerInstance = SpotinstRepoManager.getInstance();
        ISpotStorageAzureVolumeRepo volumeRepo = managerInstance.getSpotStorageAzureVolumeRepo();
        RepoGenericResponse<AzureStorageVolume> volumeAzureStorageRepoGenericResponse =
                volumeRepo.get(volumeId, authToken, account);

        if (volumeAzureStorageRepoGenericResponse.isRequestSucceed()) {
            LOGGER.info(String.format("get successfully the group %s", volumeId));
            retVal = volumeAzureStorageRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = volumeAzureStorageRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get volume : %s. Code: %s. Message: %s.",
                                       volumeId, httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    //endregion
}
