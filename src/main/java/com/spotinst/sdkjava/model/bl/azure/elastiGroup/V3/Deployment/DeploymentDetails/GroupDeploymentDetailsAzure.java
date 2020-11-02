package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupDeploymentDetailsAzure {
    //region members
    @JsonIgnore
    private Set<String>                       isSet;
    private DeploymentDetailsOverviewAzure    detailsOverview;
    private List<DeploymentDetailsBatchAzure> batches;
    private List<DeploymentDetailsEventAzure> events;
    //endregion

    //region constructor
    public GroupDeploymentDetailsAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        touch("isSet");
    }

    public DeploymentDetailsOverviewAzure getDetailsOverview() {
        return detailsOverview;
    }

    public void setDetailsOverview(DeploymentDetailsOverviewAzure detailsOverview) {
        this.detailsOverview = detailsOverview;
        touch("detailsOverview");
    }

    public List<DeploymentDetailsBatchAzure> getBatches() {
        return batches;
    }

    public void setBatches(List<DeploymentDetailsBatchAzure> batches) {
        this.batches = batches;
        touch("batches");
    }

    public List<DeploymentDetailsEventAzure> getEvents() {
        return events;
    }

    public void setEvents(List<DeploymentDetailsEventAzure> events) {
        this.events = events;
        touch("events");
    }

    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isDetailsOverviewSet() {
        return this.isSet.contains("detailsOverview");
    }
    @JsonIgnore
    public Boolean isBatchesSet() {
        return this.isSet.contains("batches");
    }
    @JsonIgnore
    public Boolean isEventsSet() {
        return this.isSet.contains("events");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
