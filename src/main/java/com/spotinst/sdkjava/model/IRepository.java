package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;

import java.util.List;

/**
 * Created by sniramsalem on 6/28/16.
 */
interface IRepository<S, F, I> {
    default RepoGenericResponse<S> get(I identifier, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<S>> getAll(F filter, String authToken, String account) {
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

    // TODO or: remove this, use delete and pass to repo same variable twice. Also put comment where you do that.
    default RepoGenericResponse<Boolean> deleteWithTokenOnly(String accountId, String authToken) {
        throw new SpotinstNotSupportedException();
    }
}
