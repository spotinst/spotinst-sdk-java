package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;

import java.util.List;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class RepoGenericResponse<T> {

    private boolean requestSucceed;
    private T value;
    private List<HttpError> httpErrors;

    public RepoGenericResponse(T value) {
        this.value = value;
        this.requestSucceed = true;
    }

    public RepoGenericResponse(boolean requestSucceed) {
        this.requestSucceed = requestSucceed;
    }

    public RepoGenericResponse(List<HttpError> httpErrors) {
        this.requestSucceed = false;
        this.httpErrors = httpErrors;
    }

    public boolean isRequestSucceed() {
        return requestSucceed;
    }

    public T getValue() {
        return value;
    }

    public List<HttpError> getHttpExceptions() {
        return httpErrors;
    }
}
