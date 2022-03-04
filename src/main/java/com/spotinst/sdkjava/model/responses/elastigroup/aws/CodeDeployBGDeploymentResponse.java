package com.spotinst.sdkjava.model.responses.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.CodeDeployConfig;

import java.util.HashSet;
import java.util.Set;
/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodeDeployBGDeploymentResponse {

    @JsonIgnore
    private Set<String>                                isSet;
    private String                                     id;
    private String                                     groupId;
    private String                                     state;
    private CodeDeployConfig                           config;

    public CodeDeployBGDeploymentResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() { return id; }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getGroupId() { return groupId; }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public String getState() { return state; }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public CodeDeployConfig getConfig() {
        return config;
    }

    public void setConfig(CodeDeployConfig config) {
        isSet.add("config");
        this.config = config;
    }

    public static class Builder {
        private CodeDeployBGDeploymentResponse getCodeDeployResponse;

        private Builder() {
            this.getCodeDeployResponse = new CodeDeployBGDeploymentResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            getCodeDeployResponse.setId(id);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            getCodeDeployResponse.setId(groupId);
            return this;
        }

        public Builder setState(final String state) {
            getCodeDeployResponse.setState(state);
            return this;
        }

        public Builder setConfig(final CodeDeployConfig config) {
            getCodeDeployResponse.setConfig(config);
            return this;
        }

        public CodeDeployBGDeploymentResponse build() {
            return getCodeDeployResponse;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

    @JsonIgnore
    public boolean isConfigSet() {
        return isSet.contains("config");
    }

}

