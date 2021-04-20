package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiImageAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private ApiMarketplaceAks                   marketplace;


    public ApiImageAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public ApiMarketplaceAks getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(ApiMarketplaceAks marketplace) {
        isSet.add("marketplace");
        this.marketplace = marketplace;
    }

    @JsonIgnore
    public boolean isMarketplaceSet() {
        return isSet.contains("marketplace");
    }
}
