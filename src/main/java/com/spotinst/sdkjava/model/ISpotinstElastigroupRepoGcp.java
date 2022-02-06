package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.gcp.*;

import java.util.List;

interface ISpotinstElastigroupRepoGcp extends IRepositoryGcp<ElastigroupGcp, GroupFilter, String> {
    RepoGenericResponse<Boolean> lockInstance(String authToken, String accountId, String ttlInMinutes, String instanceId);

    RepoGenericResponse<Boolean> unlockInstance(String authToken, String accountId, String instanceId);

    RepoGenericResponse<List<ElastigroupScaleUpResponseGcp>> scaleUp(String elastigroupId, String adjustment, String authToken, String account);

    RepoGenericResponse<List<ElastigroupScaleDownResponseGcp>> scaleDown(String elastigroupId, String adjustment, String authToken, String account);
}
