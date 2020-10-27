package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiGroupDeploymentDetailsAzure {
    //region members
    private ApiDeploymentDetailsOverviewAzure    detailsOverview;
    private List<ApiDeploymentDetailsBatchAzure> batches;
    private List<ApiDeploymentDetailsEventAzure> events;
    //endregion

    //region getters & setters
    public ApiDeploymentDetailsOverviewAzure getDetailsOverview() {
        return detailsOverview;
    }

    public void setDetailsOverview(ApiDeploymentDetailsOverviewAzure detailsOverview) {
        this.detailsOverview = detailsOverview;
    }

    public List<ApiDeploymentDetailsBatchAzure> getBatches() {
        return batches;
    }

    public void setBatches(List<ApiDeploymentDetailsBatchAzure> batches) {
        this.batches = batches;
    }

    public List<ApiDeploymentDetailsEventAzure> getEvents() {
        return events;
    }

    public void setEvents(List<ApiDeploymentDetailsEventAzure> events) {
        this.events = events;
    }
    //endregion

}
