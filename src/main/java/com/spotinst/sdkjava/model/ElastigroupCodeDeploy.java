package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupCodeDeploy {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private Boolean                           cleanUpOnFailure;
    private Boolean                           terminateInstanceOnFailure;
//    TODO or: rename obj to ElastigroupDeploymentGroups
    private List<ElastigroupDeploymentGroups> deploymentGroups;
    //endregion

    //region Constructor

    private ElastigroupCodeDeploy() {
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

    public List<ElastigroupDeploymentGroups> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<ElastigroupDeploymentGroups> deploymentGroups) {
        isSet.add("deploymentGroups");
        this.deploymentGroups = deploymentGroups;
    }

    //endregion
    //region Builder class
    public static class Builder {
//        TODO or: wrong member name
        private ElastigroupCodeDeploy ecs;

        private Builder() {
            this.ecs = new ElastigroupCodeDeploy();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCleanUpOnFailure(final Boolean cleanUpOnFailure) {
            ecs.setCleanUpOnFailure(cleanUpOnFailure);
            return this;
        }

        public Builder setTerminateInstanceOnFailure(final Boolean terminateInstanceOnFailure) {
            ecs.setTerminateInstanceOnFailure(terminateInstanceOnFailure);
            return this;
        }

        public Builder setDeploymentGroups(final List<ElastigroupDeploymentGroups> deploymentGroups) {
            ecs.setDeploymentGroups(deploymentGroups);
            return this;
        }

        public ElastigroupCodeDeploy build() {
            return ecs;
        }
    }
    //endregion

    //region isSet methods
    // Is terminateInstanceOnFailure Set boolean method
    @JsonIgnore
    public boolean isTerminateInstanceOnFailureSet() {
        return isSet.contains("terminateInstanceOnFailure");
    }

    // Is cleanUpOnFailure Set boolean method
    @JsonIgnore
    public boolean isCleanUpOnFailureSet() {
        return isSet.contains("cleanUpOnFailure");
    }

    // Is deploymentGroups Set boolean method
    @JsonIgnore
    public boolean isDeploymentGroupsSet() {
        return isSet.contains("deploymentGroups");
    }

    //endregion

}
