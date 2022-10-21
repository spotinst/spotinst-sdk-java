package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterControllerInfo {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 nodeName;
    private String                 controllerVersion;
    private String                 podName;

    private ClusterControllerInfo() {
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

    public static class Builder {
        private ClusterControllerInfo clusterControllerInfo;

        private Builder() {
            this.clusterControllerInfo = new ClusterControllerInfo();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setNodeName(final String nodeName) {
            clusterControllerInfo.setNodeName(nodeName);
            return this;
        }

        public Builder setControllerVersion(final String controllerVersion) {
            clusterControllerInfo.setControllerVersion(controllerVersion);
            return this;
        }

        public Builder setPodName(final String podName) {
            clusterControllerInfo.setPodName(podName);
            return this;
        }

        public ClusterControllerInfo build() {
            return clusterControllerInfo;
        }
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