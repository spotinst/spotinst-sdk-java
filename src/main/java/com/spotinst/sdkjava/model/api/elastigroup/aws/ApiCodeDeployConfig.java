package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ApiDeploymentGroup;
import com.spotinst.sdkjava.model.ApiTag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiCodeDeployConfig {

    @JsonIgnore
    private Set<String>                                     isSet;
    private String                                          timeout;
    private List<ApiTag>                                    tags;
    private List<ApiDeploymentGroup>                        deploymentGroups;

    public ApiCodeDeployConfig() {
        isSet = new HashSet<>();
    }

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
        isSet.add("timeout");
        this.timeout = timeout;
    }

    public List<ApiTag> getTag() {
        return tags;
    }

    public void setTags(List<ApiTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public List<ApiDeploymentGroup> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<ApiDeploymentGroup> deploymentGroups) {
        isSet.add("deploymentGroups");
        this.deploymentGroups = deploymentGroups;
    }

    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isDeploymentGroupsSet() {
        return isSet.contains("deploymentGroups");
    }

}
