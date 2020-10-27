package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import java.util.List;

public class GroupDeploymentDetailsAzure {
    //region members
    private DeploymentDetailsOverviewAzure    detailsOverview;
    private List<DeploymentDetailsBatchAzure> batches;
    private List<DeploymentDetailsEventAzure> events;
    //endregion

    //region getters & setters
    public DeploymentDetailsOverviewAzure getDetailsOverview() {
        return detailsOverview;
    }

    public void setDetailsOverview(DeploymentDetailsOverviewAzure detailsOverview) {
        this.detailsOverview = detailsOverview;
    }

    public List<DeploymentDetailsBatchAzure> getBatches() {
        return batches;
    }

    public void setBatches(List<DeploymentDetailsBatchAzure> batches) {
        this.batches = batches;
    }

    public List<DeploymentDetailsEventAzure> getEvents() {
        return events;
    }

    public void setEvents(List<DeploymentDetailsEventAzure> events) {
        this.events = events;
    }
    //endregion
}
