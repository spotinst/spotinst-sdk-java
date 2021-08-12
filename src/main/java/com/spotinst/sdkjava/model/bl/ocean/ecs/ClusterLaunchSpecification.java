package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterLaunchSpecification {
    @JsonIgnore
    private Set<String>                               isSet;
    private List<ClusterAttributes>                   attributes;
    private LaunchSpecAutoScaleSpecification          autoScale;
    private List<LaunchSpecBlockDeviceMappings>       blockDeviceMappings;
    private LaunchSpecIamInstanceProfileSpecification iamInstanceProfile;
    private String                                    imageId;
    private LaunchSpecInstanceMetadataOptions         instanceMetadataOptions;
    private List<String>                              instanceTypes;
    private String                                    name;
    private String                                    oceanId;
    private Boolean                                   restrictScaleDown;
    private List<String>                              securityGroupIds;
    private List<String>                              subnetIds;
    private List<LaunchSpecTagsSpecification>         tags;
    private String                                    userData;
    private String                                    id;
    private String                                    keyPair;
    private Boolean                                   associatePublicIpAddress;

    private ClusterLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ClusterAttributes> attributes) {
        isSet.add("attributes");
        this.attributes = attributes;
    }

    public LaunchSpecAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(LaunchSpecAutoScaleSpecification autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public List<LaunchSpecBlockDeviceMappings> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<LaunchSpecBlockDeviceMappings> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public LaunchSpecIamInstanceProfileSpecification getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(LaunchSpecIamInstanceProfileSpecification iamInstanceProfile) {
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

    public LaunchSpecInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(LaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
        isSet.add("instanceMetadataOptions");
        this.instanceMetadataOptions = instanceMetadataOptions;
    }

    public List<String> getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(List<String> instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public Boolean getRestrictScaleDown() {
        return restrictScaleDown;
    }

    public void setRestrictScaleDown(Boolean restrictScaleDown) {
        isSet.add("restrictScaleDown");
        this.restrictScaleDown = restrictScaleDown;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
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

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        isSet.add("keyPair");
        this.keyPair = keyPair;
    }

    public Boolean getAssociatePublicIpAddress() {
        return associatePublicIpAddress;
    }

    public void setAssociatePublicIpAddress(Boolean associatePublicIpAddress) {
        isSet.add("associatePublicIpAddress");
        this.associatePublicIpAddress = associatePublicIpAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public static class Builder {

        private ClusterLaunchSpecification launchspec;

        private Builder() {
            this.launchspec = new ClusterLaunchSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAttributes(final List<ClusterAttributes> attributes) {
            launchspec.setAttributes(attributes);
            return this;
        }

        public Builder setAutoScale(final LaunchSpecAutoScaleSpecification autoScale) {
            launchspec.setAutoScale(autoScale);
            return this;
        }

        public Builder setBlockDeviceMappings(final List<LaunchSpecBlockDeviceMappings> blockDeviceMappings) {
            launchspec.setBlockDeviceMappings(blockDeviceMappings);
            return this;
        }

        public Builder setIamInstanceProfile(final LaunchSpecIamInstanceProfileSpecification iamInstanceProfile) {
            launchspec.setIamInstanceProfile(iamInstanceProfile);
            return this;
        }

        public Builder setName(final String name) {
            launchspec.setName(name);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            launchspec.setOceanId(oceanId);
            return this;
        }

        public Builder setImageId(final String imageId) {
            launchspec.setImageId(imageId);
            return this;
        }

        public Builder setRestrictScaleDown(final Boolean restrictScaleDown) {
            launchspec.setRestrictScaleDown(restrictScaleDown);
            return this;
        }

        public Builder setSecurityGroupIds(final List<String> securityGroupIds) {
            launchspec.setSecurityGroupIds(securityGroupIds);
            return this;
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            launchspec.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setTags(final List<LaunchSpecTagsSpecification> tags) {
            launchspec.setTags(tags);
            return this;
        }

        public Builder setId(final String id) {
            launchspec.setId(id);
            return this;
        }

        public Builder setUserData(final String userData) {
            launchspec.setUserData(userData);
            return this;
        }

        public Builder setKeyPair(final String keyPair){
            launchspec.setKeyPair(keyPair);
            return this;
        }

        public Builder setAssociatePublicIpAddress(final Boolean associatePublicIpAddress) {
            launchspec.setAssociatePublicIpAddress(associatePublicIpAddress);
            return this;
        }

        public Builder setInstanceMetadataOptions(final LaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
            launchspec.setInstanceMetadataOptions(instanceMetadataOptions);
            return this;
        }

        public Builder setInstanceTypes(final List<String> instanceTypes) {
            launchspec.setInstanceTypes(instanceTypes);
            return this;
        }

        public ClusterLaunchSpecification build() {
            return launchspec;
        }
    }

    @JsonIgnore
    public boolean isAttributesSet() {
        return isSet.contains("attributes");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
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
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isOceanIdSet() {
        return isSet.contains("oceanId");
    }

    @JsonIgnore
    public boolean isRestrictScaleDownSet() {
        return isSet.contains("restrictScaleDown");
    }

    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }

    @JsonIgnore
    public boolean isKeyPairSet() { return isSet.contains("keyPair"); }

    @JsonIgnore
    public boolean isAssociatePublicIpAddressSet() { return isSet.contains("associatePublicIpAddress"); }

}