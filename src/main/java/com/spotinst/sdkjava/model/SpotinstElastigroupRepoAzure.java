package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ElastigroupSeverityEnumAzure;
import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.requests.elastigroup.azure.*;

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

    @Override
    public RepoGenericResponse<GetElastigroupStatusResponseAzure> getStatus(String groupId, String authToken, String account) {
        RepoGenericResponse<GetElastigroupStatusResponseAzure> status;

        try {
            ApiGetElastigroupStatusResponseAzure apiGetElastigroupeStatus =
                    SpotinstElastigroupServiceAzure.getGroupStatus(groupId, authToken, account);
            GetElastigroupStatusResponseAzure getGroupStatus = ElastigroupConverterAzure.toBl(apiGetElastigroupeStatus);
            status = new RepoGenericResponse<>(getGroupStatus);
        }

        catch (SpotinstHttpException ex) {
            status = ExceptionHelper.handleHttpException(ex);
        }

        return status;
    }

    @Override
    public RepoGenericResponse<List<ScalingResponseVms>> scaleUp(String groupId, Integer adjustment,
                                                                 String authToken, String account) {
        RepoGenericResponse<List<ScalingResponseVms>> scaleUp;

        try {
            List<ApiScalingResponseVms> apiElastigroupScalingResponse =
                    SpotinstElastigroupServiceAzure.scaleGroupUp(groupId, adjustment, authToken, account);

            List<ScalingResponseVms> elastigroupScalingResponse =
            apiElastigroupScalingResponse.stream().map(ElastigroupConverterAzure::toBl).collect(Collectors.toList());
            scaleUp = new RepoGenericResponse<>(elastigroupScalingResponse);
        }
        catch (SpotinstHttpException e) {
            scaleUp = ExceptionHelper.handleHttpException(e);
        }

        return scaleUp;
    }

    @Override
    public RepoGenericResponse<List<ScalingResponseVms>> scaleDown(String groupId, Integer adjustment,
                                                                   String authToken, String account) {
        RepoGenericResponse<List<ScalingResponseVms>> scaleDown;

        try {
            List<ApiScalingResponseVms> apiElastigroupScalingResponse =
                    SpotinstElastigroupServiceAzure.scaleGroupDown(groupId, adjustment, authToken, account);

            List<ScalingResponseVms> elastigroupScalingResponse =
                    apiElastigroupScalingResponse.stream().map(ElastigroupConverterAzure::toBl).collect(Collectors.toList());
            scaleDown = new RepoGenericResponse<>(elastigroupScalingResponse);
        }
        catch (SpotinstHttpException e) {
            scaleDown = ExceptionHelper.handleHttpException(e);
        }

        return scaleDown;
    }

    @Override
    public RepoGenericResponse<ElastigroupAzure> importGroupFromScaleSet(String resourceGroupName, String scaleSetName,
                                                                         String authToken, String account) {
        RepoGenericResponse<ElastigroupAzure> retVal;

        try {
            ApiElastigroupAzure apiElastigroup = SpotinstElastigroupServiceAzure.importGroupFromScaleSet(resourceGroupName,
                                                    scaleSetName, authToken, account);
            ElastigroupAzure    elastigroup    = ElastigroupConverterAzure.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ElastigroupAzure> importGroupFromVirtualMachine(String resourceGroupName, String virtualMachineName,
                                                                         String authToken, String account) {
        RepoGenericResponse<ElastigroupAzure> retVal;

        try {
            ApiElastigroupAzure apiElastigroup = SpotinstElastigroupServiceAzure.importGroupFromVirtualMachine(resourceGroupName,
                    virtualMachineName, authToken, account);
            ElastigroupAzure    elastigroup    = ElastigroupConverterAzure.toBl(apiElastigroup);
            retVal = new RepoGenericResponse<>(elastigroup);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> createVmSignal(ElastigroupCreateVmSignalRequestAzure elastigroupVmSignal, String authToken, String account) {
        RepoGenericResponse<Boolean> vmSignal;

        try {
            Boolean created = SpotinstElastigroupServiceAzure.createVmSignal(elastigroupVmSignal, authToken, account);
            vmSignal = new RepoGenericResponse<>(created);

        }
        catch (SpotinstHttpException e) {
            vmSignal = ExceptionHelper.handleHttpException(e);
        }

        return vmSignal;
    }

    @Override
    public RepoGenericResponse<UpdateCapacityAzure> updateCapacity(ElastigroupUpdateCapacityRequestAzure updateCapacity, String authToken, String account) {
        RepoGenericResponse<UpdateCapacityAzure> isCapacityUpdated;

        try {
            ApiUpdateCapacityAzure apiUpdated = SpotinstElastigroupServiceAzure.updateCapacity(updateCapacity, authToken, account);
            UpdateCapacityAzure updateCapacityResponse =
                    ElastigroupConverterAzure.toBl(apiUpdated);
            isCapacityUpdated = new RepoGenericResponse<>(updateCapacityResponse);

        }
        catch (SpotinstHttpException e) {
            isCapacityUpdated = ExceptionHelper.handleHttpException(e);
        }

        return isCapacityUpdated;
    }

    @Override
    public RepoGenericResponse<List<VmHealthinessAzure>> vmHealthiness(String groupId, String authToken, String account) {
        RepoGenericResponse<List<VmHealthinessAzure>> getVmHealthiness;

        try {
            List<ApiVmHealthinessAzure> apiVmHealthiness = SpotinstElastigroupServiceAzure.vmHealthiness(groupId, authToken, account);
            List<VmHealthinessAzure> vmHealthinessResponse =
            apiVmHealthiness.stream().map(ElastigroupConverterAzure::toBl).collect(Collectors.toList());
            getVmHealthiness = new RepoGenericResponse<> (vmHealthinessResponse);

        }
        catch (SpotinstHttpException e) {
            getVmHealthiness = ExceptionHelper.handleHttpException(e);
        }

        return getVmHealthiness;
    }

    @Override
    public RepoGenericResponse<Boolean> suspendGroup(SuspendgroupRequestAzure requestAzure, String authToken, String account) {
        RepoGenericResponse<Boolean> suspendGroup;

        try {
            Boolean apiSuspendgroup = SpotinstElastigroupServiceAzure.suspendGroup(requestAzure, authToken, account);
            suspendGroup = new RepoGenericResponse<>(apiSuspendgroup);

        }
        catch (SpotinstHttpException e) {
            suspendGroup = ExceptionHelper.handleHttpException(e);
        }

        return suspendGroup;
    }

    @Override
    public RepoGenericResponse<Boolean> resumeGroup(ResumegroupRequestAzure groupId, String authToken, String account) {
        RepoGenericResponse<Boolean> resumeGroup;

        try {
            Boolean apiResumegroup = SpotinstElastigroupServiceAzure.resumeGroup(groupId, authToken, account);
            resumeGroup = new RepoGenericResponse<>(apiResumegroup);

        }
        catch (SpotinstHttpException e) {
            resumeGroup = ExceptionHelper.handleHttpException(e);
        }

        return resumeGroup;
    }

    @Override
    public RepoGenericResponse<Boolean> vmProtection(String groupId, String vmName, String authToken, String account,
                                                     Integer timeLimit) {
        RepoGenericResponse<Boolean> vmProtect;

        try {
            Boolean apiVmProtect= SpotinstElastigroupServiceAzure.vmProtection(groupId, vmName, authToken, account, timeLimit);
            vmProtect = new RepoGenericResponse<>(apiVmProtect);

        }
        catch (SpotinstHttpException e) {
            vmProtect = ExceptionHelper.handleHttpException(e);
        }

        return vmProtect;
    }

    @Override
    public RepoGenericResponse<Boolean> vmRemoveProtection(String groupId, String vmName,
                                                     String authToken, String account) {
        RepoGenericResponse<Boolean> vmRemoveProtect;

        try {
            Boolean apiVmRemoveProtect= SpotinstElastigroupServiceAzure.vmRemoveProtection(groupId, vmName, authToken, account);
            vmRemoveProtect = new RepoGenericResponse<>(apiVmRemoveProtect);

        }
        catch (SpotinstHttpException e) {
            vmRemoveProtect = ExceptionHelper.handleHttpException(e);
        }

        return vmRemoveProtect;
    }

    @Override
    public RepoGenericResponse<DetachVmsResponseAzure> detachVms(DetachVmsRequestAzure groupId, String authToken, String account) {
        RepoGenericResponse<DetachVmsResponseAzure> detachVms;

        try {
            ApiElastigroupDetachedVmsAzure apiDetachedVms = SpotinstElastigroupServiceAzure.detachVms(groupId, authToken, account);
            DetachVmsResponseAzure detachedVms =
                    ElastigroupConverterAzure.toBl(apiDetachedVms);
            detachVms = new RepoGenericResponse<>(detachedVms);

        }
        catch (SpotinstHttpException e) {
            detachVms = ExceptionHelper.handleHttpException(e);
        }

        return detachVms;
    }

    @Override
    public RepoGenericResponse<GetElastilogResponseAzure> getElastilog(String elastigroupId, String authToken, String account,
                                                                       String fromDate, Integer limit, String resoucre_Id,
                                                                       ElastigroupSeverityEnumAzure severity, String toDate) {
        RepoGenericResponse<GetElastilogResponseAzure> retVal;

        try {
            ApiGetElastilogResponseAzure apiElastilog = SpotinstElastigroupServiceAzure.getElastilog(elastigroupId, authToken,
                    account, fromDate, limit, resoucre_Id, severity, toDate);
            GetElastilogResponseAzure elastilogAzure    = ElastigroupConverterAzure.toBl(apiElastilog);
            retVal = new RepoGenericResponse<>(elastilogAzure);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
