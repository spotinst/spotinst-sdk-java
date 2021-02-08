package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.ApiElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupConverterGcp;

import java.util.List;
import java.util.stream.Collectors;


class SpotinstElastigroupRepoGcp implements ISpotinstElastigroupRepoGcp{

    @Override
    public RepoGenericResponse<ElastigroupGcp> create(ElastigroupGcp elastigroupToCreate, String authToken, String account) {
        RepoGenericResponse<ElastigroupGcp> retVal;

        try {
            ApiElastigroupGcp apiElastigroupToCreate = ElastigroupConverterGcp.toDal(elastigroupToCreate);
            SpotinstElastigroupServiceGcp A = new SpotinstElastigroupServiceGcp();
            ApiElastigroupGcp apiCreatedElastigroup =
                    A.createElastigroup(apiElastigroupToCreate, authToken, account);

            ElastigroupGcp createdElastigroup = ElastigroupConverterGcp.toBl(apiCreatedElastigroup);
            retVal = new RepoGenericResponse<>(createdElastigroup);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstElastigroupServiceGcp.deleteElastigroup(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
    @Override
    public RepoGenericResponse<Boolean> update(String elastigroupId, ElastigroupGcp groupUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiElastigroupGcp apiElastigroup = ElastigroupConverterGcp.toDal(groupUpdate);

        try {
            Boolean success = SpotinstElastigroupServiceGcp.updateGroup(elastigroupId, apiElastigroup, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<List<ElastigroupGcp>> getAll(GroupFilter filter, String authToken, String account) {
        RepoGenericResponse<List<ElastigroupGcp>> retVal;

        try {
            List<ApiElastigroupGcp> apiElastigroups = SpotinstElastigroupServiceGcp.getAllGroups(filter, authToken, account);
            List<ElastigroupGcp> elastigroups =
                    apiElastigroups.stream().map(ElastigroupConverterGcp::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(elastigroups);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ElastigroupGcp> get(String elastigroupId, String authToken, String account) {
        RepoGenericResponse<ElastigroupGcp> retVal;

        try {
            ApiElastigroupGcp apiElastigroup = SpotinstElastigroupServiceGcp.getGroup(elastigroupId, authToken, account);
            ElastigroupGcp    elastigroup    = ElastigroupConverterGcp.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }



}
