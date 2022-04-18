package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.admin.organization.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SpotinstAdminOrganizationClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstAdminOrganizationClient.class);
    //region Members
    private              String authToken;
    private     String account;

    private ISpotAdminOrganizationRepo spotinstAccountAdminRepo;
    //endregion

    public ISpotAdminOrganizationRepo getSpotinstAccountAdminRepo() {
        return this.spotinstAccountAdminRepo;
    }

    public void setSpotinstAccountAdminRepo() {
        this.spotinstAccountAdminRepo = SpotinstRepoManager.getInstance().getSpotAdminOrganizationRepo();
    }

    //region Constructor
    public SpotinstAdminOrganizationClient(String authToken) {
        this(authToken,  null, null);
    }

    public SpotinstAdminOrganizationClient(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstAdminOrganizationClient(String authToken, String account, List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account   = account;

        setSpotinstAccountAdminRepo();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }
    }
    //endregion

    public User createUser(User userRequest ) {
        return createUser(userRequest, false);
    }

    public User createUser(User userRequest, Boolean generateToken) {

        User retVal = null;

        RepoGenericResponse<User> creationResponse =
                getSpotinstAccountAdminRepo().createUser(userRequest, generateToken, authToken);

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

    public List<Users> getUsers() {

        List<Users> retVal = null;

        RepoGenericResponse<List<Users>> getResponse =
                getSpotinstAccountAdminRepo().getUsers(authToken);

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

    public UserDetails getUserDetails(String userId) {

        UserDetails retVal = null;

        RepoGenericResponse<UserDetails> getResponse =
                getSpotinstAccountAdminRepo().getUserDetails(userId, authToken);

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

    public Boolean updateUserGroupMappingOfUser(String userId, List<String> userGroupIds) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserGroupMappingOfUser(userId, userGroupIds, authToken);

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

    public Boolean deleteUser(String userId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().deleteUser(userId, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete user. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updatePolicyMappingOfUser(String userId, UpdatePoliciesRequest updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> getResponse =
                getSpotinstAccountAdminRepo().updatePolicyMappingOfUser(userId, updateRequest, authToken);

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

    public UserGroup createUserGroup(UserGroup createRequest) {

        UserGroup retVal = null;

        RepoGenericResponse<UserGroup> creationResponse =
                getSpotinstAccountAdminRepo().createUserGroup(createRequest, authToken);

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

    public List<UserGroups> getUserGroups() {

        List<UserGroups> retVal = null;

        RepoGenericResponse<List<UserGroups>> getResponse =
                getSpotinstAccountAdminRepo().getUserGroups(authToken);

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

    public UserGroupDetails getUserGroupDetails(String groupId) {

        UserGroupDetails retVal = null;

        RepoGenericResponse<UserGroupDetails> getResponse =
                getSpotinstAccountAdminRepo().getUserGroupDetails(groupId, authToken);

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

    public Boolean updateUserGroupDetails(String groupId, String name, String description) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserGroupDetails(groupId, name, description, authToken);

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
                getSpotinstAccountAdminRepo().deleteUserGroup(groupId, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete user group. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean updateUserMappingOfUserGroup(String groupId, List<String> userIds) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserMappingOfUserGroup(groupId, userIds, authToken);

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

    public Boolean updatePolicyMappingOfUserGroup(String groupId, UpdatePoliciesRequest updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updatePolicyMappingOfUserGroup(groupId, updateRequest, authToken);

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

    public List<GetAccountUserMapping> getAccountUserMapping(String userEmail) {

        List<GetAccountUserMapping> retVal = null;

        RepoGenericResponse<List<GetAccountUserMapping>> getResponse = getSpotinstAccountAdminRepo().getAccountUserMapping(userEmail, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get user's account mapping Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    //endregion
}