package com.spotinst.sdkjava.model;

import java.util.List;

/**
 * Created by yossi.elman on 13/04/2020.
 */
interface ISpotinstElastigroupInstanceHealthinessRepo {

    RepoGenericResponse<List<ElastigroupInstanceHealthiness>> getAll(String elastigroupId, String authToken, String account);
}
