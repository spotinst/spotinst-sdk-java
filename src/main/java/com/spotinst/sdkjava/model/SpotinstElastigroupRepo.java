package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.elastigroup.aws.*;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.converters.elastigroup.aws.ItfMigrationConverter;
import com.spotinst.sdkjava.model.converters.elastigroup.aws.ScalingPoliciesSuspensionConverter;
import com.spotinst.sdkjava.model.converters.elastigroup.aws.StatefulElastigroupConverter;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceUnLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.ApiRetryItfMigrationRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.RetryItfMigrationRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.ElastigroupStopDeploymentRequest;

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
    public RepoGenericResponse<Boolean> lockInstance(ElastigroupInstanceLockRequest lockRequest,
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
    public RepoGenericResponse<Boolean> unlockInstance(ElastigroupInstanceUnLockRequest unlockRequest,
                                                       String authToken, String instanceId) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotinstElastigroupService.unlockInstance(unlockRequest, authToken, instanceId);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }


    @Override
    public RepoGenericResponse<Boolean> simulateInstanceInterruption(String authToken, String account, List<String> instanceIds) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotinstElastigroupService.simulateInstanceInterruption(authToken, account, instanceIds);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }


    @Override
    public RepoGenericResponse<SuspendedScalingPolicy> suspendScalingPolicies(String elastiGroupId, String policyName,
                                                                              ScalingPolicySuspension suspensions,
                                                                              String authToken, String account) {
        RepoGenericResponse<SuspendedScalingPolicy> retVal;

        ApiScalingPolicySuspension apiSuspensions = ScalingPoliciesSuspensionConverter.toDal(suspensions);

        try {
            ApiSuspendedScalingPolicy apiResponse = SpotinstElastigroupService
                    .suspendScalingPolicies(elastiGroupId, policyName, apiSuspensions, authToken, account);
            SuspendedScalingPolicy suspendedProcesses = ScalingPoliciesSuspensionConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(suspendedProcesses);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<SuspendedScalingPoliciesList> getAllSuspendedScalingPolicies(String elastiGroupId,
                                                                                            String authToken,
                                                                                            String account) {
        RepoGenericResponse<SuspendedScalingPoliciesList> retVal;

        try {
            ApiSuspendedScalingPoliciesList suspendedApiResponse =
                    SpotinstElastigroupService.getSuspendedScalingPolicies(elastiGroupId, authToken, account);

            SuspendedScalingPoliciesList allSuspendedScalingPolicies =
                    ScalingPoliciesSuspensionConverter.toBl(suspendedApiResponse);

            retVal = new RepoGenericResponse<>(allSuspendedScalingPolicies);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> removeSuspendedScalingPolicies(String elastiGroupId, String policyName,
                                                                       String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean removeStatus =
                    SpotinstElastigroupService.removeSuspendScalingPolicies(elastiGroupId, policyName, authToken, account);
            retVal = new RepoGenericResponse<>(removeStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<ElastigroupStartDeploymentResponse> startDeployment(String elastigroupId, ElastigroupStartDeployment elastiGroupDeployment,
                                                                                   String authToken, String account) {
       RepoGenericResponse<ElastigroupStartDeploymentResponse> retVal = null;

        try {

            ApiElastigroupStartDeploymentResponse apiElastigroupDeployment = SpotinstElastigroupService
                    .startDeployment(elastigroupId, elastiGroupDeployment, authToken, account);

            ElastigroupStartDeploymentResponse
                    startDeploymentResponse =  ElastigroupConverter.toBl(apiElastigroupDeployment);

            retVal = new RepoGenericResponse<>(startDeploymentResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<ElastigroupStopDeploymentResponse> stopDeployment(
            ElastigroupStopDeploymentRequest elastiGroupDeployment, String elastigroupId, String deploymentId,
            String authToken, String account) {
        RepoGenericResponse<ElastigroupStopDeploymentResponse> retVal;

        try {

            ApiElastigroupStopDeploymentResponse apiStopDeployment = SpotinstElastigroupService
                    .stopDeployment(elastiGroupDeployment, elastigroupId, deploymentId, authToken, account);

            ElastigroupStopDeploymentResponse stopDeploymentResponse = ElastigroupConverter.toBl(apiStopDeployment);
            retVal = new RepoGenericResponse<>(stopDeploymentResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<ElastigroupGetDeploymentStatusResponse> getDeploymentStatus(String elastigroupId, String deploymentId,
                                                                                           String authToken, String account) {
        RepoGenericResponse<ElastigroupGetDeploymentStatusResponse> retVal = null;

        try {

            ApiElastigroupGetDeploymentStatusResponse apiElastigroupGetDeploymentStatusResponse = SpotinstElastigroupService
                    .getDeploymentStatus(elastigroupId, deploymentId, authToken, account);

            ElastigroupGetDeploymentStatusResponse
                    getDeploymentResponse =  ElastigroupConverter.toBl(apiElastigroupGetDeploymentStatusResponse);

            retVal = new RepoGenericResponse<>(getDeploymentResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<List<ElastigroupGroupDeploymentStatusResponse>> getGroupDeploymentStatus(String elastigroupId, String authToken, String account) {
        RepoGenericResponse<List<ElastigroupGroupDeploymentStatusResponse>> retVal ;

        try {

            List<ApiElastigroupGetGroupDeploymentStatusResponse> apiElastigroupGetGroupDeploymentStatusResponse = SpotinstElastigroupService
                    .getGroupDeploymentStatus(elastigroupId, authToken, account);

            List<ElastigroupGroupDeploymentStatusResponse> getGroupDeploymentResponse =
                    apiElastigroupGetGroupDeploymentStatusResponse.stream().map(ElastigroupConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getGroupDeploymentResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }


    @Override
    public RepoGenericResponse<ElastigroupGetDeploymentActionResponse> applyDeploymentAction(
            ElastigroupDeploymentStrategyOnFailure elastigroupGetDeploymentActionRequest, String elastigroupId, String deploymentId , String authToken, String account) {
        RepoGenericResponse<ElastigroupGetDeploymentActionResponse> retVal ;

        try {

            ApiElastigroupGetDeploymentActionResponse apiElastigroupGetDeploymentActionResponse = SpotinstElastigroupService
                    .applyDeploymentAction(elastigroupGetDeploymentActionRequest, elastigroupId, deploymentId, authToken, account);

            ElastigroupGetDeploymentActionResponse
                    getDeploymentActionResponse =  ElastigroupConverter.toBl(apiElastigroupGetDeploymentActionResponse);

            retVal = new RepoGenericResponse<>(getDeploymentActionResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<List<ItfMigrationRulesStatus>> getItfMigrationRulesStatus(String elastiGroupId,
                                                                                         String authToken,
                                                                                         String account) {
        RepoGenericResponse<List<ItfMigrationRulesStatus>> retVal;

        try {
            List<ApiItfMigrationRulesStatus> getMigrationApiResponse =
                    SpotinstElastigroupService.getItfMigrationRulesStatus(elastiGroupId, authToken, account);

            List<ItfMigrationRulesStatus> list =
                    getMigrationApiResponse.stream().map(ItfMigrationConverter::toBl)
                                            .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(list);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> retryItfMigration(String elastiGroupId, RetryItfMigrationRequest request,
                                                                       String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiRetryItfMigrationRequest apiRequest = ItfMigrationConverter.toDal(request);
            Boolean retryItfMigrationResponse =
                    SpotinstElastigroupService.retryItfMigration(elastiGroupId,apiRequest, authToken, account);

            retVal = new RepoGenericResponse<>(retryItfMigrationResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateCapacity(String elastigroupId, ElastigroupUpdateCapacityConfiguration elastiGroupUpdateCapacity,
                                                       String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {


            Boolean updateCapacityResponse = SpotinstElastigroupService
                    .updateCapacity(elastigroupId, elastiGroupUpdateCapacity, authToken, account);

            retVal = new RepoGenericResponse<>(updateCapacityResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Elastigroup> importEC2Instance(ElastigroupImportEC2Instance elastigroupImportInstance, String instanceId, String region, String authToken, String account) {
        RepoGenericResponse<Elastigroup> retVal;

        try {
            
            ApiElastigroup importEC2Instance = SpotinstElastigroupService
                    .importEC2Instance(elastigroupImportInstance, instanceId, region, authToken, account);
            Elastigroup importedEC2Instance = ElastigroupConverter.toBl(importEC2Instance);

            retVal = new RepoGenericResponse<>(importedEC2Instance);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Boolean> pauseStatefulInstance(String elastigroupId, String statefulInstanceId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean pauseStatefulInstanceResponse = SpotinstElastigroupService
                    .pauseStatefulInstance(elastigroupId, statefulInstanceId, authToken, account);

            retVal = new RepoGenericResponse<>(pauseStatefulInstanceResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Boolean> resumeStatefulInstance(String elastigroupId, String statefulInstanceId,
                                                       String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {


            Boolean resumeStatefulInstanceResponse = SpotinstElastigroupService
                    .resumeStatefulInstance(elastigroupId, statefulInstanceId, authToken, account);

            retVal = new RepoGenericResponse<>(resumeStatefulInstanceResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Boolean> recycleStatefulInstance(String elastigroupId, String statefulInstanceId,
                                                               String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {


            Boolean recycleStatefulInstanceResponse = SpotinstElastigroupService
                    .recycleStatefulInstance(elastigroupId, statefulInstanceId, authToken, account);

            retVal = new RepoGenericResponse<>(recycleStatefulInstanceResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Boolean> deallocateStatefulInstance(String elastigroupId, String statefulInstanceId,
                                                                String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {


            Boolean deallocateStatefulInstanceResponse = SpotinstElastigroupService
                    .deallocateStatefulInstance(elastigroupId, statefulInstanceId, authToken, account);

            retVal = new RepoGenericResponse<>(deallocateStatefulInstanceResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<List<ElastigroupListStatefulInstancesResponse>> listStatefulInstances(String elastigroupId, String authToken, String account) {
        RepoGenericResponse<List<ElastigroupListStatefulInstancesResponse>> retVal;

        try {

            List<ApiElastigroupListStatefulInstancesResponse> listStatefulInstances = SpotinstElastigroupService
                    .listStatefulInstances(elastigroupId, authToken, account);
            List<ElastigroupListStatefulInstancesResponse> statefulInstances = listStatefulInstances.stream().map(StatefulElastigroupConverter::toBl)
                                                                                .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(statefulInstances);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }

    @Override
    public RepoGenericResponse<Boolean> deleteVolumeInStatefulInstance(String elastigroupId, String statefulInstanceId, String volumeId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {


            Boolean deleteVolumeInStatefulInstanceResponse = SpotinstElastigroupService
                    .deleteVolumeInStatefulInstance(elastigroupId, statefulInstanceId, volumeId, authToken, account);

            retVal = new RepoGenericResponse<>(deleteVolumeInStatefulInstanceResponse);
        }

        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;

    }
}