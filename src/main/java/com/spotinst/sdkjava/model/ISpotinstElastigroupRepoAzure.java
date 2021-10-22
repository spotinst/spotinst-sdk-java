package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ElastigroupSeverityEnumAzure;
import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.*;
import com.spotinst.sdkjava.model.requests.elastigroup.*;

import java.util.List;


public interface ISpotinstElastigroupRepoAzure extends IRepositoryAzure<ElastigroupAzure, GroupFilter, String> {

    default RepoGenericResponse<ElastigroupStatusAzure> getStatus(String groupId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ElastigroupScalingResponseAzure> scaleUp(String groupId, Integer adjustment, String authToken,
                                                                String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ElastigroupScalingResponseAzure> scaleDown(String groupId, Integer adjustment, String authToken,
                                                                String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ElastigroupAzure> importGroupFromScaleSet(String resourceGroupName, String scaleSetName, String authToken,
                                                                    String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ElastigroupAzure> importGroupFromVirtualMachine(String resourceGroupName,
                                                        String virtualMachineName, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> createVmSignal(ElastigroupCreateVmSignalRequestAzure elastigroupVmsignal,
                                                        String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ElastigroupUpdateCapacityAzure> updateCapacity(ElastigroupUpdateCapacityRequestAzure capacityRequest,
                                                                               String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<List<VmHealthinessAzure>> vmHealthiness(String groupId, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> suspendGroup(SuspendgroupRequestAzure suspendgroupRequest,
                                                      String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> resumeGroup(ResumegroupRequestAzure resumegroupRequest,
                                                      String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> vmProtection(String groupId, String vmName,
                                                     String authToken, String account, Integer ttlnMinutes) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<Boolean> vmRemoveProtection(String groupId, String vmName,
                                                      String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<ElastigroupDetachedVmsAzure> detachVms(DetachVmsRequestAzure detachVmsRequest,
                                                            String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }

    default RepoGenericResponse<GetElastilogAzure> getElastilog(String groupId, String authToken, String account,
                String fromDate, Integer limit, String resoucre_Id, ElastigroupSeverityEnumAzure severity, String toDate) {
        throw new SpotinstNotSupportedException();
    }
}
