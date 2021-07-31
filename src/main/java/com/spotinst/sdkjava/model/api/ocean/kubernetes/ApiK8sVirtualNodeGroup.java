package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import com.spotinst.sdkjava.model.ApiBlockDevice;
import com.spotinst.sdkjava.model.ApiTag;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiK8sVirtualNodeGroup implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           id;
    private String                           name;
    private Boolean                          associatePublicIpAddress;
    private ApiClusterHeadroomSpecification  headroom;
    private List<ApiBlockDevice>             blockDeviceMappings;
    private List<ApiTag>                     tags;
    private ApiClusterIamInstanceProfileSpec iamInstanceProfile;
    private String                           imageId;
    private ApiK8sVngInstanceMetadataOptions instanceMetadataOptions;
    private ApiClusterInstanceTypes          instanceTypes;
    private String                           oceanId;
    private List<String>                     spotTypes;
    private Boolean                          restrictScaleDown;
    private Integer                          rootVolumeSize;
    private List<String>                  		securityGroupIds;
    private Integer               		  		spotPercentage;
    private List<String>         		  		subnetIds;
    private String                        		userData;
    private Date                          		createdAt;
    private Date                          		updatedAt;	

    public ApiK8sVirtualNodeGroup() {
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

    public ApiClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiClusterHeadroomSpecification headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public List<ApiBlockDevice> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ApiBlockDevice> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public List<ApiTag> getTags() {
        return tags;
    }

    public void setTags(List<ApiTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ApiClusterIamInstanceProfileSpec getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(ApiClusterIamInstanceProfileSpec iamInstanceProfile) {
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

    public ApiClusterInstanceTypes getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ApiClusterInstanceTypes instanceTypes) {
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