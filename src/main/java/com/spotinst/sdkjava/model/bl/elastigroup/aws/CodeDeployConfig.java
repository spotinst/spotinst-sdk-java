package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CodeDeployConfig {

    @JsonIgnore
    private Set<String>                                     isSet;
    private String                                          timeout;
    private List<ElastigroupDeploymentTags>                 deploymentTags;
    private List<ElastigroupDeploymentGroup>                deploymentGroups;

    public CodeDeployConfig() {
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


    public static class Builder {
        private CodeDeployConfig config;

        private Builder() {
            this.config = new CodeDeployConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTimeout(final String timeout) {
            config.setTimeout(timeout);
            return this;
        }

        public Builder setDeploymentTags(final List<ElastigroupDeploymentTags> deploymentTags) {
            config.setDeploymentTags(deploymentTags);
            return this;
        }

        public Builder setDeploymentGroups(final List<ElastigroupDeploymentGroup> deploymentGroups) {
            config.setDeploymentGroups(deploymentGroups);
            return this;
        }

        public CodeDeployConfig build() {
            return config;
        }

    }

    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    @JsonIgnore
    public boolean isDeploymentTagsSet() {
        return isSet.contains("deploymentTags");
    }

    @JsonIgnore
    public boolean isDeploymentGroupsSet() {
        return isSet.contains("deploymentGroups");
    }

}
