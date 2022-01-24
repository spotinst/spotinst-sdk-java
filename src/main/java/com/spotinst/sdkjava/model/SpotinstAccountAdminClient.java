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

    public User createUser(User userRequest) {

        User retVal = null;

        RepoGenericResponse<User> creationResponse =
                getSpotinstAccountAdminRepo().createUser(userRequest, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create user. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public UserDetails getUserDetails(String userId) {

        UserDetails retVal = null;

        RepoGenericResponse<UserDetails> getResponse =
                getSpotinstAccountAdminRepo().getUserDetails(userId, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get user details for %s. Code: %s. Message: %s.",userId,
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public ProgrammaticUserResponse createProgrammaticUser(ProgrammaticUser userRequest, String shouldGenerateToken) {

        ProgrammaticUserResponse retVal = null;

        RepoGenericResponse<ProgrammaticUserResponse> creationResponse =
                getSpotinstAccountAdminRepo().createProgrammaticUser(userRequest,shouldGenerateToken, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create programmatic user. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<OrganizationUsers> getOrganizationUsers() {

        List<OrganizationUsers> retVal = null;

        RepoGenericResponse<List<OrganizationUsers>> getResponse =
                getSpotinstAccountAdminRepo().getOrganizationUsers(authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get organization users. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateGroupsOfUser(String userId, List<String> userGroupIds) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> getResponse =
                getSpotinstAccountAdminRepo().updateGroupsOfUser(userId, userGroupIds, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update groups for the user. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateUserDirectPolicies(String userId, UpdateUserDirectPoliciesRequest updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> getResponse =
                getSpotinstAccountAdminRepo().updateUserDirectPolicies(userId, updateRequest, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update direct policies for the user. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Policy createPolicy(Policy createRequest) {

        Policy retVal = null;

        RepoGenericResponse<Policy> creationResponse =
                getSpotinstAccountAdminRepo().createPolicy(createRequest, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create policy. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updatePolicy(String policyId, Policy updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updatePolicy(policyId, updateRequest, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update policy. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<Policy> getAllPolicies() {

        List<Policy> retVal = null;

        RepoGenericResponse<List<Policy>> creationResponse =
                getSpotinstAccountAdminRepo().getAllPolicies( authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all policies. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deletePolicy(String policyId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> deleteResponse =
                getSpotinstAccountAdminRepo().deletePolicy(policyId, authToken, account);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete policy. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public UserGroup createUserGroup(UserGroup createRequest) {

        UserGroup retVal = null;

        RepoGenericResponse<UserGroup> creationResponse =
                getSpotinstAccountAdminRepo().createUserGroup(createRequest, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create user group. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateUserGroupMappedPolicies(String groupId, List<UserGroupMappedPolicies> updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserGroupMappedPolicies(groupId, updateRequest, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update user group mapped policies. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateUserGroupMappedUsers(String groupId, List<String> userIds) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserGroupMappedUsers(groupId, userIds, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update user group mapped users. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateUserGroupDetails(String groupId, String name, String description) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserGroupDetails(groupId, name, description, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update user group details. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteUserGroup(String groupId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().deleteUserGroup(groupId, authToken, account);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update user group details. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public UserGroupDetails getUserGroup(String groupId) {

        UserGroupDetails retVal = null;

        RepoGenericResponse<UserGroupDetails> getResponse =
                getSpotinstAccountAdminRepo().getUserGroup(groupId, authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get user group for %s. Code: %s. Message: %s.",groupId,
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<OrganizationUserGroups> getOrganizationUserGroups() {

        List<OrganizationUserGroups> retVal = null;

        RepoGenericResponse<List<OrganizationUserGroups>> getResponse =
                getSpotinstAccountAdminRepo().getOrganizationUserGroups(authToken, account);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get organization user groups Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }
    //endregion
}
