package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by yossi.elman on 24/05/2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiSuspendProcessesRequest {
    //region Members
    private List<ApiProcessSuspension> suspensions;
    //endregion

    //region Getters & Setters
    public List<ApiProcessSuspension> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(List<ApiProcessSuspension> suspensions) {
        this.suspensions = suspensions;
    }
    //endregion
}
