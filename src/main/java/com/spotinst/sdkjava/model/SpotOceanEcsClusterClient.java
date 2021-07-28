package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ClusterLaunchSpecification;
import com.spotinst.sdkjava.model.bl.ocean.ecs.OceanEcsClusterLaunchSpecRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotOceanEcsClusterClient {
    private static final Logger                             LOGGER =
            LoggerFactory.getLogger(SpotOceanK8sClusterClient.class);
    //Members
    private              String                             authToken;
    private              String                             account;
    private              ISpotOceanEcsClusterLaunchSpecRepo spotOceanEcsClusterLaunchSpecRepo;

    //Constructor
    public SpotOceanEcsClusterClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstOceanClusterRepo();
    }

    public ISpotOceanEcsClusterLaunchSpecRepo getSpotOceanEcsClusterLaunchSpecRepo() {
        return spotOceanEcsClusterLaunchSpecRepo;
    }

    public void setSpotinstOceanClusterRepo() {
        this.spotOceanEcsClusterLaunchSpecRepo =
                SpotinstRepoManager.getInstance().getSpotOceanEcsClusterLaunchSpecRepo();
    }

    //Methods
    public ClusterLaunchSpecification createLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecCreationRequest) {
        ClusterLaunchSpecification retVal;

        ClusterLaunchSpecification launchSpecToCreate = launchSpecCreationRequest.getLaunchspec();

        RepoGenericResponse<ClusterLaunchSpecification> creationResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().create(launchSpecToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecCreationRequest, String launchSpecId) {
        Boolean retVal;

        ClusterLaunchSpecification launchSpecToUpdate = launchSpecCreationRequest.getLaunchspec();

        RepoGenericResponse<Boolean> updateResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().update(launchSpecId, launchSpecToUpdate, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to update ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecRequest) {
        Boolean retVal;
        String  launchSpecId = launchSpecRequest.getOceanLaunchSpecId();
        RepoGenericResponse<Boolean> deleteResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().delete(launchSpecId, authToken, account);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to delete ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public ClusterLaunchSpecification getLaunchSpec(OceanEcsClusterLaunchSpecRequest launchSpecRequest) {
        ClusterLaunchSpecification retVal;
        String                     launchSpecId = launchSpecRequest.getOceanLaunchSpecId();
        RepoGenericResponse<ClusterLaunchSpecification> getResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().get(launchSpecId, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<ClusterLaunchSpecification> getAllLaunchSpec() {
        List<ClusterLaunchSpecification> retVal;

        RepoGenericResponse<List<ClusterLaunchSpecification>> getAllResponse =
                getSpotOceanEcsClusterLaunchSpecRepo().getAll(null, authToken, account);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to list ocean ECS launch specification. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }
}
