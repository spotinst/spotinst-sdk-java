package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.BlockDeviceMapping;
import com.spotinst.sdkjava.model.Tag;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class K8sVirtualNodeGroup {
    @JsonIgnore
    private Set<String>                   isSet;
    private String                        id;
    private String                        name;
    private Boolean                       associatePublicIpAddress;
    private ClusterHeadroomSpecification  headroom;
    private List<BlockDeviceMapping>      blockDeviceMappings;
    private List<Tag>                     tags;
    private ClusterIamInstanceProfileSpec iamInstanceProfile;
    private String                        imageId;
    private K8sVngInstanceMetadataOptions instanceMetadataOptions;
    private ClusterInstanceTypes          instanceTypes;
    private String                        oceanId;
    private List<String>                  spotTypes;
    private Boolean                       restrictScaleDown;
    private Integer                       rootVolumeSize;
    private List<String>                  securityGroupIds;
    private Integer               		  spotPercentage;
    private List<String>         		  subnetIds;
    private String                        userData;
    private Date                          createdAt;
    private Date                          updatedAt;

    private K8sVirtualNodeGroup() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean getAssociatePublicIpAddress() {
        return associatePublicIpAddress;
    }

    public void setAssociatePublicIpAddress(Boolean associatePublicIpAddress) {
        isSet.add("associatePublicIpAddress");
        this.associatePublicIpAddress = associatePublicIpAddress;
    }

    public ClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ClusterHeadroomSpecification headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<BlockDeviceMapping> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        isSet.add("tags");
        this.tags = tags;
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

    public K8sVngInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(K8sVngInstanceMetadataOptions instanceMetadataOptions) {
        isSet.add("instanceMetadataOptions");
        this.instanceMetadataOptions = instanceMetadataOptions;
    }

    public ClusterInstanceTypes getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ClusterInstanceTypes instanceTypes) {
        isSet.add("instanceTypes");

        this.instanceTypes = instanceTypes;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public List<String> getSpotTypes() {
        return spotTypes;
    }

    public void setSpotTypes(List<String> spotTypes) {
        isSet.add("spotTypes");
        this.spotTypes = spotTypes;
    }

    public Boolean getRestrictScaleDown() {
        return restrictScaleDown;
    }

    public void setRestrictScaleDown(Boolean restrictScaleDown) {
        isSet.add("restrictScaleDown");
        this.restrictScaleDown = restrictScaleDown;
    }

    public Integer getRootVolumeSize() {
        return rootVolumeSize;
    }

    public void setRootVolumeSize(Integer rootVolumeSize) {
        isSet.add("rootVolumeSize");
        this.rootVolumeSize = rootVolumeSize;
    }

    public List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    public void setSecurityGroupIds(List<String> securityGroupIds) {
        isSet.add("securityGroupIds");
        this.securityGroupIds = securityGroupIds;
    }

    public Integer getSpotPercentage() {
        return spotPercentage;
    }

    public void setSpotPercentage(Integer spotPercentage) {
        isSet.add("spotPercentage");
        this.spotPercentage = spotPercentage;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        isSet.add("userData");
        this.userData = userData;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private K8sVirtualNodeGroup launchSpecification;

        private Builder() {
            this.launchSpecification = new K8sVirtualNodeGroup();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String oceanLaunchSpecId) {
            launchSpecification.setId(oceanLaunchSpecId);
            return this;
        }

        public Builder setName(final String name) {
            launchSpecification.setName(name);
            return this;
        }

        public Builder setAssociatePublicIpAddress(final Boolean associatePublicIpAddress) {
            launchSpecification.setAssociatePublicIpAddress(associatePublicIpAddress);
            return this;
        }

        public Builder setHeadroom(final ClusterHeadroomSpecification headroom) {
            launchSpecification.setHeadroom(headroom);
            return this;
        }

        public Builder setBlockDeviceMappings(final List<BlockDeviceMapping> blockDeviceMappings) {
            launchSpecification.setBlockDeviceMappings(blockDeviceMappings);
            return this;
        }

        public Builder setTags(final List<Tag> tags) {
            launchSpecification.setTags(tags);
            return this;
        }

        public Builder setIamInstanceProfile(final ClusterIamInstanceProfileSpec iamInstanceProfile) {
            launchSpecification.setIamInstanceProfile(iamInstanceProfile);
            return this;
        }

        public Builder setImageId(final String imageId) {
            launchSpecification.setImageId(imageId);
            return this;
        }

        public Builder setInstanceMetadataOptions(final K8sVngInstanceMetadataOptions instanceMetadataOptions) {
            launchSpecification.setInstanceMetadataOptions(instanceMetadataOptions);
            return this;
        }

        public Builder setInstanceTypes(final ClusterInstanceTypes instanceTypes) {
            launchSpecification.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            launchSpecification.setImageId(oceanId);
            return this;
        }

        public Builder setSpotTypes(final List<String> spotTypes) {
            launchSpecification.setSpotTypes(spotTypes);
            return this;
        }

        public Builder setRestrictScaleDown(final Boolean restrictScaleDown) {
            launchSpecification.setRestrictScaleDown(restrictScaleDown);
            return this;
        }

        public Builder setRootVolumeSize(final Integer rootVolumeSize) {
            launchSpecification.setRootVolumeSize(rootVolumeSize);
            return this;
        }

        public Builder setSecurityGroupIds(final List<String> securityGroupIds) {
            launchSpecification.setSecurityGroupIds(securityGroupIds);
            return this;
        }

        public Builder setSpotPercentage(final Integer spotPercentage) {
            launchSpecification.setSpotPercentage(spotPercentage);
            return this;
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            launchSpecification.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setUserData(final String userData) {
            launchSpecification.setUserData(userData);
            return this;
        }

        public K8sVirtualNodeGroup build() {
            // Validations
            return launchSpecification;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    public boolean isAssociatePublicIpAddressSet() {
        return isSet.contains("associatePublicIpAddress");
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headroom");
    }

    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
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
    public boolean isOceanIdSet() {
        return isSet.contains("oceanId");
    }

    @JsonIgnore
    public boolean isSpotTypesSet() {
        return isSet.contains("spotTypes");
    }

    @JsonIgnore
    public boolean isRestrictScaleDownSet() {
        return isSet.contains("restrictScaleDown");
    }

    @JsonIgnore
    public boolean isRootVolumeSizeSet() {
        return isSet.contains("rootVolumeSize");
    }

    @JsonIgnore
    public boolean isSecurityGroupIdsSet() {
        return isSet.contains("securityGroupIds");
    }

    @JsonIgnore
    public boolean isSpotPercentageSet() {
        return isSet.contains("spotPercentage");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }

    @JsonIgnore
    public boolean isUserDataSet() {
        return isSet.contains("userData");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
}