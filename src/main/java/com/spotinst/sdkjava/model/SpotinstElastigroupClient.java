package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by talzur on 11/01/2017.
 */
public class SpotinstElastigroupClient {
    private static final Logger                                      LOGGER =
            LoggerFactory.getLogger(SpotinstElastigroupClient.class);
    //region Members
    private              String                                      authToken;
    private              String                                      account;
    private              ISpotinstElastigroupRepo                    spotinstElastigroupRepo;
    private              ISpotinstElastigroupActiveInstanceRepo      spotinstElastigroupActiveInstanceRepo;
    private              ISpotinstElastigroupInstanceHealthinessRepo spotinstElastigroupInstanceHealthinessRepo;
    //endregion

    public ISpotinstElastigroupRepo getSpotinstElastigroupRepo() {
        return this.spotinstElastigroupRepo;
    }

    public void setSpotinstElastigroupRepo() {
        this.spotinstElastigroupRepo = SpotinstRepoManager.getInstance().getSpotinstElastigroupRepo();
    }

    public ISpotinstElastigroupActiveInstanceRepo getSpotinstElastigroupActiveInstanceRepo() {
        return this.spotinstElastigroupActiveInstanceRepo;
    }

    public void setSpotinstElastigroupActiveInstanceRepo() {
        this.spotinstElastigroupActiveInstanceRepo =
                SpotinstRepoManager.getInstance().getSpotinstElastigroupActiveInstanceRepo();
    }

    public ISpotinstElastigroupInstanceHealthinessRepo getSpotinstElastigroupInstanceHealthinessRepo() {
        return this.spotinstElastigroupInstanceHealthinessRepo;
    }

    public void setInstanceHealthinessRepo() {
        this.spotinstElastigroupInstanceHealthinessRepo =
                SpotinstRepoManager.getInstance().getSpotinstInstanceHealthinessRepo();
    }
    //region Constructor
    public SpotinstElastigroupClient(String authToken, String account) {
        this(authToken, account, null);
    }

