package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDeploymentGroup {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      applicationName;
    private String      deploymentGroupName;
    //endregion

    //region Constructors
    private ElastigroupDeploymentGroup() {
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

    public void setDeploymentGroupName(String deploymentGroupName) {
        isSet.add("deploymentGroupName");
        this.deploymentGroupName = deploymentGroupName;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDeploymentGroup deploymentGroups;

        private Builder() {
            this.deploymentGroups = new ElastigroupDeploymentGroup();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setApplicationName (final String applicationName){
            deploymentGroups.setApplicationName(applicationName);
            return this;
        }

        public Builder setDeploymentGroupName (final String deploymentGroupName){
            deploymentGroups.setDeploymentGroupName(deploymentGroupName);
            return this;
        }

        public ElastigroupDeploymentGroup build(){return deploymentGroups;}

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
