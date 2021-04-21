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

public class ApiClusterMarketplaceAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                          isSet;
    private String                               offer;
    private String                               publisher;
    private String                               sku;
    private String                               version;


    public ApiClusterMarketplaceAks() {

        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        isSet.add("offer");
        this.offer = offer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        isSet.add("publisher");
        this.publisher = publisher;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        isSet.add("sku");
        this.sku = sku;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
    }

    @JsonIgnore
    public boolean isPublisherSet() {
        return isSet.contains("publisher");
    }

    @JsonIgnore
    public boolean isOfferSet() {
        return isSet.contains("offer");
    }

    @JsonIgnore
    public boolean isSkuSet() {
        return isSet.contains("sku");
    }

    @JsonIgnore
    public boolean isVersioneSet() {
        return isSet.contains("version");    }
}