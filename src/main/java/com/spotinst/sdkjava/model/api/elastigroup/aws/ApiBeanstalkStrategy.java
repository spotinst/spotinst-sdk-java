package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiBeanstalkStrategy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      action;
    private Boolean     shouldDrainInstances;
    //endregion

    //region Constructors
    public ApiBeanstalkStrategy() {
        isSet = new HashSet<>();
    }
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        isSet.add("action");
        this.action = action;
    }

    public Boolean getShouldDrainInstances() {
        return shouldDrainInstances;
    }

    public void setShouldDrainInstances(Boolean shouldDrainInstances) {
        isSet.add("shouldDrainInstances");
        this.shouldDrainInstances = shouldDrainInstances;
    }

    //endregion

    //region isSet methods
    // Is action Set boolean method
    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    // Is shouldDrainInstances Set boolean method
    @JsonIgnore
    public boolean isShouldDrainInstancesSet() {
        return isSet.contains("shouldDrainInstances");
    }
    //endregion
}
