package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by yossi.elman on 24/05/2020.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiRemoveSuspensionsRequest {
    //region Members
    private List<String> processes;
    //endregion

    //region Getters & Setters
    public List<String> getProcesses() {
        return processes;
    }

    public void setProcesses(List<String> processes) {
        this.processes = processes;
    }
    //endregion
}
