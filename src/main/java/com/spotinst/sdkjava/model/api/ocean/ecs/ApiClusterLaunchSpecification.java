package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterLaunchSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                  isSet;
    private List<ApiClusterAttributes>                   attributes;
    private ApiLaunchSpecAutoScaleSpecification          autoScale;
    private List<ApiLaunchSpecBlockDeviceMappings>       blockDeviceMappings;
    private ApiLaunchSpecIamInstanceProfileSpecification iamInstanceProfile;
    private String                                       imageId;
    private ApiLaunchSpecInstanceMetadataOptions instanceMetadataOptions;
    private List<String>                         instanceTypes;
    private String                               name;
    private String                               oceanId;
    private Boolean                              restrictScaleDown;
    private List<String>                         securityGroupIds;
    private List<String>                         subnetIds;
    private List<ApiLaunchSpecTagsSepcification> tags;
    private String                               userData;
    private String                               id;

    public ApiClusterLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiClusterAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ApiClusterAttributes> attributes) {
        isSet.add("attributes");
        this.attributes = attributes;
    }

    public ApiLaunchSpecAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiLaunchSpecAutoScaleSpecification autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public List<ApiLaunchSpecBlockDeviceMappings> getBlockDeviceMappings() {
        return blockDeviceMappings;
    }

    public void setBlockDeviceMappings(List<ApiLaunchSpecBlockDeviceMappings> blockDeviceMappings) {
        isSet.add("blockDeviceMappings");
        this.blockDeviceMappings = blockDeviceMappings;
    }

    public ApiLaunchSpecIamInstanceProfileSpecification getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(ApiLaunchSpecIamInstanceProfileSpecification iamInstanceProfile) {
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

    public ApiLaunchSpecInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(ApiLaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
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

    public List<ApiLaunchSpecTagsSepcification> getTags() {
        return tags;
    }

    public void setTags(List<ApiLaunchSpecTagsSepcification> tags) {
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

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isAttributesSet() {
        return isSet.contains("attributes");
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

