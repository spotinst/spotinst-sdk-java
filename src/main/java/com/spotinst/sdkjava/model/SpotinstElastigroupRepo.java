package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

/**
 * Created by talzur on 11/01/2017.
 */
class SpotinstElastigroupRepo implements ISpotinstElastigroupRepo {
    @Override
    public RepoGenericResponse<Elastigroup> create(Elastigroup elastigroupToCreate, String authToken, String account) {
        RepoGenericResponse<Elastigroup> retVal;

        try {
            ApiElastigroup apiElastigroupToCreate = ElastigroupConverter.toDal(elastigroupToCreate);
            ApiElastigroup apiCreatedElastigroup = SpotinstElastigroupService.createElastigroup(apiElastigroupToCreate, authToken, account);
            Elastigroup createdElastigroup = ElastigroupConverter.toBl(apiCreatedElastigroup);
            retVal = new RepoGenericResponse<>(createdElastigroup);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstElastigroupService.deleteElastigroup(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> detachInstances(String elastigroupId, ElastigroupDetachInstancesRequest detachRequest, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            ApiDetachInstancesRequest apiDetachRequest =
                    ApiDetachInstancesRequestConverter.toDal(detachRequest);
            SpotinstElastigroupService.detachInstances(elastigroupId, apiDetachRequest, authToken, account);
            retVal = new RepoGenericResponse<>(new Boolean(true));
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String elastigroupId, Elastigroup groupUpdate, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        ApiElastigroup apiElastigroup = ElastigroupConverter.toDal(groupUpdate);

        try {
            Boolean success = SpotinstElastigroupService.updateGroup(elastigroupId, apiElastigroup, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Elastigroup> get(String elastigroupId, String authToken,String account) {
        RepoGenericResponse<Elastigroup> retVal;

        try {
            ApiElastigroup apiElastigroup = SpotinstElastigroupService.getGroup(elastigroupId, authToken, account);
            Elastigroup elastigroup = ElastigroupConverter.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ElastigroupScalingResponse> scaleUp(ElastigroupScalingRequest scalingRequest, String authToken, String account) {
        RepoGenericResponse<ElastigroupScalingResponse> retVal;

        try {
            ApiElastigroupScalingResponse apiElastigroupScalingResponse = SpotinstElastigroupService.scaleGroupUp(scalingRequest, authToken, account);
            // Convert
            ElastigroupScalingResponse elastigroupScalingResponse = ApiElastigroupScalingResponseConverter.dalToBl(apiElastigroupScalingResponse);
            retVal = new RepoGenericResponse<>(elastigroupScalingResponse);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }


}
