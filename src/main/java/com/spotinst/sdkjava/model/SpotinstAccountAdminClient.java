package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SpotinstAccountAdminClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstAccountAdminClient.class);
    //region Members
    private              String authToken;
    //endregion


    //region Constructor
    public SpotinstAccountAdminClient(String authToken) {
        this(authToken,  null);
    }

    public SpotinstAccountAdminClient(String authToken, List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }

    }
    //endregion


    //region Methods
    public Boolean deleteAccount(AccountDeleteRequest accountDeletionRequest) {

        Boolean               retVal;
        String                accountToDeleteId = accountDeletionRequest.getAccountId();
        SpotinstRepoManager   managerInstance   = SpotinstRepoManager.getInstance();
        ISpotAccountAdminRepo repoAdmin         = managerInstance.getSpotAdminAccountRepo();
        // the in our case the client only gets token that's why the account identifier to delete,
        // and the account who deletes are the same one. (delete in repo gets 3 attributes)
        RepoGenericResponse<Boolean> accountDeletionResponse =
                repoAdmin.delete(accountToDeleteId, authToken, accountToDeleteId);
        if (accountDeletionResponse.isRequestSucceed()) {
            retVal = accountDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = accountDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);

            LOGGER.error(
                    String.format("Error encountered while attempting to delete account: %s. Code: %s. Message: %s.",
                                  accountToDeleteId, httpException.getCode(), httpException.getMessage()));

            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    //endregion
}
