package com.spotinst.sdkjava.model;

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

    RepoGenericResponse<Boolean> enterStandby(ElastigroupStandbyRequest standbyRequest, String authToken,
                                           String account);

    RepoGenericResponse<Boolean> exitStandby(ElastigroupStandbyRequest standbyRequest, String authToken,
                                                  String account);
}
