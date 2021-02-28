package com.spotinst.sdkjava.model;

import java.util.List;

// todo oz: check whether this is not needed (it's used mainly in status?) - DONE - used to get instance status
interface ISpotinstElastigroupInstanceStatusRepoGcp {

    RepoGenericResponse<List<GroupActiveInstanceStatusGcp>> getAll(String elastigroupId, String authToken,
                                                                   String account);
}
