package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import com.spotinst.sdkjava.model.requests.admin.account.AccountDeleteRequest;
import com.spotinst.sdkjava.model.requests.admin.account.ListAllAccountsRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateAccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SpotinstAccountAdminClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstAccountAdminClient.class);
    //region Members
    private              String authToken;
    private ISpotAccountAdminRepo spotAccountAdminRepo;
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

        setSpotAccountAdminRepo();
    }

    public ISpotAccountAdminRepo getSpotAccountAdminRepo() {
        return spotAccountAdminRepo;
    }

    public void setSpotAccountAdminRepo() {
        this.spotAccountAdminRepo =
                SpotinstRepoManager.getInstance().getSpotAdminAccountRepo();
    }

    //endregion

    public Account createAccount(String accountName) {

        Account retVal;

        RepoGenericResponse<Account> response =
                getSpotAccountAdminRepo().create(accountName, authToken);

        if (response.isRequestSucceed()) {
            retVal = response.getValue();
        }
        else {
            List<HttpError> httpExceptions = response.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);

            LOGGER.error(
                    String.format("Error encountered while attempting to create account: Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));

            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }



    //region Methods
    public List<BlAccountAdmin> listAllAccounts(ListAllAccountsRequest listAllAccountsRequest) {

        List<BlAccountAdmin> retVal;
        String cloudAccountId = listAllAccountsRequest.getCloudAccountId();

        RepoGenericResponse<List<BlAccountAdmin>> listAccountResponse =
                getSpotAccountAdminRepo().getAll(null, authToken, cloudAccountId);

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


    public Boolean updateAccount(UpdateAccountRequest request, String accountId) {

        Boolean retVal;

        // the in our case the client only gets token that's why the account identifier to delete,
        // and the account who deletes are the same one. (delete in repo gets 3 attributes)
        RepoGenericResponse<Boolean> response =
                getSpotAccountAdminRepo().update(request, accountId, authToken);

        if (response.isRequestSucceed()) {
            retVal = response.getValue();
        }
        else {
            List<HttpError> httpExceptions = response.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);

            LOGGER.error(
                    String.format("Error encountered while attempting to create account: Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));

            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }



    //region Methods
    public Boolean deleteAccount(AccountDeleteRequest accountDeletionRequest) {

        Boolean               retVal;
        String                accountToDeleteId = accountDeletionRequest.getAccountId();

        // the in our case the client only gets token that's why the account identifier to delete,
        // and the account who deletes are the same one. (delete in repo gets 3 attributes)
        RepoGenericResponse<Boolean> accountDeletionResponse =
                getSpotAccountAdminRepo().delete(accountToDeleteId, authToken, accountToDeleteId);

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

    public List<AuditEventLogs> auditEventsLog(String accountId, String fromDate, String responseStatus, String toDate) {

        List<AuditEventLogs> retVal;

        RepoGenericResponse<List<AuditEventLogs>> listAuditEventLogs =
                getSpotAccountAdminRepo().getAuditEventLogs(authToken, accountId, fromDate, responseStatus, toDate);

        if (listAuditEventLogs.isRequestSucceed()) {
            retVal = listAuditEventLogs.getValue();
        }
        else {
            List<HttpError> httpExceptions = listAuditEventLogs.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get the list of accounts. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
    //endregion
}
