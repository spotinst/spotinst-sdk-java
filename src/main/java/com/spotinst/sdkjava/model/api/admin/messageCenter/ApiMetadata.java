package com.spotinst.sdkjava.model.api.admin.messageCenter;

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
public class ApiMetadata implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String banner;
    //endregion

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        isSet.add("banner");
        this.banner = banner;
    }

    //region Constructor
    public ApiMetadata() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion

    //region isSet methods
    // Is banner Set boolean method
    @JsonIgnore
    public boolean isBannerSet() {
        return isSet.contains("banner");
    }
    //endregion
}
