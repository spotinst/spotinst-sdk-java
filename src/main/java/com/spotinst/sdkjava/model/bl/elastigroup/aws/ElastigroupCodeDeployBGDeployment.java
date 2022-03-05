package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ElastigroupDeploymentGroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ElastigroupCodeDeployBGDeployment implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           timeout;
    private List<ElastigroupDeploymentTags>  deploymentTags;
    private List<ElastigroupDeploymentGroup> deploymentGroups;
    //endregion

    //region Constructor

    public ElastigroupCodeDeployBGDeployment() {
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

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public List<ElastigroupDeploymentTags> getDeploymentTags() {
        return deploymentTags;
    }

    public void setDeploymentTags(List<ElastigroupDeploymentTags> deploymentTags) {
        isSet.add("deploymentTags");
        this.deploymentTags = deploymentTags;
    }

    public List<ElastigroupDeploymentGroup> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<ElastigroupDeploymentGroup> deploymentGroups) {
        isSet.add("deploymentGroups");
        this.deploymentGroups = deploymentGroups;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ElastigroupCodeDeployBGDeployment codeDeployBGDeployment;
        //endregion


        private Builder() {
            this.codeDeployBGDeployment = new ElastigroupCodeDeployBGDeployment();
        }

        public static Builder get() {
            ElastigroupCodeDeployBGDeployment.Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setTimeout(String timeout) {
            codeDeployBGDeployment.setTimeout(timeout);
            return this;
        }

        public Builder setDeploymentTags(List<ElastigroupDeploymentTags> deploymentTags) {
            codeDeployBGDeployment.setDeploymentTags(deploymentTags);
            return this;
        }

        public Builder setDeploymentGroups(List<ElastigroupDeploymentGroup> deploymentGroups) {
            codeDeployBGDeployment.setDeploymentGroups(deploymentGroups);
            return this;
        }

        public ElastigroupCodeDeployBGDeployment build() {
            // Validations
            return codeDeployBGDeployment;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    // Is deploymenttags Set boolean method
    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    @JsonIgnore
    public boolean isDeploymentTagsSet() {
        return isSet.contains("deploymentTags");
    }

    // Is deploymentGroups Set boolean method
    @JsonIgnore
    public boolean isDeploymentGroupsSet() {
        return isSet.contains("deploymentGroups");
    }

    //endregion
}
