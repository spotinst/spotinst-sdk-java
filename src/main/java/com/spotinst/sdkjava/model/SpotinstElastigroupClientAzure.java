package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;
import com.spotinst.sdkjava.model.filters.SortFilter;
import com.spotinst.sdkjava.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstElastigroupClientAzure {
    private static final Logger                                           LOGGER =
            LoggerFactory.getLogger(SpotinstElastigroupClientAzure.class);
    //region Members
    private              String                                           authToken;
    private              String                                           account;
    private              ISpotinstElastigroupRepoAzure                    spotinstElastigroupRepo;
    private              ISpotinstElastigroupActiveInstanceRepoAzure      spotinstElastigroupActiveInstanceRepo;
    private              ISpotinstElastigroupInstanceHealthinessRepoAzure spotinstElastigroupInstanceHealthinessRepo;
    private              ISpotinstElastigroupDeploymentRepoAzure          spotinstElastigroupDeploymentRepoAzure;
    //endregion

    public ISpotinstElastigroupRepoAzure getSpotinstElastigroupRepo() {
        return this.spotinstElastigroupRepo;
    }

    public void setSpotinstElastigroupRepo() {
        this.spotinstElastigroupRepo = SpotinstRepoManager.getInstance().getSpotinstElastigroupRepoAzure();
    }

    public ISpotinstElastigroupDeploymentRepoAzure getSpotinstElastigroupDeploymentRepoAzure() {
        return this.spotinstElastigroupDeploymentRepoAzure;
    }

    public void setSpotinstElastigroupDeploymentRepoAzure() {
        this.spotinstElastigroupDeploymentRepoAzure = SpotinstRepoManager.getInstance().getSpotinstElastigroupDeploymentRepoAzure();
    }


    //region Constructor
    public SpotinstElastigroupClientAzure(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstElastigroupClientAzure(String authToken, String account,
                                          List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstElastigroupRepo();
        setSpotinstElastigroupDeploymentRepoAzure();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }
    }

    //endregion

    //region Methods
    public ElastigroupAzure createElastigroup(ElastigroupCreationRequestAzure elastigroupCreationRequest) {

        ElastigroupAzure retVal = null;

        ElastigroupAzure elastigroupToCreate = elastigroupCreationRequest.getElastigroup();

        RepoGenericResponse<ElastigroupAzure> creationResponse =
                getSpotinstElastigroupRepo().create(elastigroupToCreate, authToken, account);
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

        Boolean retVal = null;

        ElastigroupAzure elastigroupToUpdate = elastigroupUpdateRequest.getElastigroup();
        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstElastigroupRepo().update(elastigroupId, elastigroupToUpdate, authToken, account);
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

        Boolean retVal                = null;
        String  elastigroupToDeleteId = elastigroupDeletionRequest.getElastigroupId();
        RepoGenericResponse<Boolean> elastigroupDeletionResponse =
                getSpotinstElastigroupRepo().delete(elastigroupToDeleteId, authToken, account);
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

        RepoGenericResponse<List<ElastigroupAzure>> elastigroupsRepoGenericResponse =
                getSpotinstElastigroupRepo().getAll(filter, authToken, account);
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
    //endregion


    //Private Methods
    private <T> void handleFailure(RepoGenericResponse<T> response, String errorMessage) {
        List<HttpError> httpExceptions = response.getHttpExceptions();
        LOGGER.error(String.format("%s. Errors: %s", errorMessage, httpExceptions));
        throw new SpotinstHttpException(httpExceptions.get(0).getMessage());
    }

    public GroupDeploymentAzure createDeployment(GroupDeploymentCreationRequestAzure deploymentCreationRequestAzure,
                                                 String elastigroupId) {
        GroupDeploymentAzure retVal;


        RepoGenericResponse<GroupDeploymentAzure> repoGenericResponse = getSpotinstElastigroupDeploymentRepoAzure()
                .create(deploymentCreationRequestAzure, authToken, account, elastigroupId);

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

    public List<GroupDeploymentAzure> getAllDeployments(SortFilter filter, String groupId) {
        List<GroupDeploymentAzure> retVal;
        RepoGenericResponse<List<GroupDeploymentAzure>> repoGenericResponse =
                getSpotinstElastigroupDeploymentRepoAzure().getAll(filter, authToken, account, groupId);

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

    public GroupDeploymentAzure getDeployment(String groupId, String deploymentId) {
        GroupDeploymentAzure retVal;
        RepoGenericResponse<GroupDeploymentAzure> repoGenericResponse =
                getSpotinstElastigroupDeploymentRepoAzure().get(deploymentId, authToken, account, groupId);

        if (repoGenericResponse.isRequestSucceed()) {
            retVal = repoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = repoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get deployment %s. Code: %s. Message: %s.",
                                       deploymentId, httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public GroupDeploymentDetailsAzure getDeploymentDetails(String groupId, String deploymentId) {
        GroupDeploymentDetailsAzure retVal;
        RepoGenericResponse<GroupDeploymentDetailsAzure> repoGenericResponse =
                getSpotinstElastigroupDeploymentRepoAzure().getDetails(deploymentId, authToken, account, groupId);

        if (repoGenericResponse.isRequestSucceed()) {
            retVal = repoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = repoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get deployment %s. Code: %s. Message: %s.",
                                       deploymentId, httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }
    //endregion
}