    public SpotinstElastigroupClient(String authToken, String account, List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstElastigroupRepo();
        setSpotinstElastigroupActiveInstanceRepo();
        setInstanceHealthinessRepo();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }
    }

    //endregion

    //region Methods
    public Elastigroup createElastigroup(ElastigroupCreationRequest elastigroupCreationRequest) {

        Elastigroup retVal = null;

        Elastigroup elastigroupToCreate = elastigroupCreationRequest.getElastigroup();

        RepoGenericResponse<Elastigroup> creationResponse =
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

    public Boolean updateElastigroup(ElastigroupUpdateRequest elastigroupUpdateRequest, String elastigroupId) {

        Boolean retVal = null;

        Elastigroup elastigroupToUpdate = elastigroupUpdateRequest.getElastigroup();
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

    public Elastigroup cloneElastigroup(ElastigroupCloneRequest elastigroupCloneRequest, String elastigroupId) {
        Elastigroup retVal = null;

        Elastigroup elastigroupModifications = elastigroupCloneRequest.getElastigroup();
        RepoGenericResponse<Elastigroup> cloneResponse =
                getSpotinstElastigroupRepo().clone(elastigroupId, elastigroupModifications, authToken, account);

        if (cloneResponse.isRequestSucceed()) {
            retVal = cloneResponse.getValue();
        }
        else {
            String errorMessage = "Error encountered while attempting to clone elastigroup";
            handleFailure(cloneResponse, errorMessage);
        }

        return retVal;
    }

    public Boolean enterGroupStandby(ElastigroupStandbyRequest elastigroupStandbyRequest) {
        Boolean retVal;

        RepoGenericResponse<Boolean> elastigroupStandbyResponse =
                getSpotinstElastigroupRepo().enterStandby(elastigroupStandbyRequest, authToken, account);
        if (elastigroupStandbyResponse.isRequestSucceed()) {
            retVal = elastigroupStandbyResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupStandbyResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to enter elastigroup standby. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean exitGroupStandby(ElastigroupStandbyRequest elastigroupStandbyRequest) {
        Boolean retVal;

        RepoGenericResponse<Boolean> elastigroupStandbyResponse =
                getSpotinstElastigroupRepo().exitStandby(elastigroupStandbyRequest, authToken, account);
        if (elastigroupStandbyResponse.isRequestSucceed()) {
            retVal = elastigroupStandbyResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupStandbyResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to exit elastigroup standby. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteElastigroup(ElastigroupDeletionRequest elastigroupDeletionRequest) {

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

    public Boolean detachInstances(ElastigroupDetachInstancesRequest detachRequest, String elastigroupId) {

        Boolean retVal = null;

        if (detachRequest.getInstancesToDetach().size() > 0) {
            RepoGenericResponse<Boolean> detachResponse =
                    getSpotinstElastigroupRepo().detachInstances(elastigroupId, detachRequest, authToken, account);
            if (detachResponse.isRequestSucceed()) {
                retVal = detachResponse.getValue();
            }
            else {
                List<HttpError> httpExceptions = detachResponse.getHttpExceptions();
                HttpError       httpException  = httpExceptions.get(0);
                LOGGER.error(
                        String.format("Error encountered while attempting to detach instances. Code: %s. Message: %s.",
                                      httpException.getCode(), httpException.getMessage()));
                throw new SpotinstHttpException(httpException.getMessage());
            }
        }
        else {
            LOGGER.error("No instances to detach.");
        }


        return retVal;
    }

    public List<ElastigroupActiveInstance> getActiveInstances(
            ElastigroupGetActiveInstancesRequest elastigroupGetActiveInstancesRequest) {

        List<ElastigroupActiveInstance> retVal = null;

        String elastigroupId = elastigroupGetActiveInstancesRequest.getElastigroupId();

        ActiveInstanceFilter filter = new ActiveInstanceFilter();
        filter.setElastigroupId(elastigroupId);
        RepoGenericResponse<List<ElastigroupActiveInstance>> instancesResponse =
                getSpotinstElastigroupActiveInstanceRepo().getAll(filter, authToken, account);
        if (instancesResponse.isRequestSucceed()) {
            retVal = instancesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = instancesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get active instances. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<ElastigroupInstanceHealthiness> getInstanceHealthiness(
            ElastigroupGetInstanceHealthinessRequest elastigroupGetInstanceHealthinessRequest) {
        List<ElastigroupInstanceHealthiness> retVal = new LinkedList<>();

        String elastigroupId = elastigroupGetInstanceHealthinessRequest.getElastigroupId();

        RepoGenericResponse<List<ElastigroupInstanceHealthiness>> instancesHealthinessResponse =
                getSpotinstElastigroupInstanceHealthinessRepo().getAll(elastigroupId, authToken, account);

        if (instancesHealthinessResponse.isRequestSucceed()) {
            retVal = instancesHealthinessResponse.getValue();
        }
        else {
            String errorMessage = "Error encountered while attempting to get instance healthiness of elastigroup";
            handleFailure(instancesHealthinessResponse, errorMessage);
        }

        return retVal;
    }

    /**
     * Describe all the Elastigroups in your account and their full JSON
     * <p>
     * This route accepts a combination of parameters in the request object:
     * either “minCreatedAt” and “maxCreatedAt or “activeFrom” and “activeTo”.
     * A combination of the two types together is not supported.
     *
     * @param elastigroupGetAllRequest - a request that defines which elastigroups to fetch
     * @return List of Elastigroups which correspond to the given filters
     */
    public List<Elastigroup> getAllElastigroups(ElastigroupGetAllRequest elastigroupGetAllRequest) {
        List<Elastigroup> retVal;

        GroupFilter filter = new GroupFilter();

        filter.setMaxCreatedAt(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getMaxCreatedAt()));
        filter.setMinCreatedAt(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getMinCreatedAt()));
        filter.setActiveFrom(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getActiveFrom()));
        filter.setActiveTo(TimeUtils.convertDateToISO8601(elastigroupGetAllRequest.getActiveTo()));
        filter.setName(elastigroupGetAllRequest.getName());
        filter.setIncludeDeleted(elastigroupGetAllRequest.getIncludeDeleted());

        RepoGenericResponse<List<Elastigroup>> elastigroupsRepoGenericResponse =
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

    public Elastigroup getElastigroup(ElastigroupGetRequest elastigroupGetRequest) {

        Elastigroup retVal = null;

        String elastigroupId = elastigroupGetRequest.getElastigroupId();

        RepoGenericResponse<Elastigroup> elastigroupRepoGenericResponse =
                getSpotinstElastigroupRepo().get(elastigroupId, authToken, account);
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

    /**
     * This function is used to scale up an Elastigroup by taking an ElastigroupScalingRequest that is sent by the user and sending it to
     * ISpotinstElastigroupRepo.scaleUp().
     *
     * @param elastigroupScalingRequest ElastigroupScalingRequest object that can be converted to a JSON to send as a request
     * @return ElastigroupScalingResponse Object that is returned from the scale down request from ISpotinstElastigroupRepo.scaleUp()
     */
    public ElastigroupScalingResponse scaleGroupUp(ElastigroupScalingRequest elastigroupScalingRequest) {

        ElastigroupScalingResponse retVal = null;

        String elastigroupId = elastigroupScalingRequest.getElastigroupId();

        ActiveInstanceFilter filter = new ActiveInstanceFilter();
        filter.setElastigroupId(elastigroupId);
        RepoGenericResponse<ElastigroupScalingResponse> elastigroupScalingResponse =
                getSpotinstElastigroupRepo().scaleUp(elastigroupScalingRequest, authToken, account);

        if (elastigroupScalingResponse.isRequestSucceed()) {
            retVal = elastigroupScalingResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupScalingResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to scale group up. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This function is used to scale down an Elastigroup by takingin an ElastigroupScalingRequest that is sent by the user and sending it to
     * ISpotinstElastigroupRepo.scaleDown().
     *
     * @param elastigroupScalingRequest ElastigroupScalingRequest object that can be converted to a JSON to send as a request
     * @return ElastigroupScalingResponse Object that is returned from the scale down request from ISpotinstElastigroupRepo.scaleDown()
     */
    public ElastigroupScalingResponse scaleGroupDown(ElastigroupScalingRequest elastigroupScalingRequest) {
        ElastigroupScalingResponse retVal = null;

        String elastigroupId = elastigroupScalingRequest.getElastigroupId();

        ActiveInstanceFilter filter = new ActiveInstanceFilter();
        filter.setElastigroupId(elastigroupId);
        RepoGenericResponse<ElastigroupScalingResponse> elastigroupScalingResponse =
                getSpotinstElastigroupRepo().scaleDown(elastigroupScalingRequest, authToken, account);

        if (elastigroupScalingResponse.isRequestSucceed()) {
            retVal = elastigroupScalingResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupScalingResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to scale group down. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    private <T> void handleFailure(RepoGenericResponse<T> response, String errorMessage) {
        List<HttpError> httpExceptions = response.getHttpExceptions();
        LOGGER.error(String.format("%s. Errors: %s", errorMessage, httpExceptions));
        throw new SpotinstHttpException(httpExceptions.get(0).getMessage());
    }
    //endregion
}
