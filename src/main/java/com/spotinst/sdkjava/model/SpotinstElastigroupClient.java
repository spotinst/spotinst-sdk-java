package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.enums.EventsLogsSeverityEnum;
import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentStrategyOnFailure;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupStartDeployment;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ScalingPolicySuspension;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.SuspendedScalingPoliciesList;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceUnLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.SuspendedScalingPolicy;
import com.spotinst.sdkjava.model.responses.elastigroup.aws.ElastigroupGetDeploymentStatusResponse;
import com.spotinst.sdkjava.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
    private              ISpotinstEventsLogsRepo                     spotinstElastigroupEventLogRepo;
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

    public ISpotinstEventsLogsRepo getSpotinstElastigroupEventLogRepo() {
        return this.spotinstElastigroupEventLogRepo;
    }

    public void setSpotinstElastigroupEventLogRepo() {
        this.spotinstElastigroupEventLogRepo = SpotinstRepoManager.getInstance().getSpotinstElastigroupEventLogRepo();
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
        setSpotinstElastigroupEventLogRepo();

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
        String  groupId = elastigroupStandbyRequest.getElastigroupId();

        RepoGenericResponse<Boolean> elastigroupStandbyResponse =
                getSpotinstElastigroupRepo().enterStandby(groupId, authToken, account);
        if (elastigroupStandbyResponse.isRequestSucceed()) {
            retVal = elastigroupStandbyResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupStandbyResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to enter elastigroup standby. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean exitGroupStandby(ElastigroupStandbyRequest elastigroupStandbyRequest) {
        Boolean retVal;
        String  groupId = elastigroupStandbyRequest.getElastigroupId();

        RepoGenericResponse<Boolean> elastigroupStandbyResponse =
                getSpotinstElastigroupRepo().exitStandby(groupId, authToken, account);

        if (elastigroupStandbyResponse.isRequestSucceed()) {
            retVal = elastigroupStandbyResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupStandbyResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to exit elastigroup standby. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean deleteElastigroup(ElastigroupDeletionRequest elastigroupDeletionRequest) {

        Boolean               retVal                = null;
        String                elastigroupToDeleteId = elastigroupDeletionRequest.getElastigroupId();
        ApiDeleteGroupRequest deleteRequest         = elastigroupDeletionRequest.getDeleteRequest();
        RepoGenericResponse<Boolean> elastigroupDeletionResponse =
                getSpotinstElastigroupRepo().delete(elastigroupToDeleteId, authToken, account, deleteRequest);

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

    public Boolean lockInstance(ElastigroupInstanceLockRequest lockRequest, String instanceId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> lockResponse = getSpotinstElastigroupRepo().lockInstance(lockRequest, authToken, instanceId);

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

    public Boolean unlockInstance(ElastigroupInstanceUnLockRequest unlockRequest, String instanceId) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> unlockResponse = getSpotinstElastigroupRepo().unlockInstance(unlockRequest, authToken, instanceId);

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

    public Boolean simulateInstanceInterruption(List<String> instanceIds) {

        Boolean retVal = false;

        RepoGenericResponse<Boolean> interruptionResponse = getSpotinstElastigroupRepo().simulateInstanceInterruption(authToken, account, instanceIds);

        if (interruptionResponse.isRequestSucceed()) {
            retVal = interruptionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = interruptionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to interrupt instance. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
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

    public SuspendedProcesses suspendProcess(ElastigroupSuspendProcessesRequest suspendProcessesRequest) {
        SuspendedProcesses retVal;

        String                  elastigroupId = suspendProcessesRequest.getElastigroupId();
        List<ProcessSuspension> suspensions   = suspendProcessesRequest.getSuspensions();

        RepoGenericResponse<SuspendedProcesses> suspendProcessesResponse =
                getSpotinstElastigroupRepo().suspendProcesses(elastigroupId, suspensions, authToken, account);

        if (suspendProcessesResponse.isRequestSucceed()) {
            retVal = suspendProcessesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = suspendProcessesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to suspend processes. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public SuspendedProcesses removeSuspensions(ElastigroupRemoveSuspensionsRequest request) {

        SuspendedProcesses retVal;

        String                elastigroupId = request.getElastigroupId();
        List<ProcessNameEnum> processNames  = request.getProcesses();

        RepoGenericResponse<SuspendedProcesses> removeSuspensionsResponse =
                getSpotinstElastigroupRepo().removeSuspensions(elastigroupId, processNames, authToken, account);

        if (removeSuspensionsResponse.isRequestSucceed()) {
            retVal = removeSuspensionsResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = removeSuspensionsResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to remove process suspensions. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public SuspendedProcesses getSuspendedProcesses(ElastigroupGetSuspensionsRequest request) {

        SuspendedProcesses retVal;

        String elastigroupId = request.getElastigroupId();

        RepoGenericResponse<SuspendedProcesses> suspendedProcessesResponse =
                getSpotinstElastigroupRepo().getSuspendedProcesses(elastigroupId, authToken, account);

        if (suspendedProcessesResponse.isRequestSucceed()) {
            retVal = suspendedProcessesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = suspendedProcessesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get process suspensions. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public List<EventLog> getEventsLogs(GetEventsLogsRequest getEventsLogsRequest) {

        List<EventLog> retVal = null;

        String                 fromDate      = getEventsLogsRequest.getFromDate();
        String                 toDate        = getEventsLogsRequest.getToDate();
        EventsLogsSeverityEnum logsSeverity  = getEventsLogsRequest.getSeverity();
        String                 resourceId    = getEventsLogsRequest.getResourceId();
        String                 limit         = getEventsLogsRequest.getLimit();
        String                 elastigroupId = getEventsLogsRequest.getElastigroupId();

        EventsLogsFilter filter = new EventsLogsFilter();
        filter.setFromDate(fromDate);
        filter.setToDate(toDate);

        if (Objects.nonNull(logsSeverity)) {
            filter.setSeverity(logsSeverity.getName());
        }
        else {
            filter.setSeverity(null);
        }
        filter.setResourceId(resourceId);
        filter.setLimit(limit);
        filter.setElastigroupId(elastigroupId);

        RepoGenericResponse<List<EventLog>> eventsLogsResponse =
                getSpotinstElastigroupEventLogRepo().getAll(filter, authToken, account);

        if (eventsLogsResponse.isRequestSucceed()) {
            retVal = eventsLogsResponse.getValue();
        }
        else {
            String errorMessage = "Error encountered while attempting to get events logs";
            handleFailure(eventsLogsResponse, errorMessage);
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

    public SuspendedScalingPolicy suspendScalingPolicies(
            ElastigroupSuspendScalingPoliciesRequest suspendScalingPoliciesRequest) {
        SuspendedScalingPolicy retVal;

        String                  elastigroupId = suspendScalingPoliciesRequest.getGroupId();
        String                  policyName    = suspendScalingPoliciesRequest.getPolicyName();
        ScalingPolicySuspension suspensions   = suspendScalingPoliciesRequest.getSuspension();

        RepoGenericResponse<SuspendedScalingPolicy> suspendScalingPoliciesResponse = getSpotinstElastigroupRepo()
                .suspendScalingPolicies(elastigroupId, policyName, suspensions, authToken, account);

        if (suspendScalingPoliciesResponse.isRequestSucceed()) {
            retVal = suspendScalingPoliciesResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = suspendScalingPoliciesResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to suspend scaling policies. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean removeSuspendedScalingPolicies(
            ElastigroupSuspendScalingPoliciesRequest suspendScalingPoliciesRequest) {

        Boolean retVal;

        String elastigroupId = suspendScalingPoliciesRequest.getGroupId();
        String policyName    = suspendScalingPoliciesRequest.getPolicyName();

        RepoGenericResponse<Boolean> removeResponse = getSpotinstElastigroupRepo()
                .removeSuspendedScalingPolicies(elastigroupId, policyName, authToken, account);

        if (removeResponse.isRequestSucceed()) {
            retVal = removeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = removeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to remove suspended scaling policies. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<SuspendedScalingPolicy> getAllSuspendedScalingPolicies(
            ElastigroupSuspendScalingPoliciesRequest suspendScalingPoliciesRequest) {

        List<SuspendedScalingPolicy> retVal;
        String                       elastigroupId = suspendScalingPoliciesRequest.getGroupId();

        RepoGenericResponse<SuspendedScalingPoliciesList> getAllResponse =
                getSpotinstElastigroupRepo().getAllSuspendedScalingPolicies(elastigroupId, authToken, account);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue().getScalePolicySuspensions();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to list suspended scaling policies. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public ElastigroupStartDeploymentResponse startDeployment(ElastigroupStartDeploymentRequest startDeploymentRequest, String elastigroupId) {

        ElastigroupStartDeploymentResponse isDeploymentStarted;

        ElastigroupStartDeployment elastigroupStartDeploymentRequest = startDeploymentRequest.getElastigroupDeployment();

        RepoGenericResponse<ElastigroupStartDeploymentResponse> startDeploymentResponse =
                getSpotinstElastigroupRepo().startDeployment(elastigroupId, elastigroupStartDeploymentRequest, authToken, account);

        if(startDeploymentResponse.isRequestSucceed()){
            isDeploymentStarted =startDeploymentResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = startDeploymentResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to start deployment. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isDeploymentStarted;

    }

    public ElastigroupStopDeploymentResponse stopDeployment(ElastigroupStopDeploymentRequest stopDeploymentRequest, String elastigroupId, String deploymentId) {

        ElastigroupStopDeploymentResponse isDeploymentStopped;

        //ElastigroupStopDeploymentRequest elastigroupStopDeploymentRequest = stopDeploymentRequest.getStopDeployment();

        RepoGenericResponse<ElastigroupStopDeploymentResponse> stopDeploymentResponse =
                getSpotinstElastigroupRepo().stopDeployment(stopDeploymentRequest, elastigroupId , deploymentId , authToken, account);

        if(stopDeploymentResponse.isRequestSucceed()){
            isDeploymentStopped = stopDeploymentResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = stopDeploymentResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to stop deployment. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isDeploymentStopped;

    }


    public ElastigroupGetDeploymentStatusResponse getDeploymentStatus(String elastigroupId, String deploymentId) {

        ElastigroupGetDeploymentStatusResponse getDeploymentResponse;

        RepoGenericResponse<ElastigroupGetDeploymentStatusResponse> getDeploymentStatusResponse =
                getSpotinstElastigroupRepo().getDeploymentStatus(elastigroupId, deploymentId , authToken, account);

        if(getDeploymentStatusResponse.isRequestSucceed()){
            getDeploymentResponse =getDeploymentStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getDeploymentStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get deployment status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getDeploymentResponse;

    }

    public List<ElastigroupGroupDeploymentStatusResponse> getGroupDeploymentStatus(String elastigroupId) {

        List<ElastigroupGroupDeploymentStatusResponse> getGroupDeploymentResponse;

        RepoGenericResponse<List<ElastigroupGroupDeploymentStatusResponse>> getGroupDeploymentStatusResponse =
                getSpotinstElastigroupRepo().getGroupDeploymentStatus(elastigroupId, authToken, account);

        if(getGroupDeploymentStatusResponse.isRequestSucceed()){
            getGroupDeploymentResponse =getGroupDeploymentStatusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getGroupDeploymentStatusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to group deployment status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getGroupDeploymentResponse;

    }

    public ElastigroupGetDeploymentActionResponse applyDeploymentAction(
            ElastigroupGetDeploymentActionRequest getDeploymentActionRequest, String elastigroupId, String deploymentId) {

        ElastigroupGetDeploymentActionResponse getGroupDeploymentResponse;

        ElastigroupDeploymentStrategyOnFailure
                getDeploymentActionRequestBody = getDeploymentActionRequest.getElastigroupDeploymentAction();

        RepoGenericResponse<ElastigroupGetDeploymentActionResponse> getDeploymentActionResponse =
                getSpotinstElastigroupRepo().applyDeploymentAction(getDeploymentActionRequestBody, elastigroupId,deploymentId, authToken, account);

        if(getDeploymentActionResponse.isRequestSucceed()){
            getGroupDeploymentResponse =getDeploymentActionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getDeploymentActionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to apply deployment status. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return getGroupDeploymentResponse;

    }


}