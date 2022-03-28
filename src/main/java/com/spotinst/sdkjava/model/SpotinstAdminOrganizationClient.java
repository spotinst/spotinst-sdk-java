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

    public ProgrammaticUserResponse createProgrammaticUser(ProgrammaticUser userRequest) {

        ProgrammaticUserResponse retVal = null;

        RepoGenericResponse<ProgrammaticUserResponse> creationResponse =
                getSpotinstAccountAdminRepo().createProgrammaticUser(userRequest, authToken);

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
                getSpotinstAccountAdminRepo().getOrganizationUsers(authToken);

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
                getSpotinstAccountAdminRepo().updateGroupsOfUser(userId, userGroupIds, authToken);

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

    public Boolean updateUserDirectPolicies(String userId, UpdatePoliciesRequest updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> getResponse =
                getSpotinstAccountAdminRepo().updateUserDirectPolicies(userId, updateRequest, authToken);

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
                getSpotinstAccountAdminRepo().createPolicy(createRequest, authToken);

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
                getSpotinstAccountAdminRepo().updatePolicy(policyId, updateRequest, authToken);

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
                getSpotinstAccountAdminRepo().getAllPolicies( authToken);

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
                getSpotinstAccountAdminRepo().deletePolicy(policyId, authToken);

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

    public Boolean updateUserGroupMappedPolicies(String groupId, UpdatePoliciesRequest updateRequest) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstAccountAdminRepo().updateUserGroupMappedPolicies(groupId, updateRequest, authToken);

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
                getSpotinstAccountAdminRepo().updateUserGroupMappedUsers(groupId, userIds, authToken);

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

    public UserGroupDetails getUserGroup(String groupId) {

        UserGroupDetails retVal = null;

        RepoGenericResponse<UserGroupDetails> getResponse =
                getSpotinstAccountAdminRepo().getUserGroup(groupId, authToken);

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
                getSpotinstAccountAdminRepo().getOrganizationUserGroups(authToken);

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
