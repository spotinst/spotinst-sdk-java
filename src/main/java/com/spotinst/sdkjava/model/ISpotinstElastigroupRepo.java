package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ScalingPolicySuspension;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.SuspendedScalingPoliciesList;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceLockRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.ElastigroupInstanceUnLockRequest;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.SuspendedScalingPolicy;

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

    RepoGenericResponse<Boolean> enterStandby(String groupId, String authToken, String account);

    RepoGenericResponse<Boolean> exitStandby(String groupId, String authToken, String account);

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

    RepoGenericResponse<ElastigroupGetGroupDeploymentStatusResponse> getGroupDeploymentStatus(String elastigroupId, String authToken, String account);

    RepoGenericResponse<ElastigroupGetDeploymentActionResponse> getDeploymentAction(ElastigroupGetDeploymentActionRequest getDeploymentActionRequest ,String elastigroupId, String deploymentId ,String authToken, String account);
}
