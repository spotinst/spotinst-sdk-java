package com.spotinst.sdkjava.exception;

import com.spotinst.sdkjava.model.RepoGenericResponse;

import java.util.List;

/**
 * Created by aharontwizer on 8/26/15.
 */
public class ExceptionHelper {

    public static <T> RepoGenericResponse<T> handleHttpException(SpotinstHttpException exc) {
        RepoGenericResponse<T> retVal;

        if (exc instanceof SpotinstHttpErrorsException) {
            List<HttpError> httpErrors = ((SpotinstHttpErrorsException) exc).getHttpErrors();
            retVal = new RepoGenericResponse<>(httpErrors);
        } else {
            retVal = new RepoGenericResponse<>(false);
        }

        return retVal;
    }
}
