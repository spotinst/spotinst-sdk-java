package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterLaunchSpecification {
    @JsonIgnore
    private Set<String>                                                   isSet;
    private ImportClusterLaunchSpecIamInstanceProfileSpecification        iamInstanceProfile;
    private String                                                        imageId;
    private ImportClusterLaunchSpecInstanceMetadataOptions                instanceMetadataOptions;
    private List<String>                                                  securityGroupIds;
    private List<LaunchSpecTagsSpecification>                             tags;
    private String                                                        userData;
    private String                                                        keyPair;

    private ImportClusterLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ImportClusterLaunchSpecIamInstanceProfileSpecification getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(ImportClusterLaunchSpecIamInstanceProfileSpecification iamInstanceProfile) {
        isSet.add("iamInstanceProfile");
        this.iamInstanceProfile = iamInstanceProfile;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        isSet.add("imageId");
        this.imageId = imageId;
    }

    public ImportClusterLaunchSpecInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(ImportClusterLaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
        isSet.add("instanceMetadataOptions");
        this.instanceMetadataOptions = instanceMetadataOptions;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        isSet.add("keyPair");
        this.keyPair = keyPair;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public List<LaunchSpecTagsSpecification> getTags() {
        return tags;
    }

    public void setTags(List<LaunchSpecTagsSpecification> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        isSet.add("userData");
        this.userData = userData;
    }

    public static class Builder {

        private ImportClusterLaunchSpecification launchspec;

        private Builder() {
            this.launchspec = new ImportClusterLaunchSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIamInstanceProfile(final ImportClusterLaunchSpecIamInstanceProfileSpecification iamInstanceProfile) {
            launchspec.setIamInstanceProfile(iamInstanceProfile);
            return this;
        }

        public Builder setKeyPair(final String keyPair) {
            launchspec.setKeyPair(keyPair);
            return this;
        }

        public Builder setImageId(final String imageId) {
            launchspec.setImageId(imageId);
            return this;
        }

        public Builder setSecurityGroupIds(final List<String> securityGroupIds) {
            launchspec.setSecurityGroupIds(securityGroupIds);
            return this;
        }

        public Builder setTags(final List<LaunchSpecTagsSpecification> tags) {
            launchspec.setTags(tags);
            return this;
        }

        public Builder setUserData(final String userData) {
            launchspec.setUserData(userData);
            return this;
        }

        public Builder setInstanceMetadataOptions(final ImportClusterLaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
            launchspec.setInstanceMetadataOptions(instanceMetadataOptions);
            return this;
        }

        public ImportClusterLaunchSpecification build() {
            return launchspec;
        }
    }

    @JsonIgnore
    public boolean isIamInstanceProfileSet() {
        return isSet.contains("iamInstanceProfile");
    }

    @JsonIgnore
    public boolean isImageIdSet() {
        return isSet.contains("imageId");
    }

    @JsonIgnore
    public boolean isInstanceMetadataOptionsSet() {
        return isSet.contains("instanceMetadataOptions");
    }

    @JsonIgnore
    public boolean isKeyPairSet() {
        return isSet.contains("keyPair");
    }

    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }

}