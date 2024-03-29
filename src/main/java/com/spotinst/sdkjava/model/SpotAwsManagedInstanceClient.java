package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.*;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceDeletionRequest;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceImportRequest;
import com.spotinst.sdkjava.model.requests.aws.managedInstance.AwsManagedInstanceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotAwsManagedInstanceClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpotAwsManagedInstanceClient.class);
    //Members
    private              String                      authToken;
    private              String                      account;
    private ISpotAwsManagedInstanceRepo spotManagedInstanceRepo;

    //Constructor
    public SpotAwsManagedInstanceClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstManagedInstanceRepo();

    }

    public ISpotAwsManagedInstanceRepo getSpotManagedInstanceRepo() {
        return spotManagedInstanceRepo;
    }

    public void setSpotinstManagedInstanceRepo() {
        this.spotManagedInstanceRepo =
                SpotinstRepoManager.getInstance().getSpotManagedInstanceRepo();
    }

    //Methods
    public ManagedInstance createManagedInstance(AwsManagedInstanceRequest managedInstanceCreationRequest) {
        ManagedInstance isCreated;

        ManagedInstance managedInstanceToCreate = managedInstanceCreationRequest.getManagedInstance();

        RepoGenericResponse<ManagedInstance> creationResponse =
                getSpotManagedInstanceRepo().create(managedInstanceToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            isCreated = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isCreated;
    }

    public Boolean updateManagedInstance(AwsManagedInstanceRequest managedInstanceUpdateRequest, String managedInstanceId) {
        Boolean isUpdated;

        ManagedInstance managedInstanceToUpdate = managedInstanceUpdateRequest.getManagedInstance();

        RepoGenericResponse<Boolean> updateResponse =
                getSpotManagedInstanceRepo().update(managedInstanceId, managedInstanceToUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            isUpdated = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to update AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isUpdated;
    }

    public Boolean deleteManagedInstance(AwsManagedInstanceDeletionRequest managedInstanceDeleteRequest) {
        Boolean isDeleted;
        RepoGenericResponse<Boolean> deleteResponse =
                getSpotManagedInstanceRepo().delete(managedInstanceDeleteRequest, authToken, account);

        if (deleteResponse.isRequestSucceed()) {
            isDeleted = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to delete AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isDeleted;
    }

    public ManagedInstance getManagedInstance(AwsManagedInstanceRequest managedInstanceGetRequest) {
        ManagedInstance retVal;
        String                     managedInstanceId = managedInstanceGetRequest.getManagedInstanceId();
        RepoGenericResponse<ManagedInstance> getResponse =
                getSpotManagedInstanceRepo().get(managedInstanceId, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<GetAllManagedInstancesResponse> getAllManagedInstances() {
        List<GetAllManagedInstancesResponse> retVal;

        RepoGenericResponse<List<GetAllManagedInstancesResponse>> getAllResponse =
                getSpotManagedInstanceRepo().getAllManagedInstances(authToken, account);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to list AWS Managed Instances. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean pauseManagedInstance(AwsManagedInstanceRequest managedInstancePauseRequest) {
        Boolean isPaused;
        String  managedInstanceId = managedInstancePauseRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> pauseResponse =
                getSpotManagedInstanceRepo().pause(managedInstanceId, authToken, account);

        if (pauseResponse.isRequestSucceed()) {
            isPaused = pauseResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = pauseResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to pause AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isPaused;
    }

    public Boolean resumeManagedInstance(AwsManagedInstanceRequest managedInstanceResumeRequest) {
        Boolean isResumed;
        String  managedInstanceId = managedInstanceResumeRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> resumeResponse =
                getSpotManagedInstanceRepo().resume(managedInstanceId, authToken, account);

        if (resumeResponse.isRequestSucceed()) {
            isResumed = resumeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = resumeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to resume AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isResumed;
    }

    public Boolean recycleManagedInstance(AwsManagedInstanceRequest managedInstanceRecycleRequest) {
        Boolean isRecycled;
        String  managedInstanceId = managedInstanceRecycleRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> recycleResponse =
                getSpotManagedInstanceRepo().recycle(managedInstanceId, authToken, account);

        if (recycleResponse.isRequestSucceed()) {
            isRecycled = recycleResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = recycleResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to recycle AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isRecycled;
    }

    public GetStatus getManagedInstanceStatus(AwsManagedInstanceRequest managedInstanceStatusRequest) {
        GetStatus status;
        String  managedInstanceId = managedInstanceStatusRequest.getManagedInstanceId();
        RepoGenericResponse<GetStatus> statusResponse =
                getSpotManagedInstanceRepo().getStatus(managedInstanceId, authToken, account);

        if (statusResponse.isRequestSucceed()) {
            status = statusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = statusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the status of AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return status;
    }

    public ImportResponse importManagedInstance(AwsManagedInstanceImportRequest managedInstanceImportRequest) {
        ImportResponse isImported;

        Import managedInstanceToImport = managedInstanceImportRequest.getImportInstance();

        RepoGenericResponse<ImportResponse>importResponse =
                getSpotManagedInstanceRepo().importInstance(managedInstanceToImport, authToken, account);

        if (importResponse.isRequestSucceed()) {
            isImported = importResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = importResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to import AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isImported;
    }

    public GetMigrationStatus getManagedInstanceMigrationStatus(String managedInstanceId) {
        GetMigrationStatus migrationStatus;

        RepoGenericResponse<GetMigrationStatus> statusResponse =
                getSpotManagedInstanceRepo().getMigrationStatus(managedInstanceId, authToken, account);

        if (statusResponse.isRequestSucceed()) {
            migrationStatus = statusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = statusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the migration status of AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return migrationStatus;
    }

}
