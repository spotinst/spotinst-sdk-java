package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;
import com.spotinst.sdkjava.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstElastigroupClientAzure {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstElastigroupClientAzure.class);
    //region Members
    private              String authToken;
    private              String account;
    //endregion


    //region Constructor
    public SpotinstElastigroupClientAzure(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstElastigroupClientAzure(String authToken, String account,
                                          List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account = account;

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }

    }

    //endregion

    //region Methods
    public ElastigroupAzure createElastigroup(ElastigroupCreationRequestAzure elastigroupCreationRequest) {

        ElastigroupAzure retVal;

        ElastigroupAzure              elastigroupToCreate = elastigroupCreationRequest.getElastigroup();
        SpotinstRepoManager           managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure           = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupAzure> creationResponse =
                repoAzure.create(elastigroupToCreate, authToken, account);
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

    public Boolean updateElastigroup(ElastigroupUpdateRequestAzure elastigroupUpdateRequest, String elastigroupId) {

        Boolean retVal;

        ElastigroupAzure              elastigroupToUpdate = elastigroupUpdateRequest.getElastigroup();
        SpotinstRepoManager           managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure           = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> updateResponse =
                repoAzure.update(elastigroupId, elastigroupToUpdate, authToken, account);
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

    public Boolean deleteElastigroup(ElastigroupDeletionRequestAzure elastigroupDeletionRequest) {

        Boolean                       retVal;
        String                        elastigroupToDeleteId = elastigroupDeletionRequest.getElastigroupId();
        SpotinstRepoManager           managerInstance       = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure             = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> elastigroupDeletionResponse =
                repoAzure.delete(elastigroupToDeleteId, authToken, account);
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

    public List<ElastigroupAzure> getAllElastigroups(ElastigroupGetAllRequestAzure elastigroupGetAllRequest) {
        List<ElastigroupAzure> retVal;

        GroupFilter filter = new GroupFilter();

        filter.setMaxCreatedAt(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getMaxCreatedAt()));
        filter.setMinCreatedAt(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getMinCreatedAt()));
        filter.setActiveFrom(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getActiveFrom()));
        filter.setActiveTo(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getActiveTo()));
        filter.setName(elastigroupGetAllRequest.getName());
        filter.setIncludeDeleted(false);

        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<List<ElastigroupAzure>> elastigroupsRepoGenericResponse =
                repoAzure.getAll(filter, authToken, account);
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
        return retVal;
    }

    public ElastigroupAzure getElastigroup(ElastigroupGetRequestAzure elastigroupGetRequest) {

        ElastigroupAzure retVal = null;

        String elastigroupId = elastigroupGetRequest.getElastigroupId();
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupAzure> elastigroupRepoGenericResponse =
                repoAzure.get(elastigroupId, authToken, account);
        if (elastigroupRepoGenericResponse.isRequestSucceed()) {
            retVal = elastigroupRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get elastigroup. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
    //endregion


    //Private Methods
    private <T> void handleFailure(RepoGenericResponse<T> response, String errorMessage) {
        List<HttpError> httpExceptions = response.getHttpExceptions();
        LOGGER.error(String.format("%s. Errors: %s", errorMessage, httpExceptions));
        throw new SpotinstHttpException(httpExceptions.get(0).getMessage());
    }

    public GroupDeploymentCreateAzure createDeployment(
            GroupDeploymentCreationRequestAzure deploymentCreationRequestAzure, String elastigroupId) {

        GroupDeploymentCreateAzure              retVal;
        SpotinstRepoManager                     managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupDeploymentRepoAzure repoAzure       =
                managerInstance.getSpotinstElastigroupDeploymentRepoAzure();
        RepoGenericResponse<GroupDeploymentCreateAzure> repoGenericResponse =
                repoAzure.create(deploymentCreationRequestAzure, authToken, account, elastigroupId);

        if (repoGenericResponse.isRequestSucceed()) {
            retVal = repoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = repoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create a deployment. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<GroupDeploymentGetAzure> getAllDeployments(String groupId, Integer limit,
                                                           SortQueryParam sortQueryParam) {

        List<GroupDeploymentGetAzure>           retVal;
        SpotinstRepoManager                     managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupDeploymentRepoAzure repoAzure       =
                managerInstance.getSpotinstElastigroupDeploymentRepoAzure();
        RepoGenericResponse<List<GroupDeploymentGetAzure>> repoGenericResponse =
                repoAzure.getAll(groupId, authToken, account, limit, sortQueryParam);

        if (repoGenericResponse.isRequestSucceed()) {
            retVal = repoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = repoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to list deployments. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public GroupDeploymentGetAzure getDeployment(String groupId, String deploymentId) {

        GroupDeploymentGetAzure retVal;
        SpotinstRepoManager     managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupDeploymentRepoAzure repoAzure = managerInstance.getSpotinstElastigroupDeploymentRepoAzure();
        RepoGenericResponse<GroupDeploymentGetAzure> repoGenericResponse =
                repoAzure.get(deploymentId, authToken, account, groupId);

        if (repoGenericResponse.isRequestSucceed()) {
            retVal = repoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = repoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get deployment %s. Code: %s. Message: %s.",
                                  deploymentId, httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public GroupDeploymentDetailsAzure getDeploymentDetails(String groupId, String deploymentId) {

        GroupDeploymentDetailsAzure             retVal;
        SpotinstRepoManager                     managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupDeploymentRepoAzure repoAzure       =
                managerInstance.getSpotinstElastigroupDeploymentRepoAzure();
        RepoGenericResponse<GroupDeploymentDetailsAzure> repoGenericResponse =
                repoAzure.getDetails(deploymentId, authToken, account, groupId);

        if (repoGenericResponse.isRequestSucceed()) {
            retVal = repoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = repoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get deployment %s. Code: %s. Message: %s.",
                                  deploymentId, httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
    //endregion
}
