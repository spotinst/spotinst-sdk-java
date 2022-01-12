package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecGalleryConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      galleryName;
    private String      imageName;
    private String      versionName;

    public ApiLaunchSpecGalleryConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public void setGalleryName(String galleryName) {
        isSet.add("galleryName");
        this.galleryName = galleryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        isSet.add("imageName");
        this.imageName = imageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        isSet.add("versionName");
        this.versionName = versionName;
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isGalleryNameSet() {
        return isSet.contains("galleryName");
    }

    @JsonIgnore
    public boolean isImageNameSet() {
        return isSet.contains("imageName");
    }

    @JsonIgnore
    public boolean isVersionNameSet() {
        return isSet.contains("versionName");
    }

}
