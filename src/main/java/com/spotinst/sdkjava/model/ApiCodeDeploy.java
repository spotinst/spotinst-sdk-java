package com.spotinst.sdkjava.model;

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
class ApiCodeDeploy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                  cleanUpOnFailure;
    private Boolean                  terminateInstanceOnFailure;
    private List<ApiDeploymentGroup> deploymentGroups;
    //endregion

    public ApiCodeDeploy() {
        isSet = new HashSet<>();
    }

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiDeploymentGroup> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<ApiDeploymentGroup> deploymentGroups) {
        isSet.add("deploymentGroups");
        this.deploymentGroups = deploymentGroups;
    }

    public Boolean getCleanUpOnFailure() {
        return cleanUpOnFailure;
    }

    public void setCleanUpOnFailure(Boolean cleanUpOnFailure) {
        isSet.add("cleanUpOnFailure");
        this.cleanUpOnFailure = cleanUpOnFailure;
    }

    public Boolean getTerminateInstanceOnFailure() {
        return terminateInstanceOnFailure;
    }

    public void setTerminateInstanceOnFailure(Boolean terminateInstanceOnFailure) {
        isSet.add("terminateInstanceOnFailure");
        this.terminateInstanceOnFailure = terminateInstanceOnFailure;
    }
    //endregion

    //region Isset Methods
    // Is deploymentGroups Set boolean method
    @JsonIgnore
    public boolean isDeploymentGroupsSet() {
        return isSet.contains("deploymentGroups");
    }

    // Is cleanUpOnFailure Set boolean method
    @JsonIgnore
    public boolean isCleanUpOnFailureSet() {
        return isSet.contains("cleanUpOnFailure");
    }

    // Is terminateInstanceOnFailure Set boolean method
    @JsonIgnore
    public boolean isTerminateInstanceOnFailureSet() {
        return isSet.contains("terminateInstanceOnFailure");
    }

    //endregion
}
