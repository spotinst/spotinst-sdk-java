package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiResourceRequirements;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiInstanceTypes implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       ondemand;
    private List<String> ondemandtypes;
    private List<String> spot;
    private List<String> preferredspot;
    private List<ApiInstanceTypesWeights> weights;
    private ApiResourceRequirements resourcerequirements;
    //endregion

    //region Constructor

    public ApiInstanceTypes() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getSpot() {
        return spot;
    }

    public void setSpot(List<String> spot) {
        isSet.add("spot");
        this.spot = spot;
    }

    public List<String> getPreferredSpot() {
        return preferredspot;
    }

    public void setPreferredSpot(List<String> preferredspot) {
        isSet.add("preferredSpot");
        this.preferredspot = preferredspot;
    }

    public String getOndemand() {
        return ondemand;
    }

    public void setOndemand(String ondemand) {
        isSet.add("ondemand");
        this.ondemand = ondemand;
    }

    public List<String> getOnDemandTypes() {
        return ondemandtypes;
    }

    public void setOnDemandTypes(List<String> ondemandtypes) {
        isSet.add("onDemandTypes");
        this.ondemandtypes = ondemandtypes;
    }

    public List<ApiInstanceTypesWeights> getWeights() {
        return weights;
    }

    public void setWeights(List<ApiInstanceTypesWeights> weights) {
        isSet.add("weights");
        this.weights = weights;
    }

    public ApiResourceRequirements getResourceRequirements() {
        return resourcerequirements;
    }

    public void setResourceRequirements(ApiResourceRequirements requirements) {
        isSet.add("resourceRequirements");
        this.resourcerequirements = requirements;
    }

    //endregion

    //region isSet methods

    // Is ondemand Set boolean method
    @JsonIgnore
    public boolean isOndemandSet() {
        return isSet.contains("ondemand");
    }

    @JsonIgnore
    public boolean isOnDemandTypesSet() {
        return isSet.contains("onDemandTypes");
    }

    // Is spot Set boolean method
    @JsonIgnore
    public boolean isSpotSet() {
        return isSet.contains("spot");
    }

    // Is preferredSpot Set boolean method
    @JsonIgnore
    public boolean isPreferredSpotSet() {
        return isSet.contains("preferredSpot");
    }

    // Is weights Set boolean method
    @JsonIgnore
    public boolean isWeightsSet() {
        return isSet.contains("weights");
    }

    @JsonIgnore
    public boolean isResourceRequirementsSet() {
        return isSet.contains("resourceRequirements");
    }
    //endregion

}
