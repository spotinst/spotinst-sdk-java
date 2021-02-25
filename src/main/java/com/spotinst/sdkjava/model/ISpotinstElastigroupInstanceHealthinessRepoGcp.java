package com.spotinst.sdkjava.model;

import java.util.List;

// todo or: check whether this is not needed (it's used mainly in status?)
interface ISpotinstElastigroupInstanceHealthinessRepoGcp {

    RepoGenericResponse<List<ElastigroupInstanceHealthinessGcp>> getAll(String elastigroupId, String authToken,
                                                                          String account);
}
