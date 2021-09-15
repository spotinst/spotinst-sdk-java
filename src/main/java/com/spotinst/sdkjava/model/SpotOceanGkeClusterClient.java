package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.ocean.gke.LaunchSpecSpecification;
import com.spotinst.sdkjava.model.requests.ocean.gke.LaunchSpecRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotOceanGkeClusterClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpotOceanGkeClusterClient.class);
    //region Members
    private               String authToken;
    private               String account;
    private ISpotOceanGKELaunchSpecRepo spotOceanGkeClusterLaunchSpecRepo;

    public SpotOceanGkeClusterClient(String authToken, String account) {

        this.authToken = authToken;
        this.account = account;
        this.spotOceanGkeClusterLaunchSpecRepo = SpotinstRepoManager.getInstance().getSpotinstOceanGKELaunchSpecRepoGcp();
    }

    public LaunchSpecSpecification createLaunchSpec(LaunchSpecRequest launchSpecRequest){

        LaunchSpecSpecification               retVal;
        LaunchSpecSpecification
                                              oceanGKECreateLaunchSpecRes = launchSpecRequest
                .getOceanGKECreateLaunchSpecRes();
        RepoGenericResponse<LaunchSpecSpecification> creationResponse    =
                spotOceanGkeClusterLaunchSpecRepo.create(oceanGKECreateLaunchSpecRes, authToken, account);

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
        RepoGenericResponse<List<LaunchSpecSpecification>> creationResponse    =
                spotOceanGkeClusterLaunchSpecRepo.getAllStatus(authToken,account,oceanId);
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
        RepoGenericResponse<LaunchSpecSpecification> creationResponse    =
                spotOceanGkeClusterLaunchSpecRepo.get(oceanId,authToken,account);
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
        LaunchSpecSpecification oceanGKECreateLaunchSpecRes = updateLaunchSpecRequest.getOceanGKECreateLaunchSpecRes();
        RepoGenericResponse<Boolean> creationResponse    =
                spotOceanGkeClusterLaunchSpecRepo.update(launchSpecId,oceanGKECreateLaunchSpecRes, authToken, account);

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
        
        RepoGenericResponse<Boolean> creationResponse    =
                spotOceanGkeClusterLaunchSpecRepo.delete(launchSpecId, authToken, account);
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