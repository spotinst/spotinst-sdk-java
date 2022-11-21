package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupDeploymentPreferences;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ManagedActions;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElasticBeanstalk implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                isSet;
    private String                                     environmentId;
    private ApiElastigroupDeploymentPreferences        deploymentPreferences;
    private ApiManagedActions                          managedActions;
    //endregion

    //region Constructor

    public ApiElasticBeanstalk() {
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

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        isSet.add("environmentId");
        this.environmentId = environmentId;
    }

    public ApiElastigroupDeploymentPreferences getDeploymentPreferences() {
        return deploymentPreferences;
    }

    public void setDeploymentPreferences(ApiElastigroupDeploymentPreferences deploymentPreferences) {
        isSet.add("deploymentPreferences");
        this.deploymentPreferences = deploymentPreferences;
    }

    public ApiManagedActions getManagedActions() {
        return managedActions;
    }

    public void setManagedActions(ApiManagedActions managedActions) {
        isSet.add("managedActions");
        this.managedActions = managedActions;
    }

    //endregion

    //region isSet methods
    // Is environmentId Set boolean method
    @JsonIgnore
    public boolean isEnvironmentIdSet() {
        return isSet.contains("environmentId");
    }

    // Is deploymentPreferences Set boolean method
    @JsonIgnore
    public boolean isDeploymentPreferencesSet() {
        return isSet.contains("deploymentPreferences");
    }

    // Is managedActions Set boolean method
    @JsonIgnore
    public boolean isManagedActionsSet() {
        return isSet.contains("managedActions");
    }

    //endregion

}
