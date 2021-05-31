package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstAdminAccountClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstAdminAccountClient.class);
    //region Members
    private              String authToken;
    //endregion


    //region Constructor
    public SpotinstAdminAccountClient(String authToken) {
        this(authToken,  null);
    }

    public SpotinstAdminAccountClient(String authToken,
                                      List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }

    }


    //endregion

    //region Methods

    public Boolean deleteAccount(AccountDeleteRequest accountDeletionRequest) {

        Boolean                     retVal;
        String                      accountToDeleteId     = accountDeletionRequest.getAccountId();
        SpotinstRepoManager         managerInstance       = SpotinstRepoManager.getInstance();
        ISpotAdminAccountRepo       repoAdmin              = managerInstance.getSpotAdminAccountRepo();
        RepoGenericResponse<Boolean> accountDeletionResponse =
                repoAdmin.deleteWithTokenOnly(accountToDeleteId, authToken);
        if (accountDeletionResponse.isRequestSucceed()) {
            retVal = accountDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = accountDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete elastigroup. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    //endregion
}
