package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;

import java.util.List;
import java.util.stream.Collectors;


class SpotinstElastigroupRepoAzure implements ISpotinstElastigroupRepoAzure{

    @Override
    public RepoGenericResponse<ElastigroupAzure> create(ElastigroupAzure elastigroupToCreate, String authToken, String account) {
        RepoGenericResponse<ElastigroupAzure> retVal;

        try {
            ApiElastigroupAzure apiElastigroupToCreate = ElastigroupConverterAzure.toDal(elastigroupToCreate);
            SpotinstElastigroupServiceAzure A = new SpotinstElastigroupServiceAzure();
            ApiElastigroupAzure apiCreatedElastigroup =
                    A.createElastigroup(apiElastigroupToCreate, authToken, account);

            ElastigroupAzure createdElastigroup = ElastigroupConverterAzure.toBl(apiCreatedElastigroup);
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
            Boolean updated = SpotinstElastigroupServiceAzure.deleteElastigroup(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
    @Override
    public RepoGenericResponse<Boolean> update(String elastigroupId, ElastigroupAzure groupUpdate, String authToken,
                                               String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiElastigroupAzure apiElastigroup = ElastigroupConverterAzure.toDal(groupUpdate);

        try {
            Boolean success = SpotinstElastigroupServiceAzure.updateGroup(elastigroupId, apiElastigroup, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<List<ElastigroupAzure>> getAll(GroupFilter filter, String authToken, String account) {
        RepoGenericResponse<List<ElastigroupAzure>> retVal;

        try {
            List<ApiElastigroupAzure> apiElastigroups = SpotinstElastigroupServiceAzure.getAllGroups(filter, authToken, account);
            List<ElastigroupAzure> elastigroups =
                    apiElastigroups.stream().map(ElastigroupConverterAzure::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(elastigroups);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ElastigroupAzure> get(String elastigroupId, String authToken, String account) {
        RepoGenericResponse<ElastigroupAzure> retVal;

        try {
            ApiElastigroupAzure apiElastigroup = SpotinstElastigroupServiceAzure.getGroup(elastigroupId, authToken, account);
            ElastigroupAzure    elastigroup    = ElastigroupConverterAzure.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }



}
