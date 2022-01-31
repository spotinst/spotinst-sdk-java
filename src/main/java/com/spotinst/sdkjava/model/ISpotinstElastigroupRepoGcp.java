package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupScaleDownResponseGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupScaleUpResponseGcp;

import java.util.List;

interface ISpotinstElastigroupRepoGcp extends IRepositoryGcp<ElastigroupGcp, GroupFilter, String> {
    RepoGenericResponse<Boolean> lockInstance(String authToken, String accountId, String ttlInMinutes, String instanceId);

    RepoGenericResponse<Boolean> unlockInstance(String authToken, String accountId, String instanceId);

    RepoGenericResponse<List<ElastigroupScaleUpResponseGcp>> scaleUp(String groupId, String adjustment, String authToken, String account);

    RepoGenericResponse<List<ElastigroupScaleDownResponseGcp>> scaleDown(String groupId, String adjustment, String authToken, String account);
}
