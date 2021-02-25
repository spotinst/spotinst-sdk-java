package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.ApiInstanceHealthinessGcp;
import java.util.List;
import java.util.stream.Collectors;

public class SpotinstElastigroupInstanceHealthinessRepoGcp implements ISpotinstElastigroupInstanceHealthinessRepoGcp {

    // todo or: this is getting a single group's status, no getAll
    @Override
    public RepoGenericResponse<List<ElastigroupInstanceHealthinessGcp>> getAll(String elastigroupId, String authToken,
                                                                            String account) {
        RepoGenericResponse<List<ElastigroupInstanceHealthinessGcp>> retVal;

        try {
            // todo or: rename
            List<ElastigroupInstanceHealthinessGcp> instanceHealthinesses;
            List<ApiInstanceHealthinessGcp> apiInstanceHealthinesses =
                    SpotinstElastigroupServiceGcp.getInstanceHealthiness(elastigroupId, authToken, account);

            instanceHealthinesses =
                    apiInstanceHealthinesses.stream().map(ApiElastigroupInstanceHealthinessConverterGcp::dalToBl)
                                            .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(instanceHealthinesses);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}