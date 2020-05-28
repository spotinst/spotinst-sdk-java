package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;

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

    RepoGenericResponse<SuspendedProcesses> suspendProcesses(String groupId, List<ProcessSuspension> suspensions, String authToken, String account);

    RepoGenericResponse<SuspendedProcesses> removeSuspensions(String elastigroupId, List<ProcessNameEnum> processNames, String authToken, String account);

    RepoGenericResponse<SuspendedProcesses> getSuspendedProcesses(String elastigroupId, String authToken, String account);
}
