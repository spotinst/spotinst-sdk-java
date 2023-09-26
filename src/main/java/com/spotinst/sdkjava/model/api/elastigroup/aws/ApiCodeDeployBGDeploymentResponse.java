package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.CodeDeployConfig;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupCodeDeployBGDeployment;

import java.util.HashSet;
import java.util.Set;
/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCodeDeployBGDeploymentResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                isSet;
    private String                                     id;
    private String                                     groupId;
    private String                                     state;
    private ElastigroupCodeDeployBGDeployment          config;

    public ApiCodeDeployBGDeploymentResponse() {
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

    public ElastigroupCodeDeployBGDeployment getConfig() {
        return config;
    }

    public void setConfig(ElastigroupCodeDeployBGDeployment config) {
        isSet.add("config");
        this.config = config;
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