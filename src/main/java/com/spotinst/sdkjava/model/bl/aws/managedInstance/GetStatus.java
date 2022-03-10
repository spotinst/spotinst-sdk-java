package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GetStatus {

    @JsonIgnore
    private Set<String> isSet;
    private String          createdAt;
    private String          id;
    private String          imageId;
    private String          instanceId;
    private String          instanceType;
    private String          launchedAt;
    private String          name;
    private String          privateIp;
    private String          publicIp;
    private String          status;

    private GetStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public String getLaunchedAt() {
        return launchedAt;
    }

    public void setLaunchedAt(String launchedAt) {
        isSet.add("launchedAt");
        this.launchedAt = launchedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        isSet.add("privateIp");
        this.privateIp = privateIp;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        isSet.add("publicIp");
        this.publicIp = publicIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public static class Builder {
        private GetStatus getStatus;

        private Builder() {
            this.getStatus = new GetStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCreatedAt(final String createdAt) {
            getStatus.setCreatedAt(createdAt);
            return this;
        }

        public Builder setId(final String id) {
            getStatus.setId(id);
            return this;
        }

        public Builder setImageId(final String imageId) {
            getStatus.setImageId(imageId);
            return this;
        }

        public Builder setInstanceId(final String instanceId) {
            getStatus.setInstanceId(instanceId);
            return this;
        }

        public Builder setInstanceType(final String instanceType) {
            getStatus.setInstanceType(instanceType);
            return this;
        }

        public Builder setLaunchedAt(final String launchedAt) {
            getStatus.setLaunchedAt(launchedAt);
            return this;
        }

        public Builder setName(final String name) {
            getStatus.setName(name);
            return this;
        }

        public Builder setPrivateIp(final String privateIp) {
            getStatus.setPrivateIp(privateIp);
            return this;
        }

        public Builder setPublicIp(final String publicIp) {
            getStatus.setPublicIp(publicIp);
            return this;
        }

        public Builder setStatus(final String status) {
            getStatus.setStatus(status);
            return this;
        }

        public GetStatus build() {
            return getStatus;
        }
    }


    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

    @JsonIgnore
    public boolean isLaunchedAtSet() {
        return isSet.contains("launchedAt");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPrivateIpSet() {
        return isSet.contains("privateIp");
    }

    @JsonIgnore
    public boolean isPublicIpSet() {
        return isSet.contains("publicIp");
    }

    @JsonIgnore
    public boolean isStatusSet() {
            return isSet.contains("status");
        }

}

