package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by talzur on 11/01/2017.
 */
class SpotinstElastigroupActiveInstanceRepo implements ISpotinstElastigroupActiveInstanceRepo {
    @Override
    public RepoGenericResponse<List<ElastigroupActiveInstance>> getAll(ActiveInstanceFilter filter, String authToken) {
        RepoGenericResponse<List<ElastigroupActiveInstance>> retVal;

        try {
            List<ElastigroupActiveInstance> elastigroupActiveInstances = new LinkedList<>();
            List<ApiElastigroupActiveInstance> apiElastigroupActiveInstances = SpotinstElastigroupService.getGroupActiveInstances(filter.getElastigroupId(),authToken);
            for (ApiElastigroupActiveInstance apiElastigroupActiveInstance : apiElastigroupActiveInstances) {

                ElastigroupActiveInstance elastigroupActiveInstance = ApiElastigroupActiveInstanceConverter.dalToBl(apiElastigroupActiveInstance);
                elastigroupActiveInstances.add(elastigroupActiveInstance);
            }

            retVal = new RepoGenericResponse<>(elastigroupActiveInstances);

        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
