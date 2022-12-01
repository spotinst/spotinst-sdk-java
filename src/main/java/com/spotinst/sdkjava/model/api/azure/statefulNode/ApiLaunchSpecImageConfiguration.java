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
public class ApiLaunchSpecImageConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                           isSet;
    private ApiLaunchSpecMarketplaceConfiguration marketplace;
    private ApiLaunchSpecCustomImageConfiguration custom;
    private ApiLaunchSpecImageGalleryConfiguration gallery;

    public ApiLaunchSpecImageConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiLaunchSpecMarketplaceConfiguration getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(ApiLaunchSpecMarketplaceConfiguration marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
    }
    public ApiLaunchSpecCustomImageConfiguration getCustom() {
        return custom;
    }

    public void setCustom(ApiLaunchSpecCustomImageConfiguration custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public ApiLaunchSpecImageGalleryConfiguration getGallery() {
        return gallery;
    }

    public void setGallery(ApiLaunchSpecImageGalleryConfiguration gallery) {
        isSet.add("gallery");
        this.gallery = gallery;
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
