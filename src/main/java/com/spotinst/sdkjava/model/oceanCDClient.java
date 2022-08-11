package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public class oceanCDClient {
    private static final Logger    LOGGER =       LoggerFactory.getLogger(oceanCDClient.class);
    //region Members
    private              String                                      authToken;
    private              String                                      account;
    private              IOceanCDRepo                                oceanCDRepo;
    //endregion

    public IOceanCDRepo getOceanCDRepo() {
        return this.oceanCDRepo;
    }

    public void setOceanCDRepo() {
        this.oceanCDRepo = SpotinstRepoManager.getInstance().getOceanCDRepo();
    }

    //region Constructor
    public oceanCDClient(String authToken) {
        this(authToken, null);
    }

    public oceanCDClient(String authToken, List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;

        setOceanCDRepo();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }
    }

    //endregion

    //region Methods
    public Strategy createStrategy(Strategy createStrategyReq) {

        Strategy retVal;

        RepoGenericResponse<Strategy> creationResponse = getOceanCDRepo().createStrategy(createStrategyReq, authToken);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create Strategy for Ocean CD. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<Strategy> getAllStrategies() {
        List<Strategy> retVal;

        RepoGenericResponse<List<Strategy>> getAllResponse = getOceanCDRepo().getAllStrategies(authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD strategies. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Strategy getStrategy(String strategyName) {

        Strategy retVal;

        RepoGenericResponse<Strategy> getResponse = getOceanCDRepo().getStrategy(strategyName, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD strategy. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateStrategy(Strategy strategyReq, String strategyName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().updateStrategy(strategyReq, strategyName, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD Strategy. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean patchStrategy(Strategy strategyReq, String strategyName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> patchResponse = getOceanCDRepo().patchStrategy(strategyReq, strategyName, authToken);

        if (patchResponse.isRequestSucceed()) {
            retVal = patchResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = patchResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to patch Ocean CD Strategy. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteStrategy(String strategyName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> deleteResponse = getOceanCDRepo().deleteStrategy(strategyName, authToken);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete Ocean CD Strategy. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

}