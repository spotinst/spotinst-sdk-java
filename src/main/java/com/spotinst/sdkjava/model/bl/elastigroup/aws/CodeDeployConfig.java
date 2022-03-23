package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ElastigroupDeploymentGroup;
import com.spotinst.sdkjava.model.Tag;

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
    private List<Tag>                                       tags;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        isSet.add("tags");
        this.tags = tags;
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

        public Builder setTags(final List<Tag> tags) {
            config.setTags(tags);
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
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isDeploymentGroupsSet() {
        return isSet.contains("deploymentGroups");
    }

}
