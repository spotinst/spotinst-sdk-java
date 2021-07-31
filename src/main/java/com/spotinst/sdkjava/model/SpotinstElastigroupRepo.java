package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by talzur on 11/01/2017.
 */
class SpotinstElastigroupRepo implements ISpotinstElastigroupRepo {

    @Override
    public RepoGenericResponse<Elastigroup> create(Elastigroup elastigroupToCreate, String authToken, String account) {
        RepoGenericResponse<Elastigroup> retVal;

        try {
            ApiElastigroup apiElastigroupToCreate = ElastigroupConverter.toDal(elastigroupToCreate);
            ApiElastigroup apiCreatedElastigroup =
                    SpotinstElastigroupService.createElastigroup(apiElastigroupToCreate, authToken, account);
            Elastigroup createdElastigroup = ElastigroupConverter.toBl(apiCreatedElastigroup);
            retVal = new RepoGenericResponse<>(createdElastigroup);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstElastigroupService.deleteElastigroup(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String elastigroupId, String authToken, String account,
                                               ApiDeleteGroupRequest deleteRequest) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated =
                    SpotinstElastigroupService.deleteElastigroup(elastigroupId, authToken, account, deleteRequest);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> detachInstances(String elastigroupId,
                                                        ElastigroupDetachInstancesRequest detachRequest,
                                                        String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiDetachInstancesRequest apiDetachRequest = ApiDetachInstancesRequestConverter.toDal(detachRequest);
            SpotinstElastigroupService.detachInstances(elastigroupId, apiDetachRequest, authToken, account);
            retVal = new RepoGenericResponse<>(new Boolean(true));
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String elastigroupId, Elastigroup groupUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiElastigroup apiElastigroup = ElastigroupConverter.toDal(groupUpdate);

        try {
            Boolean success = SpotinstElastigroupService.updateGroup(elastigroupId, apiElastigroup, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Elastigroup> get(String elastigroupId, String authToken, String account) {
        RepoGenericResponse<Elastigroup> retVal;

        try {
            ApiElastigroup apiElastigroup = SpotinstElastigroupService.getGroup(elastigroupId, authToken, account);
            Elastigroup    elastigroup    = ElastigroupConverter.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<Elastigroup>> getAll(GroupFilter filter, String authToken, String account) {
        RepoGenericResponse<List<Elastigroup>> retVal;

        try {
            List<ApiElastigroup> apiElastigroups = SpotinstElastigroupService.getAllGroups(filter, authToken, account);
            List<Elastigroup> elastigroups =
                    apiElastigroups.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(elastigroups);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    /**
     * This function is used to scale up an Elastigroup. It is called from the SpotinstElastigroupClient.scaleUp() function
     * It sends the request to SpotinstElastigroupService.scaleGroupUp() then formats the response to get a Scaling Response
     *
     * @param scalingRequest ElastigroupScalingRequest object that is sent from SpotinstElastigroupClient
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @return elastigroupScalingResponse
     */
    @Override
    public RepoGenericResponse<ElastigroupScalingResponse> scaleUp(ElastigroupScalingRequest scalingRequest,
                                                                   String authToken, String account) {
        RepoGenericResponse<ElastigroupScalingResponse> retVal;

        try {
            ApiElastigroupScalingResponse apiElastigroupScalingResponse =
                    SpotinstElastigroupService.scaleGroupUp(scalingRequest, authToken, account);
            // Convert
            ElastigroupScalingResponse elastigroupScalingResponse =
                    ApiElastigroupScalingResponseConverter.dalToBl(apiElastigroupScalingResponse);
            retVal = new RepoGenericResponse<>(elastigroupScalingResponse);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    /**
     * This function is used to scale down an Elastigroup. It is called from the SpotinstElastigroupClient.scaleDown() function
     * It sends the request to SpotinstElastigroupService.scaleGroupDown() then formats the response to get a Scaling Response
     *
     * @param scalingRequest ElastigroupScalingRequest object that is sent from SpotinstElastigroupClient
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @return elastigroupScalingResponse
     */
    @Override
    public RepoGenericResponse<ElastigroupScalingResponse> scaleDown(ElastigroupScalingRequest scalingRequest,
                                                                     String authToken, String account) {
        RepoGenericResponse<ElastigroupScalingResponse> retVal;

        try {
            ApiElastigroupScalingResponse apiElastigroupScalingResponse =
                    SpotinstElastigroupService.scaleGroupDown(scalingRequest, authToken, account);
            // Convert
            ElastigroupScalingResponse elastigroupScalingResponse =
                    ApiElastigroupScalingResponseConverter.dalToBl(apiElastigroupScalingResponse);
            retVal = new RepoGenericResponse<>(elastigroupScalingResponse);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Elastigroup> clone(String sourceElastigroupId, Elastigroup groupModifications,
                                                  String authToken, String account) {
        RepoGenericResponse<Elastigroup> retVal;
        ApiElastigroup                   apiGroupModifications = ElastigroupConverter.toDal(groupModifications);

        try {
            ApiElastigroup apiClonedElastigroup = SpotinstElastigroupService
                    .cloneGroup(sourceElastigroupId, apiGroupModifications, authToken, account);
            Elastigroup clonedElastigroup = ElastigroupConverter.toBl(apiClonedElastigroup);
            retVal = new RepoGenericResponse<>(clonedElastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> enterStandby(String groupId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotinstElastigroupService.enterGroupStandby(groupId, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> exitStandby(String groupId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotinstElastigroupService.exitGroupStandby(groupId, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<SuspendedProcesses> suspendProcesses(String groupId, List<ProcessSuspension> suspensions,
                                                                    String authToken, String account) {
        RepoGenericResponse<SuspendedProcesses> retVal;
        ApiSuspendProcessesRequest              request = new ApiSuspendProcessesRequest();

        List<ApiProcessSuspension> apiSuspensions =
                suspensions.stream().map(ApiProcessSuspensionConverter::toDal).collect(Collectors.toList());
        request.setSuspensions(apiSuspensions);

        try {
            ApiSuspendedProcesses apiResponse =
                    SpotinstElastigroupService.suspendProcesses(groupId, request, authToken, account);
            SuspendedProcesses suspendedProcesses = ApiProcessSuspensionConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(suspendedProcesses);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<SuspendedProcesses> removeSuspensions(String elastigroupId,
                                                                     List<ProcessNameEnum> processes, String authToken,
                                                                     String account) {
        RepoGenericResponse<SuspendedProcesses> retVal;
        ApiRemoveSuspensionsRequest             request = new ApiRemoveSuspensionsRequest();

        List<String> processNames = processes.stream().map(ProcessNameEnum::getName).collect(Collectors.toList());
        request.setProcesses(processNames);

        try {
            ApiSuspendedProcesses apiResponse =
                    SpotinstElastigroupService.removeSuspensions(elastigroupId, request, authToken, account);
            SuspendedProcesses suspendedProcesses = ApiProcessSuspensionConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(suspendedProcesses);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<SuspendedProcesses> getSuspendedProcesses(String elastigroupId, String authToken,
                                                                         String account) {
        RepoGenericResponse<SuspendedProcesses> retVal;

        try {
            ApiSuspendedProcesses apiResponse =
                    SpotinstElastigroupService.getSuspendedProcesses(elastigroupId, authToken, account);
            SuspendedProcesses suspendedProcesses = ApiProcessSuspensionConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(suspendedProcesses);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> lockInstance(ElastigroupInstanceLockUnlockRequest lockRequest,
                                                     String authToken, String instanceId) {
        RepoGenericResponse<Boolean> retVal;
        try {
            Boolean success = SpotinstElastigroupService.lockInstance(lockRequest, authToken, instanceId);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> unlockInstance(ElastigroupInstanceLockUnlockRequest unlockRequest,
                                                       String authToken, String instanceId) {
        RepoGenericResponse<Boolean> retVal;
        try {
            Boolean success = SpotinstElastigroupService.unlockInstance(unlockRequest, authToken, instanceId);
            retVal = new RepoGenericResponse<>(success);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }
}
