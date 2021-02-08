package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.filters.SortQueryParam;
import com.spotinst.sdkjava.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstElastigroupClientGcp {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstElastigroupClientGcp.class);
    //region Members
    private              String authToken;
    private              String account;
    //endregion


    //region Constructor
    public SpotinstElastigroupClientGcp(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstElastigroupClientGcp(String authToken, String account,
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
    public ElastigroupGcp createElastigroup(ElastigroupCreationRequestGcp elastigroupCreationRequest) {

        ElastigroupGcp retVal;

        ElastigroupGcp              elastigroupToCreate = elastigroupCreationRequest.getElastigroup();
        SpotinstRepoManager           managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp           = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<ElastigroupGcp> creationResponse =
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
        SpotinstRepoManager           managerInstance     = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp           = managerInstance.getSpotinstElastigroupRepoGcp();
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

        Boolean                       retVal;
        String                        elastigroupToDeleteId = elastigroupDeletionRequest.getElastigroupId();
        SpotinstRepoManager           managerInstance       = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp             = managerInstance.getSpotinstElastigroupRepoGcp();
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

    public List<ElastigroupGcp> getAllElastigroups(ElastigroupGetAllRequestGcp elastigroupGetAllRequest) {
        List<ElastigroupGcp> retVal;

        GroupFilter filter = new GroupFilter();

        filter.setMaxCreatedAt(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getMaxCreatedAt()));
        filter.setMinCreatedAt(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getMinCreatedAt()));
        filter.setActiveFrom(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getActiveFrom()));
        filter.setActiveTo(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getActiveTo()));
        filter.setName(elastigroupGetAllRequest.getName());
        filter.setIncludeDeleted(false);

        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp       = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<List<ElastigroupGcp>> elastigroupsRepoGenericResponse =
                repoGcp.getAll(filter, authToken, account);
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

    public ElastigroupGcp getElastigroup(ElastigroupGetRequestGcp elastigroupGetRequest) {

        ElastigroupGcp retVal;

        String elastigroupId = elastigroupGetRequest.getElastigroupId();
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoGcp repoGcp       = managerInstance.getSpotinstElastigroupRepoGcp();
        RepoGenericResponse<ElastigroupGcp> elastigroupRepoGenericResponse =
                repoGcp.get(elastigroupId, authToken, account);

        if (elastigroupRepoGenericResponse.isRequestSucceed()) {
            LOGGER.info(String.format("get successfully the group %s", elastigroupId));
            retVal = elastigroupRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get elastigroup : %s. Code: %s. Message: %s.",
                                       elastigroupId,httpException.getCode(), httpException.getMessage()));
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
    //endregion
}
