package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecImageConfiguration {
    @JsonIgnore
    private Set<String>                        isSet;
    private LaunchSpecMarketplaceConfiguration marketplace;
    private LaunchSpecCustomImageConfiguration custom;
    private LaunchSpecImageGalleryConfiguration gallery;

    public LaunchSpecImageConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public LaunchSpecMarketplaceConfiguration getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(LaunchSpecMarketplaceConfiguration marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
    }

    public LaunchSpecCustomImageConfiguration getCustom() {
        return custom;
    }

    public void setCustom(LaunchSpecCustomImageConfiguration custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public LaunchSpecImageGalleryConfiguration getGallery() {
        return gallery;
    }

    public void setGallery(LaunchSpecImageGalleryConfiguration gallery) {
        isSet.add("gallery");
        this.gallery = gallery;
    }

    public static class Builder {
        private LaunchSpecImageConfiguration imageConfiguration;

        private Builder() {
            this.imageConfiguration = new LaunchSpecImageConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMarketplace(final LaunchSpecMarketplaceConfiguration marketplace) {
            imageConfiguration.setMarketplace(marketplace);
            return this;
        }

        public Builder setCustom(final LaunchSpecCustomImageConfiguration custom) {
            imageConfiguration.setCustom(custom);
            return this;
        }

        public Builder setGallery(final LaunchSpecImageGalleryConfiguration gallery) {
            imageConfiguration.setGallery(gallery);
            return this;
        }

        public LaunchSpecImageConfiguration build() {
            return imageConfiguration;
        }
    }

    @JsonIgnore
    public boolean isMarketplaceSet() {
        return isSet.contains("marketplace");
    }

    @JsonIgnore
    public boolean isCustomSet() {
        return isSet.contains("custom");
    }

    @JsonIgnore
    public boolean isGallerySet() {
        return isSet.contains("gallery");
    }

}
