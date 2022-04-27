package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecImageGalleryConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      galleryName;
    private String      imageName;
    private String      versionName;

    public LaunchSpecImageGalleryConfiguration() {
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


    public static class Builder {
        private LaunchSpecImageGalleryConfiguration marketplaceConfiguration;

        private Builder() {
            this.marketplaceConfiguration = new LaunchSpecImageGalleryConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            marketplaceConfiguration.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setGalleryName(final String galleryName) {
            marketplaceConfiguration.setGalleryName(galleryName);
            return this;
        }

        public Builder setImageName(final String imageName) {
            marketplaceConfiguration.setImageName(imageName);
            return this;
        }

        public Builder setVersionName(final String versionName) {
            marketplaceConfiguration.setVersionName(versionName);
            return this;
        }

        public LaunchSpecImageGalleryConfiguration build() {
            return marketplaceConfiguration;
        }
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
