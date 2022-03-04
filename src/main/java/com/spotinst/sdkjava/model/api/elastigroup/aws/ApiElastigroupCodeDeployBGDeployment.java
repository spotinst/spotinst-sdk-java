package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiDeploymentGroup;

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
public class ApiElastigroupCodeDeployBGDeployment implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                  isSet;
    private String                                       timeout;
    private List<ApiElastigroupDeploymentTags>           deploymentTags;
    private List<ApiDeploymentGroup>                     deploymentGroups;
    //endregion

    //region Constructor

    public ApiElastigroupCodeDeployBGDeployment() {
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

   public List<ApiElastigroupDeploymentTags> getDeploymentTags() {
        return deploymentTags;
    }

    public void setDeploymentTags(List<ApiElastigroupDeploymentTags> deploymentTags) {
        isSet.add("deploymentTags");
        this.deploymentTags = deploymentTags;
    }

    public List<ApiDeploymentGroup> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<ApiDeploymentGroup> deploymentGroups) {
        isSet.add("deploymentGroups");
        this.deploymentGroups = deploymentGroups;
    }

    //endregion

    //region isSet methods
    // Is timeout Set boolean method
    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    // Is deploymenttags Set boolean method
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
