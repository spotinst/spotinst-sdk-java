package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterLaunchSpecification {
    @JsonIgnore
    private Set<String>                      isSet;
    private List<ClusterAttributes>          attributes;
    private ClusterAutoScaleSpecification    autoScale;
    private List<ClusterBlockDeviceMappings> blockDeviceMappings;
    private ClusterIamInstanceProfileSpec    iamInstanceProfile;
    private String                           imageId;
    private ClusterInstanceMetadataOptions   instanceMetadataOptions;
    private List<String>                     instanceTypes;
    private String                           name;
    private String                           oceanId;
    private Boolean                          restrictScaleDown;
    private List<String>                     securityGroupIds;
    private List<String>                     subnetIds;
    private List<ClusterTagsSepcification>   tags;
    private String                           userData;
    private String                           id;

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

    public ClusterAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ClusterAutoScaleSpecification autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public List<ClusterBlockDeviceMappings> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ClusterBlockDeviceMappings> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public ClusterIamInstanceProfileSpec getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(ClusterIamInstanceProfileSpec iamInstanceProfile) {
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

    public ClusterInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(ClusterInstanceMetadataOptions instanceMetadataOptions) {
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

    public List<ClusterTagsSepcification> getTags() {
        return tags;
    }

    public void setTags(List<ClusterTagsSepcification> tags) {
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

        public Builder setAutoScale(final ClusterAutoScaleSpecification autoScale) {
            launchspec.setAutoScale(autoScale);
            return this;
        }

        public Builder setBlockDeviceMappings(final List<ClusterBlockDeviceMappings> blockDeviceMappings) {
            launchspec.setBlockDeviceMappings(blockDeviceMappings);
            return this;
        }

        public Builder setIamInstanceProfile(final ClusterIamInstanceProfileSpec iamInstanceProfile) {
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

        public Builder setTags(final List<ClusterTagsSepcification> tags) {
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

        public Builder setInstanceMetadataOptions(final ClusterInstanceMetadataOptions instanceMetadataOptions) {
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
}
