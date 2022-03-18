package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SpotinstAccountAdminClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstAccountAdminClient.class);
    //region Members
    private              String authToken;
    private     String account;

    private ISpotAccountAdminRepo spotinstAccountAdminRepo;
    //endregion

    public ISpotAccountAdminRepo getSpotinstAccountAdminRepo() {
        return this.spotinstAccountAdminRepo;
    }

    public void setSpotinstAccountAdminRepo() {
        this.spotinstAccountAdminRepo = SpotinstRepoManager.getInstance().getSpotAdminAccountRepo();
    }

    //region Constructor
    public SpotinstAccountAdminClient(String authToken) {
        this(authToken,  null, null);
    }

    public SpotinstAccountAdminClient(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstAccountAdminClient(String authToken, String account, List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account   = account;

        setSpotinstAccountAdminRepo();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }
    }
    //endregion

    //region Methods
    public List<BlAccountAdmin> listAllAccounts(ListAllAccountsRequest listAllAccountsRequest) {

        List<BlAccountAdmin> retVal;
        String cloudAccountId = listAllAccountsRequest.getCloudAccountId();
        SpotinstRepoManager managerInstance = SpotinstRepoManager.getInstance();
        ISpotAccountAdminRepo repoAdmin = managerInstance.getSpotAdminAccountRepo();

        RepoGenericResponse<List<BlAccountAdmin>> listAccountResponse =
                repoAdmin.getAll(null, authToken, cloudAccountId);

        if (listAccountResponse.isRequestSucceed()) {
            retVal = listAccountResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = listAccountResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get the list of accounts. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }


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
