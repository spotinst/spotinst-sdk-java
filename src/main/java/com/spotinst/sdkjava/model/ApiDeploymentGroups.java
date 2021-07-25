package com.spotinst.sdkjava.model;

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
public class ApiDeploymentGroups implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      applicationName;
    private String      deploymentGroupName;

    //endregion

    //region Constructors
    public ApiDeploymentGroups() {
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

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        isSet.add("applicationName");
        this.applicationName = applicationName;
    }

    public String getDeploymentGroupName() {
        return deploymentGroupName;
    }

    public void setDeploymentGroupName(String deploymentGroupName) {
        isSet.add("deploymentGroupName");
        this.deploymentGroupName = deploymentGroupName;
    }

    //endregion

    //region isSet methods
    // Is applicationName Set boolean method
    @JsonIgnore
    public boolean isApplicationNameSet() {
        return isSet.contains("applicationName");
    }

    // Is deploymentGroupName Set boolean method
    @JsonIgnore
    public boolean isDeploymentGroupNameSet() {
        return isSet.contains("deploymentGroupName");
    }

    //endregion
}
