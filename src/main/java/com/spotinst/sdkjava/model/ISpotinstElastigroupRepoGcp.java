package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceLockRequestGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceUnLockRequestGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupScalingRequestGcp;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScalingResponseGcp;

interface ISpotinstElastigroupRepoGcp extends IRepositoryGcp<ElastigroupGcp, GroupFilter, String> {
    RepoGenericResponse<Boolean> lockInstance(ElastigroupInstanceLockRequestGcp lockRequest,
                                              String authToken, String instanceId);

    RepoGenericResponse<Boolean> unlockInstance(ElastigroupInstanceUnLockRequestGcp unlockRequest,
                                                String authToken, String instanceId);
    RepoGenericResponse<ElastigroupScalingResponseGcp> scaleUp(ElastigroupScalingRequestGcp scalingRequestGcp, String authToken,
                                                               String account);

    RepoGenericResponse<ElastigroupScalingResponseGcp> scaleDown(ElastigroupScalingRequestGcp scalingRequestGcp,
                                                              String authToken, String account);
}
