package com.spotinst.sdkjava.model.api.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterControllerInfo implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 nodeName;
    private String                 controllerVersion;
    private String                 podName;

    private ApiClusterControllerInfo() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        isSet.add("nodeName");
        this.nodeName = nodeName;
    }

    public String getControllerVersion() {
        return controllerVersion;
    }

    public void setControllerVersion(String controllerVersion) {
        isSet.add("controllerVersion");
        this.controllerVersion = controllerVersion;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        isSet.add("podName");
        this.podName = podName;
    }

    @JsonIgnore
    public boolean isNodeNameSet() {
        return isSet.contains("nodeName");
    }

    @JsonIgnore
    public boolean isControllerVersionSet() {
        return isSet.contains("controllerVersion");
    }

    @JsonIgnore
    public boolean isPodNameSet() {
        return isSet.contains("podName");
    }
}