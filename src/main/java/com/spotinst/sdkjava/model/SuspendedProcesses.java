package com.spotinst.sdkjava.model;

import java.util.List;

/**
 * Created by yossi.elman on 24/05/2020.
 */
public class SuspendedProcesses {
    private String                        groupId;
    private List<ProcessSuspensionResult> suspensions;
    private List<String>                  processes;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<ProcessSuspensionResult> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(List<ProcessSuspensionResult> suspensions) {
        this.suspensions = suspensions;
    }

    public List<String> getProcesses() {
        return processes;
    }

    public void setProcesses(List<String> processes) {
        this.processes = processes;
    }
}
