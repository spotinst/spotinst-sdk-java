package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.gke.LaunchSpecSpecification;
import com.spotinst.sdkjava.model.request.ocean.gke.LaunchSpecRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotOceanGKELaunchSpecClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpotinstElastigroupClientGcp.class);
    //region Members
    private               String authToken;
    private               String account;

    public SpotOceanGKELaunchSpecClient(String authToken, String account) {

        this.authToken = authToken;
        this.account = account;
    }

    public LaunchSpecSpecification createLaunchSpec(LaunchSpecRequest launchSpecRequest){

        LaunchSpecSpecification               retVal;
        LaunchSpecSpecification
                                              oceanGKECreateLaunchSpecRes = launchSpecRequest
                .getOceanGKECreateLaunchSpecRes();
        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotOceanGKELaunchSpecRepo repoGcp         = managerInstance.getSpotinstOceanGKELaunchSpecRepoGcp();
        RepoGenericResponse<LaunchSpecSpecification> creationResponse    =
                repoGcp.create(oceanGKECreateLaunchSpecRes, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create a launch spec. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;

    }

    public List<LaunchSpecSpecification> getAllLaunchSpec(String oceanId){
        List<LaunchSpecSpecification>     retVal          = null;
        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotOceanGKELaunchSpecRepo repoGcp         = managerInstance.getSpotinstOceanGKELaunchSpecRepoGcp();
        RepoGenericResponse<List<LaunchSpecSpecification>> creationResponse    =
                repoGcp.getAllStatus(authToken,account,oceanId);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to fetch a  launch spec. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public LaunchSpecSpecification getLaunchSpec(String oceanId){
        LaunchSpecSpecification     retVal          = null;
        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotOceanGKELaunchSpecRepo repoGcp         = managerInstance.getSpotinstOceanGKELaunchSpecRepoGcp();
        RepoGenericResponse<LaunchSpecSpecification> creationResponse    =
                repoGcp.get(oceanId,authToken,account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to fetch a  launch spec. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateLaunchSpec(LaunchSpecRequest updateLaunchSpecRequest, String launchSpecId){

        Boolean                               retVal;
        LaunchSpecSpecification
                                              oceanGKECreateLaunchSpecRes = updateLaunchSpecRequest.getOceanGKECreateLaunchSpecRes();
        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotOceanGKELaunchSpecRepo repoGcp         = managerInstance.getSpotinstOceanGKELaunchSpecRepoGcp();
        RepoGenericResponse<Boolean> creationResponse    =
                repoGcp.update(launchSpecId,oceanGKECreateLaunchSpecRes, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update a launch Spec. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteALaunchSpec(String launchSpecId){

        Boolean                     retVal;
        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotOceanGKELaunchSpecRepo repoGcp         = managerInstance.getSpotinstOceanGKELaunchSpecRepoGcp();
        RepoGenericResponse<Boolean> creationResponse    =
                repoGcp.delete(launchSpecId, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete a launch Spec. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }


}
