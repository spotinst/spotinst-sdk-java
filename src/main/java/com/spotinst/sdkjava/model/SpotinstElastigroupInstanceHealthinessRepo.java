package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yossi.elman on 13/04/2020.
 */
public class SpotinstElastigroupInstanceHealthinessRepo implements ISpotinstElastigroupInstanceHealthinessRepo {

    @Override
    public RepoGenericResponse<List<ElastigroupInstanceHealthiness>> getAll(String elastigroupId, String authToken,
                                                                            String account) {
        RepoGenericResponse<List<ElastigroupInstanceHealthiness>> retVal;

        try {
            List<ElastigroupInstanceHealthiness> instanceHealthinesses;
            List<ApiInstanceHealthiness> apiInstanceHealthinesses =
                    SpotinstElastigroupService.getInstanceHealthiness(elastigroupId, authToken, account);

            instanceHealthinesses =
                    apiInstanceHealthinesses.stream().map(ApiElastigroupInstanceHealthinessConverter::dalToBl)
                                            .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(instanceHealthinesses);

        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}
