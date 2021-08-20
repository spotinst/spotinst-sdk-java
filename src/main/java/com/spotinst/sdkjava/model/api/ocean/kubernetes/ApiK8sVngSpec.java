package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiK8sVngSpec implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           id;
    private String                           name;
    private Boolean                          associatePublicIpAddress;
    private ApiK8sVngAutoScaleSpec 			 autoScale;
    private List<ApiK8sVngBlockDevice>       blockDeviceMappings;
    private ApiK8sVngElasticIpPool			 elasticIpPool;
    private ApiK8sVngIamInstanceProfileSpec  iamInstanceProfile;
    private String                           imageId;
    private ApiK8sVngInstanceMetadataOptions instanceMetadataOptions;
    private List<String>                     instanceTypes;
    private List<ApiK8sVngLabels>			 labels;
    private String                           oceanId;
    private List<String>                     preferredSpotTypes;
    private ApiK8sVngResourceLimits			 resourceLimits;
    private Boolean                          restrictScaleDown;
    private Integer                          rootVolumeSize;
    private List<String>                  	 securityGroupIds;
    private ApiK8sVngStrategySpec  			 strategy;
    private List<ApiK8sVngTaints>            taints;
    private List<String>         		  	 subnetIds;
    private List<ApiK8sVngTag>               tags;
    private String                        	 userData;
    private Date                          	 createdAt;
    private Date                          	 updatedAt;

    public ApiK8sVngSpec() {
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

    public ApiK8sVngAutoScaleSpec getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiK8sVngAutoScaleSpec autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public List<ApiK8sVngBlockDevice> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ApiK8sVngBlockDevice> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public List<ApiK8sVngLabels> getLabels() {
        return labels;
    }

    public void setLabels (List<ApiK8sVngLabels> labels) {
        isSet.add("labels");
        this.labels = labels;
    }

    public ApiK8sVngElasticIpPool getElasticIpPool() {
        return elasticIpPool;
    }

    public void setElasticIpPool(ApiK8sVngElasticIpPool elasticIpPool) {
        isSet.add("elasticIpPool");
        this.elasticIpPool = elasticIpPool;
    }

    public List<ApiK8sVngTag> getTags() {
        return tags;
    }

    public void setTags(List<ApiK8sVngTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ApiK8sVngIamInstanceProfileSpec getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(ApiK8sVngIamInstanceProfileSpec iamInstanceProfile) {
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

    public ApiK8sVngInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(ApiK8sVngInstanceMetadataOptions instanceMetadataOptions) {
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

    public ApiK8sVngResourceLimits getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiK8sVngResourceLimits resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }
    public ApiK8sVngStrategySpec getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiK8sVngStrategySpec strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public List<ApiK8sVngTaints> getTaints() {
        return taints;
    }

    public void setTaints(List<ApiK8sVngTaints> taints) {
        isSet.add("taints");
        this.taints = taints;
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
    public boolean isAutoScaleSet() { return isSet.contains("autoScale");
    }

    @JsonIgnore
    public boolean isBlockDeviceMappingsSet() {
        return isSet.contains("blockDeviceMappings");
    }

    @JsonIgnore
    public boolean isLabelsSet() {
        return isSet.contains("labels");
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
    public boolean isOceanIdSet() {
        return isSet.contains("oceanId");
    }

    @JsonIgnore
    public boolean isPreferredSpotTypesSet() {
        return isSet.contains("preferredSpotTypes");
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
    public boolean isResourceLimitsSet() {
        return isSet.contains("resourceLimits");
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