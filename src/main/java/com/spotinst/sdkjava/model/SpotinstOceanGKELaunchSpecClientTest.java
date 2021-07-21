package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstOceanGKELaunchSpecClientTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpotinstElastigroupClientGcp.class);
    //region Members
    private               String authToken;
    private               String account;

    public SpotinstOceanGKELaunchSpecClientTest(String authToken, String account) {

        this.authToken = authToken;
        this.account = account;
    }

    public OceanGKECreateLaunchSpecRes createOceanGKELaunchSpec(OceanGKECreateLaunchSpecRequest oceanGKECreateLaunchSpecRequest){

        OceanGKECreateLaunchSpecRes retVal;
        OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecRequest.getOceanGKECreateLaunchSpecRes();
        SpotinstRepoManager                 managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstOceanGKECreateLaunchSpecRepo         repoGcp             = managerInstance.getSpotinstOceanGKECreateLaunchSpecRepoGcp();
        RepoGenericResponse<OceanGKECreateLaunchSpecRes> creationResponse    =
                repoGcp.create(oceanGKECreateLaunchSpecRes, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create elastigroup. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;

    }
}
