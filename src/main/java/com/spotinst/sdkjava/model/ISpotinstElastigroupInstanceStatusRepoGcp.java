package com.spotinst.sdkjava.model;

import java.util.List;


interface ISpotinstElastigroupInstanceStatusRepoGcp {

    RepoGenericResponse<List<GroupActiveInstanceStatusGcp>> getAll(String elastigroupId, String authToken,
                                                                   String account);
}
