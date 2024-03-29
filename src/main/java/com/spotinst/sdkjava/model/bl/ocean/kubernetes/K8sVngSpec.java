package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class K8sVngSpec {
    @JsonIgnore
    private Set<String>                     isSet;
    private String                          id;
    private String                          name;
    private Boolean                         associatePublicIpAddress;
    private K8sVngAutoScaleSpec       		autoScale;
    private List<K8sVngBlockDevice>         blockDeviceMappings;
	private K8sVngElasticIpPool			 	elasticIpPool;
    private K8sVngIamInstanceProfileSpec	iamInstanceProfile;
    private String                          imageId;
    private K8sVngInstanceMetadataOptions	instanceMetadataOptions;
    private List<String>                    instanceTypes;
	private List<K8sVngLabel>			 	labels;
    private String                          oceanId;
    private List<String>                    preferredSpotTypes;
	private K8sVngResourceLimits			resourceLimits;
    private Boolean                         restrictScaleDown;
    private Integer                         rootVolumeSize;
    private List<String>                    securityGroupIds;
    private K8sVngStrategySpec        		strategy;
    private List<K8sVngTaints>              taints;
    private List<String>         		    subnetIds;
	private List<K8sVngTag>                 tags;
    private String                          userData;
    private Date                            createdAt;
    private Date                            updatedAt;

    private K8sVngSpec() {
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

    public K8sVngAutoScaleSpec getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(K8sVngAutoScaleSpec autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public List<K8sVngBlockDevice> getBlockDevices() {
        return blockDeviceMappings;
    }

    public void setK8sVngBlockDevices(List<K8sVngBlockDevice> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public K8sVngElasticIpPool getElasticIpPool() {
        return elasticIpPool;
    }

    public void setElasticIpPool(K8sVngElasticIpPool elasticIpPool) {
        isSet.add("elasticIpPool");
        this.elasticIpPool = elasticIpPool;
    }

    public List<K8sVngTag> getTags() {
        return tags;
    }

    public void setTags(List<K8sVngTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public K8sVngIamInstanceProfileSpec getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(K8sVngIamInstanceProfileSpec iamInstanceProfile) {
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

    public List<String> getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(List<String> instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public List<K8sVngLabel> getLabels() {
        return labels;
    }
    
    public void setLabels(List<K8sVngLabel> labels) {
        isSet.add("labels");
        this.labels = labels;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public List<String> getPreferredSpotTypes() {
        return preferredSpotTypes;
    }

    public void setPreferredSpotTypes(List<String> preferredSpotTypes) {
        isSet.add("preferredSpotTypes");
        this.preferredSpotTypes = preferredSpotTypes;
    }

    public K8sVngResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(K8sVngResourceLimits resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
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

    public K8sVngStrategySpec getStrategy() {
        return strategy;
    }

    public void setStrategy(K8sVngStrategySpec strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public List<K8sVngTaints> getTaints() {
        return taints;
    }

    public void setTaints(List<K8sVngTaints> taints) {
        isSet.add("taints");
        this.taints =taints;
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
        private K8sVngSpec launchSpecification;

        private Builder() {
            this.launchSpecification = new K8sVngSpec();
        }

        public static Builder get() {
            return new Builder();
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

        public Builder setAutoScale(final K8sVngAutoScaleSpec autoScale) {
            launchSpecification.setAutoScale(autoScale);
            return this;
        }

        public Builder setBlockDevices(final List<K8sVngBlockDevice> blockDeviceMappings) {
            launchSpecification.setK8sVngBlockDevices(blockDeviceMappings);
            return this;
        }

        public Builder setElasticIpPool(final K8sVngElasticIpPool elasticIpPool) {
            launchSpecification.setElasticIpPool(elasticIpPool);
            return this;
        }

        public Builder setTags(final List<K8sVngTag> tags) {
            launchSpecification.setTags(tags);
            return this;
        }

        public Builder setIamInstanceProfile(final K8sVngIamInstanceProfileSpec iamInstanceProfile) {
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

        public Builder setInstanceTypes(final List<String> instanceTypes) {
            launchSpecification.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setLabels(final List<K8sVngLabel> labels) {
            launchSpecification.setLabels(labels);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            launchSpecification.setOceanId(oceanId);
            return this;
        }

        public Builder setPreferredSpotTypes(final List<String> preferredSpotTypes) {
            launchSpecification.setPreferredSpotTypes(preferredSpotTypes);
            return this;
        }

        public Builder setResourceLimits(final  K8sVngResourceLimits resourceLimits) {
            launchSpecification.setResourceLimits(resourceLimits);
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

        public Builder setStrategy(final K8sVngStrategySpec strategy) {
            launchSpecification.setStrategy(strategy);
            return this;
        }

        public Builder setTaints(final List<K8sVngTaints> taints) {
            launchSpecification.setTaints(taints);
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

        public K8sVngSpec build() {
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
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    @JsonIgnore
    public boolean isBlockDevicesSet() {
        return isSet.contains("blockDeviceMappings");
    }

    @JsonIgnore
    public boolean isElasticIpPoolSet() {
        return isSet.contains("elasticIpPool");
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
    public boolean isLabelsSet() {
        return isSet.contains("labels");
    }

    @JsonIgnore
    public boolean isOceanIdSet() {
        return isSet.contains("oceanId");
    }

    @JsonIgnore
    public boolean isPreferredSpotTypesSet() {
        return isSet.contains("preferredSpotTypes");
    }

    @JsonIgnore
    public boolean isResourceLimitsSet() {
        return isSet.contains("resourceLimits");
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
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isTaintsSet() {
        return isSet.contains("taints");
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