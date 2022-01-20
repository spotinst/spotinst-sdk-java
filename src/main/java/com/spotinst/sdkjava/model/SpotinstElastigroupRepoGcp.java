package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.ApiElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupConverterGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceLockRequestGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupInstanceUnLockRequestGcp;
import com.spotinst.sdkjava.model.requests.elastigroup.gcp.ElastigroupScalingRequestGcp;
import com.spotinst.sdkjava.model.responses.elastigroup.gcp.ElastigroupScalingResponseGcp;

import java.util.List;
import java.util.stream.Collectors;


class SpotinstElastigroupRepoGcp implements ISpotinstElastigroupRepoGcp {

    @Override
    public RepoGenericResponse<ElastigroupGcp> create(ElastigroupGcp elastigroupToCreate, String authToken,
                                                      String account) {
        RepoGenericResponse<ElastigroupGcp> retVal;

        try {
            ApiElastigroupGcp             apiElastigroupToCreate = ElastigroupConverterGcp.toDal(elastigroupToCreate);
            SpotinstElastigroupServiceGcp elastigroupServiceGcp = new SpotinstElastigroupServiceGcp();

            ApiElastigroupGcp             apiCreatedElastigroup  = elastigroupServiceGcp.createElastigroup(apiElastigroupToCreate, authToken, account);

            ElastigroupGcp createdElastigroup = ElastigroupConverterGcp.toBl(apiCreatedElastigroup);
            retVal = new RepoGenericResponse<>(createdElastigroup);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }


    @Override
    public RepoGenericResponse<Boolean> delete(String elastigroupId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstElastigroupServiceGcp.deleteElastigroup(elastigroupId, authToken, account);
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

        try {
            ApiElastigroupGcp apiElastigroup = ElastigroupConverterGcp.toDal(groupUpdate);
            Boolean success =
                    SpotinstElastigroupServiceGcp.updateGroup(elastigroupId, apiElastigroup, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<ElastigroupGcp>> getAll(String authToken, String account) {
        RepoGenericResponse<List<ElastigroupGcp>> retVal;

        try {
            List<ApiElastigroupGcp> apiElastigroups =
                    SpotinstElastigroupServiceGcp.getAllGroups(authToken, account);
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
            ApiElastigroupGcp apiElastigroup =
                    SpotinstElastigroupServiceGcp.getGroup(elastigroupId, authToken, account);
            ElastigroupGcp elastigroup = ElastigroupConverterGcp.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> lockInstance(ElastigroupInstanceLockRequestGcp lockRequest,
                                                     String authToken, String instanceId) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotinstElastigroupServiceGcp.lockInstance(lockRequest, authToken, instanceId);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> unlockInstance(ElastigroupInstanceUnLockRequestGcp unlockRequest,
                                                       String authToken, String instanceId) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = SpotinstElastigroupServiceGcp.unlockInstance(unlockRequest, authToken, instanceId);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    /*
     * This function is used to scale up an Elastigroup. It is called from the SpotinstElastigroupClient.scaleUp() function
     * It sends the request to SpotinstElastigroupService.scaleGroupUp() then formats the response to get a Scaling Response
     *
     * @param scalingRequest ElastigroupScalingRequest object that is sent from SpotinstElastigroupClient
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @return elastigroupScalingResponse
     */
    @Override
    public RepoGenericResponse<ElastigroupScalingResponseGcp> scaleUp(ElastigroupScalingRequestGcp scalingRequestGcp,
                                                                      String authToken, String account) {
        RepoGenericResponse<ElastigroupScalingResponseGcp> retVal;

        try {
            ApiElastigroupScalingResponseGcp apiElastigroupScalingResponseGcp =
                    SpotinstElastigroupServiceGcp.scaleGroupUp(scalingRequestGcp, authToken, account);
            // Convert
            ElastigroupScalingResponseGcp elastigroupScalingResponseGcp =
                    ApiElastigroupScalingResponseConverterGcp.dalToBl(apiElastigroupScalingResponseGcp);
            retVal = new RepoGenericResponse<>(elastigroupScalingResponseGcp);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    /*
     * This function is used to scale down an Elastigroup. It is called from the SpotinstElastigroupClient.scaleDown() function
     * It sends the request to SpotinstElastigroupService.scaleGroupDown() then formats the response to get a Scaling Response
     *
     * @param scalingRequest ElastigroupScalingRequest object that is sent from SpotinstElastigroupClient
     * @param authToken      User Spotinst API token
     * @param account        User Spotinst account ID
     * @return elastigroupScalingResponse
     */
    @Override
    public RepoGenericResponse<ElastigroupScalingResponseGcp> scaleDown(ElastigroupScalingRequestGcp scalingRequestGcp,
                                                                     String authToken, String account) {
        RepoGenericResponse<ElastigroupScalingResponseGcp> retVal;

        try {
            ApiElastigroupScalingResponseGcp apiElastigroupScalingResponseGcp =
                    SpotinstElastigroupServiceGcp.scaleGroupDown(scalingRequestGcp, authToken, account);
            // Convert
            ElastigroupScalingResponseGcp elastigroupScalingResponseGcp =
                    ApiElastigroupScalingResponseConverterGcp.dalToBl(apiElastigroupScalingResponseGcp);
            retVal = new RepoGenericResponse<>(elastigroupScalingResponseGcp);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }


}
