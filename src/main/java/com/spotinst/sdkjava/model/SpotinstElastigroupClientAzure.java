package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.enums.ElastigroupSeverityEnumAzure;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;
import com.spotinst.sdkjava.model.requests.elastigroup.azure.*;
import com.spotinst.sdkjava.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstElastigroupClientAzure {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstElastigroupClientAzure.class);
    //region Members
    private   String                         authToken;
    private   String                         account;
    private   ISpotinstElastigroupRepoAzure  spotinstElastigroupRepo;
    //endregion


    public ISpotinstElastigroupRepoAzure getSpotinstElastigroupRepoAzure() {
        return this.spotinstElastigroupRepo;
    }

    public void setSpotinstElastigroupRepoAzure() {
        this.spotinstElastigroupRepo = SpotinstRepoManager.getInstance().getSpotinstElastigroupRepoAzure();
    }

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

        ElastigroupAzure retVal;

        String elastigroupId = elastigroupGetRequest.getElastigroupId();
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupAzure> elastigroupRepoGenericResponse =
                repoAzure.get(elastigroupId, authToken, account);

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

    public ElastigroupStatusAzure getGroupStatus(String groupId) {
        ElastigroupStatusAzure status = null;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupStatusAzure> statusResponse =
                repoAzure.getStatus(groupId, authToken, account);

        if (statusResponse.isRequestSucceed()) {
            status = statusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = statusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the status of Elastigroup. Code: %s. Message: %s.",
                    groupId,httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return status;
    }

    public List<ElastigroupScalingVms> scaleGroupUp(String groupId, Integer adjustment) {
        List<ElastigroupScalingVms> scaleUp = null;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();

        RepoGenericResponse<List<ElastigroupScalingVms>> elastigroupScalingResponse =
                repoAzure.scaleUp(groupId, adjustment, authToken, account);

        if (elastigroupScalingResponse.isRequestSucceed()) {
            scaleUp = elastigroupScalingResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupScalingResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to scale group up. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return scaleUp;
    }

    public List<ElastigroupScalingVms> scaleGroupDown(String groupId, Integer adjustment) {
        List<ElastigroupScalingVms> scaleDown = null;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<List<ElastigroupScalingVms>> elastigroupScalingResponse =
                repoAzure.scaleDown(groupId, adjustment, authToken, account);

        if (elastigroupScalingResponse.isRequestSucceed()) {
            scaleDown = elastigroupScalingResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupScalingResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to scale group down. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return scaleDown;
    }

    public ElastigroupAzure importGroupFromScaleSet(String resourceGroupName, String scaleSetName) {
        ElastigroupAzure isGroupImported;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupAzure> elastigroupRepoGenericResponse =
                repoAzure.importGroupFromScaleSet(resourceGroupName, scaleSetName, authToken, account);

        if (elastigroupRepoGenericResponse.isRequestSucceed()) {
            LOGGER.info(String.format("imported successfully the group from %s", resourceGroupName));
            isGroupImported = elastigroupRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to import the group : %s. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isGroupImported;
    }

    public ElastigroupAzure importGroupFromVirtalMachine(String resourceGroupName, String virtualMachineName) {
        ElastigroupAzure isGroupImported;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupAzure> elastigroupRepoGenericResponse =
                repoAzure.importGroupFromVirtualMachine(resourceGroupName, virtualMachineName, authToken, account);

        if (elastigroupRepoGenericResponse.isRequestSucceed()) {
            LOGGER.info(String.format("imported successfully the group from %s", resourceGroupName));
            isGroupImported = elastigroupRepoGenericResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupRepoGenericResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to import the group : %s. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isGroupImported;
    }

    public Boolean createVmSignal(ElastigroupCreateVmSignalRequestAzure vmSignalRequestAzure) {
        Boolean isCreated = false;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> createResponse =
                repoAzure.createVmSignal(vmSignalRequestAzure, authToken, account);

        if (createResponse.isRequestSucceed()) {
            isCreated = createResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = createResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create elastigroup vm signal. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isCreated;
    }

    public ElastigroupUpdateCapacityAzure updateCapacity(ElastigroupUpdateCapacityRequestAzure capacityRequestAzure) {
        ElastigroupUpdateCapacityAzure isUpdatedCapacity = null;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();

        RepoGenericResponse<ElastigroupUpdateCapacityAzure> elastigroupUpdateCapacityResponse =
                repoAzure.updateCapacity(capacityRequestAzure, authToken, account);

        if (elastigroupUpdateCapacityResponse.isRequestSucceed()) {
            isUpdatedCapacity = elastigroupUpdateCapacityResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = elastigroupUpdateCapacityResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to update the elastigroup capacity. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return isUpdatedCapacity;
    }

    public List<VmHealthinessAzure> vmHealthiness(String groupId) {
        List<VmHealthinessAzure> isVmHealthy = null;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<List<VmHealthinessAzure>> vmHealthinessResponse =
                repoAzure.vmHealthiness(groupId, authToken, account);

        if (vmHealthinessResponse.isRequestSucceed()) {
            isVmHealthy = vmHealthinessResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = vmHealthinessResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get vm healthiness. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return isVmHealthy;
    }

    public Boolean suspendGroup(SuspendgroupRequestAzure suspendGroupRequest) {
        Boolean isSuspended = false;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> suspendResponse =
                repoAzure.suspendGroup(suspendGroupRequest, authToken, account);

        if (suspendResponse.isRequestSucceed()) {
            isSuspended = suspendResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = suspendResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to suspend the group. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isSuspended;
    }

    public Boolean resumeGroup(ResumegroupRequestAzure resumeGroupRequest) {
        Boolean isResumed = false;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> resumeResponse =
                repoAzure.resumeGroup(resumeGroupRequest, authToken, account);

        if (resumeResponse.isRequestSucceed()) {
            isResumed = resumeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = resumeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to resume the group. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isResumed;
    }

    public Boolean vmProtection(String groupId, String vmName, Integer timeLimit) {
        Boolean isVmProtected = false;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> vmProtectResponse =
                repoAzure.vmProtection(groupId, vmName, authToken, account, timeLimit);

        if (vmProtectResponse.isRequestSucceed()) {
            isVmProtected = vmProtectResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = vmProtectResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to protect the virtual machine. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isVmProtected;
    }

    public Boolean vmRemoveProtection(String groupId, String vmName) {
        Boolean isVmProtectionRemoved = false;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<Boolean> vmRemoveProtectResponse =
                repoAzure.vmRemoveProtection(groupId, vmName, authToken, account);

        if (vmRemoveProtectResponse.isRequestSucceed()) {
            isVmProtectionRemoved = vmRemoveProtectResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = vmRemoveProtectResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to remove the virtual machine protection. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isVmProtectionRemoved;
    }

    public ElastigroupDetachedVmsAzure detachVms(DetachVmsRequestAzure detachVmsRequestAzure) {
        ElastigroupDetachedVmsAzure isVmDetached = null;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<ElastigroupDetachedVmsAzure> detachResponse =
                repoAzure.detachVms(detachVmsRequestAzure, authToken, account);

        if (detachResponse.isRequestSucceed()) {
            isVmDetached = detachResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = detachResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to detaching vm. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isVmDetached;
    }

    public GetElastilogAzure getElastilog(String groupId, String fromDate, Integer limit, String resoucre_Id,
                                          ElastigroupSeverityEnumAzure severity, String toDate) {
        GetElastilogAzure elastiLog;
        SpotinstRepoManager           managerInstance = SpotinstRepoManager.getInstance();
        ISpotinstElastigroupRepoAzure repoAzure       = managerInstance.getSpotinstElastigroupRepoAzure();
        RepoGenericResponse<GetElastilogAzure> statusResponse =
                repoAzure.getElastilog(groupId, authToken, account, fromDate, limit, resoucre_Id, severity, toDate);

        if (statusResponse.isRequestSucceed()) {
            elastiLog = statusResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = statusResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get the logs for Elastigroup. Code: %s. Message: %s.",
                    groupId,httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return elastiLog;
    }

    //endregion
}
