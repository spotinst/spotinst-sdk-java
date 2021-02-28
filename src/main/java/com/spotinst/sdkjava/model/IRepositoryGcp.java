package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;

import java.util.List;

interface IRepositoryGcp<S, F, I> {
    default RepoGenericResponse<S> get(I identifier, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<S>> getAll(F filter, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<S>> getAllStatus(I identifier, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> update(I identifier, S objectToUpdate, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<S> create(S objectToCreate, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> delete(I identifier, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }
}
