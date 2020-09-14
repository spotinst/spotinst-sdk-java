package com.spotinst.sdkjava.model;

import java.util.List;

interface ISpotinstElastigroupInstanceHealthinessRepoAzure {

    RepoGenericResponse<List<ElastigroupInstanceHealthinessAzure>> getAll(String elastigroupId, String authToken,
                                                                     String account);
}
