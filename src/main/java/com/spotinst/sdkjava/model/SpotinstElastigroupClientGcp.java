package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceLockRequestGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceUnLockRequestGcp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SpotinstElastigroupClientGcp {
    private static final Logger                                    LOGGER =
            LoggerFactory.getLogger(SpotinstElastigroupClientGcp.class);
    //region Members
    private              String                                    authToken;
    private              String                                    account;
    private              ISpotinstElastigroupRepoGcp               spotinstElastigroupRepoGcp;
    //endregion

    public ISpotinstElastigroupRepoGcp getSpotinstElastigroupRepoGcp() {
        return this.spotinstElastigroupRepoGcp;
    }

    public void setSpotinstElastigroupRepoGcp() {
        this.spotinstElastigroupRepoGcp = SpotinstRepoManager.getInstance().getSpotinstElastigroupRepoGcp();
    }


    //region Constructor
    public SpotinstElastigroupClientGcp(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstElastigroupClientGcp(String authToken, String account,
                                        List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstElastigroupRepoGcp();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }

    }


    //endregion

    //region Methods
    public ElastigroupGcp createElastigroup(ElastigroupCreationRequestGcp elastigroupCreationRequest) {

        ElastigroupGcp retVal;

        ElastigroupGcp                      elastigroupToCreate = elastigroupCreationRequest.getElastigroup();
        SpotinstRepoManager                 managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp         repoGcp             = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<ElastigroupGcp> creationResponse    =
                repoGcp.create(elastigroupToCreate, authToken, account);

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

    public Boolean updateElastigroup(ElastigroupUpdateRequestGcp elastigroupUpdateRequest, String elastigroupId) {

        Boolean retVal;

        ElastigroupGcp              elastigroupToUpdate = elastigroupUpdateRequest.getElastigroup();
        SpotinstRepoManager         managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp             = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<Boolean> updateResponse =
                repoGcp.update(elastigroupId, elastigroupToUpdate, authToken, account);
        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update elastigroup. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteElastigroup(ElastigroupDeletionRequestGcp elastigroupDeletionRequest) {

        Boolean                     retVal;
        String                      elastigroupToDeleteId = elastigroupDeletionRequest.getElastigroupId();
        SpotinstRepoManager         managerInstance       = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp               = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<Boolean> elastigroupDeletionResponse =
                repoGcp.delete(elastigroupToDeleteId, authToken, account);
        if (elastigroupDeletionResponse.isRequestSucceed()) {
            retVal = elastigroupDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete elastigroup. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<ElastigroupGcp> getAllElastigroups() {
        List<ElastigroupGcp> retVal;

        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp         = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<List<ElastigroupGcp>> elastigroupsRepoGenericResponse =
                repoGcp.getAll(authToken, account);
        if (elastigroupsRepoGenericResponse.isRequestSucceed()) {
            retVal = elastigroupsRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupsRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all elastigroups. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        System.out.println("GET- List All Elastigroups:");

        if (retVal.size() == 0){ // No groups for this account
            System.out.println("No group found for this account");
        }

        for (int i = 0; i < retVal.size(); i++) {
            System.out.println("Group number:" + i + "   " + retVal.get(i).getName() + "   " + retVal.get(i).getId());
        }

        return retVal;
    }

    public ElastigroupGcp getElastigroup(ElastigroupGetRequestGcp elastigroupGetRequest) {

        ElastigroupGcp retVal;

        String                      elastigroupId   = elastigroupGetRequest.getElastigroupId();
        SpotinstRepoManager         managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp         = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<ElastigroupGcp> elastigroupRepoGenericResponse =
                repoGcp.get(elastigroupId, authToken, account);

        if (elastigroupRepoGenericResponse.isRequestSucceed()) {
            LOGGER.info(String.format("get successfully the group %s", elastigroupId));
            retVal = elastigroupRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get elastigroup : %s. Code: %s. Message: %s.",
                                  elastigroupId, httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<GroupActiveInstanceStatusGcp> getInstanceStatus(
            ElastigroupGetGroupInstanceStatusRequestGcp elastigroupGetInstanceHealthinessRequest) {
        List<GroupActiveInstanceStatusGcp> retVal = new LinkedList<>();

        String elastigroupId = elastigroupGetInstanceHealthinessRequest.getElastigroupId();

        RepoGenericResponse<List<GroupActiveInstanceStatusGcp>> instancesHealthinessResponse =
                SpotinstRepoManager.getInstance().getSpotinstInstanceHealthinessRepoGcp().getAll(elastigroupId, authToken, account);

        if (instancesHealthinessResponse.isRequestSucceed()) {
            retVal = instancesHealthinessResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = instancesHealthinessResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get instance status of elastigroup Code: %s. Message: %s", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean lockInstance(ElastigroupInstanceLockRequestGcp lockRequest, String instanceId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> lockResponse = getSpotinstElastigroupRepoGcp().lockInstance(lockRequest, authToken, instanceId);

        if (lockResponse.isRequestSucceed()) {
            retVal = lockResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = lockResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to lock instance. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }



    public Boolean unlockInstance(ElastigroupInstanceUnLockRequestGcp unlockRequest, String instanceId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> unlockResponse = getSpotinstElastigroupRepoGcp().unlockInstance(unlockRequest, authToken, instanceId);

        if (unlockResponse.isRequestSucceed()) {
            retVal = unlockResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = unlockResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to unlock instance. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    //endregion
}
