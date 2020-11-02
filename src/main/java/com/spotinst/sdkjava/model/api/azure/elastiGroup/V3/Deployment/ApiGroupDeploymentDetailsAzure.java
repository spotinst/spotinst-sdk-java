package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGroupDeploymentDetailsAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String>                          isSet;
    private ApiDeploymentDetailsOverviewAzure    detailsOverview;
    private List<ApiDeploymentDetailsBatchAzure> batches;
    private List<ApiDeploymentDetailsEventAzure> events;
    //endregion

    //region constructor
    public ApiGroupDeploymentDetailsAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public ApiDeploymentDetailsOverviewAzure getDetailsOverview() {
        return detailsOverview;
    }

    public void setDetailsOverview(ApiDeploymentDetailsOverviewAzure detailsOverview) {
        this.detailsOverview = detailsOverview;
        touch("detailsOverview");
    }

    public List<ApiDeploymentDetailsBatchAzure> getBatches() {
        return batches;
    }

    public void setBatches(List<ApiDeploymentDetailsBatchAzure> batches) {
        this.batches = batches;
        touch("batches");
    }

    public List<ApiDeploymentDetailsEventAzure> getEvents() {
        return events;
    }

    public void setEvents(List<ApiDeploymentDetailsEventAzure> events) {
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
