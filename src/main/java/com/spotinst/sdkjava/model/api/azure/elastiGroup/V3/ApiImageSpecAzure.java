package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiImageSpecAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>               isSet;
    private ApiMarketplaceAzure marketplace;
    private List<ApiCustomSpecAzure> custom;
    //endregion

    //region Constructor
    public ApiImageSpecAzure() {
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

    public ApiMarketplaceAzure getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(ApiMarketplaceAzure marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
    }

    public List<ApiCustomSpecAzure> getCustom() {
        return custom;
    }

    public void setCustom(List<ApiCustomSpecAzure> custom) {
        isSet.add("custom");
        this.custom = custom;
    }
    //endregion

    //region isSet methods
    // Is marketplace Set boolean method
    @JsonIgnore
    public boolean isMarketplaceSet() {
        return isSet.contains("marketplace");
    }

    // Is custom Set boolean method
    @JsonIgnore
    public boolean isCustomSet() {
        return isSet.contains("custom");
    }
    //endregion
}
