package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.aws.managed.instance.ManagedInstance;
import com.spotinst.sdkjava.model.requests.aws.managed.instance.AwsManagedInstanceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotManagedInstanceClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpotManagedInstanceClient.class);
    //Members
    private              String                      authToken;
    private              String                      account;
    private              ISpotManagedInstanceRepo    spotManagedInstanceRepo;

    //Constructor
    public SpotManagedInstanceClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstManagedInstanceRepo();

    }

    public ISpotManagedInstanceRepo getSpotManagedInstanceRepo() {
        return spotManagedInstanceRepo;
    }

    public void setSpotinstManagedInstanceRepo() {
        this.spotManagedInstanceRepo =
                SpotinstRepoManager.getInstance().getSpotManagedInstanceRepo();
    }

    //Methods
    public ManagedInstance createManagedInstance(AwsManagedInstanceRequest managedInstanceCreationRequest) {
        ManagedInstance retVal;

        ManagedInstance managedInstanceToCreate = managedInstanceCreationRequest.getManagedInstance();

        RepoGenericResponse<ManagedInstance> creationResponse =
                getSpotManagedInstanceRepo().create(managedInstanceToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateManagedInstance(AwsManagedInstanceRequest managedInstanceCreationRequest, String managedInstanceId) {
        Boolean retVal;

        ManagedInstance managedInstanceToUpdate = managedInstanceCreationRequest.getManagedInstance();

        RepoGenericResponse<Boolean> updateResponse =
                getSpotManagedInstanceRepo().update(managedInstanceId, managedInstanceToUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to update AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteManagedInstance(AwsManagedInstanceRequest managedInstanceDeleteRequest) {
        Boolean retVal;
        String  managedInstanceId = managedInstanceDeleteRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> deleteResponse =
                getSpotManagedInstanceRepo().delete(managedInstanceId, authToken, account);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to delete AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
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

    public List<ManagedInstance> getAllManagedInstance() {
        List<ManagedInstance> retVal;

        RepoGenericResponse<List<ManagedInstance>> getAllResponse =
                getSpotManagedInstanceRepo().getAll(null, authToken, account);

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
        Boolean retVal;
        String  managedInstanceId = managedInstancePauseRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> pauseResponse =
                getSpotManagedInstanceRepo().pause(managedInstanceId, authToken, account);

        if (pauseResponse.isRequestSucceed()) {
            retVal = pauseResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = pauseResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to pause AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean resumeManagedInstance(AwsManagedInstanceRequest managedInstanceResumeRequest) {
        Boolean retVal;
        String  managedInstanceId = managedInstanceResumeRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> resumeResponse =
                getSpotManagedInstanceRepo().resume(managedInstanceId, authToken, account);

        if (resumeResponse.isRequestSucceed()) {
            retVal = resumeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = resumeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to resume AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean recycleManagedInstance(AwsManagedInstanceRequest managedInstanceRecycleRequest) {
        Boolean retVal;
        String  managedInstanceId = managedInstanceRecycleRequest.getManagedInstanceId();
        RepoGenericResponse<Boolean> recycleResponse =
                getSpotManagedInstanceRepo().recycle(managedInstanceId, authToken, account);

        if (recycleResponse.isRequestSucceed()) {
            retVal = recycleResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = recycleResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to recycle AWS Managed Instance. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
}
