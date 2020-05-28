package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yossi.elman on 24/05/2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ApiSuspendedProcesses {

    //region Members
    private String                           groupId;
    private List<String>                     processes;
    private List<ApiProcessSuspensionResult> suspensions;
    //endregion

    //region Constructor
    public ApiSuspendedProcesses() {
    }

    public ApiSuspendedProcesses(String groupId) {
        this.groupId = groupId;
        this.suspensions = new LinkedList<>();
        this.processes = new LinkedList<>();
    }
    //endregion

    //region Getters & Setters
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getProcesses() {
        return processes;
    }

    public void setProcesses(List<String> processes) {
        this.processes = processes;
    }

    public List<ApiProcessSuspensionResult> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(List<ApiProcessSuspensionResult> suspensions) {
        this.suspensions = suspensions;
    }
    //endregion
}
