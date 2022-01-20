package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceLockRequestGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceUnLockRequestGcp;

interface ISpotinstElastigroupRepoGcp extends IRepositoryGcp<ElastigroupGcp, GroupFilter, String> {
    RepoGenericResponse<Boolean> lockInstance(ElastigroupInstanceLockRequestGcp lockRequest,
                                              String authToken, String instanceId);

    RepoGenericResponse<Boolean> unlockInstance(ElastigroupInstanceUnLockRequestGcp unlockRequest,
                                                String authToken, String instanceId);
}
