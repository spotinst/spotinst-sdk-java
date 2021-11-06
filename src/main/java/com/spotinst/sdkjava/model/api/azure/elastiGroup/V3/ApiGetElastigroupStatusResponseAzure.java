package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.ElastigroupStatusEnumAzure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGetElastigroupStatusResponseAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                 isSet;
    private ElastigroupStatusEnumAzure                  status;
    private List<ApiScalingResponseSuspendedProcessAzure>   suspendedProcesses;
    private List<ApiGroupStatusResponseVmsAzure>                           vms;

    public ApiGetElastigroupStatusResponseAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupStatusEnumAzure getStatus() {
        return status;
    }

    public void setStatus(ElastigroupStatusEnumAzure status) {
        isSet.add("status");
        this.status = status;
    }

    public List<ApiScalingResponseSuspendedProcessAzure> getSuspendedProcesses() {
        return suspendedProcesses;
    }

    public void setSuspendedProcesses(List<ApiScalingResponseSuspendedProcessAzure> suspendedProcesses) {
        isSet.add("suspendedProcesses");
        this.suspendedProcesses = suspendedProcesses;
    }

    public List<ApiGroupStatusResponseVmsAzure> getVms() {
        return vms;
    }

    public void setVms(List<ApiGroupStatusResponseVmsAzure> vms) {
        isSet.add("vms");
        this.vms = vms;
    }


    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isSuspendedProcessesSet() {
        return isSet.contains("suspendedProcesses");
    }

    @JsonIgnore
    public boolean isVmsSet() {
        return isSet.contains("vms");
    }

}
