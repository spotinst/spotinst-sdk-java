package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.StatefulInstanceHealthStatusEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupListStatefulInstancesResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             id;
    private String                                             instanceId;
    private String                                             privateIp;
    private String                                             imageId;
    private StatefulInstanceHealthStatusEnum                   state;
    private List<ElastigroupListStatefulInstancesDevices>      devices;
    private String                                             launchedAt;
    private String                                             createdAt;

    public ElastigroupListStatefulInstancesResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        isSet.add("privateIp");
        this.privateIp = privateIp;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public StatefulInstanceHealthStatusEnum getState() {
        return state;
    }

    public void setState(StatefulInstanceHealthStatusEnum state) {
        isSet.add("state");
        this.state = state;
    }

    public List<ElastigroupListStatefulInstancesDevices> getDevices() {
        return devices;
    }

    public void setDevices(List<ElastigroupListStatefulInstancesDevices> devices) {
        isSet.add("devices");
        this.devices = devices;
    }

    public String getLaunchedAt() {
        return launchedAt;
    }

    public void setLaunchedAt(String launchedAt) {
        isSet.add("launchedAt");
        this.launchedAt = launchedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public static class Builder {
        private ElastigroupListStatefulInstancesResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupListStatefulInstancesResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setId(final String id) {
            elastigroupGetDeploymentStatusInstances.setId(id);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setInstanceId(final String instanceId) {
            elastigroupGetDeploymentStatusInstances.setInstanceId(instanceId);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setPrivateIp(final String privateIp) {
            elastigroupGetDeploymentStatusInstances.setPrivateIp(privateIp);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setImageId(final String imageId) {
            elastigroupGetDeploymentStatusInstances.setImageId(imageId);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setState(final StatefulInstanceHealthStatusEnum state) {
            elastigroupGetDeploymentStatusInstances.setState(state);
            return this;
        }

        public Builder setDevices(final List<ElastigroupListStatefulInstancesDevices> devices) {
            elastigroupGetDeploymentStatusInstances.setDevices(devices);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setLaunchedAt(final String launchedAt) {
            elastigroupGetDeploymentStatusInstances.setLaunchedAt(launchedAt);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse.Builder setCreatedAt(final String createdAt) {
            elastigroupGetDeploymentStatusInstances.setCreatedAt(createdAt);
            return this;
        }

        public ElastigroupListStatefulInstancesResponse build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isPrivateIpSet() {
        return isSet.contains("privateIp");
    }

    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

    @JsonIgnore
    public boolean isDevicesSet() {
        return isSet.contains("devices");
    }

    @JsonIgnore
    public boolean isLaunchedAtSet() {
        return isSet.contains("launchedAt");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

}
