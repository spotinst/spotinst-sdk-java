package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKELaunchSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotInstOceanGKELaunchSpecClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpotinstElastigroupClientGcp.class);
    //region Members
    private               String authToken;
    private               String account;

    public SpotInstOceanGKELaunchSpecClient(String authToken, String account) {

        this.authToken = authToken;
        this.account = account;
    }

    public OceanGKELaunchSpec createOceanGKELaunchSpec(OceanGKECreateLaunchSpecRequest oceanGKECreateLaunchSpecRequest){

        OceanGKELaunchSpec retVal;
        OceanGKELaunchSpec oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecRequest.getOceanGKECreateLaunchSpecRes();
        SpotinstRepoManager                 managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstOceanGKECreateLaunchSpecRepo         repoGcp             = managerInstance.getSpotinstOceanGKECreateLaunchSpecRepoGcp();
        RepoGenericResponse<OceanGKELaunchSpec> creationResponse    =
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

    public OceanGKELaunchSpec getALaunchSpec(String oceanId){
        OceanGKELaunchSpec retVal = null;
        SpotinstRepoManager                 managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstOceanGKECreateLaunchSpecRepo         repoGcp             = managerInstance.getSpotinstOceanGKECreateLaunchSpecRepoGcp();
        RepoGenericResponse<OceanGKELaunchSpec> creationResponse    =
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

    public Boolean updateOceanGKELaunchSpec(OceanGKECreateLaunchSpecRequest updateLaunchSpecRequest,String launchSpecId){

        Boolean retVal;
        OceanGKELaunchSpec oceanGKECreateLaunchSpecRes = updateLaunchSpecRequest.getOceanGKECreateLaunchSpecRes();
        SpotinstRepoManager                 managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstOceanGKECreateLaunchSpecRepo         repoGcp             = managerInstance.getSpotinstOceanGKECreateLaunchSpecRepoGcp();
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

        Boolean retVal;
        SpotinstRepoManager                 managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstOceanGKECreateLaunchSpecRepo         repoGcp             = managerInstance.getSpotinstOceanGKECreateLaunchSpecRepoGcp();
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
