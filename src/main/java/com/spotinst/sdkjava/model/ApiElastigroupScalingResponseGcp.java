package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Saikumar Jalda on 20/01/2022.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiElastigroupScalingResponseGcp {
    //region Members
    private List<ApiNewSpotRequest> newSpotRequests;
    private List<ApiNewInstance>    newInstances;
    //endregion
    //region Getter an Setter methods

    public List<ApiNewSpotRequest> getNewSpotRequests() {
        return newSpotRequests;
    }

    public void setNewSpotRequests(List<ApiNewSpotRequest> newSpotRequests) {
        this.newSpotRequests = newSpotRequests;
    }

    public List<ApiNewInstance> getNewInstances() {
        return newInstances;
    }

    public void setNewInstances(List<ApiNewInstance> newInstances) {
        this.newInstances = newInstances;
    }

    //endregion
}
