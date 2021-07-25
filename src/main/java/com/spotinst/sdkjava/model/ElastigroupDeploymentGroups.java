package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDeploymentGroups {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      applicationName;
    private String      deploymentGroupName;
    //endregion

    //region Constructors
    private ElastigroupDeploymentGroups() {
        isSet = new HashSet<>();
    }
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

    public void setApplicationName (String applicationName) {
        isSet.add("applicationName");
        this.applicationName = applicationName;
    }

    public String getDeploymentGroupName() {
        return deploymentGroupName;
    }

    public void setDeploymentGroupName(String DeploymentGroupName) {
        isSet.add("DeploymentGroupName");
        this.deploymentGroupName = DeploymentGroupName;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDeploymentGroups deploymentGroups;

        private Builder() {
            this.deploymentGroups = new ElastigroupDeploymentGroups();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setapplicationName (final String applicationName){
            deploymentGroups.setApplicationName(applicationName);
            return this;
        }

        public Builder setDeploymentGroupName (final String deploymentGroupName){
            deploymentGroups.setDeploymentGroupName(deploymentGroupName);
            return this;
        }

        public ElastigroupDeploymentGroups build(){return deploymentGroups;}

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
        return isSet.contains("DeploymentGroupName");
    }

    //endregion
}
