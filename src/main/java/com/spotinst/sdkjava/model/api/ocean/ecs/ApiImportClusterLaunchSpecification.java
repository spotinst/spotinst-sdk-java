package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.ocean.ecs.LaunchSpecTagsSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiImportClusterLaunchSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                                   isSet;
    private ApiImportClusterLaunchSpecIamInstanceProfileSpecification     iamInstanceProfile;
    private String                                                        imageId;
    private ApiImportClusterLaunchSpecInstanceMetadataOptions             instanceMetadataOptions;
    private List<String>                                                  securityGroupIds;
    private List<ApiLaunchSpecTagsSpecification>                          tags;
    private String                                                        userData;
    private String                                                        keyPair;

    private ApiImportClusterLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiImportClusterLaunchSpecIamInstanceProfileSpecification getIamInstanceProfile() {
        return iamInstanceProfile;
    }

    public void setIamInstanceProfile(ApiImportClusterLaunchSpecIamInstanceProfileSpecification iamInstanceProfile) {
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

    public ApiImportClusterLaunchSpecInstanceMetadataOptions getInstanceMetadataOptions() {
        return instanceMetadataOptions;
    }

    public void setInstanceMetadataOptions(ApiImportClusterLaunchSpecInstanceMetadataOptions instanceMetadataOptions) {
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

    public List<ApiLaunchSpecTagsSpecification> getTags() {
        return tags;
    }

    public void setTags(List<ApiLaunchSpecTagsSpecification> tags) {
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
    public boolean isNameSet() {
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

    @JsonIgnore
    public boolean isKeyPairSet() {
        return isSet.contains("keyPair");
    }

}