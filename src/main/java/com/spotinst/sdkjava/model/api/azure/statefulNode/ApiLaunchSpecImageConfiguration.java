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
    private ApiLaunchSpecCustomConfiguration      custom;
    private ApiLaunchSpecGalleryConfiguration     gallery;

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
    public ApiLaunchSpecCustomConfiguration getCustom() {
        return custom;
    }

    public void setCustom(ApiLaunchSpecCustomConfiguration custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public ApiLaunchSpecGalleryConfiguration getGallery() {
        return gallery;
    }

    public void setGallery(ApiLaunchSpecGalleryConfiguration gallery) {
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
