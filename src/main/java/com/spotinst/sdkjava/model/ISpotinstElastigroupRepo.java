package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.*;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceUnLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.ElastigroupGetElastilogRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.RetryItfMigrationRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.ElastigroupStopDeploymentRequest;

import java.util.List;

/**
 * Created by talzur on 11/01/2017.
 */
interface ISpotinstElastigroupRepo extends IRepository<Elastigroup, GroupFilter, String> {
    RepoGenericResponse<Boolean> detachInstances(String groupId, ElastigroupDetachInstancesRequest detachRequest,
                                                 String authToken, String account);

    RepoGenericResponse<ElastigroupScalingResponse> scaleUp(ElastigroupScalingRequest scalingRequest, String authToken,
                                                            String account);

    RepoGenericResponse<ElastigroupScalingResponse> scaleDown(ElastigroupScalingRequest scalingRequest,
                                                              String authToken, String account);

    RepoGenericResponse<Elastigroup> clone(String sourceElastigroupId, Elastigroup groupModifications, String authToken,
                                           String account);

    RepoGenericResponse<Boolean> enterInstanceStandby(String instanceId, String authToken, String account);

    RepoGenericResponse<Boolean> exitInstanceStandby(String instanceId, String authToken, String account);

    RepoGenericResponse<SuspendedProcesses> suspendProcesses(String groupId, List<ProcessSuspension> suspensions,
                                                             String authToken, String account);

    RepoGenericResponse<SuspendedProcesses> removeSuspensions(String elastigroupId, List<ProcessNameEnum> processNames,
                                                              String authToken, String account);

    RepoGenericResponse<SuspendedProcesses> getSuspendedProcesses(String elastigroupId, String authToken,
                                                                  String account);

    RepoGenericResponse<Boolean> delete(String elastigroupId, String authToken, String account,
                                        ApiDeleteGroupRequest deleteRequest);

    RepoGenericResponse<Boolean> lockInstance(ElastigroupInstanceLockRequest lockRequest,
                                              String authToken, String instanceId);

    RepoGenericResponse<Boolean> unlockInstance(ElastigroupInstanceUnLockRequest unlockRequest,
                                                String authToken, String instanceId);

    RepoGenericResponse<Boolean> simulateInstanceInterruption(String authToken, String account, List<String> instanceIds);

    RepoGenericResponse<SuspendedScalingPolicy> suspendScalingPolicies(String elastigroupId, String policyName,
                                                                       ScalingPolicySuspension suspension,
                                                                       String authToken, String account);

    RepoGenericResponse<Boolean> removeSuspendedScalingPolicies(String elastigroupId, String policyName,
                                                                String authToken, String account);

    RepoGenericResponse<SuspendedScalingPoliciesList> getAllSuspendedScalingPolicies(String elastigroupId,
                                                                                     String authToken, String account);

    RepoGenericResponse<ElastigroupStartDeploymentResponse> startDeployment(String elastigroupId, ElastigroupStartDeployment elastigroupStartDeployment, String authToken, String account);

    RepoGenericResponse<ElastigroupStopDeploymentResponse> stopDeployment(
            ElastigroupStopDeploymentRequest elastigroupStopDeployment, String elastigroupId, String deploymentId , String authToken, String account);

    RepoGenericResponse<ElastigroupGetDeploymentStatusResponse> getDeploymentStatus(String elastigroupId, String deploymentId , String authToken, String account);

    RepoGenericResponse<List<ElastigroupGroupDeploymentStatusResponse>> getGroupDeploymentStatus(String elastigroupId, String authToken, String account);

    RepoGenericResponse<ElastigroupGetDeploymentActionResponse> applyDeploymentAction(
            ElastigroupDeploymentStrategyOnFailure getDeploymentActionRequest , String elastigroupId, String deploymentId , String authToken, String account);

    RepoGenericResponse<List<ItfMigrationRulesStatus>> getItfMigrationRulesStatus(String elastigroupId,
                                                                                  String authToken, String account);

    RepoGenericResponse<Boolean> retryItfMigration(String elastiGroupId, RetryItfMigrationRequest request,
                                                          String authToken, String account);

    RepoGenericResponse<Boolean> updateCapacity(String elastigroupId, ElastigroupUpdateCapacityConfiguration elastigroupUpdateCapacity, String authToken, String account);

    RepoGenericResponse<Elastigroup> importEC2Instance(ElastigroupImportEC2Instance elastigroupImportInstance, String instanceId, String region,
                                                       String authToken, String account);

    RepoGenericResponse<Boolean> pauseStatefulInstance(String elastigroupId, String statefulInstanceId,
                                              String authToken, String account);

    RepoGenericResponse<Boolean> resumeStatefulInstance(String elastigroupId, String statefulInstanceId,
                                                       String authToken, String account);

    RepoGenericResponse<Boolean> recycleStatefulInstance(String elastigroupId, String statefulInstanceId,
                                                        String authToken, String account);

    RepoGenericResponse<Boolean> deallocateStatefulInstance(String elastigroupId, String statefulInstanceId,
                                                         String authToken, String account);

    RepoGenericResponse<List<ElastigroupListStatefulInstancesResponse>> listStatefulInstances(String elastigroupId, String authToken, String account);

    RepoGenericResponse<Boolean> deleteVolumeInStatefulInstance(String elastigroupId, String statefulInstanceId, String volumeId, String authToken, String account);

    RepoGenericResponse<List<ElastigroupGetElastilogResponse>> getElastilog(ElastigroupGetElastilogRequest elastigroupGetElastilogRequest, String elastigroupId, String authToken);

}
