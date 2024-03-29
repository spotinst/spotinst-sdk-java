package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElasticBeanstalk {
    //region Members
    @JsonIgnore
    private Set<String>                                isSet;
    private String                                     environmentId;
    private ElastigroupDeploymentPreferences           deploymentPreferences;
    private ManagedActions                             managedActions;
    //endregion

    //region Constructor

    private ElasticBeanstalk() {
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

    public ElastigroupDeploymentPreferences getDeploymentPreferences() {
        return deploymentPreferences;
    }

    public void setDeploymentPreferences(ElastigroupDeploymentPreferences deploymentPreferences) {
        isSet.add("deploymentPreferences");
        this.deploymentPreferences = deploymentPreferences;
    }

    public ManagedActions getManagedActions() {
        return managedActions;
    }

    public void setManagedActions(ManagedActions managedActions) {
        isSet.add("managedActions");
        this.managedActions = managedActions;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElasticBeanstalk beanstalk;

        private Builder() {
            this.beanstalk = new ElasticBeanstalk();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setEnvironmentId(final String environmentId) {
            beanstalk.setEnvironmentId(environmentId);
            return this;
        }

        public Builder setDeploymentPreferences(final ElastigroupDeploymentPreferences deploymentPreferences) {
            beanstalk.setDeploymentPreferences(deploymentPreferences);
            return this;
        }

        public Builder setManagedActions(final ManagedActions managedActions) {
            beanstalk.setManagedActions(managedActions);
            return this;
        }

        public ElasticBeanstalk build() {
            return beanstalk;
        }
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
